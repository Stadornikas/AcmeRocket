/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;
/**
 *
 * @author root
 */
public class Propriedades {

   public static Properties getProp() {
       Properties props = null;
       try{
            props = new Properties();
            FileInputStream file = new FileInputStream("src/config/database.properties");
            props.load(file);
	
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Falha ao buscar configurações \n Erro:"+ex.getMessage());
        }
        return props;
     }
    
}
