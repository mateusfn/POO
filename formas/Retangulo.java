package formas;

import java.awt.Color;

/**
 *
 * @author mateusfn98
 */
public class Retangulo extends Forma {

    public Retangulo(String nome, Color cor, int locationX, int locationY, int dimensaoX, int dimensaoY) {
        super(nome, cor, locationX, locationY, dimensaoX, dimensaoY);
    }

    public String toString() {
        return "Retangulo";
    }
    
}
