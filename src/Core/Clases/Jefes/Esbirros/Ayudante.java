package Core.Clases.Jefes.Esbirros;
import java.util.Random;
import Core.Clases.Habilidad;
import Core.Clases.Jefes.Jefe;

/**
 * Ayudante es una clase que hereda de Jefe, aunque estos no llevan consigo una habilidad especial.
 */
public class Ayudante extends Jefe {
    /**
     * Constructor de Ayudante
     * @param nombre el nombre que recibe
     */
    public Ayudante(String nombre){
        super.nombre = nombre;
        super.armadura=12;
        super.vidaActual = 20;
        super.tipo = "Enemigo";
        this.descripcion="Ayudante de catedra";
        this.habilidad1=new Habilidad("Bastonazo", -5, 0, 0,true);
    }

    /**
     * Sobreescritura de tirarDado, debido a que no controlamos estos personajes
     * @return int el valor del dado
     */
    @Override
    public int tirarDado() {
    	Random d20=new Random();
    	return d20.nextInt(20)+1;
    }
}
