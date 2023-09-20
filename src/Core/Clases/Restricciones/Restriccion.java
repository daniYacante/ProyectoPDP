package Core.Clases.Restricciones;

import Core.Clases.Habilidad;

//Interfaz de restricciones

import Core.Clases.Heroes.*;
/**
 * La Clase Restriccion, que se  en los heroes para ver si ya cumplen para usar la habilidad especial
 */
public class Restriccion {
    /**
     * La descripcion de la restriccion, que es lo que debe hacer para el uso de la habilidad especial
     */
    public String descripcionRes = "";
    /**
     * La restriccion, que nos muestra un valor booleano. Si es true ya puede usar la habilidad especial, si es false no
     */
    public boolean restriccion = false;
    public boolean canUse = true;
    /**
     * El turno anterior del que se jugo
     */
	protected int turnoAnt = 0;


   /* public void setRestriccion();

	public boolean getRestriccion();

	public String getDescripcionRes();

    public void progresoCond();
    */

    /**
     * Seteo de restriccion, no hay cuerpo
     * @param atacante el heroe que usara la habilidad especial
     */
    public void setRestriccion(Heroe atacante){
    }
	
	public void progresoCond(){//No se si lo vamos a implementar
	}

    /**
     * devuelve el valor booleano de la restricicon
     * @see Restriccion#restriccion
     * @return boolean true si se puede, false si no
     */
	public boolean getValorRestriccion(){
		return restriccion;
	}

    /**
     * Setea la descripcion de la restriccion
     * @param especial la habilidad especial que se va a usar
     */
    public void setDescriRes(Habilidad especial){}

    /**
     * Devuelve la descripcion de la restriccion
     * @return String con la descripcion
     */
	public String getDescripcionRes(){
		return descripcionRes;
	}
}
