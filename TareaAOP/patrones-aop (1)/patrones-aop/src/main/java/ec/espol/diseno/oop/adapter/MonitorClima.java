package ec.espol.diseno.oop.adapter;


public class MonitorClima {
    public String reportar(SensorTemperatura sensor) {
        return String.format("Temperatura actual: %.2f °C", sensor.getCelsius());
    }
}
