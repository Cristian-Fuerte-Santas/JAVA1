package usuario;

import logica.ModificarDatos;
import logica.Validaciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Consola {

	public static void mostrarMenu() {

		imprimir("Estas son las opciones:" + "\n");

		imprimir("1. Insertar Noticia");
		imprimir("2. Buscar por fecha");
		imprimir("3. Buscar por autor");
		imprimir("4. Mostrar todas las noticias");
		imprimir("5. Buscar por palabras");
		imprimir("6. Salir");

		imprimir("\n" + "Que quieres hacer?");

	}

	public static void mostrarSubMenu() {

		imprimir("Como lo guardamos?");

		imprimir("\n" + "1. Guardar temporalmente");
		imprimir("2. Guardar en Fichero");

	}

	public static void imprimir(String dato) {

		System.out.println(dato);

	}

	public static void imprimir(int dato) {

		System.out.println(dato);

	}

	public static String buscarString() {

		String palabrametida = "";

		Scanner lector = new Scanner(System.in);
		do {

			palabrametida = lector.nextLine();

		} while (!Validaciones.validarString(palabrametida));

		return palabrametida;
	}

	public static String pedirAutor() {

		Scanner lector = new Scanner(System.in);
		String autor = "";
		imprimir("Introduce el autor a buscar");

		try {

			do {
				autor = lector.nextLine();

			} while (!Validaciones.validarString(autor));

		} catch (InputMismatchException e) {
			imprimir("error tipo dato");
		}
		autor = ModificarDatos.primeraLetraAutorMayuscula(autor);

		return autor;
	}

}
