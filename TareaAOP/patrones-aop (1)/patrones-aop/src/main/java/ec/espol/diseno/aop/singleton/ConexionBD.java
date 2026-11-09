package ec.espol.diseno.aop.singleton;


public class ConexionBD {
    private final String url;

    public ConexionBD() {
        this.url = "jdbc:postgresql://localhost:5432/espol";
        System.out.println("  [ConexionBD] Creando la única conexión...");
    }

    public String consultar(String sql) {
        return "Ejecutando '" + sql + "' en " + url;
    }
}
