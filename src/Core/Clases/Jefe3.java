package Core.Clases;

public class Jefe3 extends Human{
    public Jefe3(String nombre){
        super.tipo = "Enemigo";
        super.vidaActual = 300;
        this.clase="Profe3";
        this.descripcion="Profe3";
        this.habilidad1=new Habilidad("Bastonazo");;
        this.habilidadEspecial=new Habilidad("Jefe3");
    }
}
