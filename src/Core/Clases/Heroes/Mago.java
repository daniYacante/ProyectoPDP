package Core.Clases.Heroes;

import Core.Clases.Habilidad;

public class Mago extends Core.Clases.Heroes.Heroe {
    //Coloque mana = vidaActual por simplicidad
    //vidaActual es d6 * 12
    public Mago(String nombre){
        //Mago d6
        super.nombre = nombre;
        super.tipo = "Heroe";
        super.vidaActual = 72;
        super.vidaMaxima = 140;
        super.manaActual = 72;
        super.manaMaximo = 140;
        this.clase="Mago";
        this.descripcion="Usuario de magia estudioso que es capaz de manipular la realidad";
        this.habilidad1=new Habilidad("Bastonazo", -10,0,0);
        this.habilidad2=new Habilidad("Manos Quemantes", -8,0,0);
        this.habilidadEspecial=new Habilidad("Bola de Fuego", -15,0,0);
    }    
}
