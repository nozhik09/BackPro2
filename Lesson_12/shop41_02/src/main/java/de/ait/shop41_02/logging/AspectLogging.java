package de.ait.shop41_02.logging;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectLogging {
    private final Logger logger = LogManager.getLogger(AspectLogging.class);

    @Before("execution(* de.ait.shop41_02.product.service.ProductServiceImpl.*(..))")
    public void helloAOP(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        logger.info("*******{} start", name);

    }
//только с параметром лонг
//    @After("execution(* de.ait.shop41_02.product.service.ProductServiceImpl.*(Long))")

    // all service
    @After("execution(* de.ait.shop41_02.*.service.*.*(..))")
    public void helloAOP1(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        logger.info("*******{} finish", name);

    }



    @Around("@annotation(de.ait.shop41_02.logging.Profiler)")
    public Object profileAOP(ProceedingJoinPoint joinPoint) {

        String name = joinPoint.getSignature().getName();
        logger.info("*******Profiler{} start", name);
        long startTime = System.currentTimeMillis();
        Object result ;

        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis() - startTime;

        logger.info("*******Profiler{} finish, time {} , result{}", name,endTime , result);
        return result;
    }

    @Pointcut("execution(* de.ait.shop41_02.*.controller.*.*(..))")
public void allControllers(){}

    @Pointcut("execution(* de.ait.shop41_02.*.controller.find*.*(..))")
    public void allFindMethod(){}


    @AfterReturning("allControllers()|| allFindMethod()")
    public void helloAOP3(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        logger.info("*******{} finish", name);

    }


}
