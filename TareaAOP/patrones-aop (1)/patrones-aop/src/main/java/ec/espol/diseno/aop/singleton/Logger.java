package ec.espol.diseno.aop.singleton;


public class Logger {
    public Logger() {
        System.out.println("  [Logger] Creando el único logger...");
    }

    public void log(String msg) {
        System.out.println("  LOG: " + msg);
    }
}
