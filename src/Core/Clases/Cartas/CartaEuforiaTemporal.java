package Core.Clases.Cartas;
import Core.Clases.Heroes.Heroe;

/**
 * Carta de la Euforia Temporal, cuando tu vida sea mas del 65% de su vida maxima, el daño de tus habilidades aumenta. PERO si baja a menos del 65%, tus habilidades empezaran a ser mas debiles
 */
public class CartaEuforiaTemporal extends Carta{
    //Que atributos de la persona tocare?
    /**
     * la vida maxima a la que puede llegar el portador
     */
    protected int vidaMaximaPortador;
    /**
     * la vida actual del portador
     */
    protected int vidaActualPortador;
    /**
     * el daño de la habilidad 1 del portador
     */
    protected int danioPortador1;
    /**
     * el daño de la habilidad 2 del portador
     */
    protected int danioPortador2;
    /**
     * el daño de la habilidad especial del portador
     */
    protected int danioPortador3;

    /**
     * constructor para la creacion de la carta
     */
    public CartaEuforiaTemporal() {
    	super.nombreCarta = "carta de la Euforia Temporal";
        super.descripcion = "cuando tu vida sea mas del 65% de su vida maxima, el daño de tus habilidades aumenta. PERO si baja a menos del 65%, tus habilidades empezaran a ser mas debiles";
    }

    /**
     * Se asigna el portador de la carta, pero ademas los atributos necesarios para el uso de la carta
     * @param portadorCarta quien es el que la lleva
     */
    @Override
    public void setPortador(Heroe portadorCarta) {
        super.portador = portadorCarta;
        this.vidaMaximaPortador = portador.getVidaMaxima();
        this.vidaActualPortador = portador.getVida();

        //Para no multiplicar lo multiplicado:
        this.danioPortador1 = portador.getHabilidad1().getEfectoVidaObjetivo();
        this.danioPortador2 = portador.getHabilidad2().getEfectoVidaObjetivo();
        this.danioPortador3 = portador.getHabilidadEspecial().getEfectoVidaObjetivo();
    }

    /**
     * realiza el efecto que debe hacer dicho en la descripcion de la carta
     * @see CartaEuforiaTemporal
     */
    @Override
    public void realizarEfecto(){
        if (vidaActualPortador >= ((65 * vidaMaximaPortador) / 100)){
            //en el caso de que sea mayor al 90%, que sea una buena cantidad de daño
            if (vidaActualPortador >= ((90 * vidaMaximaPortador) / 100)){
                int danioAumentado1 = this.danioPortador1 * 3;
                portador.getHabilidad1().setEfectoVidaObjetivo(danioAumentado1);

                int danioAumentado2 = this.danioPortador2 * 3;
                portador.getHabilidad2().setEfectoVidaObjetivo(danioAumentado2);

                int danioAumentado3 = this.danioPortador3 * 3;
                portador.getHabilidadEspecial().setEfectoVidaObjetivo(danioAumentado3);
            } else if (vidaActualPortador >= ((65 * vidaMaximaPortador) / 100)) {
                int danioAumentado1 = this.danioPortador1 * 2;
                portador.getHabilidad1().setEfectoVidaObjetivo(danioAumentado1);

                int danioAumentado2 = this.danioPortador2 * 2;
                portador.getHabilidad2().setEfectoVidaObjetivo(danioAumentado2);

                int danioAumentado3 = this.danioPortador3 * 2;
                portador.getHabilidadEspecial().setEfectoVidaObjetivo(danioAumentado3);
            }
        //Y si la vida ya empezo a bajar;
        } else {
            if (vidaActualPortador >= ((20 * vidaMaximaPortador) / 100)){
                int danioReducido1 = this.danioPortador1 / 2;
                portador.getHabilidad1().setEfectoVidaObjetivo(danioReducido1);

                int danioReducido2 = this.danioPortador2 / 2;
                portador.getHabilidad2().setEfectoVidaObjetivo(danioReducido2);

                int danioReducido3 = this.danioPortador3 / 2;
                portador.getHabilidadEspecial().setEfectoVidaObjetivo(danioReducido3);
            } else {
                //El caso en que esta menos del 20%:
                int danioReducido1 = this.danioPortador1 / 3;
                portador.getHabilidad1().setEfectoVidaObjetivo(danioReducido1);

                int danioReducido2 = this.danioPortador2 / 3;
                portador.getHabilidad2().setEfectoVidaObjetivo(danioReducido2);

                int danioReducido3 = this.danioPortador3 / 3;
                portador.getHabilidadEspecial().setEfectoVidaObjetivo(danioReducido3);
            }
        }

    }
}
