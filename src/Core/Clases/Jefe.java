package Core.Clases;

public class Jefe extends Human {
    //Declare como string hasta que tengamos la clase esbirro
    protected String[] esbirros = new String[10];
    protected String habilidadEspecial = "";
    //Al ser una sola habilidad basica la puse como string
    protected String habilidadBasica = ""; 

    //Herede todos los atributos de la clase humanos que debemos inicializar para cada Jefe
    //Contructor de la clase
    public Jefe(String nombre, int vidaBase, int vidaMaxima, int danoAtaqueBase, int nivel, boolean isDead){
        super.nombre = nombre;
        super.vidaBase = vidaBase;
        //super.vidaActual = vidaActual;
        super.vidaMaxima = vidaMaxima;
        super.danoAtaqueBase = danoAtaqueBase;
        super.nivel = nivel;
        super.isDead = isDead;
    //Los atributos heredados comentados, son utilizados por los metodos, por eso no hace falta inicializarlos, y si los inicializamos tendrian que ser con los valores maximos.
    }    

    //METODO
    //Por ahora van a devolver el nombre de la habilidad
    protected String usarHabilidadBasica(){ 
        return this.habilidadBasica;
    }
    protected String usarHabilidadEspecial(){
        return this.habilidadEspecial;
    }

    //Heredamos los metodos
    protected int getVida(){
        super.getVida();
    }
    protected int getNivel(){
        super.getNivel();
    }
    protected boolean checkDead(){
        super.checkDead();
    }
    protected void recibirDano() {
    	super.recibirDano();
    };

    protected void atacarObjetivo(){
        super.atacarObjetivo();
    }
}
