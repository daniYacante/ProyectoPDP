package Core.Clases.Heroes;
import Core.Game;
import Core.Clases.Habilidad;

public class Barbaro extends Heroe {
    public Barbaro(){
        super.turnoAnt = 0;
        super.tipo = "Heroe";
        super.armadura=14;
        super.vidaActual = 14;
        super.vidaMaxima = 14;
        //No tiene magia
        super.manaActual = 0;
        super.manaMaximo = 0;
        this.clase="Barbaro";
        this.descripcion="Guerrero feroz de origen primitivo que puede entrar en furor al luchar";
        this.habilidad1=new Habilidad("Hachazo", -8, 0, 0);
        this.habilidad2=new Habilidad("Lanzar Jabalina", 10, 0, -10);
        this.habilidadEspecial=new Habilidad("Furor (Habilidad Especial)", -16, 0, 0);
        this.descripcionRes = "Puedes utilizar Furor cada 3 turnos";
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


