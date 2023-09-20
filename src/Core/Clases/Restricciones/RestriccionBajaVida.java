package Core.Clases.Restricciones;

import Core.Clases.Habilidad;
import Core.Clases.Heroes.Heroe;

/**
 * Restriccion Uso de Habilidad Especial por perder vida
 */
public class RestriccionBajaVida extends Restriccion {
    /**
     * Se setea la restriccion, la logica muestra el como pierde 10% de vida
     * @param atacante Heroe que es el que va a atacar con la habilidad especial
     */
    public void setRestriccion(Heroe atacante){
        this.restriccion = true;
        int vida = (int)Math.ceil(vida = (10 * atacante.getVida()) / 100);
        atacante.recibirDmg(vida);
    }

    /**
     * Descripcion de la restriccion
     * @param especial se toma cual es la habilidad especial a tratar
     */
    public void setDescriRes(Habilidad especial){
        this.descripcionRes = String.format("Despues de utilizar %s (Habilidad Especial),\n\t tu vida disminuira un 10%s", especial.getNombre(),"%");
    }
}
