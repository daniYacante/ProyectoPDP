package Core.Clases.Heroes;
import Core.Game;
import Core.Clases.Habilidad;
import Core.Clases.Restricciones.RestricTurnosSinHabilidadEsp;

/**
 * La clase Barbaro, que hereda de Heroe
 * @see Heroe
 */
public class Barbaro extends Heroe {
    /**
     * constructor del Barbaro, sus stats y habilidades
     */
    public Barbaro(){
        super.turnoAnt = 0;
        super.tipo = "Heroe";
        super.armadura=14;
        super.vidaActual = 14;
        super.vidaMaxima = 14;
        //No tiene magia
        super.manaActual = 0;
        super.manaMaximo = 0;
        this.clase="Barbaro";
        this.descripcion="Guerrero feroz de origen primitivo que puede entrar en furor al luchar";
        this.habilidad1=new Habilidad("Hachazo", -8, 0, 0,true);
        this.habilidad2=new Habilidad("Lanzar Jabalina", 10, 0, -10,true);
        this.habilidadEspecial=new Habilidad("Furor", -16, 0, 0,false);
        this.restriccion = new RestricTurnosSinHabilidadEsp();
        this.restriccion.setDescriRes(this.habilidadEspecial);
    }
    public static void getStats() {
    	Game.imprimir("");
    }
}


