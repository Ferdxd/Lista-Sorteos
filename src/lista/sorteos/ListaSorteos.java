/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista.sorteos;


import BaseDatos.clsConexion;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author FERDY AGUSTIN
 */
public class ListaSorteos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        clsConexion cn =new clsConexion("bdtareaprogra","root","");
        List<String> Participantes= cn.Listar();
        Collections.shuffle(Participantes);
       
        int i=1;
        for(String p: Participantes)
        {
            if(i<=10){
            System.out.println(i+"-"+p);
            i++;
            }
        }
  
  
    }
    
}
