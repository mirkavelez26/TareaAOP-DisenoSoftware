package ec.espol.diseno.oop.singleton;

public class MainSingletonOOP {
    public static void main(String[] args) {
        ConexionBD a = ConexionBD.getInstance();
        ConexionBD b = ConexionBD.getInstance();
        System.out.println(a.consultar("SELECT * FROM estudiantes"));
        System.out.println("¿Misma instancia? " + (a == b));        // true
    }
}
