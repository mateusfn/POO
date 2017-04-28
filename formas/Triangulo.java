package formas;

import java.awt.Color;

/**
 *
 * @author mateusfn98
 */
public class Triangulo extends Forma {
    private int[] xPoints, yPoints;
    private int i;

    public Triangulo(String nome, Color cor, int locationX, int locationY, int dimensaoX, int dimensaoY) {
        super(nome, cor, locationX, locationY, dimensaoX, dimensaoY);
        int[] apoioX = {locationX - (dimensaoX/2), locationX + (dimensaoX/2), locationX};
        this.xPoints = apoioX;
        int[] apoioY = {locationY + (dimensaoY/2), locationY + (dimensaoY/2), locationY - (dimensaoY/2)};
        this.yPoints = apoioY;
    }

    
    
    public String toString() {
        return "Triangulo";
    }
    
}
