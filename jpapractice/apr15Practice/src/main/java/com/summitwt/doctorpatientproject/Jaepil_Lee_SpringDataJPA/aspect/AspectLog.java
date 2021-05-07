package com.summitwt.doctorpatientproject.Jaepil_Lee_SpringDataJPA.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.summitwt.doctorpatientproject.Jaepil_Lee_SpringDataJPA.ConsoleColorSettings.*;

@Aspect
@Component
public class AspectLog {

    /*
        METHODS BEING TESTED
            BEFORE ON UserService.createAccount(..)
            AFTER ON PatientService.findAllPatients()
            AROUND ON UserService.deleteByid(..)
            AFTERRETURN ON PatientService.findByName(..)
            AFTERTHROW ON PatientService.printPatient(..)
     */

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Before("execution(* com.summitwt.doctorpatientproject.Jaepil_Lee_SpringDataJPA.services.UserService.createAccount(..))")
    public void logBeforeCreateAcct(JoinPoint joinPoint) {
        log.debug("logBefore running .....");
        log.debug("Enter: {}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        System.out.println(CC_CYAN + "logging before aspect + on createAccount() method in UserService class"  + CC_RESET);
    }


    @After("execution(* com.summitwt.doctorpatientproject.Jaepil_Lee_SpringDataJPA.services.PatientService.findAllPatients())")
    public void logAfterAllPatients(JoinPoint joinPoint) {
        log.debug("logAfter running .....");
        log.debug("Enter: {}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
               joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        System.out.println(CC_CYAN + "logging After aspect + on findAllPatients() method in PatientService class" + CC_RESET);
    }


    @Around("execution(* com.summitwt.doctorpatientproject.Jaepil_Lee_SpringDataJPA.services.UserService.deleteByid(..))")
    public Object logAroundDeleteByID(ProceedingJoinPoint joinPoint) throws Throwable {
        log.debug("Running logAroundDeleteByID...");
        if (log.isDebugEnabled()) {
            log.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        }

        try {
            Object result = joinPoint.proceed();
            if (log.isDebugEnabled()) {
                log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
                        joinPoint.getSignature().getName(), result);
            }
            System.out.println(CC_CYAN + "logging Around aspect for deleteByID method in UserService class" + CC_RESET);
            return result;
        }
        catch (IllegalArgumentException e) {
            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
            System.out.println(CC_RED + "Exception in logAround thrown" + CC_RESET);
            throw e;
        }
    }

    @AfterReturning(pointcut = "execution(* com.summitwt.doctorpatientproject.Jaepil_Lee_SpringDataJPA.services.PatientService.findByName(..))",
                        returning = "res")
    public void logAfterReturnFindByName(JoinPoint joinPoint, Object res) {
        log.debug("logAfterReturning running .....");
        log.debug("Enter: {}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        System.out.println(CC_CYAN + "logging AfterReturning on findByName method in PatientService class"  + CC_RESET);
    }

    @AfterThrowing(pointcut = "execution(* com.summitwt.doctorpatientproject.Jaepil_Lee_SpringDataJPA.services.PatientService.printPatient(..))",
                        throwing = "err")
    public void logAfterThrowPrintPatient(JoinPoint joinPoint, Throwable err) {
        log.debug("logAfterThrowing running .....");
        log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), err.getCause() != null ? err.getCause() : "NULL");
        System.out.println("logging AfterThrowing for printPatient in PatientService class...");
    }


}