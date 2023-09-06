package Core.Clases;

public class Esbirro extends Human {
	private Rol clase;
	public Esbirro(String nombre,int tipo) {
		this.nombre=nombre;
		this.clase=new Rol(tipo);
		switch (tipo) {
		case 8: //Ayudante
			super.vidaActual = 30;
			break;
		case 2: //Celador
			super.vidaActual = 20;
			break;
        }
    }
    public Rol getClase() {
		return clase;
	}
	public void usarH1(Human objetivo){
		this.clase.getHabilidad1().usar(objetivo,this.modAtaquete);
	}
}

