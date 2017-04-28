package formas;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;
import visual.InputDialog;

/**
 *
 * @author mateusfn98
 */
public class DrawArea extends JComponent {

  private String desenho = "nenhum";
  private BufferedImage image;
  public static Graphics2D g2;
  private int pX, pY, eW, eH;

  InputDialog receber = new InputDialog();
  
  ArrayList<Forma> listaDeFormas = new ListaDeFormas().getListaDeFormas();
  
  Forma forma;
  
    public DrawArea() {
        setSize(3000, 3000);
        
        addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            pX = e.getX(); // Pega a posição
            pY = e.getY(); //   do mouse
                switch (desenho) {
                    case "circulo":
                        try{
                        eW = receber.inputDialog("raio");
                        g2.drawOval(pX-eW, pY-eW, 2*eW, 2*eW);
                        forma = new Circunferencia("Circunferencia", g2.getColor(), pX-eW, pY-eW, 2*eW, 2*eW);
                        } catch(NumberFormatException ex){
                            JOptionPane.showMessageDialog(null, "Digite apenas números inteiros", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case "retangulo":
                        try{
                        eW = receber.inputDialog("baseR");
                        eH = receber.inputDialog("alturaR");
                        //int [] xPointsR = {pX - (eW/2), pX + (eW/2), pX + (eW/2), pX - (eW/2)}, yPointsR = {pY + (eH/2), pY + (eH/2), pY - (eH/2), pY - (eH/2)};
                        //g2.drawPolygon(xPointsR, yPointsR, 4);
                        g2.drawRect(pX - (eW/2), pY - (eH/2), eW, eH);
                        forma = new Retangulo("Retangulo", g2.getColor(), pX - (eW/2), pY - (eH/2), eW, eH);
                        } catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Digite apenas números inteiros", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case "triangulo":
                        try{
                        eW = receber.inputDialog("baseT");
                        eH = receber.inputDialog("alturaT");
                        int [] xPointsT = {pX - (eW/2), pX + (eW/2), pX}, yPointsT = {pY + (eH/2), pY + (eH/2), pY - (eH/2)};
                        g2.drawPolygon(xPointsT, yPointsT, 3);
                        forma = new Triangulo("Triangulo", g2.getColor(), pX, pY, eW, eH);
                        } catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Digite apenas números inteiros", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    default:
                        //JOptionPane.showMessageDialog(null, "Escolha a forma a ser desenhada", "Nenhuma forma selecionada", JOptionPane.PLAIN_MESSAGE);
                        return;
                }
                listaDeFormas.add(forma);
            repaint();
        }
        });
    }

  @Override
  protected void paintComponent(Graphics g) {
    if (image == null) {
      image = (BufferedImage) createImage(getSize().width, getSize().height);
      g2 = (Graphics2D) image.getGraphics();
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      clear();
    }
    g.drawImage(image, 0, 0, null);
  }
  
  public void clear() {
    Color corAntes = g2.getColor();
    g2.setPaint(Color.white);
    g2.fillRect(0, 0, getSize().width, getSize().height);
    g2.setPaint(corAntes);
    repaint();
    listaDeFormas.clear();
  }

    ListaDeFormas lF = new ListaDeFormas();
    ArrayList<Forma> f = lF.getListaDeFormas();

  public void desenharLista(){
        for (Forma forma : f) {
            pX = forma.getLocationX();
            pY = forma.getLocationY();
            eW = forma.getDimensaoX();
            eH = forma.getDimensaoY();
            switch(forma.getNome()){
                case "Circunferencia":
                        g2.setColor(forma.getCor());
                        g2.drawOval(pX-eW, pY-eW, 2*eW, 2*eW);
                    break;
                case "Retangulo":
                        g2.setColor(forma.getCor());
                        g2.drawRect(pX - (eW/2), pY - (eH/2), eW, eH);
                    break;
                case "Triangulo":
                        g2.setColor(forma.getCor());
                        int [] xPointsT = {pX - (eW/2), pX + (eW/2), pX}, yPointsT = {pY + (eH/2), pY + (eH/2), pY - (eH/2)};
                        g2.drawPolygon(xPointsT, yPointsT, 3);
                    break;
            }
            repaint();
        }
  }
  
  public void setCor(Color c){
    g2.setPaint(c);
  }

  public void setDesenho(String desenho){
    this.desenho = desenho;
  }

  public Color getCorAtual(){
      return g2.getColor();
  }
  
  public void draw(Forma f){
    switch(f.getNome()){
        case "circunferencia":
            break;
        case "retangulo":
            break;
        case "triangulo":
            break;
      }
  }
  
}