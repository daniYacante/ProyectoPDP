package Core.Clases.Heroes;
import Core.Game;
import Core.Clases.Habilidad;
import Core.Clases.Restricciones.RestricTurnosSinHabilidadEsp;

/**
 * La clase Druida, que hereda de heroe
 * @see Heroe
 */
public class Druida extends Core.Clases.Heroes.Heroe {
    /**
     * Constructor del Druida, sus stats y habilidades
     */
    public Druida(){
        super.turnoAnt = 0;
        super.tipo = "Heroe";
        super.armadura=15;
        super.vidaActual = 10;
        super.vidaMaxima = 10;
        super.manaActual = 100;
        super.manaMaximo = 180;
        this.clase="Druida";
        this.descripcion="Sacerdote de la Fe de antaño, empuñando la fuerza de la naturaleza y capaz de tomar formas animales";
        this.habilidad1=new Habilidad("Espadazo", -8, 0, 0,true);
        this.habilidad2=new Habilidad("Fuego feérico", 10, 0, -10,false);
        this.habilidadEspecial=new Habilidad("Curar Heridas en Area", -16, 0, 0,false);
        this.restriccion = new RestricTurnosSinHabilidadEsp();
        this.restriccion.setDescriRes(this.habilidadEspecial);
    }
    public static void getStats() {
    	Game.imprimir("");
    }
}


