package Core.Clases;

public class Heroe extends Human {
	private Rol clase;
	public Heroe(String nombre,int tipo) {
		this.nombre=nombre;
		this.clase=new Rol(tipo);
	}
	public Rol getClase() {
		return clase;
	}
	public void usarH1(Human objetivo){
		if (this.clase.getHabilidad1().getEfectoManaLanzador()<this.manaActual) {
			this.clase.getHabilidad1().usar(objetivo,this.modAtaquete);
			this.manaActual-=this.clase.getHabilidad1().getEfectoManaLanzador();
		}else {
			System.out.println("Mana insuficiente!!");
		}
		
	}
	public void usarH2(Human objetivo) {
		if (this.clase.getHabilidad2().getEfectoManaLanzador()<this.manaActual) {
			this.clase.getHabilidad2().usar(objetivo, 0);
			this.manaActual-=this.clase.getHabilidad2().getEfectoManaLanzador();
		}
	}
	public void usarEsp(Human objetivo) {
		if (this.clase.getHabilidadEspecial().getEfectoManaLanzador()<this.manaActual) {
			this.clase.getHabilidadEspecial().usar(objetivo,0);
			this.manaActual-=this.clase.getHabilidadEspecial().getEfectoManaLanzador();
		}
	}
}
