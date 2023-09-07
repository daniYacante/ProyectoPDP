package Core.Clases.Jefes.Esbirros;

import Core.Clases.Habilidad;

public class Ayudante extends Core.Clases.Human {
    public Ayudante(String nombre){
        super.nombre = nombre;
        super.vidaActual = 30;
        super.tipo = "Enemigo";
        this.descripcion="Ayudante de catedra";
        this.habilidad1=new Habilidad("Bastonazo");
    }
}
