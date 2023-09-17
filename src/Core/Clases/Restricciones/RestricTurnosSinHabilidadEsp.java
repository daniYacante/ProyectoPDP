package Core.Clases.Restricciones;

import Core.Clases.Habilidad;
import Core.Clases.Heroes.Heroe;

public class RestricTurnosSinHabilidadEsp extends Restriccion{
    public int useE;
    public RestricTurnosSinHabilidadEsp(){
    }
    public void setRestriccion(Heroe atacante){
        this.restriccion = true;
        if((atacante.getTurno() - turnoAnt) >= 2){
            this.turnoAnt = atacante.getTurno();
            this.restriccion = true;
        }else this.restriccion = false;
    }
    public void setDescriRes(Habilidad especial){
        this.descripcionRes = String.format("Despues de utilizar %s (Habilidad Especial),\n\t no podras utilizar al heroe por 2 turnos", especial.getNombre());
    }
}