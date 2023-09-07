package Core.Clases;

public class Jefe1 extends Human{
    public Jefe1(String nombre){
        super.tipo = "Enemigo";
        super.vidaActual = 120;
        this.clase="Profe1";
        this.descripcion="Profe1";
        this.habilidad1=new Habilidad("Bastonazo");;
        this.habilidadEspecial=new Habilidad("Jefe1");
    }
}
