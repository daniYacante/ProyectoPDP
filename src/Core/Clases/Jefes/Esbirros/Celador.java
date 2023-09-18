package Core.Clases.Jefes.Esbirros;
import java.util.Random;
import Core.Clases.Habilidad;


public class Celador extends Core.Clases.Human{
	public Celador(String nombre){
        super.nombre = nombre;
        super.vidaActual = 20;
        super.tipo = "Enemigo";
        this.descripcion="Celador de catedra";
        this.habilidad1=new Habilidad("Bastonazo", -10, 0, 0,true);
    }
    @Override
    public int tirarDado() {
    	Random d20=new Random();
    	return d20.nextInt(20)+1;
    }
}
