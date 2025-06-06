package demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AspectConfig {

	Logger logger = LoggerFactory.getLogger(getClass());

//	@Before(value = "execution(* demo.controller.*.*(..))")
//	public void beforeAdvice(JoinPoint joinPoint) {
//		logger.info("Inside Before Advice");
//	}

	/*
	 * @Before(value = "execution(* demo.controller.*.*(..)) and args(object)")
	 * public void beforeAdvice(JoinPoint joinPoint, Object object) {
	 * logger.info("Request ="+object); }
	 */

	/*
	 * @After(value = "execution(* demo.controller.*.*(..)) and args(object)")
	 * public void beforeAdvice(JoinPoint joinPoint, Object object) {
	 * logger.info("Request ="+object); }
	 */

	/*
	 * @AfterReturning(value =
	 * "execution(* demo.controller.*.*(..)) and args(object)", returning =
	 * "returningObject") public void beforeAdvice(JoinPoint joinPoint, Object
	 * object, Object returningObject) { logger.info("Response =" +
	 * returningObject); }
	 */
	// After returning advice have return attribute i,e. 'returning =
	// "returningObject"';

	/*
	 * @Around(value = "execution(* demo.controller.*.*(..)) and args(object)")
	 * public void beforeAdvice(ProceedingJoinPoint proceedingJoinPoint, Object
	 * object) { logger.info("Request =" + object); Object returningObject = null;
	 * try { returningObject = proceedingJoinPoint.proceed(); } catch (Throwable e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * logger.info("Response ="+returningObject); }
	 */
}
