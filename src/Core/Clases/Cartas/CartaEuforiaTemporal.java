package Core.Clases.Cartas;
import Core.Clases.Heroes.Heroe;
public class CartaEuforiaTemporal extends Carta{
    //Que atributos de la persona tocare?
    protected int vidaMaximaPortador;
    protected int vidaActualPortador;
    protected int danioPortador1;
    protected int danioPortador2;
    protected int danioPortador3;

    public CartaEuforiaTemporal(Heroe portadorCarta){
        super.nombreCarta = "carta de la Euforia Temporal";
        super.descripcion = "cuando tu vida sea mas del 65% de su vida maxima, el daño de tus habilidades aumenta. PERO si baja a menos del 65%, tus habilidades empezaran a ser mas debiles";
        super.portador = portadorCarta;
        this.vidaMaximaPortador = portador.getVidaMaxima();
        this.vidaActualPortador = portador.getVida();

        //Para no multiplicar lo multiplicado:
        this.danioPortador1 = portador.getHabilidad1().getEfectoVidaObjetivo();
        this.danioPortador2 = portador.getHabilidad2().getEfectoVidaObjetivo();
        this.danioPortador3 = portador.getHabilidadEspecial().getEfectoVidaObjetivo();
    }

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
