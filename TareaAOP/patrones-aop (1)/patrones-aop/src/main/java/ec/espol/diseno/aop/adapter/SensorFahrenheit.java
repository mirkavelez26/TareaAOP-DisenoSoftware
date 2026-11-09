package ec.espol.diseno.aop.adapter;


public class SensorFahrenheit {
    private final double lectura;

    public SensorFahrenheit(double lectura) {
        this.lectura = lectura;
    }

    public double leerFahrenheit() {
        return lectura;
    }
}
