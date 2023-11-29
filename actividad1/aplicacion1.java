import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Persona {
    String nombre;
    String apellido;
    String dni;
    Date fechaNacimiento;

    public Persona(String nombre, String apellido, String dni, Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }
}

public class aplicacion1 {
    private static final List<Persona> personas = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n┌─────────────────────────────┐");
        System.out.println("│ Bienvenido/a a NeoRegis 1.0 │");
        System.out.println("└─────────────────────────────┘");

        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    agregarPersona();
                    break;
                case 2:
                    listarPersonas();
                    break;
                case 3:
                    System.out.println("\n¡Gracias por usar la aplicación!\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n------------ Menú ------------");
        System.out.println("\n1. Agregar Persona al Registro");
        System.out.println("2. Listado del Registro");
        System.out.println("3. Salir");
        System.out.print("\nSeleccione una opción: ");
    }

    private static void agregarPersona() {
        System.out.println("\n--- Agregar Persona ---\n");

        System.out.print("Nombre/s: ");
        String nombre = validarNombreApellido(scanner.nextLine());

        System.out.print("Apellido/s: ");
        String apellido = validarNombreApellido(scanner.nextLine());

        System.out.print("DNI: ");
        String dni = validarDNI(scanner.nextLine());

        System.out.print("Fecha de Nacimiento (dd/mm/yyyy): ");
        Date fechaNacimiento = validarFechaNacimiento(scanner.nextLine());

        Persona nuevaPersona = new Persona(nombre, apellido, dni, fechaNacimiento);
        personas.add(nuevaPersona);

        System.out.println("\nRegistro actualizado con éxito");
    }

    private static void listarPersonas() {
        System.out.println("\n- Listado de Personas Registradas -");
        System.out.println("-----------------------------------");
        if (personas.isEmpty()) {
            System.out.println("No hay personas en el registro");
            System.out.println("-----------------------------------");

        } else {
            for (Persona persona : personas) {
                System.out.println("Nombre/s: " + persona.nombre);
                System.out.println("Apellido/s: " + persona.apellido);
                System.out.println("DNI: " + persona.dni);
                System.out.println("Fecha de Nacimiento: " + new SimpleDateFormat("dd/MM/yyyy").format(persona.fechaNacimiento));
                System.out.println("-----------------------------------");
            }
        }
    }

    private static String validarNombreApellido(String input) {
        while (input.trim().isEmpty() || input.length() > 30) {
            System.out.println("\nIngrese un valor válido (máximo 30 caracteres)");
            System.out.print("Vuelva a ingresar: ");
            input = scanner.nextLine();
        }
        return input;
    }

    private static String validarDNI(String input) {
        while (!input.matches("\\d{8}")) {
            System.out.println("\nIngrese un DNI válido de 8 dígitos");
            System.out.print("Vuelva a ingresar: ");
            input = scanner.nextLine();
        }
        return input;
    }

    private static Date validarFechaNacimiento(String input) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        while (true) {
            try {
                Date fecha = dateFormat.parse(input);
                return fecha;
            } catch (ParseException e) {
                System.out.println("\nIngrese una fecha válida en el formato dd/mm/yyyy");
                System.out.print("Vuelva a ingresar: ");
                input = scanner.nextLine();
            }
        }
    }
}
