package Core.Clases.Cartas;

public class papelAluminio extends Carta {
	public papelAluminio() {
		super.nombreCarta="Papel aluminio";
		super.descripcion="Alguien dejo aqui papel aluminio";
	}
	@Override
	public void imprimirDescripcion() {
		System.out.println(this.descripcion);
	}

}
