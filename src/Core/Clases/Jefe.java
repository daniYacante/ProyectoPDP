package Core.Clases;

public class Jefe extends Human {
    //Declare como string hasta que tengamos la clase esbirro
    private Rol clase;
    protected String[] esbirros = new String[10];

    //Herede todos los atributos de la clase humanos que debemos inicializar para cada Jefe
    //Contructor de la clase
    public Jefe(String nombre, int tipo) {
        super.nombre = nombre;
        this.clase = new Rol(tipo);
        switch (tipo) {
            case 5: //3er Jefe
                super.vidaActual = 120;
                break;
            case 6: //2do Jefe
                super.vidaActual = 200;
                break;
            case 7: //3er Jefe
                super.vidaActual = 300;
                break;
            default:
                break;
        }
    }

    //METODO

    public Rol getClase() {
        return clase;
    }
    public void usarH1(Human objetivo){
        this.clase.getHabilidad1().usar(objetivo,this.modAtaquete);
        //this.manaActual-=this.clase.getHabilidad1().getEfectoManaLanzador();
    }

    public void usarEsp(Human objetivo) {
        this.clase.getHabilidadEspecial().usar(objetivo,0);
        //this.manaActual-=this.clase.getHabilidadEspecial().getEfectoManaLanzador();
    }
}
