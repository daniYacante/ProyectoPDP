package Core.Clases.Cartas;

import Core.Clases.Heroes.Heroe;

/**
 * Carta del Masoquista, cuando el portador reciba daño del enemigo, este sera multiplicado por dos veces. PERO ganara una gran cantidad de mana
 */
public class CartaMasoquista extends Carta{
    /**
     * la vida que llevaba el portador
     */
    protected int vidaAnterior;
    //protected int vidaPerdida;
    //protected int manaGanado;
    //protected Human ayuda;
    /**
     * constructor para la creacion de la carta
     */
    public CartaMasoquista() {
    	super.nombreCarta = "Carta del Masoquista";
        super.descripcion = "cuando el portador reciba daño del enemigo, este sera multiplicado por dos veces. PERO ganara una gran cantidad de mana";
    }
    /**
     * Se asigna el portador de la carta, pero ademas los atributos necesarios para el uso de la carta
     * @param portadorCarta quien es el que la lleva
     */
    @Override
    public void setPortador(Heroe portadorCarta) {
    	super.portador = portadorCarta;

        //this.ayuda = (Human) portadorCarta;
        //¿Como darse cuenta de que le pegaron mientras estamos en lucha?
        //La manera que se me ocurre es revisarle cada vez que se hace el realizarEfecto() si su vida esta distinta
        this.vidaAnterior = portador.getVida();
    }
    /**
     * realiza el efecto que debe hacer dicho en la descripcion de la carta
     * @see CartaMasoquista
     */
    @Override
    public void realizarEfecto(){
        if ((this.vidaAnterior != portador.getVida()) && (portador.getVida() < this.vidaAnterior)){
            int diferenciaVida = this.vidaAnterior - portador.getVida();

            //Aca le restamos otra vez (por ser multiplicado por dos veces)
            //Tuve que crear otro
            portador.recibirDamage(diferenciaVida);
            portador.setMana(50);

            //Se redefine vida anterior:
            this.vidaAnterior = portador.getVida();
        }
    }
}
