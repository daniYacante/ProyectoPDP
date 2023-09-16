package Core.Clases.Heroes;
import java.util.Random;

import Core.Clases.Restriccion;
import Core.Clases.Cartas.Carta;

//Solo la utilizo para definir que paladin, mago, clerigo y rogue son de tipo heroe
public class Heroe extends Core.Clases.Human implements Restriccion{
	//y esta bien si agrego aca la carta?
	protected Carta cartaElegida;
	protected boolean restriccion = false;
	protected int turnos;
	public String descripcionRes = "";
	public boolean canUse = true;
	public Heroe(){
		turnos = 0;
		super.tipo = "Heroe";
	}

	public boolean getCanUse(){
		return canUse;
	}
    @Override
    public int tirarDado() {
    	Random d20=new Random();
    	return d20.nextInt();
    }
    public String getDescripcion() {
    	String msg="";
    	msg=String.format("%s:\n\tArmadura: %s\n\tVida maxima: %s\n\tMana Max: %s\n\tHabilidades:\n\t*%s\n\t*%s\n\t*%s", this.clase,this.armadura,this.getVidaMaxima(),this.getMana(),this.getHabilidad1().getNombre(),this.getHabilidad2().getNombre(),this.getHabilidadEspecial().getNombre());
    	return msg;
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


