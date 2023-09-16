package Core.Clases.Heroes;
import Core.Game;
import Core.Clases.Habilidad;

public class Monje extends Core.Clases.Heroes.Heroe {
    public Monje(){
        super.turnoAnt = 0;
        super.tipo = "Heroe";
        super.armadura=15;
        super.vidaActual = 10;
        super.vidaMaxima = 10;
        super.manaActual = 100;
        super.manaMaximo = 180;
        this.clase="Monje";
        this.descripcion="Maestro de las Artes Marciales, utilizando el poder del cuerpo en busqueda de la perfeccion fisica y espiritual";
        this.habilidad1=new Habilidad("Artes Marciales", -8, 0, 0,true);
        this.habilidad2=new Habilidad("Lanzar Dardos", 10, 0, -10,true);
        this.habilidadEspecial=new Habilidad("Golpe Divino (Habilidad Especial)", -16, 0, 0,true);//Buscar
        this.descripcionRes = "Puedes utilizar Golpe Divino cada 3 turnos";
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


