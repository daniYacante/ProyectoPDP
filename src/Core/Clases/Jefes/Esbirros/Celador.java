package Core.Clases.Jefes.Esbirros;

import Core.Clases.Habilidad;


public class Celador extends Core.Clases.Human{
    public Celador(String nombre){
        super.vidaActual = 20;
        super.tipo = "Enemigo";
        this.descripcion="Celador de catedra";
        this.habilidad1=new Habilidad("Bastonazo");
    }
}
