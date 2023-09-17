package Core.Clases.Restricciones;
import Core.Clases.Habilidad;
import Core.Clases.Heroes.*;

public class RestriccionDosTurnos extends Restriccion{
    public int useE;
    public RestriccionDosTurnos(){
    }
    public void setRestriccion(Heroe atacante){
        this.restriccion = true;
        useE = atacante.getuseEsp();
        if (useE == 0){
            turnoAnt = atacante.getTurno();
            atacante.changeCanUse();
        }
        if ((atacante.getTurno() - turnoAnt) == 1) {
            atacante.changeCanUse();
            turnoAnt = atacante.getTurno();
            atacante.changeUesEsp();
        }
    }
    public void setDescriRes(Habilidad especial){
        this.descripcionRes = String.format("Despues de utilizar %s (Habilidad Especial),\n\t no podras utilizar a Rogue por 2 turnos", especial.getNombre());
    }

}
