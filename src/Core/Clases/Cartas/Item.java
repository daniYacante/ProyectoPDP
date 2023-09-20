package Core.Clases.Cartas;

import Core.Clases.Heroes.Heroe;

public interface Item {
    String getNombreCarta();
    void realizarEfecto();

    String imprimirDescripcion();

    void setPortador(Heroe portador);
}
