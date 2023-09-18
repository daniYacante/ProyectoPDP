package Core.Clases.Heroes;
import Core.Game;
import Core.Clases.Habilidad;
import Core.Clases.Restricciones.RestriccionDosTurnos;

public class Hechicero extends Core.Clases.Heroes.Heroe {
    public Hechicero(){
        super.turnoAnt = 0;
        super.tipo = "Heroe";
        super.armadura=13;
        super.vidaActual = 10;
        super.vidaMaxima = 10;
        super.manaActual = 100;
        super.manaMaximo = 180;
        this.clase="Hechicero";
        this.descripcion="Ser con magia obtenida por un contrato con una entidad extraplanar";
        this.habilidad1=new Habilidad("Acuchillada", -8, 0, 0,true);
        this.habilidad2=new Habilidad("Estallido Arcano", 10, 0, -10,true);
        this.habilidadEspecial=new Habilidad("Golpe Divino", -16, 0, 0,false);
        this.restriccion = new RestriccionDosTurnos();
        this.restriccion.setDescriRes(this.habilidadEspecial);
    }
    //Usar habilidad Especial despues de tres turnos
    public static void getStats() {
    	Game.imprimir("");
    }
}


