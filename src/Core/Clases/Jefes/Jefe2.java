package Core.Clases.Jefes;
import Core.Clases.Habilidad;

/**
 * La clase Jefe2, que hereda de Jefe
 * @see Jefe
 */
public class Jefe2 extends Jefe{
    /**
     * Constructor del Jefe2, sus stats y habilidades
     * @param nombre recibe como parametro el nombre que quiere que le demos
     */
    public Jefe2(String nombre){
        super.nombre = nombre;
        super.vidaActual = 80;
        super.vidaMaxima=80;
        super.armadura=16;
        this.clase="Profe2";
        this.descripcion="Profe de Lenguajes Formales y de los temibles Compiladores";
        this.habilidad1=new Habilidad("Expresion Regular", -10, 0, 0, true);
        this.habilidadEspecial=new Habilidad("Hacer Compilador", -20, 0,0, true);
    }
}
