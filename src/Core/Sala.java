package Core;
import Core.Clases.Jefes.*;
import Core.Clases.Cartas.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * La clase Sala, en la que ocurren los acontecimientos de lucha, busqueda, etc
 */
public class Sala {
	private ArrayList<Jefe> listaEnemigos= new ArrayList<Jefe>(3);
	private Carta item;

	/**
	 * Constructor de la clase sala, tambien se crea aca lo que es el objeto que hay dentro
	 * @param nivelDeSala se da el nivel de la sala
	 */
	public Sala(int nivelDeSala) {
		for (int i=0;i<3;i++) {
			listaEnemigos.add(new Jefe1(String.format("Profe %d", i)));
		}
		Random rn =new Random();
		//50% de chances de que en la sala haya un objeto
		pickCard pC = new pickCard();
		int prob=rn.nextInt(2);
		if (prob==1) {
			this.item=pC.pick();
		}else {
			this.item=new papelAluminio();
		}
	}

	/**
	 * La lista de enemigos en la sala
	 * @return ArrayList que muestra los jefes vivos
	 */
	public ArrayList<Jefe> getListaEnemigo() {
		return this.listaEnemigos;
	}

	/**
	 * Funcion la cual se da cuando los heroes quieren investigar la sala
	 * @return Carta la carta que fue encontrada en la sala
	 */
	public Carta investigar() {
		System.out.println(String.format("Buscando en la sala has encontrado %s",this.item.getNombreCarta()));
		this.item.imprimirDescripcion();
		return item;
	}
	
}
