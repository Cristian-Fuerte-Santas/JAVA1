package logica;

import java.util.ArrayList;
import datos.Datos;
import usuario.Consola;

public class ModificarDatos {

	public static String pasarDatosAString(Datos dato) {

		return dato.toString();
	}

	public static ArrayList<String> pasarArrayListAString(ArrayList<String> array) {

		Consola.imprimir(array.toString());

		return array;
	}

	// METODO PARA QUE EL LA PRIMERA LETRA DE AUTOR SE PASE A MAYUSCULA

	public static String primeraLetraAutorMayuscula(String dato) {

		String primeraLetra = "";

		String restoLetras = "";

		primeraLetra = dato.substring(0, 1);
		restoLetras = dato.substring(1, dato.length());

		primeraLetra = primeraLetra.toUpperCase();
		restoLetras = restoLetras.toLowerCase();

		primeraLetra = primeraLetra.toUpperCase();
		dato = primeraLetra + restoLetras;

		return dato;

	}

	public static int pasarStringAInt(String cadenametida) {

		int numero = Integer.parseInt(cadenametida);

		return numero;
	}

}
