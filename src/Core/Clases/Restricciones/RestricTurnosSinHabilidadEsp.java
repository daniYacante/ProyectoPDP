package Core.Clases.Restricciones;

import Core.Clases.Habilidad;
import Core.Clases.Heroes.Heroe;

/**
 * Restriccion Turnos sin uso de la habilidad especial
 */
public class RestricTurnosSinHabilidadEsp extends Restriccion{
    public int useE;

    /**
     * Constructor de la restriccion
     */
    public RestricTurnosSinHabilidadEsp(){
    }

    /**
     * Seteo de la restriccion, la logica para contar que no puede usar su habilidad especial por dos turnos
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