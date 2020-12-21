package com.qingmi.yi.common.handler;

import cn.hutool.core.map.MapUtil;
import com.qingmi.yi.common.constant.CommonConstant;
import com.qingmi.yi.common.constant.ConstantToken;
import com.qingmi.yi.common.enums.SysDictEnum;
import com.qingmi.yi.common.utils.PrintJsonUtils;
import com.qingmi.yi.common.utils.ResponseUtils;
import com.google.common.collect.Maps;
import io.rong.RongCloud;
import io.rong.methods.user.User;
import io.rong.models.Result;
import io.rong.models.response.TokenResult;
import io.rong.models.response.UserResult;
import io.rong.models.user.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 认证成功
 * @author  chengxin
 */
@Slf4j
//@Component
public class AuthAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private AuthorizationServerTokenServices authorizationServerTokenServices;

    // 融云appKey
    @Value("${rongcloud.appKey}")
    private String appKey;

    // 融云appSecret
    @Value("${rongcloud.appSecret}")
    private String appSecret;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("==================================登录成功============================");
        try {
            OAuth2AccessToken  accessToken = getToken(request,authentication);
            PrintJsonUtils.write(response, ResponseUtils.success("登录成功!",getAccessToken(accessToken)));
        } catch (Exception e) {
            PrintJsonUtils.write(response, ResponseUtils.error("登录失败!"));
            e.printStackTrace();
        }
    }

    /**
     * 获取token
     */
    public OAuth2AccessToken getToken(HttpServletRequest request,Authentication authentication){
        String clientId = request.getParameter(ConstantToken.CLIENT_ID);
        String clientSecret = request.getParameter(ConstantToken.CLIENT_SECRET);
        String grantType = request.getParameter(ConstantToken.GRANT_TYPE);
        Map<String, String> paraMap = MapUtil.newHashMap();
        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);
        paraMap.put(ConstantToken.CLIENT_ID, clientId);
        paraMap.put(ConstantToken.CLIENT_SECRET, clientSecret);
        paraMap.put(ConstantToken.GRANT_TYPE, grantType);

        TokenRequest tokenRequest = new TokenRequest(paraMap, clientId, clientDetails.getScope(), grantType);
        OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);
        OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);
        OAuth2AccessToken oAuth2AccessToken = authorizationServerTokenServices.createAccessToken(oAuth2Authentication);
        log.info("获取token 成功：{}", oAuth2AccessToken.getValue());
        return oAuth2AccessToken;
    }


    private Map<String,Object> getAccessToken(OAuth2AccessToken token) throws Exception {
        Map<String,Object> tokenData= Maps.newHashMap();
        tokenData.put(ConstantToken.USER_TYPE,token.getAdditionalInformation().get(ConstantToken.USER_TYPE));
        tokenData.put(ConstantToken.CLIENT_TYPE,token.getAdditionalInformation().get(ConstantToken.CLIENT_TYPE));
        tokenData.put(ConstantToken.USER_NAME,token.getAdditionalInformation().get(ConstantToken.USER_NAME));
        tokenData.put(ConstantToken.USER_ID,token.getAdditionalInformation().get(ConstantToken.USER_ID));
        tokenData.put(ConstantToken.LOGIN_TYPE,token.getAdditionalInformation().get(ConstantToken.LOGIN_TYPE));
        tokenData.put(ConstantToken.AUTHORITIES,token.getAdditionalInformation().get(ConstantToken.AUTHORITIES));
        tokenData.put(ConstantToken.IS_BIND__MOBILE,token.getAdditionalInformation().get(ConstantToken.IS_BIND__MOBILE));
        tokenData.put("accessToken",token.getValue());
        tokenData.put("expires",token.getExpiresIn());
        tokenData.put("refreshToken",token.getRefreshToken().getValue());

        if (SysDictEnum.USER_TYPE_APP.getValue().equals(token.getAdditionalInformation().get(ConstantToken.USER_TYPE))) {
            // 融云
            RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
            User User = rongCloud.user;

            /**
             * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/user/user.html#register
             *
             * 注册用户，生成用户在融云的唯一身份标识 Token
             */
            UserModel user = new UserModel()
                    .setId(token.getAdditionalInformation().get(ConstantToken.USER_ID) + "")
                    .setName(token.getAdditionalInformation().get(ConstantToken.USER_NAME) + "")
                    .setPortrait("http://www.rongcloud.cn/images/logo.png");
            UserModel sysUser = new UserModel()
                    .setId(CommonConstant.RONG_CLOUD_SYS_SEND_USER_ID)
                    .setName(CommonConstant.RONG_CLOUD_SYS_SEND_USER_NAME)
                    .setPortrait(CommonConstant.RONG_CLOUD_SYS_SEND_USER_PORTRAIT);
            User.register(sysUser);
            TokenResult result = User.register(user);
            log.info("rongcloud_getToken:  " + result);

            /**
             *
             * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/user/user.html#refresh
             *
             * 刷新用户信息方法
             */
            Result refreshResult = User.update(user);
            log.info("rongcloud_refresh:  " + refreshResult);

            /**
             *
             * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/user/user.html#get
             *
             * 查询用户信息方法
             */
            UserResult userResult = User.get(user);
            log.info("rongcloud_getUserInfo:  " + userResult);

            tokenData.put("rongcloudToken", result.getToken());
        }

        return tokenData;
    }

}
