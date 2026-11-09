package ec.espol.diseno.aop.singleton;

import java.util.HashMap;
import java.util.Map;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Aspecto abstracto y reutilizable (basado en Hannemann & Kiczales, OOPSLA 2002).
 * Toda clase marcada como Singleton queda controlada por este aspecto.
 */
@Aspect
public abstract class SingletonProtocol {

    /** Una instancia por clase. */
    private final Map<Class<?>, Object> instancias = new HashMap<>();

    /** Pointcut abstracto: el aspecto concreto define desde dónde se permiten "new" reales. */
    @Pointcut
    protected abstract void excepciones();

    /** Join point: cualquier llamada al constructor de una clase Singleton (o sus subclases). */
    @Pointcut("call((ec.espol.diseno.aop.singleton.Singleton+).new(..)) && !excepciones()")
    protected void creacionSingleton() {}

    @Around("creacionSingleton()")
    public Object controlarCreacion(ProceedingJoinPoint jp) throws Throwable {
        Class<?> clase = jp.getStaticPart().getSignature().getDeclaringType();
        synchronized (instancias) {
            Object instancia = instancias.get(clase);
            if (instancia == null) {
                instancia = jp.proceed();       // ejecuta el constructor real una sola vez
                instancias.put(clase, instancia);
            }
            return instancia;
        }
    }
}
