package Core.Clases.Heroes;
import Core.Game;
import Core.Clases.Habilidad;

public class Hechicero extends Core.Clases.Heroes.Heroe {
    public Hechicero(){
        super.turnoAnt = 0;
        super.tipo = "Heroe";
        super.armadura=
        super.vidaActual = 10;
        super.vidaMaxima = 10;
        super.manaActual = 100;
        super.manaMaximo = 180;
        this.clase="Hechicero";
        this.descripcion="Ser con magia obtenida por un contrato con una entidad extraplanar";
        this.habilidad1=new Habilidad("Acuchillada", -8, 0, 0,true);
        this.habilidad2=new Habilidad("Estallido Arcano", 10, 0, -10,true);
        this.habilidadEspecial=new Habilidad("Golpe Divino (Habilidad Especial)", -16, 0, 0,false);
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


