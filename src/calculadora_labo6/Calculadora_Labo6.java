/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora_labo6;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author David Massana
 */
public class Calculadora_Labo6 {

    static Scanner key = new Scanner(System.in);
    static int resultado = 0;
    static double res = 0;
    static int num1, num2;
    static int opc;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean flag = true;
        while(flag){
                try{
                    menuCalc();
                    opc = key.nextInt(); 
                        switch(opc){
                            case 0:
                                capturar();
                            break;
                            case 1: 
                                System.out.println("\nRESULTADO DE LA SUMA: " + suma(num1, num2));
                            break;
                            case 2: 
                                System.out.println("\nRESULTADO DE LA RESTA: " + resta(num1, num2));
                            break;
                            case 3: 
                                System.out.println("\nRESULTADO DE LA MULTIPLICACION: " + multiplicar(num1, num2));
                            break;
                            case 4: 
                                System.out.println("\nRESULTADO DE LA DIVISION: " + Math.rint((division(num1, num2))*100)/100);
                            break;
                            case 5: 
                                System.out.println("\nRAIZ CUADRADA DEL PRIMER NUMERO: " + Math.rint((raizNum1(num1))*100)/100);
                                System.out.println("RAIZ CUADRADA DEL SEGUNDO NUMERO: " + Math.rint((raizNum2(num2))*100)/100);
                            break;
                            case 6:
                                System.out.print("\nINGRESE EL EXPONENTE A ELEVAR: ");
                                double exp = key.nextDouble();
                                System.out.println("\nEXPONENCIAL DE " + num1 + ": " + expNum1(num1, exp));
                                System.out.println("EXPONENCIAL DE " + num2 + ": " + expNum2(num2, exp));
                            break;
                            case 7:
                                System.out.println("\nSALIENDO...");
                                flag = false;
                            break;
                            default: 
                            System.out.println("\nINGRESE OPCION VALIDA.");
                            break;
                        }
                }catch(InputMismatchException e){
                    System.out.println("Error " + e.toString());
                    key.nextLine();
                }
        }
    }
    
    static void capturar(){
        boolean flag = true;
        
        while(flag){
            try{
                System.out.println("\nDEBE INGRESAR UN NUMERO ENTRE -999 Y 1000");
                System.out.print("INGRESE PRIMER NUMERO A EVALUAR: ");
                num1 = key.nextInt();
                if (num1 >= -999 && num1 < 1000) {
                    flag = false;
                }
            }catch(InputMismatchException e){
                key.nextLine();
                num1 = 0;
                System.out.println("DEBE INGRESAR UN NUMERO VALIDO. " + e.toString() + "\n");
                flag = true;
                }
        }
        
        flag = true;
        
        while(flag){
            try{
                System.out.print("\nINGRESE SEGUNDO NUMERO A EVALUAR: ");
                num2 = key.nextInt();
                if (num2 >= -999 && num2 < 1000) {
                    flag = false;
                }
            } catch(InputMismatchException e) {
                key.nextLine();
                num2 = 0;
                System.out.println("DEBE INGRESAR UN NUMERO VALIDO. " + e.toString());
                flag = true;
            }
        }
    }
    
    static void menuCalc(){
        System.out.println("\nQUE ACCION DESEA REALIZAR: ");
        System.out.println("0. INGRESAR NUMEROS.");
        System.out.println("1. SUMA");
        System.out.println("2. RESTA");
        System.out.println("3. MULTIPLICACION");
        System.out.println("4. DIVISION");
        System.out.println("5. RAIZ CUADRADA.");
        System.out.println("6. EXPONECIAL");
        System.out.println("7. SALIR.");
        System.out.print("INGRESE OPCION: ");
    }
    
    static int suma(int n1, int n2){
        resultado = (n1 + n2);
        return resultado;
    }
    
    static int resta(int n1, int n2){
        resultado = n1 - n2;
        return resultado;
    }
    
    static int multiplicar(int n1, int n2){
        resultado = n1 * n2;
        return resultado;
    }
    static double division(double n1, double n2){
        try{
            res = (double)(n1/n2);
        }catch(ArithmeticException a){
            System.out.println("NO SE PUEDE DIVIDIR ENTRE 0 " + a.toString());
            System.out.println("INGRESE OTROS NUMEROS.\n");
        }
        return res;
    }
    
    static double raizNum1(double n1){
        double raiz1 = 0;
        try{
            raiz1 = (double)Math.sqrt(n1);
        }catch(ArithmeticException e){
            System.out.println("NO EXISTE LA RAIZ DE NEGATIVOS " + e.toString());
        }
        return raiz1;
    }
    
    static double raizNum2(double n2){   
        return (double)Math.sqrt(n2); 
    }
    
    static double expNum1(double n1, double e){
        return (double)Math.pow(n1, e);
    }
    
    static double expNum2(double n2, double e){
        return (double)Math.pow(n2,e);
    }
}
