# Patrones Adapter y Singleton: OOP vs AOP (AspectJ)

Requisitos: JDK 17+ y Maven 3.8+.

```bash
mvn clean compile          # compila con ajc y muestra qué se tejió (showWeaveInfo)

# Sección A (OOP)
mvn -q exec:java -Dexec.mainClass=ec.espol.diseno.oop.adapter.MainAdapterOOP
mvn -q exec:java -Dexec.mainClass=ec.espol.diseno.oop.singleton.MainSingletonOOP

# Sección B (Adapter AOP)
mvn -q exec:java -Dexec.mainClass=ec.espol.diseno.aop.adapter.MainAdapterAOP

# Sección C (Singleton AOP)
mvn -q exec:java -Dexec.mainClass=ec.espol.diseno.aop.singleton.MainSingletonAOP
```

Estructura:
- `src/main/java/.../oop`  → implementaciones puramente orientadas a objetos (Sección A)
- `src/main/java/.../aop/adapter`   → clases base + aspecto `AdaptadorSensorAspect.java` (Sección B)
- `src/main/java/.../aop/singleton` → clases base + `Singleton.java`, `SingletonProtocol.java` y `SingletonConexionAspect.java` (Sección C)

Los aspectos usan la sintaxis de anotaciones de AspectJ (`@Aspect`, `@Around`, `@DeclareParents`,
`@DeclareMixin`), así que son archivos `.java` normales que cualquier IDE reconoce. El
aspectj-maven-plugin (ajc) los compila y teje durante `mvn compile`.

## NetBeans
1. File → Open Project → selecciona la carpeta `patrones-aop` (NetBeans la reconoce como proyecto Maven).
2. Project Properties → Build → Compile → desmarca **Compile on Save** (si no, NetBeans compila con javac
   y se pierde el tejido de los aspectos).
3. Clic derecho en `MainAdapterAOP.java` o `MainSingletonAOP.java` → **Run File**.

Si ejecutas sin tejer (solo javac), el Adapter lanza `ClassCastException` y el Singleton crea dos
instancias: eso demuestra que el comportamiento lo agregan los aspectos.
