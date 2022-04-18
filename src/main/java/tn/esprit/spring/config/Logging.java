package tn.esprit.spring.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j

public class Logging {
	/* private long t1, t2;
@Before("execution(* tn.esprit.spring.service.*.*(11))") //PointCut
public void avant( JoinPoint thisJoinPoint) {
	t1= System.currentTimeMillis();
	log.info("In the method" + thisJoinPoint.getSignature().getName());
}

@After("execution(* tn.esprit.spring.service.*.*(..))")
public void apres(JoinPoint thisJoinPoint) {
	t2 = System.currentTimeMillis();
}
	
	
	*/

}
