package Core.Clases;

public class Heroe extends Human {
	private Rol clase;
	public Heroe(String nombre,int tipo) {
		this.nombre=nombre;
		this.clase=new Rol(tipo);
		switch (tipo) {
            case 1: //Paladin d10
				//Coloque mana = vidaActual por simplicidad
				//vidaActual es d10 * 12
                super.vidaActual = 120;
                super.vidaMaxima = 180;
                super.manaActual = 100;
                super.manaMaximo = 180;
				break;
            case 2: //Clerigo d8
				super.vidaActual = 96;
				super.vidaMaxima = 160;
				super.manaActual = 96;
				super.manaMaximo = 160;
				break;
			case 3: //Mago d6
				super.vidaActual = 72;
				super.vidaMaxima = 140;
				super.manaActual = 72;
				super.manaMaximo = 140;
				break;
			case 4: //Rogue d8.1
				super.vidaActual = 97;
				super.vidaMaxima = 161;
				super.manaActual = 97;
				super.manaMaximo = 161;
				break;
			default:
				break;
        }
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
