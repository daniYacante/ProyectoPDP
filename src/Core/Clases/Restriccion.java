package Core.Clases;

//Interfaz de restricciones
public interface Restriccion {
    
    public String descripcionRes = "";
    public boolean restriccion = false;

    public void setRestriccion();

	public boolean getRestriccion();

	public String getDescripcionRes();

    public void progresoCond();
}
