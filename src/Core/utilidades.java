package Core;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * La clase sirve para tener todas las funciones de utilidad como imprimir por pantalla y leer de la consola
 */
public class utilidades {
	public static Scanner scanner =new Scanner(System.in);
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
					boolean lleno=false;
					//Hacer que divida la linea en multiples
					String lineaTemp="";
					for (String palabra:cadTemp.split(" ")) {
						if ((linea.length()+palabra.length()<80)&&(!lleno)) {
							linea+=palabra+" ";
						}else {
							lleno=true;
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
			utilidades.imprimir(mensaje);
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
    	utilidades.imprimir(mensaje);
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
}
