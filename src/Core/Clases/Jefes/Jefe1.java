package Core.Clases.Jefes;

import Core.Clases.Habilidad;

public class Jefe1 extends Jefe{
    public Jefe1(String nombre){
        super.nombre = nombre;
        super.vidaActual = 120;
        this.clase="Profe1";
        this.descripcion="Profe1";
        this.habilidad1=new Habilidad("Bastonazo");;
        this.habilidadEspecial=new Habilidad("Jefe1");
    }
}
