package logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import datos.Datos;
import usuario.Consola;

public class Operaciones {

	// METODO PARA LEER FICHERO
	public static void leerFichero(String ruta) {

		FileReader fichero = null;
		BufferedReader lector = null;
		String cadena;

		try {
			fichero = new FileReader(ruta);
			lector = new BufferedReader(fichero);

			while ((cadena = lector.readLine()) != null) {
				Consola.imprimir(cadena + "\n");
			}

		} catch (FileNotFoundException e) {
			Consola.imprimir("No se encuentra el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			Consola.imprimir("Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			Consola.imprimir("Error inesperado");
			e.printStackTrace();
		} finally {
			try {
				if (lector != null) {
					lector.close();
				}
				if (fichero != null) {
					fichero.close();
				}

			} catch (IOException e) {
				Consola.imprimir("Error al cerrar el fichero");
				e.printStackTrace();
			}

		}

	}

	// METODO PARA ESCRIBIR FICHERO, PASANDO RUTA Y OBJETO DE TIPO DATOS

	public static void escribirFichero(String ruta, Datos noticia) {

		FileWriter guardar = null;

		try {
			guardar = new FileWriter(ruta, true);
			guardar.write(ModificarDatos.pasarDatosAString(noticia) + (char) 13);

		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			Consola.imprimir("Un error incontrolado");
		} finally {
			try {
				if (guardar != null) {
					guardar.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	// METODO PARA INTRODUCIR FECHAS
	public static LocalDate introducirFecha() {

		Scanner lector = new Scanner(System.in);

		LocalDate fechaLocalDate = null;

		String diaString = "";

		String mesString = "";

		String anioString = "";

		String fechaString = "";

		try {

			do {

				System.out.println("Pon el dia en números (01-31):");
				diaString = lector.nextLine();

			} while (!Validaciones.validarString(diaString) || !Validaciones.debeSerNumeroDia(diaString));

			do {

				System.out.println("Pon el mes en números (01-12):");
				mesString = lector.nextLine();

			} while (!Validaciones.validarString(mesString) || !Validaciones.debeSerNumeroMes(mesString));

			do {

				System.out.println("Pon el año en números (2012):");
				anioString = lector.nextLine();

				if (anioString.length() < 4) {
					System.out.println("El año deben ser 4 dígitos");
				}

			} while (!Validaciones.validarString(anioString) || anioString.length() < 4);

			fechaString = anioString + "-" + mesString + "-" + diaString;

			fechaLocalDate = LocalDate.parse(fechaString);

		} catch (java.lang.NumberFormatException e) {
			Consola.imprimir("Solo se pueden meter número en las fechas");
		}

		return fechaLocalDate;

	}

	// METODO PARA BUSCAR POR FECHA

	public static void buscarPorFecha(LocalDate fechaAbuscar, Datos objetoNoticia) {

		if (objetoNoticia.toString().contains(fechaAbuscar.toString())) {

			Consola.imprimir(objetoNoticia.toString());

		}

	}
	// METODO PARA BUSCAR POR AUTOR

	public static void buscarPorAutor(String autorAbuscar, Datos objetoNoticia) {

		if (objetoNoticia.toString().contains(autorAbuscar)) {

			Consola.imprimir(objetoNoticia.toString());

		}

	}

	// METODO PARA BUSCAR POR PALABRAS

	public static void buscarPorPalabras(String palabraAbuscar, Datos objetoNoticia) {

		if (objetoNoticia.toString().contains(palabraAbuscar)) {

			Consola.imprimir(objetoNoticia.toString());

		}

	}

}
