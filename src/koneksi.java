
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joni
 */
import java.sql.Connection;
import java.sql.DriverManager;
public class koneksi {
     public Connection bukaKoneksi(){
        Connection kon=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            kon=(Connection)DriverManager.getConnection("jdbc:mysql://localhost/java2db","root","");
            System.out.println("Berhasil");
            return kon;
        }
        catch (Exception e){
            System.out.println("Gagal");
            return null;
        }
    }
    public static void main(String args[]){
        new koneksi().bukaKoneksi();
    }

    
    
}
