/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem;
import java.io.FileNotFoundException;
import java.io.IOException;
import spark.Request;
import spark.Response;
import static spark.Spark.*;


/**
 *
 * @author 2125509
 */
public class SparkWebApp {

    

    public static void main(String[] args) {
        port(getPort());
        get("/index", (req, res) -> index(req,res));
        get("/respuesta", (req, res) -> respuesta(req,res));
    }
 
    static int getPort() {
        if (System.getenv("PORT") != null) {
        return Integer.parseInt(System.getenv("PORT"));
    }
    return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
    
    
    private static String index(Request rq, Response rp){
        String pagina = "<!DOCTYPE html>\n" 
                + "<html>\n" 
                + "<body>\n"
                + "<h1>Calculadora de la media y desviacion estandar</h1>\n"
                + "<p>Dado un conjunto de n numeros, este programa calcula la desviacion y media del conjunto</p>\n"
                + "<p>Los numeros deben estar separados por comas</p>\n"
                + "<form>"
                + "Ingrese sus datos:<br>\n"
                + "<input type=\"text\" name=\"numeros\" placeholder=\"numeros\"><br>\n"
                + "<href type=\"submit\" value=\"Calcular\">\n"
                + "<a href=\"/respuesta\">Ver respuesta</a>"
                + "</form>\n"
                + "</body>\n" 
                + "</html>\n";
        String numbers = rq.queryParams("numeros");
        System.out.println("numbers");
        return pagina;
    }

    private static String respuesta(Request rq, Response rp){
        
        
        
        String pagina = "<!DOCTYPE html>\n" 
                + "<html>\n" 
                + "<body>\n"
                + "<h1>Resultados</h1>\n"
                + "<p>La media es: </p>\n" //+ media 
                + "<p>La desviacion estandar es: </p>\n" //+ desviacion
                + "</form>\n"
                + "</body>\n" 
                + "</html>\n";
       
        return pagina;
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
