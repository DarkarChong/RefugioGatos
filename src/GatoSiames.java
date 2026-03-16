// CLASE GATOSIAMES — hereda de Gato
// Gato ya hereda de SerVivo, así que
// GatoSiames hereda de AMBOS en cadena:
//   GatoSiames → Gato → SerVivo

public class GatoSiames extends Gato {

    // Atributo extra que solo tiene el Siamés
    private String patrones;

    // Constructor — llama a super() para inicializar Gato
    public GatoSiames(String nombre, String patrones) {
        super(nombre, "Crema y café", 9);  // llama al constructor de Gato
        this.patrones = patrones;
    }

    // ─ @Override  reemplaza el hablar() de Gato 
    // La cadena es: GatoSiames.hablar() reemplaza Gato.hablar()
    // que ya reemplazó SerVivo.hablar()
    @Override
    public void hablar() {
        System.out.println(getNombre() + ": ¡MIAU SIAMÉS!");
    }

    // Método propio — solo lo tiene GatoSiames
    public void mostrarPatrones() {
        System.out.println(getNombre() + " tiene patrones: " + patrones);
    }
}
