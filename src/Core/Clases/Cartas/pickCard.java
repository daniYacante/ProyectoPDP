package Core.Clases.Cartas;
import java.util.ArrayList;
import java.util.Random;
public class pickCard {
	private ArrayList<Carta> listaCartas = new ArrayList<Carta> ();
	public pickCard(){
		listaCartas.add(new CartaEncantamientoIneficiente());
		listaCartas.add(new CartaEuforiaTemporal());
		listaCartas.add(new CartaMasoquista());
		listaCartas.add(new cartaUltimaEsperanza());
	}
	public Carta pick() {
		Random rn = new Random();
		return listaCartas.get(rn.nextInt(listaCartas.size()));
	}
}
