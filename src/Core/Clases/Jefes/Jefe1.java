package Core.Clases.Jefes;

import Core.Clases.Habilidad;

public class Jefe1 extends Jefe{
    public Jefe1(String nombre){
        super.nombre = nombre;
        super.vidaActual = 120;
        this.clase="Profe1";
        this.descripcion="Profe1";
        this.habilidad1=new Habilidad("Bastonazo", -10, 0, 0);
        this.habilidadEspecial=new Habilidad("Final PdP", -23, 0,0);
    }
}
