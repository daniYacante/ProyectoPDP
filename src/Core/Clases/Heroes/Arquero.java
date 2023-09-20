package Core.Clases.Heroes;
import Core.Clases.Habilidad;
import Core.Clases.Restricciones.RestriccionBajaVida;


/**
 * La clase Arquero, que hereda de Heroe
 * @see Heroe
 */
public class Arquero extends Core.Clases.Heroes.Heroe {
    /**
     * constructor del Arquero, sus stats y habilidades
     */
    public Arquero(){
        super.turnoAnt = 0;
        super.tipo = "Heroe";
        super.armadura=13;
        super.vidaActual = 28;
        super.vidaMaxima = 28;
        super.manaActual = 10;
        super.manaMaximo = 10;
        this.clase="Arquero";
        this.descripcion="Guerrero santo atado a un juramento sagrado";
        this.habilidad1=new Habilidad("Disparar Flecha", -8, 0, 0,true);
        super.modH1=5;
        this.habilidad2=new Habilidad("Acuchillada", -7, 0,0,true);
        super.modH2=5;
        this.habilidadEspecial=new Habilidad("Lluvia de flechas", -17, 0, -2,true);
        super.modEsp=4;
        this.restriccion = new RestriccionBajaVida();
        this.restriccion.setDescriRes(this.habilidadEspecial);
    }
}


