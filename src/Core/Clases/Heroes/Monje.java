package Core.Clases.Heroes;
import Core.Clases.Habilidad;
import Core.Clases.Restricciones.RestriccionBajaVida;


/**
 * La clase Monje, que hereda de Heroe
 * @see Heroe
 */
public class Monje extends Core.Clases.Heroes.Heroe {
    public Monje(){
        super.turnoAnt = 0;
        super.tipo = "Heroe";
        super.armadura=15;
        super.vidaActual = 10; 
        super.vidaMaxima = 10;
        super.manaActual = 100;
        super.manaMaximo = 180;
        this.clase="Monje";
        this.descripcion="Maestro de las Artes Marciales, utilizando el poder del cuerpo en busqueda de la perfeccion fisica y espiritual";
        this.habilidad1=new Habilidad("Artes Marciales", -8, 0, 0,true);
        this.habilidad2=new Habilidad("Lanzar Dardos", 10, 0, -10,true);
        this.habilidadEspecial=new Habilidad("Golpe Divino", -16, 0, 0,true);//Buscar
        this.restriccion = new RestriccionBajaVida();
        this.restriccion.setDescriRes(this.habilidadEspecial);
    }
}


