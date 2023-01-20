package usuario;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import datos.ControladorDatos;
import datos.Datos;
import logica.Operaciones;
import logica.Validaciones;

public class Principal {

	public static void main(String[] args) {

		// ZONA DECLARATIVA

		int opcionSubMenu = 0;

		int opcionelegida = 0;

		boolean salir = false;

		String autorBuscado = "";

		String palabraBuscada = "";

		LocalDate fechaBuscada;

		Datos noticia1 = new Datos(null, null, null, null);

		Datos noticia2 = new Datos(null, null, null, null);

		Datos noticia3 = new Datos(null, null, null, null);

		Datos nuevaNoticia = new Datos(null, null, null, null);

		Scanner lector = new Scanner(System.in);

		// INICIALIZAR fechaBuscada PARA QUE NO DE ERRORES

		fechaBuscada = LocalDate.parse("1111-11-11");

		// DAR VALORES A NOTICIA 1

		noticia1.setFecha(LocalDate.parse("2021-10-12"));

		noticia1.setTitulo("Los que nos leen nuestro periódico son los mejores");

		noticia1.setTexto(
				"Un científico muy famoso, cuyo nombre no desvelaremos a petición personal, ha publicado los resultados de una investigación recientemente en una revista muy prestigiosa, cuyo título y página en la que aparece dicha investigación no podemos desvelar porque solo nos la ha enseñado a nosotros. Aún así, creednos porque es verdad de la buena. La investigación ha desvelado que los lectores de nuestro periódico son los más inteligentes, atractivos, productivos y honrados del mundo. De entre estes, los que pagan la subscripción anual más cara, son los que más posibilidades tienen de acabar siendo multimillonarios. Todos los que leen otros periódicos que no son el nuestro, según concluye el estudio, tienen muchas mas posibilidades de que se les caiga un caimán hambriento encima, algo que, según el científico, ocurre cada tres segundos en España.");

		noticia1.setAutor("Miguel");

		// DAR VALORES A NOTICIA 2

		noticia2.setFecha(LocalDate.parse("2020-04-13"));

		noticia2.setTitulo("Todo está bien");

		noticia2.setTexto("Absolutamente todo en el mundo va bien. No hay nada malo que contar hoy. Disfrutad el día.");

		noticia2.setAutor("Marta");

		// DAR VALORES A NOTICIA 3

		noticia3.setFecha(LocalDate.parse("2022-07-24"));

		noticia3.setTitulo("La verdad sobre los pomos de las puertas");

		noticia3.setTexto(
				"Hoy por la noche, en la Sexta, se emitirá un especial de Equipo de Investigación, para desvelar los secretos nunca antes contados de los pomos de las puertas. Qué nos ocultan estos aparentemente inocuos objetos? Es posible que quieran dominar el mundo? Se contará con la participación del Presidente de la Asociación Española de la Estudios del Pomo.");

		noticia3.setAutor("Pablo");

		// METER LAS NOTICIAS EN EL FICHERO DE TEXTO "NOTICIAS.txt"

		Operaciones.escribirFichero("carpetaFicheros/Noticias.txt", noticia1);
		Operaciones.escribirFichero("carpetaFicheros/Noticias.txt", noticia2);
		Operaciones.escribirFichero("carpetaFicheros/Noticias.txt", noticia3);

		// INICIO MENU PRINCIPAL
		do {

			try {
				Consola.mostrarMenu();

				opcionelegida = lector.nextInt();
				// LIMPIAMOS BUFFER
				lector.nextLine();

				switch (opcionelegida) {

				case 1:
					// INSERTAR NOTICIA

					// SUBMENU: OPCION 1 METER EN ARRAY LIST, OPCION 2 CREAR OBJETO DE DATOS Y PASAR
					// AL FICHERO

					Consola.mostrarSubMenu();

					try {
						opcionSubMenu = lector.nextInt();
						// LIMPIAMOS BUFFER
						lector.nextLine();

					} catch (Exception general) {
						Consola.imprimir("Error tipo de dato");
					}

					switch (opcionSubMenu) {
					case 1:
						// GUARDAR EN LISTA

						ControladorDatos.guardarEnLista();

						break;

					case 2:
						// GUARDAR COMO OBJETO

						Operaciones.escribirFichero("carpetaFicheros/Noticias.txt",
								ControladorDatos.guardarComoObjeto(nuevaNoticia));

						Consola.imprimir("\n" + "Recuerda que puedes darle al 4 para verlo todo" + "\n");

						break;

					default:
						Consola.imprimir("Solo puedes elegir el 1 o el 2");
						break;

					}

					break;

				case 2:

					// BUSCAR POR FECHA

					Consola.imprimir("Ha entrado en buscar");

					try {

						fechaBuscada = Operaciones.introducirFecha();

					} catch (java.lang.NullPointerException e) {

						Consola.imprimir("Solo números, por favor");

					} catch (Exception e) {

						Consola.imprimir("Error general");
					}

					Operaciones.buscarPorFecha(fechaBuscada, noticia1);

					Operaciones.buscarPorFecha(fechaBuscada, noticia2);

					Operaciones.buscarPorFecha(fechaBuscada, noticia3);

					Operaciones.buscarPorFecha(fechaBuscada, nuevaNoticia);

					break;
				case 3:

					// BUSCAR POR AUTOR

					try {

						do {

							autorBuscado = Consola.pedirAutor();

						} while (!Validaciones.validarString(autorBuscado));

					} catch (InputMismatchException e) {

						Consola.imprimir("Error tipo de datos");

					} catch (Exception e) {

						Consola.imprimir("Error general");
					}

					Operaciones.buscarPorAutor(autorBuscado, noticia1);

					Operaciones.buscarPorAutor(autorBuscado, noticia2);

					Operaciones.buscarPorAutor(autorBuscado, noticia3);

					Operaciones.buscarPorAutor(autorBuscado, nuevaNoticia);

					break;
				case 4:

					// MOSTRAR TODAS LAS NOTICIAS

					Operaciones.leerFichero("carpetaFicheros/Noticias.txt");

					System.out.println("\n");

					break;
				case 5:

					// BUSCAR POR PALABRAS

					Consola.imprimir("Introduce la palabra ha buscar");

					try {

						do {
							palabraBuscada = lector.nextLine();

						} while (!Validaciones.validarString(palabraBuscada));

					} catch (java.util.InputMismatchException e) {

						Consola.imprimir("Error tipo de datos");

					} catch (Exception e) {

						Consola.imprimir("Error general");
					}

					Operaciones.buscarPorPalabras(palabraBuscada, noticia1);
					Operaciones.buscarPorPalabras(palabraBuscada, noticia2);
					Operaciones.buscarPorPalabras(palabraBuscada, noticia3);
					Operaciones.buscarPorPalabras(palabraBuscada, nuevaNoticia);

					break;
				case 6:

					// SALIR

					salir = true;

					System.out.println("Gracias por usar el programa!");

					break;

				default:
					Consola.imprimir("Tienes que elegir un numero del 1 al 6");
					break;

				}

			} catch (Exception e) {
				Consola.imprimir("Error general");
			}

		} while ((opcionelegida >= 1 && opcionelegida <= 6) && !salir);

	}

}
