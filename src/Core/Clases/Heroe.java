package Core.Clases;

public class Heroe extends Human {
	private Rol clase;
	public Heroe(int tipo) {
		this.clase=new Rol(tipo);
	}
	public Rol getClase() {
		return clase;
	}
	public void usarH1(Human objetivo){
		this.clase.getHabilidad1().usar(objetivo);
	}
}
