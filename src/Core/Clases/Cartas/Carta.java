package Core.Clases.Cartas;
import Core.Clases.Heroes.Heroe;

public abstract class Carta  extends Core.Clases.Heroes.Heroe{
    protected String nombreCarta;
    //descripcion de la carta (tanto el efecto positivo como el efecto negativo)
    protected String descripcion;
    //saber quien la porta
    protected Heroe portador;

    //METODOS:
    public String getNombreCarta(){
        return this.nombreCarta;
    }

    public void imprimirDescripcion(){
        System.out.println(String.format("Tu carta hara lo siguiente: %s", this.descripcion));
    }

    public void realizarEfecto(){

    }
    
	public void setPortador(Heroe portadorCarta) {
		// TODO Auto-generated method stub
		
	}
}
