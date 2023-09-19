package Core.Clases.Heroes;
import Core.Clases.*;
import Core.Clases.Restricciones.RestricTurnosSinHabilidadEsp;

/**
 * La clase Paladin, que hereda de Heroe
 * @see Heroe
 */
public class Paladin extends Core.Clases.Heroes.Heroe {
    //Paladin d10
    //Coloque mana = vidaActual por simplicidad
    //vidaActual es d10 * 12

    /**
     * Constructor del Paladin, sus stats y habilidades
     */
    public Paladin(){
        super.turnoAnt = 0;
        super.tipo = "Heroe";
        super.armadura=18;
        super.vidaActual = 28;
        super.vidaMaxima = 28;
        super.manaActual = 60;
        super.manaMaximo = 60;
        this.clase="Paladin";
        this.descripcion="Guerrero santo atado a un juramento sagrado";
        this.habilidad1=new Habilidad("Espadazo", -8, 0, 0,true);
        super.modH1=5;
        this.habilidad2=new Habilidad("Imposicion de Manos", 10, 0, -10,false);
        this.habilidadEspecial=new Habilidad("Golpe Divino", -16, 0, 0,false);
        this.restriccion = new RestricTurnosSinHabilidadEsp();
        this.restriccion.setDescriRes(this.habilidadEspecial);
    }
}


