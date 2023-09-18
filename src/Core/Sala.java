package Core;
import Core.Clases.Jefes.*;
import Core.Clases.Human;
import Core.Clases.Cartas.*;
import Core.Clases.Jefes.Esbirros.Ayudante;
import java.util.ArrayList;
import java.util.Random;

/**
 * La clase Sala, en la que ocurren los acontecimientos de lucha, busqueda, etc
 */
public class Sala {
	private ArrayList<Human> listaEnemigos= new ArrayList<Human>(3);
	private Carta item = null;
	private papelAluminio itemTroll = null;

	/**
	 * Constructor de la clase sala, tambien se crea aca lo que es el objeto que hay dentro
	 * @param nivelDeSala se da el nivel de la sala
	 */
	public Sala(int nivelDeSala) {
		switch (nivelDeSala) {
		case 1:
			listaEnemigos.add(new Jefe1("Pablo"));
			listaEnemigos.add(new Ayudante("Bauti"));
			listaEnemigos.add(new Ayudante("Facu"));
			break;

		default:
			break;
		}
		Random rn =new Random();
		//50% de chances de que en la sala haya un objeto
		pickCard pC = new pickCard();
		int prob=rn.nextInt(2);
		if (prob==1) {
			this.item=pC.pick();
		}else {
			this.itemTroll=new papelAluminio();
		}
	}

	/**
	 * La lista de enemigos en la sala
	 * @return ArrayList que muestra los jefes vivos
	 */
	public ArrayList<Human> getListaEnemigo() {
		return this.listaEnemigos;
	}

	/**
	 * Funcion la cual se da cuando los heroes quieren investigar la sala
	 * @return Carta la carta que fue encontrada en la sala
	 */
	public Item investigar() {
		if (item != null){
			System.out.println(String.format("Buscando en la sala has encontrado %s",this.item.getNombreCarta()));
			this.item.imprimirDescripcion();
			return item;
		} else {
			System.out.println(String.format("Buscando en la sala has encontrado %s",this.itemTroll.getNombreCarta()));
			this.itemTroll.imprimirDescripcion();
			return itemTroll;
		}

	}
	
}
