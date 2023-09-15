package Core.Clases;

public class Habilidad {
    private String nombre="";
	private int efectoVidaObjetivo=0;
	private int efectoDMGObjetivo=0;
	private int efectoManaLanzador=0;
	
    public Habilidad(String nombre, int efectoVidaObjetivo, int efectoDMGObjetivo, int efectoManaLanzador) {
        this.nombre = nombre;
        this.efectoDMGObjetivo = efectoDMGObjetivo;
        this.efectoManaLanzador = efectoManaLanzador;
        this.efectoVidaObjetivo = efectoVidaObjetivo;
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

	public void setEfectoManaLanzador(int nuevoEfectoMana){
		this.efectoManaLanzador = nuevoEfectoMana;
	}
	//Para uso de cartas
	public void setEfectoVidaObjetivo(int nuevoEfectoVida){
		this.efectoVidaObjetivo = nuevoEfectoVida;
	}
	public int getEfectoVidaObjetivo(){
		return this.efectoVidaObjetivo;
	}
}
