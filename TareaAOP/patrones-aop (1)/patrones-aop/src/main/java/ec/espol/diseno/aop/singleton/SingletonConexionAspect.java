package ec.espol.diseno.aop.singleton;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class SingletonConexionAspect extends SingletonProtocol {

 
    @DeclareParents("ec.espol.diseno.aop.singleton.ConexionBD || ec.espol.diseno.aop.singleton.Logger")
    private Singleton marcador;

    @Pointcut("within(*..*Test)")
    protected void excepciones() {}
}
