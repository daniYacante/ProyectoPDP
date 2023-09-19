package Core.Clases.Jefes.Esbirros;
import java.util.Random;
import Core.Clases.Habilidad;
import Core.Clases.Jefes.Jefe;

public class Ayudante extends Jefe {
    public Ayudante(String nombre){
        super.nombre = nombre;
        super.armadura=12;
        super.vidaActual = 20;
        super.tipo = "Enemigo";
        this.descripcion="Ayudante de catedra";
        this.habilidad1=new Habilidad("Bastonazo", -5, 0, 0,true);
    }
    @Override
    public int tirarDado() {
    	Random d20=new Random();
    	return d20.nextInt(20)+1;
    }
}
