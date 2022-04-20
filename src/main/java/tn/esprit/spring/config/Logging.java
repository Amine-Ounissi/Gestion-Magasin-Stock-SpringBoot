package tn.esprit.spring.config;


import java.util.logging.LogManager;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.annotations.common.util.impl.Log;
import org.slf4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j

public class Logging {

	 private long t1, t2;
@Before("execution(* tn.esprit.spring.service.*.*(..))") //PointCut
public void avant( JoinPoint thisJoinPoint) {
	t1= System.currentTimeMillis();
	log.info("Before the method" + thisJoinPoint.getSignature().getName());
}

@After("execution(* tn.esprit.spring.service.*.*(..))")
public void apres(JoinPoint thisJoinPoint) {
	t2 = System.currentTimeMillis();
	log.info("After the method" + thisJoinPoint.getSignature().getName());
}

@Around("execution(* tn.esprit.spring.service.*.*(..))")
public Object profile(ProceedingJoinPoint pjp) throws Throwable {
long start = System.currentTimeMillis();
Object obj = pjp.proceed();
long elapsedTime = System.currentTimeMillis() - start;
log.info("Method execution time: " + elapsedTime + " milliseconds.");
return obj;
}
}
