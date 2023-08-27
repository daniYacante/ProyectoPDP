package Core.Clases;

public class Habilidad {
	private String nombre="";
	private int efectoVidaObjetivo=0;
	private int efectoDMGObjetivo=0;
	private int efectoManaLanzador=0;
	public Habilidad(String nombre) {
		this.nombre=nombre;
		switch (nombre) {
		case "Espadazo":
			this.efectoVidaObjetivo=-8;
			break;
		case "Imposicion de Manos":
			this.efectoVidaObjetivo=10;
		case "Golpe Divino":
			this.efectoVidaObjetivo=-16;
		//Faltan las otras habilidades con sus respectivos efectos
		default:
			break;
		}
	}
	public void usar(Human target) {
		if (this.efectoVidaObjetivo<0) {
			target.recibirDmg(-1*efectoVidaObjetivo);
		}else if (this.efectoVidaObjetivo>0) {
			target.curarse();
		}
		if (this.efectoDMGObjetivo!=0) {
			target.modificarAtaque(efectoDMGObjetivo);
		}

	}
	public String getNombre() {
		return nombre;
	}
	public int getEfectoManaLanzador() {
		return efectoManaLanzador;
	}
}
