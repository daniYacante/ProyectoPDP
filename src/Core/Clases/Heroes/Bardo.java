package Core.Clases.Heroes;
import Core.Game;
import Core.Clases.Habilidad;

public class Bardo extends Core.Clases.Heroes.Heroe {
    public Bardo(){
        super.turnoAnt = 0;
        super.tipo = "Heroe";
        super.armadura=13;
        super.vidaActual = 10;
        super.vidaMaxima = 10;
        super.manaActual = 50;
        super.manaMaximo = 50;
        this.clase="Bardo";
        this.descripcion="Un inspirador magico cuyo poder resuena en la musica de creacion";
        this.habilidad1=new Habilidad("Espadazo", -8, 0, 0,true);
        this.habilidad2=new Habilidad("Curar Heridas", 10, 0, -10,false);
        this.habilidadEspecial=new Habilidad("Inspiracion (Habilidad Especial)", -16, 0, 0,false);
        this.descripcionRes = "Puedes utilizar Inspiracion cada 3 turnos";
    }
    //Usar habilidad Especial despues de tres turnos

    public void setRestriccion(){
        if ((turnos - turnoAnt) >= 2) {
            turnoAnt = turnos;
            super.restriccion = true;
        } else {
            super.restriccion = false;
        }
    }
    
    public static void getStats() {
    	Game.imprimir("");
    }
}


