package Core.Clases.Heroes;
import Core.Clases.Habilidad;
import Core.Clases.Restricciones.RestriccionBajaVida;


/**
 * La clase Monje, que hereda de Heroe
 * @see Heroe
 */
public class Monje extends Core.Clases.Heroes.Heroe {
    /**
     * Constructor del monje, sus stats y habilidades
     */
    public Monje(){
        super.turnoAnt = 0;
        super.tipo = "Heroe";
        super.armadura=15;
        super.vidaActual = 24; 
        super.vidaMaxima = 24;
        super.manaActual = 100;
        super.manaMaximo = 100;
        this.clase="Monje";
        this.descripcion="Maestro de las Artes Marciales, utilizando el poder del cuerpo en busqueda de la perfeccion fisica y espiritual";
        this.habilidad1=new Habilidad("Artes Marciales", -8, 0, 0,true);
        super.modH1=5;
        this.habilidad2=new Habilidad("Lanzar Dardos", -6, 0, -10,true);
        super.modH2=4;
        this.habilidadEspecial=new Habilidad("Golpe Divino", -16, 0, 0,true);//Buscar
        this.restriccion = new RestriccionBajaVida();
        this.restriccion.setDescriRes(this.habilidadEspecial);
    }
}


