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
			this.efectoManaLanzador=-10;
			break;
		case "Golpe Divino":
			this.efectoVidaObjetivo=-16;
			break;
		case "Bendicion":
			this.efectoDMGObjetivo=4;
			break;
		case "Curar Heridas":
			this.efectoVidaObjetivo=10;
			break;
		case "Curar Heridas en Area":
			this.efectoVidaObjetivo=20;
			break;
		case "Bastonazo":
			this.efectoVidaObjetivo=-5;
			break;
		case "Manos Quemantes":
			this.efectoVidaObjetivo=8;
			break;
		case "Bola de Fuego":
			this.efectoVidaObjetivo=15;
			break;
		case "Aucuchillada":
			this.efectoVidaObjetivo=8;
			break;
		case "Golpe Mortal":
			this.efectoVidaObjetivo=15;
			break;
		//Faltan las otras habilidades con sus respectivos efectos
		default:
			break;
		}
	}
	public void usar(Human target, int modificador) {
		if (this.efectoVidaObjetivo<0) {
			target.recibirDmg((-1*this.efectoVidaObjetivo)+modificador);
		}else if (this.efectoVidaObjetivo>0) {
			target.curarse(this.efectoVidaObjetivo);
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
