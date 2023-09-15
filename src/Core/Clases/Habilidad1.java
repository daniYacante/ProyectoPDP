package Core.Clases;

public class Habilidad1 {
	private String nombre="";
	private int efectoVidaObjetivo=0;
	private int efectoDMGObjetivo=0;
	private int efectoManaLanzador=0;
	public Habilidad1(String nombre) {
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
			this.efectoVidaObjetivo=-10;
			break;
		case "Manos Quemantes":
			this.efectoVidaObjetivo=-8;
			break;
		case "Bola de Fuego":
			this.efectoVidaObjetivo=-15;
			break;
		case "Acuchillada":
			this.efectoVidaObjetivo=-8;
			break;
		case "Golpe Mortal":
			this.efectoVidaObjetivo=-15;
			break;
		//Especial
		case "Bestia":
			this.efectoVidaObjetivo=-22;
			break;
		//Faltan las otras habilidades con sus respectivos efectos
		//HABILIDADES JEFE (FALTAN PONER LAS HABILIDADES QUE SE VAN A UTILIZAR)
		case "Jefe 1":
			this.efectoVidaObjetivo=30;
			break;
		case "Jefe 2":
			this.efectoVidaObjetivo=40;
			break;
		case "Jefe 3":
			this.efectoVidaObjetivo=50;
			break;
		default:
			break;
		}
	}

}
