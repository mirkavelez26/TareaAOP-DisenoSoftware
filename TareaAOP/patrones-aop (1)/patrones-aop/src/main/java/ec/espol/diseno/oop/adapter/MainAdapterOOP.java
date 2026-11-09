package ec.espol.diseno.oop.adapter;

public class MainAdapterOOP {
    public static void main(String[] args) {
        SensorFahrenheit sensorViejo = new SensorFahrenheit(98.6);
        SensorTemperatura adaptado = new AdaptadorSensor(sensorViejo);
        System.out.println(new MonitorClima().reportar(adaptado));   // 37.00 °C
    }
}
