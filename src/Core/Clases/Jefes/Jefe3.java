package Core.Clases.Jefes;

import Core.Clases.Habilidad;

/**
 * La clase Jefe3, que hereda de Jefe
 * @see Jefe
 */
public class Jefe3 extends Jefe{
    /**
     * Constructor del Jefe3
     * @param nombre recibe como parametro el nombre que quiere que le demos
     */
    public Jefe3(String nombre){
        super.nombre = nombre;
        super.vidaMaxima = 100;
        super.vidaActual = 100;
        super.armadura=16;
        this.clase="Profe3";
        this.descripcion="Profe de esa materia que todos dejan hasta el final de la carrera";
        this.habilidad1=new Habilidad("Examen la semana que viene", -10, 0, 0,true);
        this.habilidadEspecial=new Habilidad("Integrales Triples", -30, 0,0,true);
    }
}
