// CLASE GATO
// - extiende SerVivo     → hereda nombre, respirar(), hablar()
// - implementa Animal    → OBLIGADO a tener hablar(), dormir(), getNombre()

public class Gato extends SerVivo implements Animal {

    // ── ATRIBUTOS (todos private = encapsulamiento) ──────────
    // Nadie los puede tocar directo desde afuera.
    // Solo se leen/cambian con getters y setters.
    private int vidas;
    private String color;
    private EstadoGato estado;  // usa el enum que creamos

    // ── CONSTRUCTOR VACÍO ─────────────────────────────────────
    // Se usa cuando no tienes datos aún: new Gato()
    // super() llama al constructor del PADRE (SerVivo)
    public Gato() {
        super("Superman");            // le pasa "Superman" a SerVivo
        this.vidas  = 9;
        this.color  = "Desconocido";
        this.estado = EstadoGato.DORMIDO;
    }

    // ── CONSTRUCTOR CON PARÁMETROS ───────────────────────────
    // Se usa cuando ya tienes los datos: new Gato("Luna", "Gris", 9)
    // "this.nombre" = el atributo del objeto
    // "nombre"      = el parámetro que te pasaron
    public Gato(String nombre, String color, int vidas) {
        super(nombre);           // pasa el nombre al constructor de SerVivo
        this.color  = color;
        this.vidas  = vidas;
        this.estado = EstadoGato.DORMIDO;
    }

    // ── GETTERS — leer atributos privados ─────────────────────
    public String getNombre()      { return name; }
    public int getVidas()          { return vidas;  }
    public String getColor()       { return color;  }
    public EstadoGato getEstado()  { return estado; }

    // ── SETTERS — cambiar atributos con control ───────────────
    public void setEstado(EstadoGato nuevoEstado) {
        this.estado = nuevoEstado;
    }

    // ── MÉTODO CON PARÁMETROS ─────────────────────────────────
    // "veces" y "tono" solo existen dentro de este método
    public void maullar(int veces, String tono) {
        for (int i = 0; i < veces; i++) {
            System.out.println(name + ": " + tono);
        }
    }

    // Pierde una vida con lógica de if/else
    public void perderVida() {
        if (vidas > 0) {
            vidas--;
            System.out.println(name + " perdió una vida. Le quedan: " + vidas);
        } else {
            System.out.println(name + " no tiene más vidas 😿");
        }
    }

    // Muestra el estado con if / else if / else
    public void mostrarEstado() {
        System.out.print(name + " está: ");

        if (estado == EstadoGato.DORMIDO) {
            System.out.println("durmiendo 😴");
        } else if (estado == EstadoGato.JUGANDO) {
            System.out.println("¡jugando! 🐾");
        } else if (estado == EstadoGato.ENOJADO) {
            System.out.println("enojado... mejor no tocarlo 😾");
        } else if (estado == EstadoGato.ADOPTADO) {
            System.out.println("¡adoptado! tiene un hogar 🏠");
        } else {
            System.out.println("comiendo 🍖");
        }
    }

    // ── @Override — REEMPLAZA hablar() del padre SerVivo ─────
    // Sin @Override, Java no sabría que estás reemplazando.
    // Con @Override, si escribes mal el nombre Java te avisa.
    @Override
    public void hablar() {
        System.out.println(name + ": ¡Miau!");
    }

    // ── @Override — cumple el contrato de la interface Animal ─
    @Override
    public void dormir() {
        estado = EstadoGato.DORMIDO;
        System.out.println(name + " está durmiendo... Zzzz 💤");
    }
}
