package Core.Clases.Heroes;
import java.util.ArrayList;
import Core.Clases.Human;
import Core.Clases.Restriccion;
import Core.Clases.Cartas.Carta;

//Solo la utilizo para definir que paladin, mago, clerigo y rogue son de tipo heroe
public class Heroe extends Human implements Restriccion{
	//y esta bien si agrego aca la carta?
	protected Carta cartaElegida;
	protected boolean restriccion = false;
	protected int turnos;
	public String descripcionRes = "";
	public boolean canUse = true;
	public Heroe(){
		turnos = 0;
		super.tipo = "Heroe";
		super.aliados=new ArrayList<Human>();
	}

	public boolean getCanUse(){
		return canUse;
	}
    public String getDescripcion() {
    	String msg="";
    	msg=String.format("%s:\n\tArmadura: %s\n\tVida maxima: %s\n\tMana Max: %s\n\tHabilidades:\n\t*%s\n\t*%s\n\t*%s", this.clase,this.armadura,this.getVidaMaxima(),this.getMana(),this.getHabilidad1().getNombre(),this.getHabilidad2().getNombre(),this.getHabilidadEspecial().getNombre());
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
	public void setCartaElegida(Carta cartaSeleccionada){
		this.cartaElegida = cartaSeleccionada;
	}
	
	public Carta getCartaElegida(){
		return this.cartaElegida;
	}

	public void recibirDamage(int danio){
		this.recibirDmg(danio);
	}
	
	public void setRestriccion(){
    }
	
	public void progresoCond(){//No se si lo vamos a implementar
	}
	public boolean getRestriccion(){
		return restriccion;
	}

	public String getDescripcionRes(){
		return descripcionRes;
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


