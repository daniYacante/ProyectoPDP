package Core.Clases.Cartas;
import Core.Clases.Heroes.Heroe;

public class cartaUltimaEsperanza extends Carta{
    protected int vidaMaximaPortador;

    // Esta carta va a tener que ser una "especial" podemos decir, ya que necesita de este atributo
    protected boolean fueUsada = false;
    public cartaUltimaEsperanza(Heroe portadorCarta){
        super.nombreCarta = "Carta de la Ultima Esperanza";
        super.descripcion = "cuando tu vida baje mas de un 80% POR SOLO UNA VEZ, volvera al maximo PERO tus ataques seran mas debiles";
        super.portador = portadorCarta;
        this.vidaMaximaPortador = portador.getVidaMaxima();
    }

    @Override
    public void realizarEfecto() {
        //En este caso debo de estar al tanto de la comprobacion de la vida
        if (portador.getVida() > 0) {
            if ((portador.getVida() <= ((vidaMaximaPortador * 20) / 100)) && (this.fueUsada == false)) {
                portador.keyCurarse(portador.getVidaMaxima() - portador.getVida());
                //A continuacion como reducir el daño de sus habilidades
                int danioReducido = portador.getHabilidad1().getEfectoVidaObjetivo() / 2;
                portador.getHabilidad1().setEfectoVidaObjetivo(danioReducido);

                int danioReducido2 = portador.getHabilidad2().getEfectoVidaObjetivo() / 2;
                portador.getHabilidad2().setEfectoVidaObjetivo(danioReducido2);

                int danioReducido3 = portador.getHabilidadEspecial().getEfectoVidaObjetivo() / 2;
                portador.getHabilidadEspecial().setEfectoVidaObjetivo(danioReducido3);

                this.fueUsada = true;
                System.out.println(String.format("%s se ha curado %s debido a la carta: ¡Ultima Esperanza!", portador.getNombre(), portador.getVidaMaxima() - portador.getVida()));
            } else if (portador.getVida() > (vidaMaximaPortador * 20) / 100) {
                System.out.println("¡Aun no puedo activar mi carta!");
            } else {
                System.out.println("¡Ya he usado mi carta!");
            }
        }
    }
}
