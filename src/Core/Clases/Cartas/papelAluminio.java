package Core.Clases.Cartas;

import Core.Clases.Heroes.Heroe;

/**
 * objeto engañoso
 */
public class papelAluminio implements Item {

	/**
	 * el nombre del item
	 */
	protected String nombreItem;
	/**
	 * Su descripcion
	 */
	protected String descripcionItem;
	/**
	 * Quien es el que la lleva
	 */
	protected Heroe heroePortador;
	/**
	 * constructor para la creacion del papel aluminio
	 */
	public papelAluminio() {
		this.nombreItem="Papel aluminio";
		this.descripcionItem="Alguien dejo aqui papel aluminio";
	}

	/**
	 * Nos muestra la descripcion del papel aluminio, nada bueno
	 */
	@Override
	public String imprimirDescripcion() {
		return this.descripcionItem;
	}

	/**
	 * Nos devuelve el nombre (papel aluminio)
	 * @return String de papel aluminio
	 */
	@Override
	public String getNombreCarta(){
		return this.nombreItem;
	}

	/**
	 * No realiza nada
	 */

	public void realizarEfecto(){
		System.out.println("No hay ningun efecto");
	}

	/**
	 * Se le setea el portador
	 * @param portador heroe quien lleve el item
	 */

	@Override
	public void setPortador(Heroe portador) {
		this.heroePortador = portador;
	}
}
