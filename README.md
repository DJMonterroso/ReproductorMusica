# 🎵 Reproductor de Música

Este proyecto consiste en un sistema de consola que permite crear y gestionar múltiples playlists de música. Cada playlist está compuesta por canciones que se almacenan usando listas enlazadas simples, implementadas manualmente sin utilizar estructuras dinámicas estándar de Java como `ArrayList` o `LinkedList`.

## 📌 Funcionalidades implementadas

- ✅ Crear nuevas playlists
- ✅ Agregar canciones a una playlist
- ✅ Mostrar todas las canciones de una playlist
- ✅ Buscar canción por título dentro de una playlist
- ✅ Eliminar canción por título
- ✅ Validaciones completas para evitar errores comunes
- ✅ Confirmaciones antes y después de cada acción (estilo profesional)
- ✅ Limpieza de pantalla para mejorar la experiencia del usuario

## 🧠 Estructura del proyecto

- `Cancion`: clase que representa los datos de una canción (título, artista, duración)
- `NodoCancion`: nodo individual para la lista enlazada de canciones
- `ListaCanciones`: lista enlazada simple que gestiona las canciones de una playlist
- `Playlist`: almacena el nombre de la lista y su lista de canciones
- `ListaPlaylists`: lista enlazada que almacena múltiples playlists
- `ReproductorMusica`: clase principal con menú interactivo y flujo de control

## ⚙️ Tecnologías

- Lenguaje: Java 17+
- Entorno: consola (CMD / terminal)
- IDE sugerido: IntelliJ IDEA, NetBeans o Eclipse

## 🧪 Cómo usar

1. Clona el repositorio.
2. Abre el proyecto en tu IDE o compílalo desde consola:
   ```bash
   javac ReproductorMusica.java
   java ReproductorMusica
   ```
3.Interactúa con el menú de forma intuitiva.

## Estructura de archivos

Todo el código está contenido en un único archivo llamado:

```bash
ReproductorMusica.java
```

📌 Proyecto elaborado como parte del curso Programación 1
🎓 Desarrollado por: Diego Monterroso
🗓️ Junio 2025
