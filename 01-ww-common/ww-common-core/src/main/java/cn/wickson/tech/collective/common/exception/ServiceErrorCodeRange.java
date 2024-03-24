package cn.wickson.tech.collective.common.exception;

/**
 * 业务异常的错误码区间，解决：解决各模块错误码定义，避免重复，在此只声明不做实际使用
 * 一共 10 位，分成四段
 * 第一段，1 位，类型
 * <span> 1 - 业务级别异常 </span>
 * <span> x - 预留 </span>
 * 第二段，3 位，系统类型
 * <span> 001 - 用户系统 </span>
 * <span> 002 - 商品系统 </span>
 * <span> 003 - 订单系统 </span>
 * <span> 004 - 支付系统 </span>
 * <span> 005 - 优惠劵系统 </span>
 * ... - ...
 * 第三段，3 位，模块
 * <span> 不限制规则。
 * <span> 一般建议，每个系统里面，可能有多个模块，可以再去做分段。以用户系统为例子：
 * <span> 001 - OAuth2 模块
 * <span> 002 - User 模块
 * <span> 003 - MobileCode 模块
 * 第四段，3 位，错误码
 * 不限制规则。
 * 一般建议，每个模块自增。
 */
public class ServiceErrorCodeRange {

    // 模块 system 错误码区间 [1-002-000-000 ~ 1-003-000-000)
    // 模块 member 错误码区间 [1-003-000-000 ~ 1-004-000-000)

}
