package Core.Clases;

public class Rol {
	private String clase="";
	private String descripcion="";
	private Habilidad habilidad1;
	private Habilidad habilidad2;
	private Habilidad habilidadEspecial;
	
	public Rol(int opcion) {
		switch (opcion) {
		case 1:
			this.clase="Paladin";
			this.descripcion="Guerrero santo atado a un juramento sagrado";
			this.habilidad1=new Habilidad("Espadazo");
			this.habilidad2=new Habilidad("Imposicion de Manos");
			this.habilidadEspecial=new Habilidad("Golpe Divino");
			break;
		case 2:
			this.clase="Clerigo";
			this.descripcion="Guerrero sacerdotal que ejerce magia divina en servicio de un poder superior";
			this.habilidad1=new Habilidad("Bendicion");
			this.habilidad2=new Habilidad("Curar Heridas");
			this.habilidadEspecial=new Habilidad("Curar Heridas en Area");
			break;
		case 3:
			this.clase="Mago";
			this.descripcion="Usuario de magia estudioso que es capaz de manipular la realidad";
			this.habilidad1=new Habilidad("Bastonazo");
			this.habilidad2=new Habilidad("Manos Quemantes");
			this.habilidadEspecial=new Habilidad("Bola de Fuego");
			break;
		case 4:
			this.clase="Rogue";
			this.descripcion="Malandrin que utiliza el sigilo y artimañas para superar obstaculos y enemigos";
			this.habilidad1=new Habilidad("Acuchillada");
			this.habilidad2=new Habilidad("");//Tengo que buscar mas sobre los rogue
			this.habilidadEspecial=new Habilidad("Golpe Mortal");
			break;
			//CASOS JEFES (Comprobar que cuando cree HEROES el numero sea menor que 5)
		case 5:
			this.clase="Profe1";
			this.descripcion="Profe1";
			this.habilidad1=new Habilidad("Bastonazo");;
			this.habilidadEspecial=new Habilidad("Jefe1");
			break;
		case 6:
			this.clase="Profe2";
			this.descripcion="Profe2";
			this.habilidad1=new Habilidad("Bastonazo");;
			this.habilidadEspecial=new Habilidad("Jefe2");
			break;
		case 7:
			this.clase="Profe3";
			this.descripcion="Profe3";
			this.habilidad1=new Habilidad("Bastonazo");;
			this.habilidadEspecial=new Habilidad("Jefe3");
			break;
		//CASOS ESBIRROS
		case 8:
			this.clase="Ayudante";
			this.descripcion="Ayudante de catedra";
			this.habilidad1=new Habilidad("Bastonazo");
			break;
		case 9:
			this.clase="Celador";
			this.descripcion="Celador de la facultad";
			this.habilidad1=new Habilidad("Bastonazo");
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
	public Habilidad getHabilidad1() {
		return habilidad1;
	}
	public Habilidad getHabilidad2() {
		return habilidad2;
	}
	public Habilidad getHabilidadEspecial() {
		return habilidadEspecial;
	}
}
