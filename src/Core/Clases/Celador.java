package Core.Clases;

public class Celador extends Human{
    public Celador(String nombre){
        super.vidaActual = 20;
        super.tipo = "Enemigo";
        this.descripcion="Celador de catedra";
        this.habilidad1=new Habilidad("Bastonazo");
    }
}
