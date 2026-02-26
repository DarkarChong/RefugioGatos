// CLASE PADRE — SerVivo
// Gato va a heredar (extends) de esta clase.
// "protected" significa que las clases hijas
// también pueden ver ese atributo.

public class SerVivo {

    // protected → visible en esta clase Y en las clases hijas
    protected String name;

        // Constructor del padre — recibe el nombre
        public SerVivo(String nombre) {
            this.name = nombre;
        }

        // Método que las clases hijas pueden heredar o sobreescribir
        public void respirar() {
            System.out.println(name + " inhala... exhala...");
        }

        // Método genérico — las hijas lo sobreescriben con @Override
        public void hablar() {
            System.out.println("...");
        }
    }
