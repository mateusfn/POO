package formas;

import java.awt.Color;
import java.awt.Polygon;

/**
 *
 * @author usuario
 */
public abstract class Forma extends Polygon {
    private String nome;
    private Color cor;
    private int locationX, locationY;
    private int dimensaoX, dimensaoY;
    
    public Forma(String nome, Color cor, int locationX, int locationY, int dimensaoX, int dimensaoY){
        this.nome = nome;
        this.cor = cor;
        this.locationX = locationX;
        this.locationY = locationY;
        this.dimensaoX = dimensaoX;
        this.dimensaoY = dimensaoY;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public int getDimensaoX() {
        return dimensaoX;
    }

    public void setDimensaoX(int dimensaoX) {
        this.dimensaoX = dimensaoX;
    }

    public int getDimensaoY() {
        return dimensaoY;
    }

    public void setDimensaoY(int dimensaoY) {
        this.dimensaoY = dimensaoY;
    }

}