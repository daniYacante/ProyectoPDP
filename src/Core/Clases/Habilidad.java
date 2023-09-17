package Core.Clases;

/**
 * La clase Habilidad, con esta toman forma las habilidades de los heroes, cual es el nombre, Si es de daño, cura, o buff, etc
 */
public class Habilidad {

    private String nombre="";

	private int efectoVidaObjetivo=0;

	private int efectoDMGObjetivo=0;

	private int efectoManaLanzador=0;

	private boolean tiraDado=false;

	/**
	 * Constructor de la Habilidad
	 * @param nombre el nombre de la habilidad
	 * @param efectoVidaObjetivo el efecto que lleva al objetivo, nos permite saber si es una habilidad de cura o de daño
	 * @param efectoDMGObjetivo el modificador de daño, podemos decir un buff
	 * @param efectoManaLanzador el costo de mana que conlleva usar la habilidad
	 * @param dado la forma de saber si se puede tirar el dado o no (este dado para evitar el ataque del oponente)
	 */
	public Habilidad(String nombre, int efectoVidaObjetivo, int efectoDMGObjetivo, int efectoManaLanzador,boolean dado) {
        this.nombre = nombre;
        this.efectoDMGObjetivo = efectoDMGObjetivo;
        this.efectoManaLanzador = efectoManaLanzador;
        this.efectoVidaObjetivo = efectoVidaObjetivo;
        this.tiraDado=dado;
    }

	/**
	 * Usar la habilidad elegida, se ve si se trata de un ataque, una curacion, o un modificador.
	 * @param target va a hacer el objetivo, quien va a recibir la accion de la habilidad
	 * @param modificador el buff para hacer mas daño
	 */
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

	/**
	 * Se toma el nombre de la habilidad
	 * @return un string con el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Se toma el coste de mana de la habilidad
	 * @return un int refiriendose al gasto de mana
	 */
	public int getEfectoManaLanzador() {
		return efectoManaLanzador;
	}

	/**
	 * Para el uso de cartas, seteamos un nuevo coste de mana para la habilidad
	 * @param nuevoEfectoMana el nuevo coste de mana
	 */
	public void setEfectoManaLanzador(int nuevoEfectoMana){
		this.efectoManaLanzador = nuevoEfectoMana;
	}
	//Para uso de cartas

	/**
	 * Para el uso de cartas, este es un modificador del daño que hace la habilidad, puede aumentar o disminuir
	 * @param nuevoEfectoVida el nuevo daño que hara la habilidad
	 */
	public void setEfectoVidaObjetivo(int nuevoEfectoVida){
		this.efectoVidaObjetivo = nuevoEfectoVida;
	}

	/**
	 * para tomar el daño/cura de la habilidad
	 * @return el valor que hace la habilidad
	 */
	public int getEfectoVidaObjetivo(){
		return this.efectoVidaObjetivo;
	}

	/**
	 * Se fija si se puede tirar el dado
	 * @return true si se puede, false si no
	 */
	public boolean isTiraDado() {
		return tiraDado;
	}
	
}
