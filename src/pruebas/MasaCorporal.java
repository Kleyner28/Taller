/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class MasaCorporal {

    public MasaCorporal(double a , double b , String c) {
        
        this.peso=a;
        this.altura=b;
        this.mes=c;
        
    }
    
    public MasaCorporal(){
    
    }
    
    private String mes;
    private double altura;
    private double peso;
    private double imc;
    private String descp;

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }        

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }
    
    //Method for calculate Muscle mass index (IMC)
    public double calculateIMC(){
        
        try{
    
        imc=this.getPeso()/(this.getAltura()*this.getAltura());
                
        }catch(Exception e){
        
        }
        
        return imc;
    }
    
    //Method for sort Muscle mass index (IMC)
    public String descriptionIMC(){            
        
        if (imc<18.5) {
            
            descp="Su estado actual es Insuficiencia ponderal";
                        
        }else if(imc>=18.5 && imc<=24.9 ){
        
            descp="Su estado actual es Normal";
            
        }else if(imc==25.0){
        
            descp="Su estado atual es Sobrepeso";
        
        }else if(imc>25.0 && imc<=29.9){
        
            descp="Su estado actual es Preobesidad";
        
        }else if(imc==30.0){
        
            descp="Su estado actual es Obesidad";
        
        }else if(imc>30.0 && imc<=34.9){
        
            descp="Su estado actual es Obesidad clase I";
        
        }else if(imc>=35.0 && imc<=39.9){
        
            descp="Su estado actual es Obesidad clase II";
        
        }else if(imc>=40.0){
        
            descp="Su estado actual es Obesidad clase III";
    
        }else{
        
            JOptionPane.showMessageDialog(null,"Datos erroneos, por favor "
                    + "ingresar datos validos","HOSPITAL GENERAL",
                    JOptionPane.WARNING_MESSAGE);
            
        }
        
        return descp;
    
    }

}
