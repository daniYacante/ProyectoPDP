package Core.Clases.Heroes;
import Core.Clases.Habilidad;
import Core.Clases.Restricciones.RestriccionBajaVida;

/**
 * La clase Brujo, que hereda de heroe
 * @see Heroe
 */
public class Brujo extends Core.Clases.Heroes.Heroe {
    /**
     * Constructor del Brujo, sus stats y habilidades
     */
    public Brujo(){
        super.turnoAnt = 0;
        super.tipo = "Heroe";
        super.armadura=13;
        super.vidaActual = 24;
        super.vidaMaxima = 24;
        super.manaActual = 100;
        super.manaMaximo = 100;
        this.clase="Brujo";
        this.descripcion="Conjurador que obtiene sus poderes por linea de sangre o por un regalo del universo";
        this.habilidad1=new Habilidad("Espadazo", -8, 0, 0,true);
        super.modH1=4;
        this.habilidad2=new Habilidad("Estallido magico", -9, 0, -10,true);
        super.modH2=5;
        this.habilidadEspecial=new Habilidad("Bola de Fuego", -28, 0, -40,false);
        this.restriccion = new RestriccionBajaVida();
        this.restriccion.setDescriRes(this.habilidadEspecial);
    }
}


