package org.climb.business.manager.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * My first Aspect - AOP - adapted to SiteManager
 * @author bob
 * @see http://www.eclipse.org/aspectj/doc/released/progguide/preface.html
 */
@Aspect
public class SiteTransactionAspect {

	static final Logger LOGGER = LogManager.getLogger(SiteTransactionAspect.class);
	
	@Before("execution(* org.climb.business.manager.impl.SiteManagerImpl.addSite(..))")
	public void transactionBefore(JoinPoint joinPoint) {

		LOGGER.debug("transactionBefore() is running!");
		LOGGER.debug("hijacked : " + joinPoint.getSignature().getName());
		LOGGER.debug("************");
		
		
		
	}
}