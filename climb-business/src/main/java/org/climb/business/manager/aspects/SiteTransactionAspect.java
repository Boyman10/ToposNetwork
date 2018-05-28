package org.climb.business.manager.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * My first Aspect - AOP - adapted to SiteManager
 * @author bob
 * @see https://blog.espenberntsen.net/tag/aspectj/
 * @see https://www.mkyong.com/spring3/spring-aop-aspectj-annotation-example/
 */
@Aspect
public class SiteTransactionAspect {

	@Before("execution(* org.climb.business.manager.impl.SiteManagerImpl.addSite(..))")
	public void transactionBefore(JoinPoint joinPoint) {

		System.out.println("transactionBefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}
}