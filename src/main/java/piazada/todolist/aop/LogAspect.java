package piazada.todolist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    // Atributos
    private Logger logger = LoggerFactory.getLogger(LogAspect.class.getName());

    @Around("@annotation(ParaLogar)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String nomeMetodo = joinPoint.getSignature().getName();
        String nomeClasse = joinPoint.getClass().getName();
        logger.debug("Inicializando o método {}.{}", nomeClasse, nomeMetodo);

        try {
            Object retorno = joinPoint.proceed();
            logger.debug("Finalizando o método {},{}", nomeClasse, nomeMetodo);

            return retorno;
        } catch (Throwable e) {
            logger.debug("Erro no método {}.{}",nomeClasse, nomeMetodo);

            throw e;
        }
    }
}
