package Core.Clases.Heroes;

import Core.Clases.Habilidad;
import Core.Clases.Restricciones.RestricTurnosSinHabilidadEsp;

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
        super.vidaActual = 20;
        super.vidaMaxima = 20;
        super.manaActual = 100;
        super.manaMaximo = 100;
        this.clase="Mago";
        this.descripcion="Usuario de magia estudioso que es capaz de manipular la realidad";
        this.habilidad1=new Habilidad("Bastonazo", -6,0,0,true);
        super.modH1=2;
        this.habilidad2=new Habilidad("Manos Quemantes", -10,0,0,true);
        super.modH2=5;
        this.habilidadEspecial=new Habilidad("Bola de Fuego", -28,0,0,false);
        this.restriccion = new RestricTurnosSinHabilidadEsp();
        this.restriccion.setDescriRes(this.habilidadEspecial);
    }    
}
