package Core.Clases.Heroes;
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
        super.armadura=13;
        super.vidaActual = 24;
        super.vidaMaxima = 24;
        super.manaActual = 80;
        super.manaMaximo = 80;
        this.clase="Druida";
        this.descripcion="Sacerdote de la Fe de antaño, empuñando la fuerza de la naturaleza y capaz de tomar formas animales";
        this.habilidad1=new Habilidad("Espadazo", -8, 0, 0,true);
        super.modH1=4;
        this.habilidad2=new Habilidad("Fuego feérico", -3, -3, -10,false);
        this.habilidadEspecial=new Habilidad("Curar Heridas en Area", 20, 0, 20,false);
        this.restriccion = new RestricTurnosSinHabilidadEsp();
        this.restriccion.setDescriRes(this.habilidadEspecial);
    }
}


