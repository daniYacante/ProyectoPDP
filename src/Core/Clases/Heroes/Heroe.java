package Core.Clases.Heroes;
import java.util.ArrayList;

import Core.Clases.Cartas.Item;
import Core.Clases.Human;
import Core.Clases.Cartas.Carta;
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
	 * la carta que lleva el heroe
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
	protected boolean canUse = true;
	protected int turnoAnt = 0;
	protected Restriccion restriccion;
	/**
	 * constructor que genera al heroe
	 */
	public Heroe(){
		turnos = 0;
		super.tipo = "Heroe";
		super.aliados=new ArrayList<Human>();
	}

	public boolean getCanUse(){
		return canUse;
	}

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
    public ArrayList<? extends Human> getAliados() {
    	return this.aliados;
	}
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

	public Restriccion getRestriccion(){
		return restriccion;
	}
	public void aumentarTurno(){
		this.turnos++;
	}
	public void ceroTurno(){
		this.turnos = 0;
	}
	public int getTurno(){
		return this.turnos;
	}
}


