package Core.Clases.Heroes;

import Core.Clases.Habilidad;

/**
 * La clase Rogue, que hereda de Heroe
 * @see Heroe
 */
public class Rogue extends Core.Clases.Heroes.Heroe {
    //Coloque mana = vidaActual por simplicidad
    //vidaActual es d8.1 * 12

    /**
     * Constructor del Rogue, sus stats y habilidades
     */
    public Rogue(){
       //Rogue d8.1
        super.turnoAnt = 0;
        super.nombre = nombre;
        super.tipo = "Heroe";
        super.vidaActual = 97;
        super.vidaMaxima = 161;
        super.manaActual = 97;
        super.manaMaximo = 161;
        this.clase="Rogue";
        this.descripcion="Malandrin que utiliza el sigilo y artimañas para superar obstaculos y enemigos";
        this.habilidad1=new Habilidad("Acuchillada", -8, 0,0,true);
        this.habilidad2=new Habilidad("",0,0,0,true);//Tengo que buscar mas sobre los rogue
        this.habilidadEspecial=new Habilidad("Golpe Mortal", -15, 0,0,true);
        this.descripcionRes = "Despues de utilizar Golpe Mortal (Habilidad Especial), no podras utilizar a Rogue por 2 turnos";
    }
    //Si usas la habilidad Especial despues no podes utilizar el personaje por 2 turnos
    public void setRestriccion(){
        restriccion = true;
        if (useEsp == false){
            turnoAnt = turnos;
        }
        if ((turnos - turnoAnt) == 2) {
            super.canUse = true;
            turnoAnt = turnos;
            super.useEsp = false;
        }else super.canUse = false;
    }
}
