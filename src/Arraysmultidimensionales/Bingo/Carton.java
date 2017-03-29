/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arraysmultidimensionales.Bingo;

/**
 *
 * @author dam111
 */
import java.util.*;

public class Carton {
    
    private int [] carton=new int[15];
    static int contcarton;
    
    /*Constructor que crea el carton*/
    public Carton(){
        Random rnd=new Random();
        for(int i=0;i<15;i++){
            this.carton[i]=rnd.nextInt(99)+1;
                for(int j=0;j<i;j++){
                    while(this.carton[i]==this.carton[j]){
                        this.carton[i]=rnd.nextInt(99)+1;
                        j=0;
                    }
                }
        }
    }
    
    /*Metodo para Mostrar el carton*/
    public void MostrarCarton(){
        for(int i=0;i<15;i++){
            System.out.print(this.carton[i]+", ");
            if((i==4)||(i==9)){
                System.out.println(" ");
            }
        }
         System.out.println(" ");
    }
    
    /*Metodo para marcar el carton*/
    public void MarcarCarton(int num){
        for(int i=0;i<15;i++){
            if(this.carton[i]==num){
            this.carton[i]=0;
            }
        }
    }
     /*Metodo para buscar linea*/
    public boolean LineaCarton1(){
        boolean winlin=false;
        int cont=0;
            for(int j=0;j<5;j++){
                if(this.carton[j]==0){
                   cont++;
                }
            }
            if(cont==5){
                winlin=true;
            }
            else{
                winlin=false;
            }
            return winlin;
        }
     public boolean LineaCarton2(){
        boolean winlin=false;
        int cont=0;
            for(int j=5;j<10;j++){
                if(this.carton[j]==0){
                    cont++;
                }
            }
            if(cont==5){
                winlin=true;
            }
            else{
                winlin=false;
            }
            return winlin;
        }
      public boolean LineaCarton3(){
        boolean winlin=false;
        int cont=0;
            for(int j=10;j<15;j++){
                if(this.carton[j]==0){
                    cont++;
                }
            }
            if(cont==5){
                winlin=true;
            }
            else{
                winlin=false;
            }
            return winlin;
        }
    
    /*Metodo para buscar ganador*/
    public boolean GanadorCarton(){
        boolean win=true;
        int i=0;
        while(i<15){
            if(this.carton[i]!=0){
                win=false;
            }
            i++;
        }
        return win;
    }
    

    public void sumaCarton(){
        contcarton++;
}

public int numCarton(){
    return contcarton;
}
}