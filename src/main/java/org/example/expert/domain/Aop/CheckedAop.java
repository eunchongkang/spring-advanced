package org.example.expert.domain.Aop.CheckedAop

@Slf4j(topic = "CheckedAop")
@Aspect
@Component
@RequiredArgsConstructor
public class CheckedAop {

    public final HttpServletRequest httpServletRequest;

    @Pointcut("execution(*org.example.expert.domain.comment.controller.*(..))")
    private void commet() {}
    @Pointcut("execution(*org.example.expert.domain.user.controller.*(..))")
    private void user() {}

    @Around("comment() || user()")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        String userId = httpServletRequest.getAttribute(userId)
        long startTime = System.currentTimeMillis();
        String requestUri = httpServletRequest.getRequestURI();
        try{
            return joinPoint.proceed();
        } finally {
            log.info("요청한 사용자의 ID: " +userId + "API 요청 시각: " + startTime + "API 요청 URL" + requestUri)
        }
    }
}










