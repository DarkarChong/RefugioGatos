// CLASE REFUGIO
// Maneja una colección de gatos con ArrayList.
// Demuestra: ArrayList, for loop, enhanced for,
// búsqueda con if/else, parámetros, métodos.

import java.util.ArrayList;  // necesario para usar ArrayList

public class Refugio {

    // ── ATRIBUTOS ─────────────────────────────────────────────
    private String nombre;
    private ArrayList<Gato> gatos;  // lista dinámica — crece y encoge

    // ── CONSTRUCTOR ───────────────────────────────────────────
    public Refugio(String nombre) {
        this.nombre = nombre;
        this.gatos  = new ArrayList<Gato>();  // empieza vacía
    }

    // ── AGREGAR GATO (recibe un parámetro de tipo Gato) ───────
    public void agregarGato(Gato g) {
        gatos.add(g);  // .add() agrega al final de la lista
        System.out.println("✅ " + g.getNombre() + " ingresó al refugio.");
    }

    // ── MOSTRAR TODOS (enhanced for loop) ─────────────────────
    // "for (Gato g : gatos)" → por cada Gato en la lista...
    public void mostrarTodos() {
        System.out.println("\n🏠 Refugio: " + nombre);
        System.out.println("─────────────────────────────");

        for (Gato g : gatos) {
            System.out.println("🐱 " + g.getNombre()
                + " | Color: " + g.getColor()
                + " | Vidas: " + g.getVidas());
            g.mostrarEstado();
        }
    }

    // ── BUSCAR POR NOMBRE (for + if/else) ────────────────────
    public void buscarPorNombre(String nombreBuscado) {
        System.out.println("\n🔍 Buscando: " + nombreBuscado + "...");

        for (Gato g : gatos) {
            if (g.getNombre().equals(nombreBuscado)) {
                System.out.println("¡Encontrado! " + g.getNombre()
                    + " | Estado: " + g.getEstado());
                return;  // sale del método al encontrarlo
            }
        }

        // Si el for termina sin encontrar nada, llega aquí
        System.out.println("❌ '" + nombreBuscado + "' no está en el refugio.");
    }

    // ── GETTER ────────────────────────────────────────────────
    public int totalGatos() {
        return gatos.size();  // .size() da el número de elementos
    }
}
