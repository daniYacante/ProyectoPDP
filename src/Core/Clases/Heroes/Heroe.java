package Core.Clases.Heroes;
import java.util.ArrayList;
import Core.Clases.Cartas.Item;
import Core.Clases.Human;
import Core.Clases.Restricciones.Restriccion;

//Solo la utilizo para definir que paladin, mago, clerigo y rogue son de tipo heroe

/**
 * Heroe, la clase en la que van a heredar los distintos tipos de heroe, personajes seleccionables para el usuario. Heroe hereda de Human
 * @see Arquero
 * @see Barbaro
 * @see Bardo
 * @see Brujo
 * @see Clerigo
 * @see Druida
 * @see Mago
 * @see Monje
 * @see Paladin
 * @see Rogue
 */
public class Heroe extends Human /*implements Restriccion*/{
	/**
	 * la carta que lleva el heroe (o el papel aluminio)
	 */
	//y esta bien si agrego aca la carta?
	protected Item cartaElegida;
	/**
	 * la restriccion que tiene el heroe para el uso de su habilidad especial
	 */
	/**
	 * la cantidad de turnos que lleva en juego
	 */
	protected int turnos;
	/**
	 * Booleano que nos dice si el Heroe es utilizable en el turno que toque para la lucha
	 */
	protected boolean canUse = true;
	/**
	 * el turno anterior que se jugo
	 */
	protected int turnoAnt = 0;
	/**
	 * La restriccion que lleva el heroe por su habilidad especial
	 */
	protected Restriccion restriccion;
	/**
	 * constructor que genera al heroe
	 */
	public Heroe(){
		turnos = 0;
		super.tipo = "Heroe";
		super.aliados=new ArrayList<Human>();
	}

	/**
	 * devuelve el valor de canUse
	 * @return boolean true si se puede usar, false si no
	 */
	public boolean getCanUse(){
		return canUse;
	}

	/**
	 * Cambia el estado del personaje si se puede usar en el turno de lucha, si es falso pasa a verdadero y viceversa
	 */
	public void changeCanUse(){
		if (this.canUse == false) {
			this.canUse = true;
		}else this.canUse = false;
	}
	/**
	 * nos muestra las estadisticas del heroe y sus habilidades
	 * @return un mensaje de sus stats y habs
	 */
    public String getDescripcion() {
    	String msg="";
    	msg=String.format("%s:\n\tArmadura: %s\n\tVida maxima: %s\n\tMana Max: %s\n\tHabilidades:\n\t*%s\n\t*%s\n\t*%s\n\tRestriccion habilidad especial:\n\t*%s", this.clase,this.armadura,this.getVidaMaxima(),this.getMana(),this.getHabilidad1().getNombre(),this.getHabilidad2().getNombre(),this.getHabilidadEspecial().getNombre(), this.restriccion.getDescripcionRes());
    	return msg;
    }

	/**
	 * Se toman sus aliados
	 * @return ArrayList de sus aliados
	 */
    public ArrayList<? extends Human> getAliados() {
    	return this.aliados;
	}

	/**
	 * Se agrega aliados al arraylist
	 * @param aliado el cual en este caso es heroe
	 * @return int 1 si no hubo problema en agregarlo, 0 si hubieron.
	 */
    public int addAliado(Human aliado) {
    	this.aliados.add(aliado);
    	if (this.aliados.contains(aliado)) {
    		return 1;
    	}else {
    		return 0;
    	}
    }
    public int deleteAliado(Heroe aliado) {
    	this.aliados.remove(aliado);
    	if (this.aliados.contains(aliado)) {
    		return 0;
    	}else {
    		return 1;
    	}
    }
	//PROBEMOS, si funciona aca joya.

	/**
	 * se le da a alguno de los heroes la carta encontrada
	 * @param cartaSeleccionada la carta encontrada
	 */
	public void setCartaElegida(Item cartaSeleccionada){
		this.cartaElegida = cartaSeleccionada;
	}

	/**
	 * Se devuelve el item que lleva el heroe
	 * @return Item
	 */
	public Item getCartaElegida(){
		return this.cartaElegida;
	}

	/**
	 * para poder entrar a la funcion recibirDmg
	 * @param danio el daño causado
	 */
	public void recibirDamage(int danio){
		this.recibirDmg(danio);
	}
	/* 
	public void setRestriccion(){
    }
	
	public void progresoCond(){//No se si lo vamos a implementar
	}

	public String getDescripcionRes(){
		return descripcionRes;
	}
	*/

	/**
	 * Devuelve la restriccion que lleva para su habilidad especial
	 * @return Restriccion
	 */
	public Restriccion getRestriccion(){
		return restriccion;
	}

	/**
	 * Aumenta los turnos que lleva participando
	 */
	public void aumentarTurno(){
		this.turnos++;
	}
	public void ceroTurno(){
		this.turnos = 0;
	}

	/**
	 * Devuelve la cantidad de turnos que lleva
	 * @return int turnos
	 */
	public int getTurno(){
		return this.turnos;
	}
}


