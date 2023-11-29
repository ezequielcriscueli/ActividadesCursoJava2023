package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private static ArrayList<Libro> libros;
    private static ArrayList<Usuario> usuarios;

    public Biblioteca() {
        Biblioteca.libros = new ArrayList<>();
        Biblioteca.usuarios = new ArrayList<>();
    }
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        new Biblioteca();
        menuPrincipal();
        
    }
    
    private static void menuPrincipal(){   

        int opcion;
        
        do {
            System.out.println("\nMenú del Usuario\n");
            System.out.println("1 - Agregar un usuario nuevo");
            System.out.println("2 - Ingreso de usuario");
            System.out.println("3 - Salir");
            System.out.println(" ");
            System.out.print("Seleccione una opción: ");
            
            if(scanner.hasNextInt()){   
                opcion = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (opcion) { 
                    case 1 -> registrarUsuarioNuevo();
                    case 2 -> validarUserExistente();
                    case 3 -> System.out.println("\nSesión finalizada. Hasta la próxima...\n");
                    default -> System.out.println("\nLa opción ingresada no es un número válido. Por favor intente nuevamente...\n");
                            
                }
            } else {
                System.out.println("La opción ingresada no es un número. Por favor intente nuevamente...\n");
                scanner.nextLine(); 
                opcion = 0;
            }
            
        } while (opcion != 3);
        
        scanner.close(); 
    
    }
       
    private static void registrarUsuarioNuevo(){
    
        System.out.println(" ");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine().toUpperCase(); 
        
        System.out.print("Ingrese su apellido: ");
        String apellido = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese su DNI (8 dígitos sin puntos): ");
        String dniStr = scanner.nextLine();
        
        if(validarNombre(nombre) && validarApellido(apellido)  && validarDni(dniStr)){
            int dni = Integer.parseInt(dniStr); 
            Usuario nuevoUser = new Usuario(nombre, apellido, dni); 
            usuarios.add(nuevoUser);   
            System.out.println(" ");
            System.out.println("El Usuario " + nombre + " " + apellido + " ha sido registrado con éxito."); 
            System.out.println(" ");
        } else {
            System.out.println("\nOcurrió un error con algunos de los datos ingresados. El usuario no pudo ser registrado."); 
            System.out.println(" ");
        }
    }
    
    private static boolean validarNombre (String nombre){
        return !nombre.isBlank() && nombre.matches("[a-zA-ZñÑ]+"); 
    }
    
    private static boolean validarApellido(String apellido) {
        return !apellido.isBlank() && apellido.matches("[a-zA-ZñÑ]+");
    }

    private static boolean validarDni(String dniStr){ 
        return dniStr.length() == 8 && dniStr.matches("\\d{8}"); 
    }

    private static void validarUserExistente(){

        System.out.println(" ");
        System.out.print("Ingrese con su DNI (8 dígitos sin puntos): ");
        String dniStr = scanner.nextLine();
        
        if (validarDni(dniStr)){
            int dni = Integer.parseInt(dniStr);
            Usuario usuarioEncontrado = buscarUsuarioPorDni(usuarios, dni);
            if (usuarioEncontrado != null){
                System.out.println(" ");
                System.out.println("Bienvenido " + usuarioEncontrado.getNombre() + " " + usuarioEncontrado.getApellido());
                System.out.println(" ");
                menuUsuario();
            } else {
                System.out.println("\nUsuario no encontrado, deberá registrarlo para poder continuar...");
                System.out.println(" ");
            }
            
        } else {
            System.out.println("\nEl DNI no es numérico o no posee 8 dígitos. Por favor intente nuevamente..."); 
            System.out.println(" ");
        }
        
    }
    
    private static Usuario buscarUsuarioPorDni(ArrayList<Usuario> usuarios, int dni){
        for (Usuario usuario : usuarios) {
            if (usuario.getDni() == dni) {
                return usuario;
            }
        }
        return null;
    }
    
    private static void menuUsuario(){

        int opcionUser;
        
        do {
            System.out.println("Menú de Libros\n");
            System.out.println("1 - Agregar un libro");
            System.out.println("2 - Eliminar un libro");
            System.out.println("3 - Alquilar un libro");
            System.out.println("4 - Devolver un libro");
            System.out.println("5 - Buscar un libro");
            System.out.println("6 - Mostrar los libros");
            System.out.println("7 - Volver al Menú de Usuario");
            System.out.println("8 - Salir");
            System.out.println(" ");
            System.out.print("Seleccione una opción: ");
            
            if(scanner.hasNextInt()){   
                opcionUser = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcionUser) { 
                    case 1 -> agregarLibro();
                    case 2 -> eliminarLibro();
                    case 3 -> alquilarLibro();
                    case 4 -> devolverLibro();
                    case 5 -> menuBuscarLibro();
                    case 6 -> listarLibros();
                    case 7 -> System.out.println(" "); 
                    case 8 -> {
                        System.out.println("\nSesión finalizada. Hasta la próxima...\n");
                        System.exit(0);
                    }
                    default -> System.out.println("\nLa opción ingresada no es un número válido. Por favor intente nuevamente...\n");
                            
                }
            } else {
                System.out.println("\nLa opción ingresada no es un número. Por favor intente nuevamente...\n");
                scanner.nextLine(); 
                opcionUser = 0;
            }
            
        } while (opcionUser != 7);
    
    }
        
    private static void agregarLibro(){
    
        System.out.println(" ");
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine().toUpperCase();
        
        System.out.print("Ingrese el nombre del autor del libro: ");
        String autor = scanner.nextLine().toUpperCase();
        
        System.out.print("Ingrese el género del libro: ");
        String genero = scanner.nextLine().toUpperCase();
        
        boolean disponible = true;
        
        if (campoRellenado(titulo) && campoRellenado(autor) && campoRellenado(genero)){ 
            if(!libroRepetido(libros, titulo)){      
                Libro nuevoLibro = new Libro(titulo, autor, genero, disponible); 
                libros.add(nuevoLibro);    
                System.out.println(" ");
                System.out.println("Libro ingresado con éxito."); 
                System.out.println(" ");           
            } else {
                System.out.println("El libro que intenta agregar ya existe, intente nuevamente");
                System.out.println(" "); 
            } 
        } else {
            System.out.println("Alguno de los datos solicitados estaban en blanco. El libro no pudo ser agregado."); 
            System.out.println(" ");
        }
    }
    
    private static boolean campoRellenado(String palabra){
        return !palabra.isBlank();
    }
    
    private static boolean libroRepetido (ArrayList<Libro> libros, String titulo){
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                return true; 
            }
        }
        return false; 
    }
    
    private static void eliminarLibro(){
    
        System.out.println(" ");
        System.out.print("Ingrese el título del libro a eliminar: ");
        String titulo = scanner.nextLine().toUpperCase();
        
        for (Libro libro : libros){
            if (libro.getTitulo().equals(titulo)){
                libros.remove(libro);
                System.out.println(" ");
                System.out.println("Libro '" + titulo + "' eliminado con exito");
                System.out.println(" ");
                return;
            } 
        }
        System.out.println(" ");
        System.out.println("Libro '" + titulo + "' no encontrado en la lista");
        System.out.println(" ");
    }
    
    private static void listarLibros(){
        for (Libro libro : libros){
            System.out.println(libro);
        }
    }
    
    private static void alquilarLibro(){
    
        System.out.println(" ");
        System.out.print("Ingrese el título del libro que quisiera alquilar: ");
        String titulo = scanner.nextLine().toUpperCase();
        
        for (Libro libro : libros){
            if (libro.getTitulo().equals(titulo) && libro.isDisponible()){
                libro.setDisponible(false);
                System.out.println(" ");
                System.out.println("Libro '" + titulo + "' alquilado con éxito");
                System.out.println(" ");
                return;
            } 
        }
        System.out.println(" ");
        System.out.println("Libro '" + titulo + "' no encontrado o alquilado. No se pudo alquilar");
        System.out.println(" ");
        
    }
    
    private static void devolverLibro(){
    
    System.out.println(" ");
        System.out.print("Ingrese el título del libro que quisiera devolver: ");
        String titulo = scanner.nextLine().toUpperCase();
        
        for (Libro libro : libros){
            if (libro.getTitulo().equals(titulo) && !libro.isDisponible()){
                libro.setDisponible(true);
                System.out.println(" ");
                System.out.println("Libro '" + titulo + "' devuelto con éxito");
                System.out.println(" ");
                return;
            } 
        }
        System.out.println(" ");
        System.out.println("Libro '" + titulo + "' no encontrado o ya existente. No se pudo devolver");
        System.out.println(" ");
        
    }
        
    private static void menuBuscarLibro(){
    
        int opcion;
        
        do {
            System.out.println("Menú de Búsqueda");
            System.out.println("1 - Buscar por título");
            System.out.println("2 - Buscar por autor");
            System.out.println("3 - Buscar por género");
            System.out.println("4 - Volver al Menú de Usuarios");
            System.out.println("5 - Salir");
            System.out.println(" ");
            System.out.print("Seleccione una opción: ");
            
            if(scanner.hasNextInt()){   
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) { 
                    case 1 -> busquedaPorTitulo();
                    case 2 -> busquedaPorAutor();
                    case 3 -> busquedaPorGenero();
                    case 4 -> System.out.println(" ");
                    case 5 -> {
                        System.out.println("\nSesión finalizada. Hasta la próxima...\n");
                        System.exit(0);
                    }
                    default -> System.out.println("La opción ingresada no es un número válido. Por favor intente nuevamente...\n");
                            
                }
            } else {
                System.out.println("La opción ingresada no es un número. Por favor intente nuevamente...\n");
                scanner.nextLine(); 
                opcion = 0;
            }
            
        } while (opcion != 4);
    
    }
    
    private static void busquedaPorTitulo(){
        System.out.println(" ");
        System.out.print("Ingrese el título del libro para iniciar la búsqueda: ");
        String titulo = scanner.nextLine().toUpperCase();
        
        for (Libro libro : libros){
            if (libro.getTitulo().equals(titulo)){
                System.out.println(libro);
                return; 
            } 
        }
        System.out.println(" ");
        System.out.println("No hay libros para mostrar");
        System.out.println(" ");
    }
    
    private static void busquedaPorAutor(){
        System.out.println(" ");
        System.out.print("Ingrese el autor para iniciar la búsqueda: ");
        String autor = scanner.nextLine().toUpperCase();
        int flag = 0;
        
        for (Libro libro : libros){
            if (libro.getAutor().equals(autor)){
                System.out.println(libro);
                flag = 1;
            } 
        }
        System.out.println(" ");
        if (flag == 0){
            System.out.println("No hay libros para mostrar");
            System.out.println(" ");
            return;
        } 
        System.out.println(" ");
    }
    
    private static void busquedaPorGenero(){
        System.out.println(" ");
        System.out.print("Ingrese el género para iniciar la búsqueda: ");
        String genero = scanner.nextLine().toUpperCase();
        int flag = 0;
        
        for (Libro libro : libros){
            if (libro.getGenero().equals(genero)){
                System.out.println(libro);
                flag = 1;
            } 
        }
        
        System.out.println(" ");
        if (flag == 0){
            System.out.println("No hay libros para mostrar");
            System.out.println(" ");
            return;
        }
        System.out.println(" ");
    }
    
    
}
