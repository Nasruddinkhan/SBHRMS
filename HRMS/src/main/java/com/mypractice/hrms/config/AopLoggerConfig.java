/**
 * nasru
 * AopLoggerConfig.java
 * Feb 16, 2020
 */
package com.mypractice.hrms.config;



import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author nasru
 *
 */
@Aspect
@Component
public class AopLoggerConfig {
	 private final Logger log = LoggerFactory.getLogger(this.getClass());
	 
	 @Pointcut("within(@org.springframework.stereotype.Repository *)" +
		        " || within(@org.springframework.stereotype.Service *)" +
		        " || within(@org.springframework.web.bind.annotation.RestController *)")
		    public void springBeanPointcut() {
		        // Method is empty as this is just a Pointcut, the implementations are in the advices.
		    }
	 
	 @Pointcut("within(com.mypractice.hrms..*)" +
		        " || within(com.mypractice.hrms.serviceimpl..*)" +
		        " || within(com.mypractice.hrms.controller..*)")
		    public void applicationPackagePointcut() {
		        // Method is empty as this is just a Pointcut, the implementations are in the advices.
		    }
	 @AfterThrowing(pointcut = "applicationPackagePointcut() && springBeanPointcut()", throwing = "e")
	    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
	        log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
	            joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
	    }
	 @Around("applicationPackagePointcut() && springBeanPointcut()")
	    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
	        if (log.isDebugEnabled()) {
	            log.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
	                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
	        }
	        if (log.isInfoEnabled()) {
	            log.info("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
	                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
	        }
	        try {
	            Object result = joinPoint.proceed();
	            if (log.isDebugEnabled()) {
	                log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
	                    joinPoint.getSignature().getName(), result);
	            }
	            return result;
	        } catch (IllegalArgumentException e) {
	            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
	                joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
	            throw e;
	        }
	    }
}
