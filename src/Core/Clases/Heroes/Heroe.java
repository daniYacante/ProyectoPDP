package Core.Clases.Heroes;
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


