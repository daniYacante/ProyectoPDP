package Core.Clases;

public class Rol {
	private String clase="";
	private String descripcion="";
	private String habilidad1="";
	private String habilidad2="";
	private String habilidadEspecial="";
	
	public Rol(int opcion) {
		switch (opcion) {
		case 1:
			this.clase="Paladin";
			this.descripcion="Guerrero santo atado a un juramento sagrado";
			this.habilidad1="Espadazo";
			this.habilidad2="Imposicion de Manos";
			this.habilidadEspecial="Golpe Divino";
			break;
		case 2:
			this.clase="Clerigo";
			this.descripcion="Guerrero sacerdotal que ejerce magia divina en servicio de un poder superior";
			this.habilidad1="Bendicion";
			this.habilidad2="Curar Heridas";
			this.habilidadEspecial="Curar Heridas en Area";
			break;
		case 3:
			this.clase="Mago";
			this.descripcion="Usuario de magia estudioso que es capaz de manipular la realidad";
			this.habilidad1="Bastonazo";
			this.habilidad2="Manos Quemantes";
			this.habilidadEspecial="Bola de Fuego";
			break;
		case 4:
			this.clase="Rogue";
			this.descripcion="Malandrin que utiliza el sigilo y artimañas para superar obstaculos y enemigos";
			this.habilidad1="Acuchillada";
			this.habilidad2="Imposicion de Manos";//Tengo que buscar mas sobre los rogue
			this.habilidadEspecial="Golpe Mortal";
			break;
		default:
			break;
		}
	}
	public String getClase() {
		return clase;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getHabilidad1() {
		return habilidad1;
	}
	public String getHabilidad2() {
		return habilidad2;
	}
	public String getHabilidadEspecial() {
		return habilidadEspecial;
	}
}
