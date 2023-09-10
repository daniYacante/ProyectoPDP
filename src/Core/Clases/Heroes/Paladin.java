package Core.Clases.Heroes;

import Core.Clases.Habilidad;

public class Paladin extends Core.Clases.Heroes.Heroe {
    //Paladin d10
    //Coloque mana = vidaActual por simplicidad
    //vidaActual es d10 * 12
    public Paladin(String nombre){
        super.nombre = nombre;
        super.tipo = "Heroe";
        super.vidaActual = 120;
        super.vidaMaxima = 180;
        super.manaActual = 100;
        super.manaMaximo = 180;
        this.clase="Paladin";
        this.descripcion="Guerrero santo atado a un juramento sagrado";
        this.habilidad1=new Habilidad("Espadazo");
        this.habilidad2=new Habilidad("Imposicion de Manos");
        this.habilidadEspecial=new Habilidad("Golpe Divino");
    }
}


