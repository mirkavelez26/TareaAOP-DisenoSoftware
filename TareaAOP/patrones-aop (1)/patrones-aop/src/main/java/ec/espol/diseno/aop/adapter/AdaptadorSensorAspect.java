package ec.espol.diseno.aop.adapter;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareMixin;


@Aspect
public class AdaptadorSensorAspect {

    @DeclareMixin("ec.espol.diseno.aop.adapter.SensorFahrenheit")
    public static SensorTemperatura adaptar(Object instancia) {
        SensorFahrenheit sensor = (SensorFahrenheit) instancia;   // el objeto que se adapta
        return () -> (sensor.leerFahrenheit() - 32) * 5.0 / 9.0;
    }
}
