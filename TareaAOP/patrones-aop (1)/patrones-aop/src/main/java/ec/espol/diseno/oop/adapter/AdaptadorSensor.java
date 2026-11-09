package ec.espol.diseno.oop.adapter;

// Adapter
public class AdaptadorSensor implements SensorTemperatura {
    private final SensorFahrenheit sensor;

    public AdaptadorSensor(SensorFahrenheit sensor) {
        this.sensor = sensor;
    }

    @Override
    public double getCelsius() {
        return (sensor.leerFahrenheit() - 32) * 5.0 / 9.0;
    }
}
