
// INTERFACE — Contrato que deben cumplir
// todas las clases que usen "implements Animal"
// No tiene cuerpo, solo define qué métodos
// deben existir obligatoriamente

public interface Animal {
    void hablar();        // toda clase Animal DEBE tener hablar()
    void dormir();        // toda clase Animal DEBE tener dormir()
    String getNombre();   // toda clase Animal DEBE tener getNombre()
}
