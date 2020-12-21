package com.qingmi.yi.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SysUserVo {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 工号
     */
    private String jobNo;

    /**
     * 用户名
     */
    private String userName;

    /**
     *  用户昵称
     */
    private String nickName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 密码盐
     */
    private String salt;

    /**
     *  性别: 1：男  2：女
     */
    private Integer sex;

    /**
     * 婚姻状态
     */
    private Integer maritalStatus;

    /**
     * 状态:1：正常 2 删除
     */
    private Integer status;

    /**
     * 用户头像
     */
    private String picture;

    /**
     * 移动电话
     */
    private String mobile;

    /**
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    /**
     * 固定电话
     */
    private String phone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 身份证号
     */
    private String idcard;

    /**
     *  用户类型
     */
    private Integer userType;

    /**
     * 用户类型字典码
     */
    private String userTypeCode;

    /**
     * 所属部门
     */
    private String orgId;

    /**
     *  二维码
     */
    private String qrcode;

    /**
     *  住址
     */
    private String address;

    /**
     *  创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建名称
     */
    private String createUserName;

    /**
     * 更新名称
     */
    private String updateUserName;

    /**
     * openId
     */
    private String openId;

    //是否激活
    private Integer isActive;

    //邀请者
    private String inviteUser;

    //登录次数
    private Integer loginCount;

    /**
     *旧用户名
     */
    private String oldUserName;

    /**
     * 旧身份证号
     */
    private String oldIdCard;

    /**
     * 用户可完成的健康任务数量
     */
    private Integer canCompletedNumber;

    /**
     * 用户可评价订单数量
     */
    private Integer canAssessNumber;

    /**
     * 用户可用优惠券数量
     */
    private Integer canUseCouponNumber;

    /**
     * 用户健康币数量
     */
    private Integer healthCoin;

    /**
     * 用户账户余额
     */
    private BigDecimal amount;

    /**
     * 用户健康行为指数
     */
    private Integer healthBehaviorIndex;

    /**
     * 用户是否签到 0未签到 非0已签到
     */
    private Integer isCheckIn;

    /**
     * 用户未读消息数量
     */
    private Integer unreadMessage;
}
