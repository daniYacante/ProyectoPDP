package Core.Clases.Heroes;
import Core.Clases.Habilidad;
import Core.Clases.Restricciones.RestriccionDosTurnos;

/**
 * La clase Bardo, que hereda de Heroe
 * @see Heroe
 */
public class Bardo extends Core.Clases.Heroes.Heroe {
    /**
     * Constructor del Bardo, sus stats y habilidades
     */
    public Bardo(){
        super.turnoAnt = 0;
        super.tipo = "Heroe";
        super.armadura=13;
        super.vidaActual = 24;
        super.vidaMaxima = 24;
        super.manaActual = 50;
        super.manaMaximo = 50;
        this.clase="Bardo";
        this.descripcion="Un inspirador magico cuyo poder resuena en la musica de creacion";
        this.habilidad1=new Habilidad("Espadazo", -8, 0, 0,true);
        super.modH1=4;
        this.habilidad2=new Habilidad("Curar Heridas", 10, 0, -10,false);
        this.habilidadEspecial=new Habilidad("Inspiracion", -16, 0, 0,false);
        this.restriccion = new RestriccionDosTurnos();
        this.restriccion.setDescriRes(this.habilidadEspecial);
    }
}


