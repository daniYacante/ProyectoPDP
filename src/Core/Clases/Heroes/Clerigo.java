package Core.Clases.Heroes;

import Core.Clases.Habilidad;
import Core.Clases.Restricciones.RestriccionDosTurnos;

/**
 * La clase Clerigo, que hereda de Heroe
 * @see Heroe
 */
public class Clerigo extends Core.Clases.Heroes.Heroe{
    /**
     * Constructor del clerigo, sus stats y habilidades
     */
    public Clerigo(){
        super.tipo = "Heroe";
        super.armadura=15;
        super.vidaActual = 24;
        super.vidaMaxima = 24;
        super.manaActual = 100;
        super.manaMaximo = 100;
        this.clase="Clerigo";
        this.descripcion="Guerrero sacerdotal que ejerce magia divina en servicio de un poder superior";
        this.habilidad1=new Habilidad("Bendicion", 0, 4, 15,false);
        this.habilidad2=new Habilidad("Curar Heridas", 10, 0, 0,false);
        this.habilidadEspecial=new Habilidad("Curar Heridas en Area", 20, 0, 0,false);
        this.restriccion = new RestriccionDosTurnos();
        this.restriccion.setDescriRes(this.habilidadEspecial);
    }
    
}
