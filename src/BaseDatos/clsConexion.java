/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author FERDY AGUSTIN
 */
public class clsConexion {
     private Connection conn=null;
    private String BaseDatos="";
    private String usuario="";
    private String clave="";
    
   
    
    public clsConexion(String db,String usr,String pwd)
    {
        BaseDatos=db;
        usuario=usr;
        clave=pwd;
        
        try{
    Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException e)
    {
        System.out.println("No se encontro el directorio");
    }
        
    }//fin del constructor
  
    
    
    
    
    private String abrirConexion()
    {
        try{
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + BaseDatos, usuario, clave);
            return "Ok";
        }catch(SQLException e){
            System.out.println("Error en la db");
            return e.getMessage();
        }
    }
    
    private String cerrarConexion()
    {
        try{
            conn.close();
            return "Ok";
        }
        catch(SQLException e){
            return "Error en la base de datos";
        }
    }
    

    
    public List<String> Listar()
    {
        List<String> nombres=new ArrayList<>();
        String Query="select * from tb_rifa ";
        abrirConexion();
      
        try
        {
              Statement st=conn.createStatement();
              ResultSet result=st.executeQuery(Query);
              while(result.next())
              {
                  nombres.add(result.getString("Nombre"));
              }
            
        }catch(SQLException e)
        {
            System.out.println("Error Al Conectar Con La BD");
        }finally
        {
            cerrarConexion();
        }
        return nombres;
        
    }
    
   
    
}
