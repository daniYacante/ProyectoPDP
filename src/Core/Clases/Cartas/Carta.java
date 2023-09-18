package Core.Clases.Cartas;
import Core.Clases.Heroes.Heroe;

/**
 * Carta es una clase abstracta la cual es la "forma" que deben de tener las demas cartas
 */
public abstract class Carta implements Item{
    /**
     * el nombre que la carta tiene
     */
    protected String nombreCarta;
    //descripcion de la carta (tanto el efecto positivo como el efecto negativo)
    /**
     * una breve descripcion del efecto positivo y efecto negativo de la carta
     */
    protected String descripcion;
    //saber quien la porta
    /**
     * es el Heroe quien la lleva
     */
    protected Heroe portador;

    /**
     * Tomar el nombre de la carta
     * @return El nombre de la carta
     */
    //METODOS:
    public String getNombreCarta(){
        return this.nombreCarta;
    }

    /**
     * Nos muestra la descripcion de la carta, el efecto bueno y el efecto malo
     */
    public void imprimirDescripcion(){
        System.out.println(String.format("Tu carta hara lo siguiente: %s", this.descripcion));
    }

    /**
     * activar el efecto de la carta en uso
     */
    public void realizarEfecto(){
    	System.out.println("No hay ningun efecto");
    }

    /**
     * Se le asigna a la carta, su portador.
     * @param portadorCarta quien es el que la lleva
     */
	public void setPortador(Heroe portadorCarta) {
		// TODO Auto-generated method stub
		
	}
}
