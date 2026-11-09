package ec.espol.diseno.oop.singleton;


public final class ConexionBD {
    private static volatile ConexionBD instancia;
    private final String url;

    private ConexionBD() {
        this.url = "jdbc:postgresql://localhost:5432/espol";
        System.out.println("  [ConexionBD] Creando la única conexión...");
    }

    public static ConexionBD getInstance() {
        if (instancia == null) {
            synchronized (ConexionBD.class) {
                if (instancia == null) {
                    instancia = new ConexionBD();
                }
            }
        }
        return instancia;
    }

    public String consultar(String sql) {
        return "Ejecutando '" + sql + "' en " + url;
    }
}
