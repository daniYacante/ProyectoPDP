package Core.Clases.Restricciones;

import Core.Clases.Habilidad;
import Core.Clases.Heroes.Heroe;

public class RestriccionBajaVida extends Restriccion {
    public void setRestriccion(Heroe atacante){
        this.restriccion = true;
        int vida = (int)Math.ceil(vida = (10 * atacante.getVida()) / 100);
        atacante.recibirDmg(vida);
    }
    public void setDescriRes(Habilidad especial){
        this.descripcionRes = String.format("Despues de utilizar %s (Habilidad Especial),\n\t tu vida disminuira un 10%s", especial.getNombre(), "%");
    }
}
