package com.qingmi.yi.common.base;

import com.alibaba.fastjson.JSON;
import com.qingmi.yi.common.enums.ResultCode;
import com.qingmi.yi.common.exception.BaseException;
import com.qingmi.yi.common.utils.ResultUtil;
import com.qingmi.yi.common.vaild.BeanValidators;
import com.qingmi.yi.common.vo.R;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.client.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.List;

public abstract class BaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 验证Bean实例对象
     */
    @Autowired
    protected Validator validator;

    /**
     * 服务端参数有效性验证
     *
     * @param object 验证的实体对象
     * @param groups 验证组，不传入此参数时，同@Valid注解验证
     * @return 验证成功：继续执行；验证失败：抛出异常。
     */
    protected void beanValidator(Object object, Class<?>... groups) {
        try {
            BeanValidators.validateWithException(validator, object, groups);
        } catch (ConstraintViolationException e) {
            List<String> list = BeanValidators.extractPropertyAndMessageAsList(e, ": ");
            StringBuilder sb = new StringBuilder();
            for (String message : list.toArray(new String[]{})) {
                sb.append(message).append(";");
            }
            throw new BaseException(sb.toString(), ResultCode.FAIL.code);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * 客户端返回JSON字符串
     *
     * @param response
     * @param object
     * @return
     */
    protected String renderString(HttpServletResponse response, Object object) {
        return renderString(response, JSON.toJSONString(object));
    }

    /**
     * 客户端返回字符串
     *
     * @param response
     * @param string
     * @return
     */
    protected String renderString(HttpServletResponse response, String string) {
        try {
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * 全局异常处理器
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public R exception(Exception ex, HttpServletRequest request) {
        ex.printStackTrace();
        logger.info("==============Exception===============" + ex.getMessage());
        return new ResultUtil<>().setErrorMsg(ResultCode.INTERNAL_SERVER_ERROR.code, ResultCode.INTERNAL_SERVER_ERROR.name);
    }

    /**
     * 字段验证异常处理器
     *
     * @param e
     * @return
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public R validatorException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return new ResultUtil<>().setErrorMsg(ResultCode.INTERNAL_SERVER_ERROR.code, message);
    }

    /**
     * 无权限异常处理器
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({AccessDeniedException.class})
    @ResponseBody
    public R securityException(AccessDeniedException ex) {
        return new ResultUtil().setErrorMsg(ResultCode.UNAUTHORIZED.getCode(), "您无权访问，请联系管理员添加权限");
    }

    /**
     * 自定义异常处理器
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({BaseException.class})
    @ResponseBody
    public R myErrorHandler(BaseException ex) {
        R result = new R()
                .setCode(ex.getCode())
                .setMessage(ex.getMessage());
        if (ex.getCode() == null) {
            result.setCode(ResultCode.INTERNAL_SERVER_ERROR.code)
                    .setMessage(ResultCode.INTERNAL_SERVER_ERROR.name);
        }
        return result;
    }

    /**
     * 初始化数据绑定
     * 1. 将所有传递进来的String进行HTML编码，防止XSS攻击
     * 2. 将字段中Date类型转换为String类型
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
            }

            @Override
            public String getAsText() {
                Object value = getValue();
                return value != null ? value.toString() : "";
            }
        });
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
//			@Override
//			public String getAsText() {
//				Object value = getValue();
//				return value != null ? DateUtils.formatDateTime((Date)value) : "";
//			}
        });
    }
}
