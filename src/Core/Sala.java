package Core;
import Core.Clases.*;
import java.util.ArrayList;

public class Sala {
	private ArrayList<Jefe> listaEnemigos= new ArrayList<Jefe>(3);
	public Sala(int nivelDeSala) {
		for (int i=0;i<3;i++) {
			listaEnemigos.add(new Jefe(String.format("Profe %d", i),i));
		}
	}
	public ArrayList<Jefe> getListaEnemigo() {
		return this.listaEnemigos;
	}
}
