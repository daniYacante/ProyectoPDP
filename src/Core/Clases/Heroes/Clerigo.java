package Core.Clases.Heroes;

import Core.Clases.Habilidad;

public class Clerigo extends Core.Clases.Heroes.Heroe{
    //Coloque mana = vidaActual por simplicidad
    //vidaActual es d8 * 12
    public Clerigo(){
        //Clerigo d8
        super.tipo = "Heroe";
        super.vidaActual = 96;
        super.vidaMaxima = 160;
        super.manaActual = 96;
        super.manaMaximo = 160;
        this.clase="Clerigo";
        this.descripcion="Guerrero sacerdotal que ejerce magia divina en servicio de un poder superior";
        this.habilidad1=new Habilidad("Bendicion");
        this.habilidad2=new Habilidad("Curar Heridas");
        this.habilidadEspecial=new Habilidad("Curar Heridas en Area");
    }
    
}
