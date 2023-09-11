package Core.Clases.Cartas;

import Core.Clases.Heroes.Heroe;

public class CartaMasoquista extends Carta{
    protected int vidaAnterior;
    protected int vidaPerdida;
    protected int manaGanado;
    //protected Human ayuda;
    public CartaMasoquista() {
    	super.nombreCarta = "Carta del Masoquista";
        super.descripcion = "cuando el portador reciba daño del enemigo, este sera multiplicado por dos veces. PERO ganara una gran cantidad de mana";
    }
    @Override
    public void setPortador(Heroe portadorCarta) {
    	super.portador = portadorCarta;

        //this.ayuda = (Human) portadorCarta;
        //¿Como darse cuenta de que le pegaron mientras estamos en lucha?
        //La manera que se me ocurre es revisarle cada vez que se hace el realizarEfecto() si su vida esta distinta
        this.vidaAnterior = portador.getVida();
    }

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
