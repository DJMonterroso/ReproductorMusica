import java.util.Scanner;

public class ReproductorMusica {
    static Scanner scanner = new Scanner(System.in);
    static ListaPlaylists listaPlaylists = new ListaPlaylists();

    public static void main(String[] args) {
        int opcion;
        do {
            limpiarPantalla();
            mostrarMenu();
            opcion = leerEntero("\nSeleccione una opción: ");
            switch (opcion) {
                case 1 -> {
                    if (confirmarAccion("¿Desea crear una nueva playlist?")) {
                        crearPlaylist();
                        esperarEnter();
                    }
                }
                case 2 -> {
                    if (confirmarAccion("¿Desea agregar una canción a una playlist?")) {
                        agregarCancion();
                        esperarEnter();
                    }
                }
                case 3 -> {
                    if (confirmarAccion("¿Desea mostrar canciones de una playlist?")) {
                        mostrarCanciones();
                        esperarEnter();
                    }
                }
                case 4 -> {
                    if (confirmarAccion("¿Desea buscar una canción por título?")) {
                        buscarCancion();
                        esperarEnter();
                    }
                }
                case 5 -> {
                    // eliminarCancion();
                    esperarEnter();
                }
                case 6 -> {
                    limpiarPantalla();
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

    private static void crearPlaylist() {
        System.out.print("Ingrese el nombre de la nueva playlist: ");
        String nombre = scanner.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }
        if (listaPlaylists.buscarPlaylist(nombre) != null) {
            System.out.println("Ya existe una playlist con ese nombre.");
            return;
        }
        Playlist nueva = new Playlist(nombre);
        listaPlaylists.agregarPlaylist(nueva);
    }

    private static void agregarCancion() {
        listaPlaylists.mostrarPlaylists();
        System.out.print("Ingrese el nombre de la playlist: ");
        String nombre = scanner.nextLine().trim();
        Playlist seleccionada = listaPlaylists.buscarPlaylist(nombre);
        if (seleccionada == null) {
            System.out.println("Playlist no encontrada.");
            return;
        }

        System.out.print("Ingrese el título de la canción: ");
        String titulo = scanner.nextLine().trim();
        if (titulo.isEmpty()) {
            System.out.println("El título no puede estar vacío.");
            return;
        }

        System.out.print("Ingrese el artista: ");
        String artista = scanner.nextLine().trim();
        if (artista.isEmpty()) {
            System.out.println("El artista no puede estar vacío.");
            return;
        }

        int duracion = leerEntero("Ingrese la duración (segundos): ");
        if (duracion <= 0) {
            System.out.println("La duración debe ser mayor a cero.");
            return;
        }

        Cancion nueva = new Cancion(titulo, artista, duracion);
        seleccionada.canciones.agregarCancion(nueva);
    }

    private static void mostrarCanciones() {
        listaPlaylists.mostrarPlaylists();
        System.out.print("Ingrese el nombre de la playlist: ");
        String nombre = scanner.nextLine().trim();
        Playlist seleccionada = listaPlaylists.buscarPlaylist(nombre);
        if (seleccionada == null) {
            System.out.println("Playlist no encontrada.");
            return;
        }
        seleccionada.canciones.mostrarCanciones();
    }

    private static void buscarCancion() {
        listaPlaylists.mostrarPlaylists();
        System.out.print("Ingrese el nombre de la playlist: ");
        String nombre = scanner.nextLine().trim();
        Playlist seleccionada = listaPlaylists.buscarPlaylist(nombre);
        if (seleccionada == null) {
            System.out.println("Playlist no encontrada.");
            return;
        }

        System.out.print("Ingrese el título de la canción a buscar: ");
        String titulo = scanner.nextLine().trim();
        seleccionada.canciones.buscarPorTitulo(titulo);
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

    private static boolean confirmarAccion(String mensaje) {
        String respuesta;
        while (true) {
            System.out.print(mensaje + " (S/N): ");
            respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("s")) return true;
            if (respuesta.equals("n")) return false;
            System.out.println("Respuesta inválida. Ingrese S o N.");
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

// =========================
// CLASES DE SOPORTE
// =========================

class Cancion {
    String titulo;
    String artista;
    int duracion;

    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
    }
}

class NodoCancion {
    Cancion cancion;
    NodoCancion siguiente;

    public NodoCancion(Cancion cancion) {
        this.cancion = cancion;
        this.siguiente = null;
    }
}

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

    public void buscarPorTitulo(String titulo) {
        if (inicio == null) {
            System.out.println("La playlist está vacía.");
            return;
        }
        NodoCancion actual = inicio;
        while (actual != null) {
            if (actual.cancion.titulo.equalsIgnoreCase(titulo)) {
                System.out.println("\nCANCION ENCONTRADA:");
                System.out.println("Título: " + actual.cancion.titulo);
                System.out.println("Artista: " + actual.cancion.artista);
                System.out.println("Duración: " + actual.cancion.duracion + " segundos");
                return;
            }
            actual = actual.siguiente;
        }
        System.out.println("No se encontró una canción con ese título.");
    }
}

class Playlist {
    String nombre;
    ListaCanciones canciones;
    Playlist siguiente;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new ListaCanciones();
    }
}

class ListaPlaylists {
    Playlist inicio;

    public void agregarPlaylist(Playlist nueva) {
        if (inicio == null) {
            inicio = nueva;
        } else {
            Playlist actual = inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nueva;
        }
        System.out.println("\nPlaylist creada exitosamente.");
    }

    public Playlist buscarPlaylist(String nombre) {
        Playlist actual = inicio;
        while (actual != null) {
            if (actual.nombre.equalsIgnoreCase(nombre)) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public void mostrarPlaylists() {
        if (inicio == null) {
            System.out.println("\nNo hay playlists creadas.");
            return;
        }
        System.out.println("\nPLAYLISTS DISPONIBLES:");
        Playlist actual = inicio;
        while (actual != null) {
            System.out.println("- " + actual.nombre);
            actual = actual.siguiente;
        }
    }
}
