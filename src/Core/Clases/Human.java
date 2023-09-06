package Core.Clases;

public abstract class Human {
    //Atributos
    protected String nombre="";
    
    
    //ACLARACION: Hay valores que les di por tirar una idea, luego los modificamos si queremos.
    //Tres tipos de vida
    //1. vidaBase que represente la vida que toma desde un inicio
    //2. vidaMaxima la vida que el personaje tenga como maxima por subir de nivel, usar items (cartas), etc.
    //3. vidaActual la que va a representar el estado del personaje (si malherido, si esta muerto, si esta sano, etc.).
    protected int vidaMaxima = 80;
    protected int vidaActual = 80;
    
    //Supongo que pasaria lo mismo con el mana
    protected int manaMaximo = 100;
    protected int manaActual = 100;
    
    //Daño de Ataque
    protected int modAtaquete = 0;
    
    //el nivel y la experiencia
    //Se podria desbloquear la habilidad especial a tal nivel, �o les permitimos el uso desde un inicio?
    //la barra de experiencia luego de completarse, automaticamente debe de volver a 0 (y sumarle lo que quedo restando).
    //realizar aumentos de la vida, del mana y la fuerza.
    //la experienciaRequerida se refiere a la cantidad que se necesita para subir al siguiente nivel.
    //Se podria realizar una funcion subirNivel() (que la llame en el momento que barraExperiencia >= experienciaRequerida) que pase como parametro el nivel actual, y adentro que haya un switch dependiendo del nivel. Se aumentan las stats ahi.
    protected int nivel = 1;
    protected int nivelMaximo = 10;
    protected int barraExperiencia = 0;
    protected int experienciaRequerida = 15;
    
    //�Esta muerto?
    //realizar una funcion que se deberia usar frecuentemente durante el combate (antes de cederle el turno al siguiente personaje) que revise la vidaActual de cada uno.
    // si vidaActual <= 0, de alguna forma "hacerlo invisible" para que no pueda realizar acciones. isDead darlo por true.
    protected boolean isDead = false;
    
    //Aliados
    //Pensaba que estaria bueno un array que nos muestre los aliados (maximo como 10 por el tema de que son 10 heroes). 
    //No se bien si se inicializa asi, pero por el momento para que darnos la idea.
    //Asi en los combates, supongamos el caso de que algun heroe tiene la habilidad especial de potenciar/curar a algun aliado suyo.
    //Y asi si hubiera uno de aliados, �habria que hacer uno de enemigos?
    protected String[] aliados = new String[10];
    
    //Objetos
    //Un almacenamiento de objetos (peque�o) para asi llevar la Carta, consumibles, etc.
    protected String[] objetos = new String[3];
    
    
    //Metodos
    public String getNombre() {
		return nombre;
	}
    public int getVida(){
        return this.vidaActual;
    }
    protected int getMana(){
        return this.manaActual;
    }
    protected int getNivel(){
        return this.nivel;
    }
    public boolean checkDead(){
        return this.isDead;
    }
    protected void recibirDmg(int dmg) {
    	System.out.println(String.format("%s ha recibido %s puntos de daño", this.nombre,dmg));
    	if ((this.vidaActual-dmg)<=0) {
    		this.vidaActual=0;
    		this.isDead=true;
    		System.out.println(String.format("%s ha muerto!!", this.nombre));
    	}else {
    		this.vidaActual-=dmg;
    	}
    };
    protected void curarse(int vida) {
    	if ((this.vidaActual+vida)>this.vidaMaxima) {
    		this.vidaActual=this.vidaMaxima;
    		System.out.println(String.format("%s esta al maximo vida", this.nombre));
    	}else {
    		this.vidaActual+=vida; 		
    		System.out.println(String.format("%s ha recuperado %s puntos de vida", this.nombre,vida));
    	}
    }
    protected void modificarAtaque(int mod) {
    	this.modAtaquete=mod;
    }
    
    //Durante o antes de un combate, el jugador deberia tener la opcion de usar algun consumible de los objetos que lleva.
    //Revisara cuales objetos son consumibles y los muestra por pantalla.
    protected void usarObjeto(){
    
    }
    
    protected void subirNivel(){
    
    }
    
    protected void recuperarMana(){
    
    }
}