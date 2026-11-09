package ec.espol.diseno.aop.adapter;

public class MainAdapterAOP {
    public static void main(String[] args) {
        // No hay clase AdaptadorSensor: el aspecto hace que SensorFahrenheit sea un SensorTemperatura
        SensorFahrenheit sensor = new SensorFahrenheit(98.6);

        SensorTemperatura adaptado = (SensorTemperatura) sensor;

        System.out.println(new MonitorClima().reportar(adaptado));   // 37.00 °C
        System.out.println("¿Es el mismo objeto? " + (adaptado == (Object) sensor));  // true
    }
}
