package Core.Clases.Heroes;

import Core.Clases.Habilidad;

public class Rogue extends Core.Clases.Human {
    //Coloque mana = vidaActual por simplicidad
    //vidaActual es d8.1 * 12
    public Rogue(String nombre){
       //Rogue d8.1
        super.tipo = "Heroe";
        super.vidaActual = 97;
        super.vidaMaxima = 161;
        super.manaActual = 97;
        super.manaMaximo = 161;
        this.clase="Rogue";
        this.descripcion="Malandrin que utiliza el sigilo y artimañas para superar obstaculos y enemigos";
        this.habilidad1=new Habilidad("Acuchillada");
        this.habilidad2=new Habilidad("");//Tengo que buscar mas sobre los rogue
        this.habilidadEspecial=new Habilidad("Golpe Mortal");
    }
}
