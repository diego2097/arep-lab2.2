package edu.escuelaing.arem;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
     public static LinkedList<Double> calculo(String numeros)throws FileNotFoundException, IOException{  
        String[] list = numeros.split(",");
        
        float suma=0;
        LinkedList<Double> lista = new LinkedList<>();
        for (int i=0; i<list.length;i++){ 
            Double number = Double.parseDouble(list[i]);
            lista.add(number);
            suma+=number;
        }	
        double media=suma/list.length;
        double numerador=0;
        
        for (int i=0; i<lista.size();i++){
            numerador+=Math.pow(lista.get(i)-media,2);
        }
        
        double desv=Math.sqrt(numerador/(lista.size()-1));
        LinkedList<Double> rta  = new LinkedList<>();
        rta.add(media);
        rta.add(desv);
        return rta; 
    }
}
