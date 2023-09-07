package Core.Clases;

public class Ayudante extends Human {
    public Ayudante(String nombre){
        super.vidaActual = 30;
        super.tipo = "Enemigo";
        this.descripcion="Ayudante de catedra";
        this.habilidad1=new Habilidad("Bastonazo");
    }
}
