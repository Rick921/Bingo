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
public class ConsultaBingo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        Random rnd=new Random();
        
        int xogador;
        int cont=0;
        int num;
        boolean linea=false;
        
        /*Introducir num xogador*/
        System.out.println("Introduzca numero de jugadores");
        xogador=sc.nextInt();
        while(xogador>100){
            System.out.println("Introduzca de nuevo el numero de jugadores, "
                    + "no puede ser mayor a 100");
            xogador=sc.nextInt();
        }
        
        /*Crear array para cartones base xogador*/
        Carton [] XOGADORES= new Carton[xogador];
        
        /*Crear carton*/
        XOGADORES[0]= new Carton();
        
        /*Reyenar array con distintos cartones con ayuda de un aux*/
        while(cont<xogador){
            Carton aux=new Carton();
            XOGADORES[XOGADORES[0].numCarton()]=aux;
            XOGADORES[0].sumaCarton();
            cont++;
        }
        
        /*Bucle para mostrar cartones*/
        for(int i=0;i<xogador;i++){
            System.out.print("Este e o carton "+(i+1)+": ");
            System.out.println(" ");
            XOGADORES[i].MostrarCarton();
            System.out.println(" ");
        }
        
        /*Creamos un array para sacar bola*/
        int [] numeros =new int[100];
        System.out.println("Estas son las bolas: ");
        
        boolean ganador=false;
        int contbolas=0;
        
        while((contbolas<99)&&(ganador==false)){
            /*Sacar bola*/
            numeros[contbolas]=rnd.nextInt(99)+1;
                for(int j=0;j<contbolas;j++){
                    while(numeros[contbolas]==numeros[j]){
                        numeros[contbolas]=rnd.nextInt(99)+1;
                        j=0;
                    }
                }
                num=numeros[contbolas];
                System.out.println(" ");
                System.out.print("Bola: "+numeros[contbolas]+", ");
                System.out.println(" ");
                
                
                /*Bucle que marca el carton y comprueba ganador*/
                for(int i=0;i<xogador;i++){
                    XOGADORES[i].MarcarCarton(num);
                }
                
                int g=0;
                while((g<xogador)&&(ganador==false)){
                /*Comprobar linea*/
                 if (linea==false){
                     if(XOGADORES[g].LineaCarton1()||XOGADORES[g].LineaCarton2()||XOGADORES[g].LineaCarton3()){
                     System.out.println("Canta linea o xogador: " + (g+1));
                     linea=true;
                 }
                 }   
                 /*Comprobar ganador*/
                    if(XOGADORES[g].GanadorCarton()==true){
                        ganador=true;
                        System.out.println(" ");
                        System.out.println("Este es el carton ganador: "+(g+1));
                    }
                    XOGADORES[g].MostrarCarton();
                    System.out.println(" ");
                    g++;
                }
                contbolas++;
            }
        }   
    }