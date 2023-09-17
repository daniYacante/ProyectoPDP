package Core.Clases.Heroes;
import Core.Game;
import Core.Clases.Habilidad;

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
        this.habilidadEspecial=new Habilidad("Curar Heridas en Area (Habilidad Especial)", -16, 0, 0,false);
        this.descripcionRes = "Puedes utilizar Curar Heridas en Area cada 3 turnos";
    }
    //Usar habilidad Especial despues de tres turnos

    public void setRestriccion(){
        if ((turnos - turnoAnt) >= 2) {
            turnoAnt = turnos;
            super.restriccion = true;
        } else {
            super.restriccion = false;
        }
    }
    
    public static void getStats() {
    	Game.imprimir("");
    }
}


