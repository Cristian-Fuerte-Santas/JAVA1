package logica;

import usuario.Consola;

public class Validaciones {

	// METODO PARA VALIDAR QUE LA CADENA INTRODUCIDA NO ESTÉ VACÍA Y TENGA MÍNIMO 2
	// CARACTERES

	public static boolean validarString(String cadena) {

		boolean valido = true;

		if (cadena.length() == 0) {
			valido = false;
			System.out.println("Debes meter algo");
		}

		if (cadena.length() < 2) {
			valido = false;
			System.out.println("Debe tener minimo 2 caracteres");
		}

		return valido;
	}

	// METODO PARA QUE EL DÍA DEL MES ESTÈ ENTRE 1 Y 31

	public static boolean debeSerNumeroDia(String numerometido) {

		boolean valido;

		int numero = 0;

		numero = Integer.parseInt(numerometido);

		if (numero < 1 || numero > 31) {
			valido = false;
			Consola.imprimir("El día debe ser entre el 1 y el 31");
		} else {
			valido = true;
		}

		return valido;
	}

	// METODO PARA QUE EL MES ESTÈ ENTRE 1 Y 12
	public static boolean debeSerNumeroMes(String numerometido) {

		boolean valido;

		int numero = 0;

		numero = Integer.parseInt(numerometido);

		if (numero < 1 || numero > 12) {
			valido = false;
			Consola.imprimir("El mes debe ser entre el 1 y el 12");
		} else {
			valido = true;
		}

		return valido;
	}

}
