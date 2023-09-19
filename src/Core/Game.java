package Core;
import java.util.ArrayList;
import java.util.Random;
import Core.Clases.*;
import Core.Clases.Cartas.Item;
import Core.Clases.Heroes.*;
//import Core.utilidades;
//import java.util.concurrent.TimeUnit;

/**
 * @author Mauro Sorbello
 * @author Daniel Yacante
 * @author Joaquin Villegas
 * la clase Game es por asi decirlo la clase main, donde se va a ejecutar el juego.
 */
public class Game {
	private static boolean Fin=false;
	private static int nSala=1;
	private static int status;
	private static int nHeroes=5;
	private static int respAccion;
	private static int respObjetivo;
	private static int indice;
	private static String msg;
	private static ArrayList<Heroe> listaHeroesVivos= new ArrayList<Heroe>(nHeroes);
	public static Random intRandom=new Random();
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static void main(String[] args) {
		utilidades.imprimir("Disclaimer!!! en este juego se utilizan algunos caracteres ANSI especiales para darle color al texto\n"
				+ "Si ves bien esto es que no tendras problemas:"+ANSI_RED+"Rojo"+ANSI_RESET);
		utilidades.pressToContinue();
		System.out.println(ANSI_GREEN+" _____       _       _                                ______           __                              \r\n"
				+ "/  __ \\     | |     | |                               | ___ \\         / _|                             \r\n"
				+ "| /  \\/ __ _| | __ _| |__   ___ _______  ___   _   _  | |_/ / __ ___ | |_ ___  ___  ___  _ __ ___  ___ \r\n"
				+ "| |    / _` | |/ _` | '_ \\ / _ \\_  / _ \\/ __| | | | | |  __/ '__/ _ \\|  _/ _ \\/ __|/ _ \\| '__/ _ \\/ __|\r\n"
				+ "| \\__/\\ (_| | | (_| | |_) | (_) / / (_) \\__ \\ | |_| | | |  | | | (_) | ||  __/\\__ \\ (_) | | |  __/\\__ \\\r\n"
				+ " \\____/\\__,_|_|\\__,_|_.__/ \\___/___\\___/|___/  \\__, | \\_|  |_|  \\___/|_| \\___||___/\\___/|_|  \\___||___/\r\n"
				+ "                                                __/ |                                                  \r\n"
				+ "                                               |___/                                                   "
				+ ANSI_RESET);
        utilidades.imprimir("Existe la profecia de unos estudiantes que lograrian completar la carrera en 5 años, los profesores creian que esto era un absurdo, que nadie asi llegaria algun dia...\nHASTA ESTE DIA... TU ERES UNO.");
        utilidades.pressToContinue();
        utilidades.imprimir("\t\t\t\t\tMenu");
        //Menu de opciones:
        boolean salir=false;
        do {
			int valor = 0;
	        msg="Por favor, elija una opcion\n[1] JUGAR\n[2] COMO JUGAR\n[3] CREDITOS\n[4] SALIR\n";
	        //ut.imprimir(msg);
	        valor=utilidades.readConsoleInt(msg, 4);
	        switch(valor){
	            case 1:
	                opcion1();
	                break;
	            case 2:
	                opcion2();
	                //Para que empiece el menu de vuelta luego de la opcion 2 y 3, podria ser con esto?:
	                //respuesta = false;
	                break;
	            case 3: 
	                opcion3();
	                //respuesta = false;
	                break;
	            case 4: 
	                System.out.println("¡Gracias por jugar!");
	                salir=true;
	                break;
	            default:
	                System.out.println("El numero: "+ valor +" no es ninguna opcion, el juego se cerrara automaticamente.");
	                salir=true;
	                break;
	        }
        } while (!salir);
        
	}

    /**
     * La opcion 1, que es la de jugar. Se da la seleccion de personajes, y empieza el juego
     */
    public static void opcion1(){
    	//String respString;
    	int respInt;
    	Sala stage;
    	String nombre = utilidades.readConsoleString("Jugador, ¿cual es tu nombre?");
        utilidades.imprimir("Muy bien, "+nombre+". Elige tus 5 personajes que iran en el equipo:");
        do {
	        msg=String.format("Heroe %d/5\nRoles:\n"
	        		+ "[1]  Arquero\n"
	        		+ "[2]  Barbaro\n"
	        		+ "[3]  Bardo\n"
	        		+ "[4]  Brujo\n"
	        		+ "[5]  Clerigo\n"
	        		+ "[6]  Druida\n"
	        		+ "[7]  Mago\n"
	        		+ "[8]  Monje\n"
	        		+ "[9] Paladin\n"
	        		+ "[10] Rouge\n",listaHeroesVivos.size()+1);
	        int respuestaUsuario=utilidades.readConsoleInt(msg,11);
	        Heroe seleccionHeroe=crearHeroe(respuestaUsuario);
	        
	        //ut.imprimir stats
	        utilidades.imprimir(seleccionHeroe.getDescripcion());
	        //ut.imprimir("Clase: "+ seleccionHeroe.getClase()+"\n"+"Vida: "+ seleccionHeroe.getVidaMaxima());
	        //System.out.println("Ataque: "+ seleccionHeroe.get());
	        
	        respuestaUsuario=utilidades.readConsoleInt("¿Seleccionar?\n[1] Si \n[2] No",2);
	        if (respuestaUsuario==1) {
	        	seleccionHeroe.setNombre(utilidades.readConsoleString(String.format("Ingrese nombre para el %s",seleccionHeroe.getClase())));
	        	listaHeroesVivos.add(seleccionHeroe);
	        }
        } while (listaHeroesVivos.size()<5); //CAMBIO 5 POR 1 PARA PROBAR
        utilidades.imprimir("¡Los jugadores estan listos! comenzamos...");
        //Crea la lista de aliados
        for (Heroe heroe: listaHeroesVivos) {
	        for (Heroe aliado: listaHeroesVivos) {
				if (!heroe.getNombre().equals(aliado.getNombre())) {
					if(heroe.addAliado(aliado)==0) {
						System.out.println("Problema al añadir aliado");
					}
				}
			}
        }
        //Fin
        Item item;
        //Lucha
        do {
        	stage=crearSala(nSala);
        	utilidades.imprimir(stage.getDescription());
        	respInt=utilidades.readConsoleInt("¿Que decides hacer?\n[1] Investigar que es lo que brilla \n[2] Ir hacia la \"puerta\"",2);
        	if (respInt==1) {
        		item=stage.investigar();
        		respInt=utilidades.readConsoleInt("Deseas guardartelo?\n[1] Si \n[2] No", 2);
        		if (respInt==1) {
        			msg="Quien deberia llevarlo?\n";
        			for (int i=0;i<listaHeroesVivos.size();i++) {
        				msg+=String.format("[%d] - %s\n",i+1,listaHeroesVivos.get(i).getNombre());
        			}
        			respInt=utilidades.readConsoleInt(msg,listaHeroesVivos.size());
					item.setPortador(listaHeroesVivos.get(respInt-1));
					listaHeroesVivos.get(respInt-1).setCartaElegida(item);
					utilidades.imprimir(String.format("%s ahora lleva %s", listaHeroesVivos.get(respInt-1).getNombre(),listaHeroesVivos.get(respInt-1).getCartaElegida().getNombreCarta()));
        		}else {
        			utilidades.imprimir("Lo dejas donde estaba...");
        		}
        		
        		utilidades.imprimir(stage.getDescriptionEnemigos());
        	}
    		status=lucha(stage);
    		if ((status==-1) || (nSala==3)) {//maximo 3 salas
        		Fin=true;
        	}else {
        		nSala++;
        	}
        	
        } while (!Fin);
        //End Lucha
        if (status==-1) {
        	utilidades.imprimir("Nuestros queridos heroes no han podido pasar los finales mas dificiles de la carrera...lamentablemente tendran que recursar el año que viene.");
        	System.out.println(ANSI_RED+" _____  ___ ___  ________   _____ _   _ ___________ \r\n"
        			+ "|  __ \\/ _ \\|  \\/  |  ___| |  _  | | | |  ___| ___ \\\r\n"
        			+ "| |  \\/ /_\\ \\ .  . | |__   | | | | | | | |__ | |_/ /\r\n"
        			+ "| | __|  _  | |\\/| |  __|  | | | | | | |  __||    / \r\n"
        			+ "| |_\\ \\ | | | |  | | |___  \\ \\_/ | \\_/ / |___| |\\ \\ \r\n"
        			+ " \\____|_| |_|_|  |_|____/   \\___/ \\___/\\____/\\_| \\_|"+ANSI_RESET);
        }else {
        	utilidades.imprimir("Habiendo derrotado a los temibles profesores junto a la ayuda de tus compañeros has logrado avanzar en la carrera contra todo pronostico..."
        			+ "ve y sal a festejar con tus compañeros que te lo mereces crack!");
        	System.out.println(ANSI_GREEN+" _   _ _____ _____ _____ ___________ _____ ___      \r\n"
        			+ "| | | |_   _/  __ \\_   _|  _  | ___ \\_   _/ _ \\     \r\n"
        			+ "| | | | | | | /  \\/ | | | | | | |_/ / | |/ /_\\ \\    \r\n"
        			+ "| | | | | | | |     | | | | | |    /  | ||  _  |    \r\n"
        			+ "\\ \\_/ /_| |_| \\__/\\ | | \\ \\_/ / |\\ \\ _| || | | |    \r\n"
        			+ " \\___/ \\___/ \\____/ \\_/  \\___/\\_| \\_|\\___|_| |_/"+ANSI_RESET);
        }
    }

    /**
     * La opcion 2 del juego, una explicacion sobre como jugar
     */
    public static void opcion2(){
    	utilidades.imprimir("Te daremos una breve descripcion de como jugar el juego."
    			+ "El objetivo del juego es superar a los jefes que te iras encontrando hasta el final."
    			+ "Para ello se te dara a elegir 5 clases de personajes. Los cuales tendras que cuidar ya que si mueren"
    			+ "estaran moridos/muertos para siempre(hasta que reinicies :P)"
    			+ "Cada una de estas clases tienen distintos atributos de armadura, vida y mana, como asi tambien"
    			+ "distintas habilidades, asi que piensa bien antes de elegir."
    			+ "Para supera a los jefes y a sus esbirros tendras que luchar contra ellos en una batalla de baile...\n"
    			+ "ok no\n"
    			+ "Pero si tendras que derrotarlos, y para hacerte las cosas un poco mas faciles hay objetos que te daran algo bueno...a cambio de algo negativo"
    			+ "Cada vez que se realice un ataque, ya sea heroe o enemigo, se lanzara un dado d20 (dado de 20 caras) o icosaedro para los mas ñoños"
    			+ "de la geometria. Este dado sumado a un valor magico que tiene cada personaje tendra que superar o igualar la armadura del objetivo."
    			+ "Si se supera el golpe hara daño, sino no."
    			+ "Espero que se haya entendido y si quedan dudas...seguro se te van jugando que tampoco es tan complicado."
    			+ "Suerte y que lo disfrutes!!");
        utilidades.pressToContinue();
    }

    /**
     * La opcion 3, los creditos
     */
    public static void opcion3(){
        utilidades.imprimir("Hecho por:\n\n"
        		+ "*Mauro Sorbello*\n\n"
        		+ "*Daniel Yacante*\n\n"
        		+ "*Joaquin Villegas*\n\n"
        		+ "Para: Paradigmas");
        utilidades.pressToContinue();
    }

    /**
     * La logica de la lucha por turnos
     * @param sala recibe la sala en donde se encuentran
     * @return int -1 en el caso de que los Heroes hayan perdido, 1 si es que han ganado
     */
	public static int lucha(Sala sala) {
		String msg="Unos ";
		ArrayList<? extends Human> listaEnemigos= sala.getListaEnemigo();
		Human target = null;
		int contHeroes;
		int contEnemigos;
		Heroe heroe;
		for (Human enemigo:listaEnemigos) {
			msg=msg.concat(String.format("%s, ", enemigo.getNombre()));
		}
		msg=msg.concat("salvajes aparecen");
		utilidades.imprimir(msg);
		while ((listaHeroesVivos.size()!=0) && (listaEnemigos.size()!=0)){
			contHeroes=0;
			contEnemigos=0;	
			while(contHeroes<listaHeroesVivos.size()) {
				heroe=listaHeroesVivos.get(contHeroes);
				if (heroe.getCanUse() == false) {
					heroe.getRestriccion().setRestriccion(heroe);
					if (heroe.getCanUse() == false){
						heroe.aumentarTurno();
						contHeroes++;
						if (contHeroes>=listaHeroesVivos.size()) {
							contHeroes = 0;
						}
						if (listaHeroesVivos.size() == 1) break;
						heroe=listaHeroesVivos.get(contHeroes);
					}

				}
				if (!heroe.checkDead()) {
					msg=String.format("¿Que hara nuestro heroe %s?\n[1]- Atacar \n[2]- Usar Objeto", heroe.getNombre());
					respAccion=utilidades.readConsoleInt(msg, 2);
					if (respAccion==1){
						msg=String.format("¿Como quiere atacar?\n1-%s\n2-%s\n3-%s",heroe.getHabilidad1().getNombre(),heroe.getHabilidad2().getNombre(),heroe.getHabilidadEspecial().getNombre());
						respAccion=utilidades.readConsoleInt(msg, 3);
						respObjetivo=utilidades.readConsoleInt("¿A...\n1-\u001B[32mAliados\u001B[0m?\n2-\u001B[31mEnemigo\u001B[0m?",2);
						if (respObjetivo==1) {
							if (heroe.getAliados().size()!=0) {
								int cont=1;
								msg="Aliados:\n";
								for (Human aliado: heroe.getAliados()) {
									msg=msg.concat(String.format("[%d]- %s\n",cont ,aliado.getNombre()));
									cont++;
								}
								respObjetivo=utilidades.readConsoleInt(msg, heroe.getAliados().size());
								target=heroe.getAliados().get(respObjetivo-1);
							}else {
								utilidades.imprimir(String.format("Solamente queda %s...el destino de la carrera esta sobre sus hombros",heroe.getNombre()));
								continue;
							}
						}else {
							int cont=1;
							msg="Enemigos:\n";
							for (Human enemigo: listaEnemigos) {
								msg=msg.concat(String.format("[%d]- %s\n",cont ,enemigo.getNombre()));
								cont++;
							}
							respObjetivo=utilidades.readConsoleInt(msg, listaEnemigos.size());
							target=listaEnemigos.get(respObjetivo-1);
						}
						
						switch (respAccion) {
						case 1:
							System.out.println(String.format("El heroe %s uso %s contra %s", heroe.getNombre(),heroe.getHabilidad1().getNombre(),target.getNombre()));
							heroe.usarH1(target);
							break;
						case 2:
							System.out.println(String.format("El heroe %s uso %s contra %s", heroe.getNombre(),heroe.getHabilidad2().getNombre(),target.getNombre()));
							heroe.usarH2(target);
							break;
						case 3:
							//System.out.println(heroe.getuseEsp());
							heroe.getRestriccion().setRestriccion(heroe);
							if (heroe.getRestriccion().getValorRestriccion() == true) {
								utilidades.imprimir(String.format("El heroe usara %s, recordamos que %s", heroe.getHabilidadEspecial().getNombre(), heroe.getRestriccion().getDescripcionRes())+"\n"+String.format("El heroe %s uso %s contra %s", heroe.getNombre(),heroe.getHabilidadEspecial().getNombre(),target.getNombre()));
								heroe.usarEsp(target);
								break;
							}else
								System.out.println(String.format("El heroe %s no cumple con la condicion: %s", heroe.getNombre(),heroe.getRestriccion().getDescripcionRes()));
								continue;
						default:
							break;
						}
						if (target.checkDead()) {
							if (target.getTipo()=="Enemigo") {
								System.out.println(String.format("%s ha caido", target.getNombre()));
								listaEnemigos.remove(respObjetivo-1);
							}else {
								listaHeroesVivos.remove(respObjetivo-1);
							}
							if (listaEnemigos.size()==0)break;
						}else {
							System.out.println(String.format("La vida de %s es: %d", target.getNombre(),target.getVida()));
						}
					}else {
						if (heroe.getCartaElegida()!=null) {
							//System.out.println("Has usado el item, este tendra efecto en proximo turno");
							heroe.getCartaElegida().realizarEfecto();
						}else {
							System.out.println("No lleva nada para usar!!");
							//Forma de que no pierda el turno xD
							contHeroes--;
						}
					}
				}
				heroe.aumentarTurno();
				contHeroes++;
				}
				while(contEnemigos<listaEnemigos.size()) {
					if (listaEnemigos.size()!=0) {
						
					Human enemigo=listaEnemigos.get(contEnemigos);
					System.out.println(String.format("%s ataca!!", enemigo.getNombre()));
					// cAMBIE PARA PROBAR
					indice = 0;
					target=listaHeroesVivos.get(intRandom.nextInt(listaHeroesVivos.size()-1));
					//target=listaHeroesVivos.get(0);
					enemigo.usarH1(target);
					utilidades.pressToContinue();
					//Ponemos rondas hasta usar la especial?
					if (target.checkDead()) {
						System.out.println(String.format("%s ha caido", target.getNombre()));
						listaHeroesVivos.remove(indice);
						if (listaHeroesVivos.size() == 0) break;
					}else {
						System.out.println(String.format("La vida de %s es: %d", target.getNombre(),target.getVida()));
					}
					contEnemigos++;
					}else {
						break;
					}
				}
		} 
		if (listaHeroesVivos.size()==0) {
			return -1;
		} else {
			utilidades.imprimir("Has superado con exito a los enemigos de la sala...pero no hay tiempo que perder, tienes que apresurarte para el diploma... que por algo se llama carrera...vamos vamos!!");
			utilidades.pressToContinue();
			return 1;
		}
	}

    /**
     * la creacion de la sala
     * @param nSala el numero de la sala
     * @return Sala una nueva sala
     */
	public static Sala crearSala(int nSala) {
		Sala sala=new Sala(nSala);
		return sala;
	}

    /**
     * La logica para la creacion de heroes, de esta forma se pueden mostrar las stats y habilidades del heroe que haya elegido el usuario a traves del teclado
     * @param tipo la opcion que el usuario escogio
     * @return Heroe retorna al heroe para mostrarlo
     */
	public static Heroe crearHeroe(int tipo){
		Heroe H;
		switch (tipo) {
		case 1:
			H=new Arquero();
			break;
		case 2:
			H=new Barbaro();
			break;
		case 3:
			H=new Bardo();
			break;
		case 4:
			H=new Brujo();
			break;
		case 5:
			H=new Clerigo();
			break;
		case 6:
			H=new Druida();
			break;
		case 7:
			H=new Mago();
			break;
		case 8:
			H=new Monje();
			break;
		case 9:
			H=new Paladin();
			break;
		case 10:
			H=new Rogue();
			break;
		default:
			H=new Paladin();
			break;
		}
		return H;
	}
}
