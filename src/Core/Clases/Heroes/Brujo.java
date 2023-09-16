package Core.Clases.Heroes;
import Core.Game;
import Core.Clases.Habilidad;

public class Brujo extends Core.Clases.Heroes.Heroe {
    public Brujo(){
        super.turnoAnt = 0;
        super.tipo = "Heroe";
        super.armadura=14;
        super.vidaActual = 8;
        super.vidaMaxima = 8;
        super.manaActual = 100;
        super.manaMaximo = 180;
        this.clase="Brujo";
        this.descripcion="Conjurador que obtiene sus poderes por linea de sangre o por un regalo del universo";
        this.habilidad1=new Habilidad("Bastonazo", -8, 0, 0);
        this.habilidad2=new Habilidad("Rayo de Escarcha", 10, 0, -10);
        this.habilidadEspecial=new Habilidad("Bola de Fuego (Habilidad Especial)", -16, 0, 0);
        this.descripcionRes = "Puedes utilizar Bola de Fuego cada 3 turnos";
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


