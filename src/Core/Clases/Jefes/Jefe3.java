package Core.Clases.Jefes;

import Core.Clases.Habilidad;


public class Jefe3 extends Jefe{
    public Jefe3(String nombre){
        super.nombre = nombre;
        super.vidaActual = 300;
        this.clase="Profe3";
        this.descripcion="Profe3";
        this.habilidad1=new Habilidad("Examen la semana que viene", -10, 0, 0,true);
        this.habilidadEspecial=new Habilidad("Integrales Triples", -43, 0,0,true);
    }
}
