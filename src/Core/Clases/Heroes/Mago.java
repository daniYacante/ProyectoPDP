package Core.Clases.Heroes;

import Core.Clases.Habilidad;

/**
 * La clase Mago, que hereda de Heroe
 */
public class Mago extends Core.Clases.Heroes.Heroe {
    //Coloque mana = vidaActual por simplicidad
    //vidaActual es d6 * 12

    /**
     * Constructor de la clase Mago, sus stats y habilidades
     */
    public Mago(){
        //Mago d6
        super.tipo = "Heroe";
        super.armadura=12;
        super.vidaActual = 8;
        super.vidaMaxima = 8;
        super.manaActual = 72;
        super.manaMaximo = 140;
        this.clase="Mago";
        this.descripcion="Usuario de magia estudioso que es capaz de manipular la realidad";
        this.habilidad1=new Habilidad("Bastonazo", -10,0,0,true);
        this.habilidad2=new Habilidad("Manos Quemantes", -8,0,0,true);
        this.habilidadEspecial=new Habilidad("Bola de Fuego", -15,0,0,false);
    }    
}
