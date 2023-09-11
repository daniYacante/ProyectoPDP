package Core.Clases.Jefes;
import Core.Clases.Habilidad;

public class Jefe2 extends Jefe{
    
    public Jefe2(String nombre){
        super.nombre = nombre;
        super.vidaActual = 200;
        this.clase="Profe2";
        this.descripcion="Profe2";
        this.habilidad1=new Habilidad("Bastonazo");;
        this.habilidadEspecial=new Habilidad("Jefe2");
    }
}
