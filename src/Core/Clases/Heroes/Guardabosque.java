package Core.Clases.Heroes;
import Core.Clases.Habilidad;
import Core.Clases.Restricciones.RestriccionBajaVida;


public class Guardabosque extends Core.Clases.Heroes.Heroe {
    //Coloque mana = vidaActual por simplicidad
    //vidaActual es d6 * 12
    public Guardabosque(String nombre){
        //Explorador d10
        super.tipo = "Heroe";
        super.vidaActual = 80;
        super.vidaMaxima = 120;
        super.manaActual = 80;
        super.manaMaximo = 120;
        this.clase="Explorador";
        this.descripcion="Hábil casador de los bosques";
        //HABILIDADES ESTOY BUSCANDO
        this.habilidad1=new Habilidad("Acuchillada", -8, 0,0,true);
        this.habilidad2=new Habilidad("Martillazo", -10, 0,0,true);
        this.habilidadEspecial=new Habilidad("Flecha Relampago", -20, 0, 0,true);
        this.restriccion = new RestriccionBajaVida();
        this.restriccion.setDescriRes(this.habilidadEspecial);
    }    
}