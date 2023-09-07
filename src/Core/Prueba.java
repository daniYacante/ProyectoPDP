package Core;
import Core.Clases.*;
public class Prueba {
    public static void main(String[] args) {
        lucha();
    }
    public static void lucha() {
		Paladin Juan = new Paladin("Yo");
        Jefe1 Malo = new Jefe1("Malo");
        System.out.println(Juan.getClase());
        System.out.println(Juan.getHabilidad1());
        System.out.println("Estado del enemigo");
		System.out.println(Malo.getVida());
		System.out.println(String.format("El heroe va a atacar al enemigo con %s",Juan.getHabilidad1().getNombre()));
		Juan.usarH1(Malo);
		System.out.println("Estado del enemigo");
		System.out.println(Malo.getVida());
        System.out.println("Estado del Heroe");
		System.out.println(Juan.getVida());
		System.out.println(String.format("El enemigo va a atacar al heroe con %s",Malo.getHabilidad1().getNombre()));
		Malo.usarH1(Juan);
		System.out.println("Estado del Heroe");
		System.out.println(Juan.getVida());
	}
}

