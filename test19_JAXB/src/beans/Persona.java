package beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// STUDY JAXB -> Las anotaciones sirven para que JAXB que es el motor de java para convertir objetos a XML y a la inversa, sepa como hacerlo serializar y deserializar

// STUDY JAXB -> @XmlRootElement()  Esta anotación habilita la serialización de esta clase a XML. Esta etiqueta establece el nombre de el nodo raiz en xml, etiqueta obligatoria
@XmlRootElement(name="persona")

// STUDY JAXB -> @XmlType(propOrder = {})  podemos hacer que las etiquetas salgan en un determinado orden etiqueta opcional
@XmlType(propOrder = {
	    "idPersona",
	    "nombre",
	    "apellido",
	    "edad",
	    "direccion"
	})

	public class Persona {
	private int idPersona;
	private String nombre;
	private String apellido;
	private int edad;
	private Direccion direccion;

	// JAXB necesita para funcionar del constructor vacio por defecto de java
	public Persona() {

	}

	public Persona( int id, String nombre, String apellido, int edad) {
		this.idPersona = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	// STUDY JAXB -> @XmlAttribute(name = "id") Etiqueta que hace que el id de la persona se serialize como atributo de persona etiqueta opcional
	@XmlAttribute(name = "id")
	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	// Etiqueta opcional
	@XmlElement
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// STUDY JAXB -> @XmlAttribute(name="apellidos") Etiqueta que hace que el id de la persona se serialize como atributo de persona etiqueta opcional
	@XmlElement(name="apellidos")
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@XmlElement
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", direccion=" + direccion + "]";
	}
}
