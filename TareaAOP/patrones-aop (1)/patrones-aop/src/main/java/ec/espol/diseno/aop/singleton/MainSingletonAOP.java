package ec.espol.diseno.aop.singleton;

public class MainSingletonAOP {
    public static void main(String[] args) {
        // El cliente usa "new" normalmente; el aspecto intercepta y devuelve siempre la misma instancia
        ConexionBD a = new ConexionBD();
        ConexionBD b = new ConexionBD();
        System.out.println(a.consultar("SELECT * FROM estudiantes"));
        System.out.println("¿Misma ConexionBD? " + (a == b));        // true

        Logger l1 = new Logger();
        Logger l2 = new Logger();
        l1.log("probando");
        System.out.println("¿Mismo Logger? " + (l1 == l2));          // true
    }
}
