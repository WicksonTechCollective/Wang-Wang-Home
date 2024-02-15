package cn.wickson.tech.collective.common.web.handle;

/**
 * sentinel限流、降级和熔断全局异常处理类
 */
public class GlobalSentinelExceptionHandler {

//    private static void handleException(BlockException exception) {
//        try {
//            if (exception instanceof FlowException) {
//                throw UserOperationException.getInstance(ResultCodeEnum.SENTINEL_INTERFACE_CURRENT_LIMIT);
//            }
//            if (exception instanceof DegradeException) {
//                throw UserOperationException.getInstance(ResultCodeEnum.SENTINEL_SERVICE_DOWNGRADE);
//            }
//            if (exception instanceof ParamFlowException) {
//                throw UserOperationException.getInstance(ResultCodeEnum.SENTINEL_HOTSPOT_PARAMETER_CURRENT_LIMIT);
//            }
//            if (exception instanceof SystemBlockException) {
//                throw UserOperationException.getInstance(ResultCodeEnum.SENTINEL_TRIGGER_SYSTEM_PROTECTION_RULES);
//            }
//            if (exception instanceof AuthorityException) {
//                throw UserOperationException.getInstance(ResultCodeEnum.SENTINEL_AUTHORIZATION_RULES_FAILED);
//            }
//        } catch (Exception e) {
//            // 处理异常，可以记录日志或者返回特定的错误信息
//            throw UserOperationException.getInstance(ResultCodeEnum.SENTINEL_INTERFACE_CURRENT_LIMIT);
//        }
//    }

}
