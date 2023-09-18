package Core.Clases.Jefes.Esbirros;
import java.util.Random;
import Core.Clases.Habilidad;

public class Ayudante extends Core.Clases.Human {
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
