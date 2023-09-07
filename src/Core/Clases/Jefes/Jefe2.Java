package Core.Clases.Jefes;
import Core.Clases.Habilidad;

public class Jefe2 extends Core.Clases.Human{
    
    public Jefe2(String nombre){
        super.tipo = "Enemigo";
        super.vidaActual = 200;
        this.clase="Profe2";
        this.descripcion="Profe2";
        this.habilidad1=new Habilidad("Bastonazo");;
        this.habilidadEspecial=new Habilidad("Jefe2");
    }
}
