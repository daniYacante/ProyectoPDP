package Core;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import Core.Clases.*;
import Core.Clases.Cartas.Item;
import Core.Clases.Heroes.*;
//import java.util.concurrent.TimeUnit;

/**
 * @author Mauro Sorbello
 * @author Daniel Yacante
 * @author Joaquin Villegas
 * la clase Game es por asi decirlo la clase main, donde se va a ejecutar el juego.
 */
public class Game {
	public static Scanner scanner =new Scanner(System.in);
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
		
		System.out.println(ANSI_GREEN+" _____       _       _                                ______           __                              \r\n"
				+ "/  __ \\     | |     | |                               | ___ \\         / _|                             \r\n"
				+ "| /  \\/ __ _| | __ _| |__   ___ _______  ___   _   _  | |_/ / __ ___ | |_ ___  ___  ___  _ __ ___  ___ \r\n"
				+ "| |    / _` | |/ _` | '_ \\ / _ \\_  / _ \\/ __| | | | | |  __/ '__/ _ \\|  _/ _ \\/ __|/ _ \\| '__/ _ \\/ __|\r\n"
				+ "| \\__/\\ (_| | | (_| | |_) | (_) / / (_) \\__ \\ | |_| | | |  | | | (_) | ||  __/\\__ \\ (_) | | |  __/\\__ \\\r\n"
				+ " \\____/\\__,_|_|\\__,_|_.__/ \\___/___\\___/|___/  \\__, | \\_|  |_|  \\___/|_| \\___||___/\\___/|_|  \\___||___/\r\n"
				+ "                                                __/ |                                                  \r\n"
				+ "                                               |___/                                                   "
				+ ANSI_RESET);
        imprimir("Existe la profecia de unos estudiantes que lograrian completar la carrera en 5 años, los profesores creian que esto era un absurdo, que nadie asi llegaria algun dia...\nHASTA ESTE DIA... TU ERES UNO.");
        pressToContinue();
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("                                           Menu                                                           ");
        System.out.println("----------------------------------------------------------------------------------------------------------");
//Menu de opciones:
        int valor = 0;
        msg="Por favor, elija una opcion\n[1] JUGAR\n[2] COMO JUGAR\n[3] CREDITOS\n[4] SALIR\n";
        //imprimir(msg);
        valor=readConsoleInt(msg, 4);
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
                break;
            default:
                System.out.println("El numero: "+ valor +" no es ninguna opcion, el juego se cerrara automaticamente.");
                break;
        }
        
	}

    /**
     * La opcion 1, que es la de jugar. Se da la seleccion de personajes, y empieza el juego
     */
    public static void opcion1(){
    	//String respString;
    	int respInt;
    	Sala stage;
    	String nombre = readConsoleString("Jugador, ¿cual es tu nombre?");
        imprimir("Muy bien, "+nombre+". Elige tus 5 personajes que iran en el equipo:");
        do {
	        msg="Roles:\n"
	        		+ "[1]  Arquero\n"
	        		+ "[2]  Barbaro\n"
	        		+ "[3]  Bardo\n"
	        		+ "[4]  Brujo\n"
	        		+ "[5]  Clerigo\n"
	        		+ "[6]  Druida\n"
	        		+ "[7]  Hechicero\n"
	        		+ "[8]  Mago\n"
	        		+ "[9]  Monje\n"
	        		+ "[10] Paladin\n"
	        		+ "[11] Rouge\n";
	        int respuestaUsuario=readConsoleInt(msg,11);
	        Heroe seleccionHeroe=crearHeroe(respuestaUsuario);
	        
	        //Imprimir stats
	        imprimir(seleccionHeroe.getDescripcion());
	        //imprimir("Clase: "+ seleccionHeroe.getClase()+"\n"+"Vida: "+ seleccionHeroe.getVidaMaxima());
	        //System.out.println("Ataque: "+ seleccionHeroe.get());
	        
	        respuestaUsuario=readConsoleInt("¿Seleccionar?\n[1] Si \n[2] No",2);
	        if (respuestaUsuario==1) {
	        	seleccionHeroe.setNombre(readConsoleString(String.format("Ingrese nombre para el %s",seleccionHeroe.getClase())));
	        	listaHeroesVivos.add(seleccionHeroe);
	        }
        } while (listaHeroesVivos.size()<5); //CAMBIO 5 POR 1 PARA PROBAR
        imprimir("¡Los jugadores estan listos! comenzamos...");
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
        	imprimir("Entras a una sala donde la luz escasea, sientes el olor a humedad en el aire, sobre una mesa ves"
        			+" algo que \u001B[33mbrilla\u001B[0m y hacia tu derecha ves lo que parece ser una puerta.");
        	respInt=readConsoleInt("¿Que decides hacer?\n[1] Investigar que es lo que brilla \n[2] Ir hacia la \"puerta\"",2);
        	if (respInt==1) {
        		item=stage.investigar();
        		respInt=readConsoleInt("Deseas guardartelo?\n[1] Si \n[2] No", 2);
        		if (respInt==1) {
        			msg="Quien deberia llevarlo?\n";
        			for (int i=0;i<listaHeroesVivos.size();i++) {
        				msg+=String.format("[%d] - %s\n",i+1,listaHeroesVivos.get(i).getNombre());
        			}
        			respInt=readConsoleInt(msg,listaHeroesVivos.size());
					item.setPortador(listaHeroesVivos.get(respInt-1));
					listaHeroesVivos.get(respInt-1).setCartaElegida(item);
					imprimir(String.format("%s ahora lleva %s", listaHeroesVivos.get(respInt-1).getNombre(),listaHeroesVivos.get(respInt-1).getCartaElegida().getNombreCarta()));
        		}else {
        			imprimir("Lo dejas donde estaba...");
        		}
        		
        		imprimir("Luego de ver que es lo que brillaba, te diriges hacia la puerta y...");
        	}
    		System.out.println("A luchaaaaar!!!!");
    		status=lucha(stage);
    		if ((status==-1) || (nSala==0)) {
        		Fin=true;
        	}else {
        		nSala++;
        	}
        	
        } while (!Fin);
        //End Lucha
        if (status==-1) {
        	imprimir("Nuestros queridos heroes no han podido pasar los finales mas dificiles de la carrera...lamentablemente tendran que recursar el año que viene.");
        	System.out.println(ANSI_RED+" _____  ___ ___  ________   _____ _   _ ___________ \r\n"
        			+ "|  __ \\/ _ \\|  \\/  |  ___| |  _  | | | |  ___| ___ \\\r\n"
        			+ "| |  \\/ /_\\ \\ .  . | |__   | | | | | | | |__ | |_/ /\r\n"
        			+ "| | __|  _  | |\\/| |  __|  | | | | | | |  __||    / \r\n"
        			+ "| |_\\ \\ | | | |  | | |___  \\ \\_/ | \\_/ / |___| |\\ \\ \r\n"
        			+ " \\____|_| |_|_|  |_|____/   \\___/ \\___/\\____/\\_| \\_|"+ANSI_RESET);
        }else {
        	imprimir("Habiendo derrotado a los temibles profesores junto a la ayuda de tus compañeros has logrado avanzar en la carrera contra todo pronostico..."
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
        //Mejorar el texto de explicacion, esto nada mas se hizo para ver como luce.
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Este es un manual de como jugar Calabozos y Profesores.");
        System.out.println("Como has podido ver en el menu para acceder aca, es un videojuego con el que interactua con el usuario a traves de preguntas y respuestas tomadas por teclado");
        System.out.println("Calabozos y Profesores es un videojuego de solo un jugador o multijugador (hasta 4 maximo)");
        System.out.println("Te adentraras a un mundo donde los profesores haran de tu vida una desgracia para que no te recibas en 5 a�os");
        System.out.println("Pero yo confio en ti jugador, �Suerte!");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Presione alguna tecla para volver al menu.");
        pressToContinue();
    }

    /**
     * La opcion 3, los creditos
     */
    public static void opcion3(){
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Hecho por: ");
        System.out.println("");
        System.out.println("?Mauro Sorbello?");
        System.out.println("");
        System.out.println("?Daniel Yacante?");
        System.out.println("");
        System.out.println("?Joaquin Villegas?");
        System.out.println("");
        System.out.println("Para: Paradigmas");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Presione alguna tecla para volver al menu.");
        pressToContinue();
    }

    /**
     * La logica de la lucha por turnos
     * @param sala recibe la sala en donde se encuentran
     * @return int -1 en el caso de que los Heroes hayan perdido, 1 si es que han ganado
     */
	public static int lucha(Sala sala) {
		String msg="";
		ArrayList<? extends Human> listaEnemigos= sala.getListaEnemigo();
		Human target = null;
		int contHeroes;
		int contEnemigos;
		Heroe heroe;
		do {
			contHeroes=0;
			contEnemigos=0;	
			do {
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
					respAccion=readConsoleInt(msg, 2);
					if (respAccion==1){
						msg=String.format("¿Como quiere atacar?\n1-%s\n2-%s\n3-%s",heroe.getHabilidad1().getNombre(),heroe.getHabilidad2().getNombre(),heroe.getHabilidadEspecial().getNombre());
						respAccion=readConsoleInt(msg, 3);
						respObjetivo=readConsoleInt("¿A...\n1-\u001B[32mAliados\u001B[0m?\n2-\u001B[31mEnemigo\u001B[0m?",2);
						if (respObjetivo==1) {
							if (heroe.getAliados().size()!=0) {
								int cont=1;
								msg="Aliados:\n";
								for (Human aliado: heroe.getAliados()) {
									msg=msg.concat(String.format("[%d]- %s\n",cont ,aliado.getNombre()));
									cont++;
								}
								respObjetivo=readConsoleInt(msg, heroe.getAliados().size());
								target=heroe.getAliados().get(respObjetivo-1);
							}else {
								imprimir(String.format("Solamente queda %s...el destino de la carrera esta sobre sus hombros",heroe.getNombre()));
								continue;
							}
						}else {
							int cont=1;
							msg="Enemigos:\n";
							for (Human enemigo: listaEnemigos) {
								msg=msg.concat(String.format("[%d]- %s\n",cont ,enemigo.getNombre()));
								cont++;
							}
							respObjetivo=readConsoleInt(msg, listaEnemigos.size());
							target=listaEnemigos.get(respObjetivo-1);
						}
						if (respAccion == 3) {
							//System.out.println(heroe.getuseEsp());
							heroe.getRestriccion().setRestriccion(heroe);
							if (heroe.getRestriccion().getValorRestriccion() == true) {
								System.out.println(String.format("El heroes usara %s, recordamos que %s", heroe.getHabilidadEspecial().getNombre(), heroe.getRestriccion().getDescripcionRes()));
								System.out.println(String.format("El heroe %s uso %s contra %s", heroe.getNombre(),heroe.getHabilidadEspecial().getNombre(),target.getNombre()));
								heroe.usarEsp(target);
								break;
							}else
								System.out.println(String.format("El heroe %s no cumple con la condicion: %s", heroe.getNombre(),heroe.getRestriccion().getDescripcionRes()));
								msg=String.format("¿Como quiere atacar?\n1-%s\n2-%s",heroe.getHabilidad1().getNombre(),heroe.getHabilidad2().getNombre());
								respAccion=readConsoleInt(msg, 2);
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
						default:
							break;
						}
						if (target.checkDead()) {
							System.out.println(String.format("%s ha caido", target.getNombre()));
							listaEnemigos.remove(respObjetivo-1);
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
				}while(contHeroes<listaHeroesVivos.size());
				do {
					Human enemigo=listaEnemigos.get(contEnemigos);
					System.out.println(String.format("%s ataca!!", enemigo.getNombre()));
					// cAMBIE PARA PROBAR
					indice = 0;
					target=listaHeroesVivos.get(intRandom.nextInt(listaHeroesVivos.size()-1));
					//target=listaHeroesVivos.get(0);
					enemigo.usarH1(target);
					if (target.checkDead()) {
							System.out.println(String.format("%s ha caido", target.getNombre()));
							listaHeroesVivos.remove(indice);
							if (listaHeroesVivos.size() == 0) break;
						}else {
							System.out.println(String.format("La vida de %s es: %d", target.getNombre(),target.getVida()));
						}
					contEnemigos++;
				}while(contEnemigos<listaEnemigos.size());
		} while ((listaHeroesVivos.size()!=0) && (listaEnemigos.size()!=0));
		if (listaHeroesVivos.size()==0) {
			return -1;
		} else {
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

    public static void cleanConsole(){
        System.out.println("\n\n\n\n\n");
    }

    /**
     * La logica de la interaccion del usuario a traves del teclado
     * @param mensaje el mensaje que se muestra en juego, el contexto de lo que esta pasando
     * @param maxOpciones el numero maximo de opciones que tiene el usuario para elegir
     * @return int la opcion que el usuario elige
     */
    public static int readConsoleInt(String mensaje,int maxOpciones) {
		int input=-1;
		do {
			//System.out.println(mensaje);
			imprimir(mensaje);
			System.out.print("\t");
			try {
				input=Integer.parseInt(scanner.next());
				scanner.nextLine();
			} catch (Exception e) {
				input=-1;
//				e.printStackTrace();
				System.out.println("Opcion no valida");
			}
		} while (input<1 || input>maxOpciones);
		return input;
		
	}

    /**
     * La logica de la interaccion del usuario a traves del teclado
     * @param mensaje el mensaje que se muestra en juego, el contexto de lo que esta pasando
     * @return String la cadena de caracteres que da el usuario a traves del teclado (nombres por ejemplo)
     */
    public static String readConsoleString(String mensaje) {
    	String input;
    	boolean leido=false;
    	//System.out.println(mensaje);
    	imprimir(mensaje);
    	do {
			try {
				input=scanner.nextLine();
				leido=true;
			} catch (Exception e) {
				input="";
				System.out.println("Entrada no tomada");
				//pressToContinue();
			}
    	}while (!leido);
    	return input;
    }

    /**
     * La logica para que el usuario siga avanzando a traves del teclado
     */
	public static void pressToContinue() {
		System.out.println("Presione enter para continuar");
		scanner.nextLine();
//		try {
//			System.in.read();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
			H=new Hechicero();
			break;
		case 8:
			H=new Mago();
			break;
		case 9:
			H=new Monje();
			break;
		case 10:
			H=new Paladin();
			break;
		case 11:
			H=new Rogue();
			break;
		default:
			H=new Paladin();
			break;
		}
		return H;
	}

    /**
     * Logica para la impresion de texto en cuadrados
     * @param mensaje el mensaje que se quiere mostrar
     */
	public static void imprimir(String mensaje) {
		int maxHorizontal=100;
		//int maxVertical=10;
		String format = "|\t%-91s|";
		mensaje=mensaje.replaceAll("\t", "       ");
		
		String[] mensj=mensaje.split("\n");
		int iMensj=0;
		ArrayList<String> pantalla= new ArrayList<String>();
		ArrayList<String> lineas = new ArrayList<String>();
		for(String cadenas:mensj) {
			lineas.add(cadenas);
		}
		String linea;
		String cadTemp;
		for (int j=0; j<lineas.size()+2;j++) {
			linea="";
			if(j==0 || j==lineas.size()+1) {
				for(int i=0;i<maxHorizontal;i++) {
					if (i==0 || i==maxHorizontal-1) {
						linea+="+";
					}else{
						linea+="~";
					}
				}
			}else {
				cadTemp=lineas.get(iMensj);
				if (cadTemp.length()<80) {
					linea=String.format(format,cadTemp );
					iMensj++;
				}else {
					//Hacer que divida la linea en multiples
					String lineaTemp="";
					for (String palabra:cadTemp.split(" ")) {
						if (linea.length()+palabra.length()<80) {
							linea+=palabra+" ";
						}else {
							lineaTemp+=palabra+" ";
						}
					}
					linea=String.format(format, linea);
					lineas.add(iMensj+1,lineaTemp);
					iMensj++;
					//System.out.println(lineaTemp.getClass());
				}
			}
			
			pantalla.add(linea);
		}
		for (String line:pantalla) {
			System.out.println(line);
		}
	}
}
