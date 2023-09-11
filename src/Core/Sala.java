package Core;
import Core.Clases.Jefes.*;
import Core.Clases.Cartas.*;
import java.util.ArrayList;
import java.util.Random;

public class Sala {
	private ArrayList<Jefe> listaEnemigos= new ArrayList<Jefe>(3);
	private Carta objeto;
	public Sala(int nivelDeSala) {
		for (int i=0;i<3;i++) {
			listaEnemigos.add(new Jefe1(String.format("Profe %d", i)));
		}
		Random rn =new Random();
		//50% de chances de que en la sala haya un objeto
		int prob=rn.nextInt(1);
		if (prob==1) {
			this.objeto=new Carta();
		}
	}
	public ArrayList<Jefe> getListaEnemigo() {
		return this.listaEnemigos;
	}
	public Carta getObjeto() {
		return objeto;
	}
}
