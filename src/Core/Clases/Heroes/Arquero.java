package Core.Clases.Heroes;
import Core.Game;
import Core.Clases.Habilidad;

public class Arquero extends Core.Clases.Heroes.Heroe {
    public Arquero(){
        super.turnoAnt = 0;
        super.tipo = "Heroe";
        super.armadura=13;
        super.vidaActual = 12;
        super.vidaMaxima = 12;
        super.manaActual = 100;
        super.manaMaximo = 180;
        this.clase="Arquero";
        this.descripcion="Guerrero santo atado a un juramento sagrado";
        this.habilidad1=new Habilidad("Disparar Flecha", -8, 0, 0);
        this.habilidad2=new Habilidad("Acuchillada", 10, 0, -10);
        this.habilidadEspecial=new Habilidad("Golpe Divino (Habilidad Especial)", -16, 0, 0);
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


