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
	private String description="";
	private String descriptionEnemigos="";
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
			this.description="Entras a una sala donde la luz escasea, el silencio reina por sobre todas las cosas, sobre una mesa ves algo que \u001B[33mbrilla\u001B[0m y hacia tu derecha ves lo que parece ser una puerta.";
			this.descriptionEnemigos="Llegando a la puerta tu equipo es sorprendido por el equipo de Paradigmas";
			break;
		case 2:
			listaEnemigos.add(new Jefe2("Caro"));
			listaEnemigos.add(new Ayudante("Turing"));
			listaEnemigos.add(new Ayudante("Sergio"));
			this.description="Justo cuando pensabas que lo peor habia pasado..."
					+ "En esta nueva sala te encuentras con lo que intuyes fueron prototipos de las primeras"
					+ "computadoras. Computadoras que ocupan paredes enteras de la sala."
					+ "De vuelta ves algo que brilla sobresaliendo de una de las maquinas.";
			this.descriptionEnemigos="Llegando a la puerta tu equipo es sorprendido por el equipo de Compiladores";
			break;
		case 3:
			listaEnemigos.add(new Jefe3("Larriqueta"));
			listaEnemigos.add(new Ayudante("Julio"));
			listaEnemigos.add(new Ayudante("Geogebra"));//aunque deberia ser un aliado
			this.description="Continuando con tu camino hacia el titulo te encuentras en una sala donde el polvo"
					+ "de tiza flota en el aire, ves a una entidad llorando en la esquina que no se ha dado cuenta de tu presencia."
					+ "Como es \"normal\"... vuelves a ver algo brillando entre la niebla de tiza";
			this.descriptionEnemigos="Frente a ti se encuentra el enemigo final...aquello que siempre has temido";
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
	public String getDescription() {
		return description;
	}
	public String getDescriptionEnemigos() {
		return descriptionEnemigos;
	}
}
