package Core.Clases.Cartas;

import Core.Clases.Heroes.Heroe;

/**
 * objeto engañoso
 */
public class papelAluminio implements Item {

	protected String nombreItem;
	protected String descripcionItem;
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

	@Override
	public String getNombreCarta(){
		return this.nombreItem;
	}

	public void realizarEfecto(){
		System.out.println("No hay ningun efecto");
	}

	@Override
	public void setPortador(Heroe portador) {
		this.heroePortador = portador;
	}
}
