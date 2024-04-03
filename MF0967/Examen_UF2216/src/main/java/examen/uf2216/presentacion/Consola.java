package examen.uf2216.presentacion;

import java.util.*;

import examen.uf2216.pojos.*;

public class Consola {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
        // Solicitar datos del libro
        String titulo = solicitarCampo("Título", 3, 150, scanner);
        int isbn = solicitarCampoISBN("ISBN", 10, scanner);
        int numeroPaginas = solicitarCampoNumPaginas("Número de páginas", 1, scanner);
        boolean formatoDigital = solicitarCampoFormato("Formato (digital=true, papel=false)", scanner);

        // Crear objeto libro

        Libro libro = new Libro(titulo, isbn, numeroPaginas, formatoDigital);

        libro.mostrarResumen();
        
        System.out.print("\n¿Desea guardar el libro en el CMS? (Sí/No): ");
        String confirmacion = scanner.nextLine();
        if (confirmacion.equalsIgnoreCase("Sí")) {
            // Aquí iría la lógica para guardar el libro en el CMS
            System.out.println("El libro ha sido guardado exitosamente en el CMS.");
        } else {
            System.out.println("El libro no ha sido guardado en el CMS.");
        }

        scanner.close();
    }

    // Método para solicitar un campo con formato válido
    public static String solicitarCampo(String nombreCampo, int min, int max, Scanner scanner) {
        String valor;
        do {
            System.out.print("Ingrese " + nombreCampo + " (" + min + " a " + max + " caracteres): ");
            valor = scanner.nextLine();
        } while (valor.length() < min || valor.length() > max);
        return valor;
    }

    // Método para solicitar un campo numérico para ISBN
    
     public static int solicitarCampoISBN(String nombreCampo, int num, Scanner scanner) {
    	 int valor = 0;
         do {
         	System.out.print("Ingrese " + nombreCampo + " (mínimo " + num + "): ");
             try {
             	valor = scanner.nextInt();
                 scanner.nextLine();
                 String valorString = String.valueOf(valor);
                 if (nombreCampo.equals("ISBN") && valorString.length() != 10) {
                     System.out.println(nombreCampo + " debe tener 10 caracteres.");
                     System.out.println("Introduzca de nuevo el " + nombreCampo);
                     valor = 0;
                 }
             } catch (NumberFormatException e) {
             	System.out.println("Debe ingresar un valor numérico para " + nombreCampo + ".");
             	valor = 0;
             }
         } while (valor < 10);
         
         return valor;
     }
     
     public static int solicitarCampoNumPaginas(String nombreCampo, int num, Scanner scanner) {
       	int valor = 0;
       	do {
            System.out.print("Ingrese " + nombreCampo + " (mínimo " + num + "): ");
            try {
                valor = scanner.nextInt();
                scanner.nextLine();
                if (nombreCampo.equals("Número de páginas") && valor < 1) {
                    System.out.println(nombreCampo + " debe tener al menos 1 página.");
                    System.out.println("Introduzca de nuevo el " + nombreCampo);
                    valor = 0;
                }
             } catch (NumberFormatException e) {
             	System.out.println("Debe ingresar un valor numérico para " + nombreCampo + ".");
             	valor = 0;
             }
         } while (valor < 1);
         
         return valor;
      }

    // Método para solicitar el formato (digital o papel)
    public static boolean solicitarCampoFormato(String nombreCampo, Scanner scanner) {
        String valor;
        do {
            System.out.print("Ingrese " + nombreCampo + ": ");
            valor = scanner.nextLine();
        } while (!valor.equalsIgnoreCase("true") && !valor.equalsIgnoreCase("false"));
        return Boolean.parseBoolean(valor);
    }
    
    
}
