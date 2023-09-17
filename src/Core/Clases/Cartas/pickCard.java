package Core.Clases.Cartas;
import java.util.ArrayList;
import java.util.Random;

/**
 * pickCard es una clase en la que se realizara la seleccion de carta al haber encontrado algo
 */
public class pickCard {
	/**
	 * un ArrayList que lleva todas las cartas del juego
	 */
	private ArrayList<Carta> listaCartas = new ArrayList<Carta> ();

	/**
	 * constructor de la clase, agrega las cartas al ArrayList
	 */
	public pickCard(){
		listaCartas.add(new CartaEncantamientoIneficiente());
		listaCartas.add(new CartaEuforiaTemporal());
		listaCartas.add(new CartaMasoquista());
		listaCartas.add(new CartaUltimaEsperanza());
	}

	/**
	 * Se toma una carta al azar de la ArrayList
	 * @return una carta la cual han encontrado el grupo de heroes
	 */
	public Carta pick() {
		Random rn = new Random();
		return listaCartas.get(rn.nextInt(listaCartas.size()));
	}
}
