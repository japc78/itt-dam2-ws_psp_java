package itt_metodo2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.TreeMap;

import itt_comun.Producto;

/**
 * DAM2 - UTF2<br/>
 * Actividad 1. Tarea individual.
 * Servidor socket para consulta de inventario frutería.
 *
 * Enunciado: Esta práctica consiste en la implementación de un servidor socket que atenderá peticiones de clientes que desean consultar la disponibilidad y precio de artículos en un almacén de frutería.
 *
 * Especificaciones:
 * - Para comenzar, partirás de una copia de la última versión de la aplicación cliente-servidor que desarrollaste durante el estudio de la unidad. Concretamente la que quedó desarrollada en la lección “2.3. Utilización de hilos en la programación de aplicaciones en red” apartado “Servidor multihilo”.
 * - Esta vez el cliente no se comunicará con el servidor para enviarle simples mensajes, sino que enviará códigos de artículos para consultar, esperando que el servidor responda con todos los detalles del artículo si ha sido encontrado en el almacén de frutería.
 * - Cada código de artículo es una cadena de texto de 2 caracteres.
 * - Los artículos estarán guardados en una colección de tipo TreeMap de objetos Producto cuya declaración estará situada en la clase Servidor
 *
 *
 * @author Juan Antonio Pavón Carmona
 * @version Metodo 2. Con Socket y BufferedReader.
 *
 */

public class Servidor {
	// Se crea el atributo de clase productos como treemap, para poder acceder desde la clase hilosEscuchador a través de el getter correspondiente.
	private static TreeMap <String, Producto>  productos = new TreeMap <String, Producto>();

	public static void main(String[] args) {
		// Se declara el servidor(SeverSocket) y la conexion(Socket).
		ServerSocket servidor = null;
		Socket conexionACliente = null;

		// Se añaden los datos al treemap de productos
		productos.put("PL",new Producto("Peras limoneras", 14, 5f));
		productos.put("PC",new Producto("Peras conferencia", 12, 7f));
		productos.put("PN",new Producto("Plátano canario", 5, 2.5f));
		productos.put("BN",new Producto("Bananas", 7, 1.3f));
		productos.put("TP",new Producto("Tomates tipo pera", 8, 1.7f));
		productos.put("TR",new Producto("Tomates Raf", 7, 5.3f));
		productos.put("UN",new Producto("Uvas negras", 8, 3.2f));
		productos.put("UB",new Producto("Uvas blancas", 5, 2.7f));
		productos.put("PT",new Producto("Picotas", 8, 4.3f));
		productos.put("CR",new Producto("Ciruelas rojas", 10, 2.8f));
		productos.put("MR",new Producto("Melocotones rojos", 3, 2.5f));
		productos.put("MA",new Producto("Melocotones amarillos", 4, 3.2f));



		System.out.println("SERVIDOR DE CONSULTA DE ARTICULOS");
		System.out.println("----------------------------------");
		try {
			// Se arranca el servidor. Se instancia servidor de la clase ServerSocktes pasando como argumento el puerto de conexion.
			servidor = new ServerSocket(2202);


			// Se muestra por pantalla los mensajes de servidor listo y se muestra la ip, nombre del host y puerto de la maquina.
			// InetAddress.getLocalHost() -> Retorna la ip y host name de la maquina .
			System.out.println("Servidor listo para aceptar solicitudes");
			System.out.println("Dirección IP: " + InetAddress.getLocalHost());
			System.out.println("Puerto: " + servidor.getLocalPort());

			// Se queda el servidor en modo 'Demonio' esperando una conexcion.
			while (true) {
				System.out.println("SERVIDOR: Esperando peticion...");

				// El servidor se queda esperando el programa hasta que entra una peticion de conexion por parte de un cliente.
				conexionACliente = servidor.accept();
				System.out.println("Comunicación entrante");

				// Cuando tenemos una conexion se le pasa a la clase hilosEscuchasdor la conexion del cliente y el TreeMap con los productos.
				// Se creara un hilo para esta conexion servidor/cliente
				new HiloEscuchador(conexionACliente);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/** Getter de Produtos
	 * @return the productos
	 */
	public static TreeMap<String, Producto> getProductos() {
		return productos;
	}
}