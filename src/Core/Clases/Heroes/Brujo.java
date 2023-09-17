package Core.Clases.Heroes;
import Core.Game;
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
        super.armadura=14;
        super.vidaActual = 8;
        super.vidaMaxima = 8;
        super.manaActual = 100;
        super.manaMaximo = 180;
        this.clase="Brujo";
        this.descripcion="Conjurador que obtiene sus poderes por linea de sangre o por un regalo del universo";
        this.habilidad1=new Habilidad("Bastonazo", -8, 0, 0,true);
        this.habilidad2=new Habilidad("Rayo de Escarcha", 10, 0, -10,true);
        this.habilidadEspecial=new Habilidad("Bola de Fuego", -16, 0, 0,false);
        this.restriccion = new RestriccionBajaVida();
        this.restriccion.setDescriRes(this.habilidadEspecial);
    }
    public static void getStats() {
    	Game.imprimir("");
    }
}


