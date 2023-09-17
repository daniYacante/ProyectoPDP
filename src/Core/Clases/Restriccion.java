package Core.Clases;

//Interfaz de restricciones

import Core.Clases.Heroes.*;

/**
 * La interface Restriccion, que se implementa en los heroes para ver si ya cumplen para usar la habilidad especial
 */
public interface Restriccion {
    /**
     * La descripcion de la restriccion, que es lo que debe hacer para el uso de la habilidad especial
     */
    public String descripcionRes = "";
    /**
     * La restriccion, que nos muestra un valor booleano. Si es true ya puede usar la habilidad especial, si es false no
     */
    public boolean restriccion = false;

    /**
     * La restriccion en cada uno de los heroes
     * @see Arquero#setRestriccion()
     * @see Barbaro#setRestriccion()
     * @see Bardo#setRestriccion()
     * @see Brujo#setRestriccion()
     * @see Druida#setRestriccion()
     * @see Monje#setRestriccion()
     * @see Paladin#setRestriccion()
     * @see Rogue#setRestriccion()
     */
    public void setRestriccion();

	public boolean getRestriccion();

	public String getDescripcionRes();

    public void progresoCond();
}
