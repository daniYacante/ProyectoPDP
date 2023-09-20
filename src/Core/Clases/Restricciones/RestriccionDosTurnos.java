package Core.Clases.Restricciones;
import Core.Clases.Habilidad;
import Core.Clases.Heroes.*;

/**
 * Restriccion Turnos sin uso del heroe
 */
public class RestriccionDosTurnos extends Restriccion{
    /**
     * useE es una variable int que tomara el valor que se encuentra en UseEsp
     */
    public int useE;

    /**
     * Constructor de la restriccion
     */
    public RestriccionDosTurnos(){
    }

    /**
     * Se setea la restriccion, si es 0 se va a poder pero en la logica lo deshabilita, luego en caso de que no sea 0 empieza a revisar si ya pasaron los dos turnos para habilitarlo
     * @param atacante el heroe que va a atacar con la habilidad especial
     */
    public void setRestriccion(Heroe atacante){
    	this.restriccion = true;
        if((atacante.getTurno() - turnoAnt) > 2){
            this.turnoAnt = atacante.getTurno();
            this.restriccion = true;
            atacante.changeCanUse();
        }else if((atacante.getTurno()-turnoAnt)==0)atacante.changeCanUse();
    }

    /**
     * Descripcion de la restriccion
     * @param especial se toma cual es la habilidad especial a tratar
     */
    public void setDescriRes(Habilidad especial){
        this.descripcionRes = String.format("Despues de utilizar %s (Habilidad Especial),\n\t no podras utilizar al heroe por 2 turnos", especial.getNombre());
    }

}
