package Core.Clases.Jefes;

import Core.Clases.Habilidad;

/**
 * La clase Jefe1, que hereda de Jefe
 * @see Jefe
 */
public class Jefe1 extends Jefe{
    /**
     * Constructor del Jefe1, sus stats y habilidades
     * @param nombre recibe como parametro el nombre que quiere que le demos
     */
	public Jefe1(String nombre){
        super.nombre = nombre;
        super.vidaActual = 50;
        super.vidaMaxima = 50;
        super.armadura=13;
        this.clase="Profe1";
        this.descripcion="Profe1";
        this.habilidad1=new Habilidad("Pasar al frente", -8, 0, 0,true);
        this.habilidadEspecial=new Habilidad("Final PdP", -23, 0,0,true);
    }
}
