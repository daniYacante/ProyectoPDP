package Core.Clases.Heroes;

import Core.Clases.Habilidad;
import Core.Clases.Restricciones.RestriccionDosTurnos;

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
        super.armadura=14;//armadura de cuero(11) + dex(3) 
        super.vidaActual = 24;
        super.vidaMaxima = 24;
        super.manaActual = 50;
        super.manaMaximo = 50;
        this.clase="Rogue";
        this.descripcion="Malandrin que utiliza el sigilo y artimañas para superar obstaculos y enemigos";
        this.habilidad1=new Habilidad("Acuchillada", -5, 0,0,true);
        this.habilidad2=new Habilidad("Espadazo",-8,0,0,true);//Tengo que buscar mas sobre los rogue
        this.habilidadEspecial=new Habilidad("Golpe Mortal", -15, 0,0,true);
        this.restriccion = new RestriccionDosTurnos();
        this.restriccion.setDescriRes(this.habilidadEspecial);
    }
    //Si usas la habilidad Especial despues no podes utilizar el personaje por 2 turnos
}
