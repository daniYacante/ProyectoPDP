package Core.Clases.Jefes;

import java.util.Random;

import Core.Clases.Human;

/**
 * La clase Jefe, que hereda de Human
 * @see Human
 */
public class Jefe extends Human {
    protected String[] esbirros = new String[10];
    public Jefe() {
        super.tipo = "Enemigo";
    }
    @Override
    public int tirarDado() {
    	Random d20=new Random();
    	return d20.nextInt(20)+1;
    }
}
    //METODO

