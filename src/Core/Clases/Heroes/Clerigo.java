package Core.Clases.Heroes;

import Core.Clases.Habilidad;

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
        super.vidaActual = 10;
        super.vidaMaxima = 10;
        super.manaActual = 96;
        super.manaMaximo = 160;
        this.clase="Clerigo";
        this.descripcion="Guerrero sacerdotal que ejerce magia divina en servicio de un poder superior";
        this.habilidad1=new Habilidad("Bendicion", 0, 4, 0,false);
        this.habilidad2=new Habilidad("Curar Heridas", 10, 0, 0,false);
        this.habilidadEspecial=new Habilidad("Curar Heridas en Area", 20, 0, 0,false);
    }
    
}
