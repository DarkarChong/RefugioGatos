// MAIN — Punto de entrada del programa
// Aquí se crean TODAS las instancias.
// Las clases son el molde, Main es donde
// los objetos cobran vida.


public class Main {

    public static void main(String[] args) {


      

        // 2. INSTANCIAS con parámetros 
        // new Gato("nombre", "color", vidas)
        //          ↑          ↑        ↑
        //       String      String    int
        Gato luna  = new Gato("Luna",  "Gris",    9);
        Gato sol   = new Gato("Sol",   "Naranja",  7);

        // ── 3. INSTANCIA de clase HIJA 
        GatoSiames cleo = new GatoSiames("Cleo", "Oscuro en orejas y cola");

        System.out.println(" MÉTODOS CON PARÁMETROS");
        // maullar(veces, tono) → dos parámetros
        luna.maullar(3, "MIAU FUERTE ");
        sol.maullar(1, "miau suavecito...");

        

   

        //  5. @Override en acción 
        System.out.println(" @OVERRIDE: hablar() ");
        luna.hablar();   // usa Gato.hablar()  → "¡Miau!"
        cleo.hablar();   // usa GatoSiames.hablar() → "¡MIAU SIAMÉS!"
        // SerVivo.hablar() nunca se ejecuta — fue reemplazado

        //  6. HERENCIA en cadena 
        System.out.println("HERENCIA");
        cleo.respirar();          // heredado de SerVivo → Gato → GatoSiames
        cleo.dormir();            // heredado de Gato
        cleo.mostrarPatrones();   // propio de GatoSiames

        

       System.out.println(cleo.getNombre());  // heredado de SerVivo → Gato → GatoSiames

      
    }
}
