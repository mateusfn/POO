package formas;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class ListaDeFormas {
    
    public static ArrayList<Forma> listaDeFormas = new ArrayList();
    
    public ArrayList<Forma> getListaDeFormas(){
        return listaDeFormas;
    }
    
    public void add(Forma f){
        listaDeFormas.add(f);
    }
    
    public void clear(){
        listaDeFormas.removeAll(listaDeFormas);
    }
    
    public void removeForma(int i){
        listaDeFormas.remove(i);
    }
    
    public void verFormas(){
        System.out.println(listaDeFormas);
    }
    
    public void salvarFormas(File f) {
        try {
            FileOutputStream arq = new FileOutputStream(f);
                ObjectOutputStream writer = new ObjectOutputStream(arq);
                for (Forma forma : listaDeFormas) {
                        writer.writeObject(forma);
                }
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
    
    public void carregarFormas(File f) {
        try {
            FileInputStream arq = new FileInputStream(f);
            ObjectInputStream reader = new ObjectInputStream(arq);
            while(true){
                Forma forma = (Forma) reader.readObject();
                listaDeFormas.add(forma);
            }
        }catch (EOFException e){

        } catch (IOException e) {
            // TODO Auto-generated catch block
            //ErrorPopUp openError = new OpenErrorPopUp();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
