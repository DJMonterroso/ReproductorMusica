import java.util.Scanner;

public class ReproductorMusica {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            limpiarPantalla();
            mostrarMenu();
            opcion = leerEntero("\nSeleccione una opción: ");
            switch (opcion) {
                case 1 -> {
                    
                    esperarEnter();
                }
                case 2 -> {
                    
                    esperarEnter();
                }
                case 3 -> {
                    
                    esperarEnter();
                }
                case 4 -> {
                    
                    esperarEnter();
                }
                case 5 -> {
                    
                    esperarEnter();
                }
                case 6 -> {
                    System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                    esperarEnter();
                    return;
                }
                default -> {
                    System.out.println("Opción inválida.");
                    esperarEnter();
                }
            }
        } while (true);
    }

    private static void mostrarMenu() {
        System.out.println("=========== REPRODUCTOR DE MÚSICA ===========");
        System.out.println("1. Crear nueva playlist");
        System.out.println("2. Agregar canción a una playlist");
        System.out.println("3. Mostrar canciones de una playlist");
        System.out.println("4. Buscar canción por título");
        System.out.println("5. Eliminar canción por título");
        System.out.println("6. Salir");
        System.out.println("=============================================");
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }

    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void esperarEnter() {
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
}

// Clase base
class Cancion {
    String titulo;
    String artista;
    int duracion;

    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
    }

    // Nodo para la lista enlazada
class NodoCancion {
    Cancion cancion;
    NodoCancion siguiente;

    public NodoCancion(Cancion cancion) {
        this.cancion = cancion;
        this.siguiente = null;
    }
}

// Lista enlazada de canciones
class ListaCanciones {
    NodoCancion inicio;

    public void agregarCancion(Cancion c) {
        NodoCancion nuevo = new NodoCancion(c);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            NodoCancion actual = inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        System.out.println("Canción agregada correctamente.");
    }

    public void mostrarCanciones() {
        if (inicio == null) {
            System.out.println("La playlist está vacía.");
            return;
        }
        NodoCancion actual = inicio;
        System.out.println("\nCANCIONES EN LA PLAYLIST:");
        while (actual != null) {
            System.out.println("---------------------------");
            System.out.println("Título: " + actual.cancion.titulo);
            System.out.println("Artista: " + actual.cancion.artista);
            System.out.println("Duración: " + actual.cancion.duracion + " segundos");
            actual = actual.siguiente;
            }
        }
    }

}
