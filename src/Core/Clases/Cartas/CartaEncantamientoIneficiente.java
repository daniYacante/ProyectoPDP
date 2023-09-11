package Core.Clases.Cartas;
import Core.Clases.Heroes.Heroe;

public class CartaEncantamientoIneficiente extends Carta{
    //Que esta sea respecto al mana
    //Y esto me servira para aclararle que es una pasiva, por eso no se debe de repetir
    protected  boolean fueUsada;
    protected int danioPortador1;
    protected int danioPortador2;
    protected int danioPortador3;
    protected int manaPortador1;
    protected int manaPortador2;
    protected int manaPortador3;
    public CartaEncantamientoIneficiente() {
    	super.nombreCarta = "Carta del Encantamiento Ineficiente";
        super.descripcion = "el costo de mana de tus habilidades se reducira un 50%, PERO el daño de tus habilidades tambien se reduciran el mismo porcentaje";
    }
    @Override
    public void setPortador(Heroe portadorCarta){
        super.portador = portadorCarta;
        this.fueUsada = false;
        //Tomar el daño de las habilidades
        this.danioPortador1 = portador.getHabilidad1().getEfectoVidaObjetivo();
        this.danioPortador2 = portador.getHabilidad2().getEfectoVidaObjetivo();
        this.danioPortador3 = portador.getHabilidadEspecial().getEfectoVidaObjetivo();
        //Tomar el coste de mana de las habilidades
        this.manaPortador1 = portador.getHabilidad1().getEfectoManaLanzador();
        this.manaPortador2 = portador.getHabilidad2().getEfectoManaLanzador();
        this.manaPortador3 = portador.getHabilidadEspecial().getEfectoManaLanzador();
    }

    @Override
    public void realizarEfecto(){
        if (this.fueUsada == false){
            int manaReducido1 = this.manaPortador1 / 2;
            int danioReducido1 = this.danioPortador1 / 2;

            int manaReducido2 = this.manaPortador2 / 2;
            int danioReducido2 = this.danioPortador2 / 2;

            int manaReducido3 = this.manaPortador3 / 2;
            int danioReducido3 = this.danioPortador3 / 2;

            //Actualizamos el daño y el mana;
            portador.getHabilidad1().setEfectoVidaObjetivo(danioReducido1);
            portador.getHabilidad1().setEfectoManaLanzador(manaReducido1);

            portador.getHabilidad2().setEfectoVidaObjetivo(danioReducido2);
            portador.getHabilidad2().setEfectoManaLanzador(manaReducido2);

            portador.getHabilidadEspecial().setEfectoVidaObjetivo(danioReducido3);
            portador.getHabilidadEspecial().setEfectoManaLanzador(manaReducido3);

            this.fueUsada = true;

        } else {
            //System.out.println("¡El efecto de la carta Encantamiento Ineficiente ya se realizo!, no se volvera a hacer.");
        }
    }
}
