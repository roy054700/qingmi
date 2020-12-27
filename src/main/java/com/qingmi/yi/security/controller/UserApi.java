package com.qingmi.yi.security.controller;

import com.alibaba.fastjson.JSONObject;
import com.qingmi.yi.common.utils.TokenUtil;
import com.qingmi.yi.common.inter.UserLoginToken;
import com.qingmi.yi.security.model.SysUserAuthentication;
import com.qingmi.yi.security.service.TokenService;
import com.qingmi.yi.security.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 李龙真
 * @Date: 2020/12/22 18:39
 */
@RestController
public class UserApi {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    // 登录
    @ApiOperation(value = "登陆", notes = "登陆")
    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public Object login(SysUserAuthentication user, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        SysUserAuthentication userForBase = new SysUserAuthentication();
        SysUserAuthentication byUser = userService.findByUsername(user);
        userForBase.setId(byUser.getId());
        userForBase.setUsername(byUser.getUsername());
        userForBase.setPassword(byUser.getPassword());
        if (!userForBase.getPassword().equals(user.getPassword())) {
            jsonObject.put("message", "登录失败,密码错误");
            return jsonObject;
        } else {
            String token = tokenService.getToken(userForBase);
            jsonObject.put("token", token);

            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);

            return jsonObject;

        }
    }
    /***
     * 这个请求需要验证token才能访问
     * @return String 返回类型
     */
    @UserLoginToken
    @ApiOperation(value = "获取信息", notes = "获取信息")
    @RequestMapping(value = "/getMessage" ,method = RequestMethod.GET)
    public String getMessage() {

        // 取出token中带的用户id 进行操作
        System.out.println(TokenUtil.getTokenUserId());

        return "您已通过验证";
    }
}
