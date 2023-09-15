package Core.Clases.Heroes;
import Core.Game;
import Core.Clases.Habilidad;

public class Paladin extends Core.Clases.Heroes.Heroe {
    //Paladin d10
    //Coloque mana = vidaActual por simplicidad
    //vidaActual es d10 * 12
    public Paladin(String nombre){
        super.turnoAnt = 0;
        super.nombre = nombre;
        super.tipo = "Heroe";
        super.vidaActual = 120;
        super.vidaMaxima = 180;
        super.manaActual = 100;
        super.manaMaximo = 180;
        this.clase="Paladin";
        this.descripcion="Guerrero santo atado a un juramento sagrado";
        this.habilidad1=new Habilidad("Espadazo", -8, 0, 0);
        this.habilidad2=new Habilidad("Imposicion de Manos", 10, 0, -10);
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


