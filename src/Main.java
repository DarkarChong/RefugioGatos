// MAIN — Punto de entrada del programa
// Aquí se crean TODAS las instancias.
// Las clases son el molde, Main es donde
// los objetos cobran vida.


public class Main {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║   REFUGIO DE GATOS 🐱        ║");
        System.out.println("╚══════════════════════════════╝\n");

        // ── 1. INSTANCIAS con constructor vacío ───────────────
        // No sé el nombre aún → uso constructor vacío
        Gato gatito = new Gato();
        gatito.maullar(1, "miau (sin nombre aún)");

        // ── 2. INSTANCIAS con parámetros ──────────────────────
        // new Gato("nombre", "color", vidas)
        //          ↑          ↑        ↑
        //       String      String    int
        Gato luna  = new Gato("Luna",  "Gris",    9);
        Gato sol   = new Gato("Sol",   "Naranja",  7);
        Gato noche = new Gato("Noche", "Negro",   9);

        // ── 3. INSTANCIA de clase HIJA ────────────────────────
        GatoSiames cleo = new GatoSiames("Cleo", "Oscuro en orejas y cola");

        System.out.println("=== MÉTODOS CON PARÁMETROS ===");
        // maullar(veces, tono) → dos parámetros
        luna.maullar(3, "MIAU FUERTE 😾");
        sol.maullar(1, "miau suavecito...");

        System.out.println("\n=== CAMBIAR ESTADO CON ENUM ===");
        luna.setEstado(EstadoGato.JUGANDO);
        sol.setEstado(EstadoGato.COMIENDO);
        noche.setEstado(EstadoGato.ENOJADO);

        // ── 4. IF/ELSE dentro del objeto ──────────────────────
        System.out.println("\n=== ESTADOS CON IF/ELSE ===");
        luna.mostrarEstado();
        sol.mostrarEstado();
        noche.mostrarEstado();

        // ── 5. @Override en acción ────────────────────────────
        System.out.println("\n=== @OVERRIDE: hablar() ===");
        luna.hablar();   // usa Gato.hablar()  → "¡Miau!"
        cleo.hablar();   // usa GatoSiames.hablar() → "¡MIAU SIAMÉS!"
        // SerVivo.hablar() nunca se ejecuta — fue reemplazado

        // ── 6. HERENCIA en cadena ─────────────────────────────
        System.out.println("\n=== HERENCIA ===");
        cleo.respirar();          // heredado de SerVivo → Gato → GatoSiames
        cleo.dormir();            // heredado de Gato
        cleo.mostrarPatrones();   // propio de GatoSiames

        // ── 7. WHILE LOOP — perder vidas ──────────────────────
        System.out.println("\n=== WHILE LOOP ===");
        int contador = 0;
        while (sol.getVidas() > 5) {
            sol.perderVida();
            contador++;
        }
        System.out.println("Sol perdió " + contador + " vida(s) en total.");

        // ── 8. ARRAY simple con FOR LOOP clásico ──────────────
        System.out.println("\n=== ARRAY + FOR LOOP ===");
        String[] sonidos = {"Miau", "Prrr", "Mrrrow", "Fsss", "Nya~"};

        for (int i = 0; i < sonidos.length; i++) {
            System.out.println("[" + i + "] " + sonidos[i]);
        }

        // ── 9. REFUGIO con ARRAYLIST ──────────────────────────
        System.out.println("\n=== ARRAYLIST: REFUGIO ===");
        Refugio refugio = new Refugio("Patitas Felices");

        // agregarGato(Gato g) → recibe el objeto como parámetro
        refugio.agregarGato(luna);
        refugio.agregarGato(sol);
        refugio.agregarGato(noche);
        refugio.agregarGato(cleo);

        // ── 10. ENHANCED FOR LOOP (dentro de mostrarTodos) ────
        refugio.mostrarTodos();
        System.out.println("\nTotal de gatos: " + refugio.totalGatos());

        // ── 11. BÚSQUEDA con FOR + IF/ELSE ───────────────────
        refugio.buscarPorNombre("Sol");
        refugio.buscarPorNombre("Mittens");  // no existe

        System.out.println("\n¡Programa terminado! 🐾");
    }
}
