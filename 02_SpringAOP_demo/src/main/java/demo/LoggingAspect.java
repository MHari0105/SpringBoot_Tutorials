package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    
    @Before("execution(* demo.ShoppingCart.checkout(..))")  // * for any return type of method from the package
    public void beforLogger(JoinPoint jp) {
        System.out.println("\n" + jp.getSignature());
        String arg = jp.getArgs()[0].toString();
        System.out.println("login your account to continue shopping : " + arg);
    }

    @After("execution(* *.*.checkout(..))")   // * (any method), *.*.method() => (anyPackage).(anyClass).particularMethodOfThatClass()
    public void afterLogger(JoinPoint jp) {
        System.out.println("\n" + jp.getSignature());
        System.out.println("your profile found");
    }

    @Pointcut("execution(* demo.ShoppingCart.quantity(..))")
    public void afterReturningPointCut() {

    }

    @AfterReturning(pointcut = "afterReturningPointCut()", returning = "returnValue")
    public void afterReturning(String returnValue) {
        System.out.println("After returning : " + returnValue);
    }
}
