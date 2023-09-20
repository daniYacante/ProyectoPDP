package Core.Clases.Jefes;

import java.util.Random;

import Core.Clases.Human;

/**
 * La clase Jefe, que hereda de Human
 * @see Human
 */
public class Jefe extends Human {
    protected String[] esbirros = new String[10];

    /**
     * Constructor de Jefe
     */
    public Jefe() {
        super.tipo = "Enemigo";
    }

    /**
     * Sobreescritura de tirarDado de Human, debido a que en Jefe no controlamos estos personajes
     * @return int el valor del dado
     */
    @Override
    public int tirarDado() {
    	Random d20=new Random();
    	return d20.nextInt(20)+1;
    }
}
    //METODO

