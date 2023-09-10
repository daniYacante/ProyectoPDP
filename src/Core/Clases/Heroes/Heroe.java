package Core.Clases.Heroes;

import Core.Clases.Cartas.Carta;

//Solo la utilizo para definir que paladin, mago, clerigo y rogue son de tipo heroe
public class Heroe extends Core.Clases.Human {
	//y esta bien si agrego aca la carta?
	protected Carta cartaElegida;
	public Heroe(){
		super.tipo = "Heroe";
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
}


