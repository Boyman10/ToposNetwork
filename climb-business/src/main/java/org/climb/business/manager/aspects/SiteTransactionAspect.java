package org.climb.business.manager.aspects;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * My first Aspect - AOP - adapted to SiteManager
 * 
 * @author bob
 * @see http://www.eclipse.org/aspectj/doc/released/progguide/preface.html
 * @see https://docs.spring.io/spring/docs/2.0.x/reference/aop.html
 */
@Aspect
public class SiteTransactionAspect {

	static final Logger LOGGER = LogManager.getLogger(SiteTransactionAspect.class);

    @Inject
    @Named("txManager")
    private PlatformTransactionManager platformTransactionManager;
    private TransactionStatus vTransactionStatus;
    
    
	@Before("execution(* org.climb.business.manager.impl.SiteManagerImpl.*Site(..))")
	public void transactionBefore(JoinPoint joinPoint) {

		LOGGER.debug("transactionBefore() is running!");
		LOGGER.debug("hijacked : " + joinPoint.getSignature().getName());
		LOGGER.debug("************");

		vTransactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());

	}

	@AfterReturning(pointcut = "execution(* org.climb.business.manager.impl.SiteManagerImpl.*Site(..))", returning = "result")
	public void afterTransactionalMethod(JoinPoint joinPoint, Object result) {

		LOGGER.debug("afterTransactionalMethod() is running!");
		LOGGER.debug("hijacked : " + joinPoint.getSignature().getName());
		LOGGER.debug("*****" + result + "*******");

		platformTransactionManager.commit(vTransactionStatus);
	}

	@AfterThrowing(pointcut = "execution(* org.climb.business.manager.impl.SiteManagerImpl.*Site(..))", throwing = "error")
	public void transactionAfterThrowing(JoinPoint joinPoint, Throwable error) {

		System.out.println("transactionAfterThrowing() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		System.out.println("******");

		platformTransactionManager.rollback(vTransactionStatus);

	}
}