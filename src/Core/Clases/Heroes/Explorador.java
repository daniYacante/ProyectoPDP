package Core.Clases.Heroes;

import Core.Clases.Habilidad;

public class Explorador extends Core.Clases.Human {
    //Coloque mana = vidaActual por simplicidad
    //vidaActual es d6 * 12
    public Explorador(String nombre){
        //Explorador d10
        super.nombre = nombre;
        super.tipo = "Heroe";
        super.vidaActual = 80;
        super.vidaMaxima = 120;
        super.manaActual = 80;
        super.manaMaximo = 120;
        this.clase="Explorador";
        this.descripcion="Hábil casador de los bosques";
        //HABILIDADES ESTOY BUSCANDO
        this.habilidad1=new Habilidad("Acuchillada");
        this.habilidad2=new Habilidad("Espadazo");
        this.habilidadEspecial=new Habilidad("Bestia");
    }    
}