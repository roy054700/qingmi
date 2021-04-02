/*
 * For com.royal.art
 * Copyright [2015/11/9] By FCHEN
 */
package com.qingmi.yi.common.exception.msg;

/**
 * APIGlobalErrorMsg
 * 全局异常定义
 * 全局异常code 统一定义为负数，便于识别
 * 全局异常msg  统一末尾需要加上%s,用于接收具体的错误消息
 * @author FCHEN
 * @date 2015/11/9
 */
public enum APIGlobalErrorMsg {

    /**
     * 未知的异常
     */
    UnknownException(-9999,"系统繁忙\n请稍后重试!"),
    CodeException(-1001,"验证码不正确\n请重新输入"),
    PageNotExistsException(-9998,"分页参数错误\n请稍后重试!"),
    MobilePhoneIllegalException(-1002,"手机号码格式不正确\n请重新输入"),
    UserExistsException(-1003,"账号已存在\n请直接登录"),
    UserRegisterFaildException(-1004,"用户注册失败\n请稍后再试!"),
    PasswordlengthErrorException(-1005,"密码格式不正确\n请重新输入!"),
    PasswordPatternErrorException(-1005,"密码格式为字母加数字6-20位"),
    PasswordTwoNotEqualsException(-1006,"两次密码不一致\n请重新输入!"),
    UserOrPasswordErrorException(-1007,"账号或者密码错误\n请重新输入!"),
    EncryptErrorException(-1008,"加密格式错误\n请重新输入!"),
    UserNotExistsException(-1009,"账户未注册\n请先注册"),
    UserInfoAddFaildException(-2001,"用户信息添加失败\n请稍后再试!"),
    SNCodeFaildException(-2001,"SN码不存在\n请重新输入!"),
    BsCorporationExistsException(-1010,"已经存在一个未认证的机构/学校\n请重新操作"),
    InVationCodeNotEmptyException(-2002,"邀请码不能为空\n请重新输入!"),
    InVationCodeNotHasClassException(-2003,"该邀请码无班级!"),
    CorporationNotExistsException(-2204,"该机构不存在\n请重新输入!"),
    CorporationIsHaveExistsException(-2205,"您已加入过该机构\n请勿重复添加!"),
    CorporationHaveExistsException(-2206,"您已加入过其他机构\n不能在加入该机构"),
    ParamNotNullException(-4001,"参数不能为空\n请重新输入!"),
    UidRepeatException(-4002,"Uid不能重复"),
    ByIdNotExistsException(-4003,"id不存在"),
    StudentGuIdNotExistsException(-4004,"学生id有误"),
    VersionException(-4005,"您的版本过低"),
    MobileNotNullException(-4006,"手机号码不能为空\n请重新输入"),
    ClassNotExistsCorporationException(-5001,"该机构还没有班级\n请前往创建班级!"),
    UserPasswordExistsException(-6003,"账户密码未匹配"),
    OutOfDeviceMaxCountException(-6005,"超出最大设备数"),
    UnKnowTokenException(-6006,"您已被登出,您的账号在另一台设备登陆或者您已被移出学校权限!"),
    UnKnowHttpsTimeException(-4000,"你的请求已过期\n请重新操作"),
    ParamNotRightException(-6007,"参数格式不正确\n请重新操作"),
    SmsException(-6008,"短信验证码发送失败\n请稍后再试"),
    AccountOrPasswordErrorException(-6009,"用户名不正确或者密码错误\n请重新操作"),
    TeacherUnboundUserException(-6010,"教师未绑定系统用户"),
    ThisRoleNotallowLoginException(-6011,"非一线教师角色不允许登录"),
    GetuthException(-6012,"获取上传凭证失败"),
    PasswordlFormatErrorException(-6014,"密码格式有误"),
    MobileNotRightException(-6015,"手机号不正确"),
    BookUnitNotExistsException(-6016,"该书本无内容,请重新选择!"),
    QuestionMateriaNotExistsException(-60017,"该题目无内容,请重新选择!"),
    CorporationExistsException(-60018,"该机构已经激活,请选择其他机构!"),
    BsClassStudentIsEmptyException(-60019,"已经加入过该班级,请勿重复添加!"),
    BsCorporationGuidIsNotEmptyException(-60020,"只能加入同一个机构班级!"),
    BsCorporationGuidIsNotEmptyByClssException(-60021,"该班级没有所属机构,不能加入!"),
    HomeWorkIsEmptyException(-60022,"作业id不能为空!"),
    addressNotExistsException(-6023,"地址参数不正确!"),
    LongitudeAndLatitudeNotExistsException(-6024,"坐标参数错误!"),
    ParamTimeNotNullException(-6025,"时间参数错误!"),
    QuestionNotNullException(-6026,"作业提交错误,请检查"),
    HomeWorkNotNullException(-6027,"该班级已没有此作业,请检查"),
    ClassNotRightException(-6002,"班级信息参数有误!"),
    UserBirthdayErrorException(-6003,"生日错误!"),
    SaveDataErrorException(-6003,"保存失败!"),
    ParamMissException(-9998,"参数缺失\n请稍后重试"),
    CorpNameException(-7001, "请填写您的机构或组织名称！"),
    FileSerializeErrorException(-6005,"文件处理错误!"),
    FileUploadErrorException(-6006,"文件上传错误!"),
    SubjectiveMessageErrorException(-6004,"处理消息错误!"),
    MobileNumberException(-7002, "请填写您的手机号！"),
    CorpSizeOrTypeException(-7001,"机构信息类型/人数规模错误!"),
    MessageParameterContentNotExistsException(-8001,"消息内容不能为空!"),
    MessageParameterDurationNotExistsException(-8002,"消息的音频时长不能为空!"),
    MessageParameterFileNameNotExistsException(-8003,"文件名称不能为空!"),
    MessageParameterIconNotExistsException(-8007,"视频文件的缩略图不能为空!"),
    MessageParameterImageNotExistsException(-8004,"图片的宽/高不能为空!"),
    HomeWorkSubjectiveSubStuException(-8005,"该互动练习已经提交过了!"),
    ClassNameExistsException(-8006,"该班级名称已被使用,请使用其他班级名称!"),
    subjectiveQuestionsWorkNameNullException(-8008,"主观题题目不能为空!"),
    subjectiveQuestionsWorkTimeNullException(-8009,"主观题目开始/结束时间填写错误!"),
    subjectiveQuestionsCorporationGuidNullException(-8010,"机构id不能为空!"),
    subjectiveQuestionsMessageListNullException(-8011,"消息集合不能为空!"),
    subjectiveQuestionsClassListNullException(-8012,"主观题发布班级列表不能为空!"),
    subjectiveQuestionsClassNullException(-8013,"发布班级信息有误!"),
    subjectiveQuestionsGradeNullException(-8014,"发布班级级别信息有误!"),
    evaluateStarLevelNotExistsException(-8015,"老师评分不能为空!"),
    MessageParameterLocalPathException(-8016,"缓存文件地址不能为空!"),
    SaveFileOnSubErrorException(-8017,"交互练习文件发布失败!"),
    MessageParameterTypeNotExistsException(-8018,"消息类型不能为空!"),
    ObjectiveQuestionsWorkNameNullException(-8019,"客观题题目不能为空!"),
    ObjectiveQuestionsClassNullException(-8019,"发布班级信息有误!"),
    UserNameException(-7003, "请填写您的姓名！"),
    CorporationHasException(-7007,"该手机号已存在一个未认证的机构/学校<br />请重新操作"),
    UserNotFountException(-7004,"账号不存在"),
    DataNotExistException(-7005,"数据已不存在\n请重新加载页面"),
    CorpInitDataException(-7006, "机构初始化数据失败"),
    TeacherNumEnoughException(-7008, "老师人数已满"),
    SysNoticeTitleNotNullException(-7009, "公告标题不能为空"),
    SysNoticeContextNotNullException(-7010, "公告内容不能为空"),
    TerminalInformationNullException(-7011, "终端信息不完善!"),
    CurriculumClassNumberErrorException(-3000, "课时区间0-99（不包含0，包含99）"),
    StartTimeNotNullException(-7011, "开始时间不能为空"),
    EndTimeNotNullException(-7012, "结束时间不能为空"),
    OutTradeNoNotNullException(-7013, "订单号不能为空"),
    TotalAmountNotNullException(-7014, "订单金额不能为空"),
    SubjectNotNullException(-7015, "订单名称不能为空"),
    PayChannelNotNullException(-7016, "支付渠道不能为空"),
    PayTradeException(-7017, "支付繁忙,请稍后重试!"),
    RuunningErrorContactLengthIsTooLang(-7018,"错误详情不能超过500字!"),
    TeacherGuidIsEmptyException(-7019,"教师信息有误!"),
    AdminCountIsNotEnoughException(-7020,"管理员数量已达上限!"),
    UserIsAdminException(-7021,"该用户已经是管理员!"),
    AdminStatusIsEmptyException(-7022,"操作状态异常!"),
    UserIsNotAdminException(-7023,"该用户已不是管理员!"),
    TeacherHaveClassIsNotEmptyException(-7024,"在职老师无法移除!"),
    TeacherIsAdminOnCorpException(-7025,"该用户是机构创建人,不能进行该操作!"),
    BsGradeIsExistException(-7026,"该级别已经存在!"),
    BsLabelIsExistException(-7027,"该关键字已经存在,请勿重复添加!"),
    BsLabelIsNotExistException(-7028,"该关键字已存在!"),
    CorporationIsNotAdminException(-7029,"你不是管理员,不能进行该操作!"),
    CorporationIsNotExistException(-7030,"该机构不存在!"),
    CorporationManageIsEmptyException(-7031,"机构信息有误!"),
    CorporationCityIsEmptyException(-7032,"机构位置信息有误!"),
    CorporationPrincipalIsEmptyException(-7033,"机构联系人信息有误"),
    CorporationCornOrCardIsEmptyException(-7034,"机构的图标或者名片信息有误!"),
    OrderPayTradeException(-7018, "订单支付异常,请稍后重试!"),
    CorporationClassIsExistException(-7782, "该机构下班级名称已经存在，请重新输入。"),
    ClassIsNullException(-7035, "班级信息有误\n请稍后再试!"),
    ErrorPerMissionDeniedException(-7036,"权限不足\n不能进行该操作!"),
    StuInfoException(-7037,"您未选中学生\n请重新操作!"),
    ClassInfoIsNullException(-7038,"暂无班级,请重新选择!"),
    ClassIsEmptyException(-7039,"该班级已删除\n请选择其它班级!"),
    StudentOutClassException(-7040,"您已被移除该班级\n请选择其它班级!"),
    ParamRangeTypeNotNullException(-7783,"公告参数错误，请重新输入!"),
    AddRepeatException(-7784,"系统繁忙，请勿重复操作!"),
    GameNotExistException(-7786,"尽请期待!"),
    OrderRepeatPayException(-7785, "订单状态异常"),
    OrderHasPayException(-7792, "订单已支付"),
    PicBookNotNullException(-7788, "绘本信息不能为空"),
    OrderNotFoundException(-7789, "该订单不存在"),
    BindWXPhoneExistsException(-7790,"该手机号码已经绑定微信账号\n请更换手机号码!"),
    BindWXPhoneUnionIDNotExistsException(-7791,"微信用户信息有误!"),
    BindWXStudentExistsException(-7792,"该微信已绑定,请直接登陆!"),
    RevBookIsNotExistsException(-7793,"该书本不存在!"),
    ClassScheduleCardNullException(-7794,"课程表地址为空！"),
    FileUsedException(-7795,"文件被班级引用，不能删除！"),
    FileNotFoundException(-7796,"文件不存在！"),
    FileExistsException(-7797,"该文件班级已存在\n请重新选择"),
    KidsContentNullException(-7798, "成长记录内容不能为空！"),
    KidsContentStatusException(-7799, "点赞状态异常！"),
    LiveException(-7800, "课程名称不能为空！"),
    LiveRoomNullException(-7801, "请输入房间号！"),
    LiveRoomNotFountException(-7803, "暂无直播课，请点击查看【班级消息】，\n随时关注直播课动态。"),//该直播不存在或已结束！
    LiveParamNullException(-7900,"直播课的学生人数和时长不能为为空"),
    UserExistsLiveRoomException(-7802, "已加入该直播间，请不要重复加入！"),
    StudentExperienceNotExistsException(-7800,"该学生已完成体验,请使用激活码!"),
    LiveRoomCountException(-7804, "该直播间用户已达上限！"),
    LessonNotUpException(-7805,"该教材未上架\n请刷新"),
    LiveRoomExceprion(-7806,"该班级下的直播课正在进行中，暂时不能创建直播！"),
    LessonUnitNotFoundException(-7807,"该单元未上架\n请刷新"),
    LessonModuleNotFoundException(-7808,"该模块数据不存在\n请刷新"),
    PhoneExistsException(-7787,"手机号已存在\n请直接登录");



    private int code;
    private String msg;
    APIGlobalErrorMsg(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
