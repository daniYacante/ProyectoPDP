package Core.Clases.Cartas;

/**
 * objeto engañoso
 */
public class papelAluminio extends Carta {

	/**
	 * constructor para la creacion del papel aluminio
	 */
	public papelAluminio() {
		super.nombreCarta="Papel aluminio";
		super.descripcion="Alguien dejo aqui papel aluminio";
	}

	/**
	 * Nos muestra la descripcion del papel aluminio, nada bueno
	 */
	@Override
	public void imprimirDescripcion() {
		System.out.println(this.descripcion);
	}

}
