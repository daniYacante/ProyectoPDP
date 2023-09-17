package Core.Clases.Heroes;
import Core.Game;
import Core.Clases.Habilidad;
import Core.Clases.Restricciones.RestriccionBajaVida;


/**
 * La clase Arquero, que hereda de Heroe
 * @see Heroe
 */
public class Arquero extends Core.Clases.Heroes.Heroe {
    /**
     * constructor del Arquero, sus stats y habilidades
     */
    public Arquero(){
        super.turnoAnt = 0;
        super.tipo = "Heroe";
        super.armadura=13;
        super.vidaActual = 12;
        super.vidaMaxima = 12;
        super.manaActual = 100;
        super.manaMaximo = 180;
        this.clase="Arquero";
        this.descripcion="Guerrero santo atado a un juramento sagrado";
        this.habilidad1=new Habilidad("Disparar Flecha", -8, 0, 0,true);
        this.habilidad2=new Habilidad("Acuchillada", 10, 0, -10,true);
        this.habilidadEspecial=new Habilidad("Golpe Divino", -16, 0, 0,true);
        this.restriccion = new RestriccionBajaVida();
        this.restriccion.setDescriRes(this.habilidadEspecial);
    }
    public static void getStats() {
    	Game.imprimir("");
    }
}


