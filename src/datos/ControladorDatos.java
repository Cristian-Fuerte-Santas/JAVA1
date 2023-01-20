package datos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import logica.ModificarDatos;
import logica.Operaciones;
import logica.Validaciones;
import usuario.Consola;

public class ControladorDatos {

	public static Datos guardarComoObjeto(Datos noticiaNueva) {

		// guardar en fichero

		Scanner lector = new Scanner(System.in);

		String tituloIntroducido = "";

		String textoIntroducido = "";

		String autorIntroducido = "";

		LocalDate fechaIntroducida;

		Consola.imprimir("Empezamos por la fecha.");

		do {

			fechaIntroducida = Operaciones.introducirFecha();

		} while (fechaIntroducida == null);

		do {
			Consola.imprimir("Introduce el título: ");

			tituloIntroducido = lector.nextLine();

		} while (!Validaciones.validarString(tituloIntroducido));

		do {

			Consola.imprimir("Introduce el texto: ");

			textoIntroducido = lector.nextLine();

		} while (!Validaciones.validarString(textoIntroducido));

		do {

			Consola.imprimir("Introduce el autor: ");

			autorIntroducido = lector.nextLine();

		} while (!Validaciones.validarString(autorIntroducido));

		autorIntroducido = ModificarDatos.primeraLetraAutorMayuscula(autorIntroducido);

		noticiaNueva.setFecha(fechaIntroducida);

		noticiaNueva.setTitulo(tituloIntroducido);

		noticiaNueva.setTexto(textoIntroducido);

		noticiaNueva.setAutor(autorIntroducido);

		Consola.imprimir("Se ha añadido la noticia al fichero");

		return noticiaNueva;

	}

	public static void guardarEnLista() {

		ArrayList<String> ListaObjetosGuardados = new ArrayList<String>();

		Scanner lector = new Scanner(System.in);

		String tituloIntroducido = "";

		String textoIntroducido = "";

		String autorIntroducido = "";

		LocalDate fechaIntroducida;

		fechaIntroducida = Operaciones.introducirFecha();

		// SI LA FECHA NO SE METE BIEN, NO CONTINUAMOS. SI ESTÀ BIEN, SEGUIMOS

		if (fechaIntroducida == null) {
			Consola.imprimir("La fecha no puede estar vacía");
		} else {

			do {
				Consola.imprimir("Introduce el título: ");

				tituloIntroducido = lector.nextLine();

			} while (!Validaciones.validarString(tituloIntroducido));

			do {

				Consola.imprimir("Introduce el texto: ");

				textoIntroducido = lector.nextLine();

			} while (!Validaciones.validarString(textoIntroducido));

			do {

				Consola.imprimir("Introduce el autor: ");

				autorIntroducido = lector.nextLine();

			} while (!Validaciones.validarString(autorIntroducido));

			autorIntroducido = ModificarDatos.primeraLetraAutorMayuscula(autorIntroducido);

			ListaObjetosGuardados.add("fecha= " + fechaIntroducida + "\n");

			ListaObjetosGuardados.add("titulo= " + tituloIntroducido + "\n");

			ListaObjetosGuardados.add("texto= " + textoIntroducido + "\n");

			ListaObjetosGuardados.add("autor= " + autorIntroducido + "\n");

			Consola.imprimir("Se ha creado la noticia temporalemente, el resultado se ve así: " + "\n");

			Consola.imprimir(ListaObjetosGuardados.toString());

		}

	}

}
