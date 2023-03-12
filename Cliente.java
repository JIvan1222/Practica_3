import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cliente {

    public static void main(String[] args) {
        
            // Escribe el nombre y se lo manda al servidor
            

    Scanner input = new Scanner(System.in);

    float num1, num2;
    int valor=0;
    char operador;
    while(true){

    System.out.print("Ingrese el primer número: ");
    num1 = input.nextFloat();

    System.out.print("Ingrese el segundo número: ");
    num2 = input.nextFloat();

    System.out.print("Ingrese la operación que desea realizar (+, -, *, /): ");
    operador = input.next().charAt(0);

    switch (operador) {
      case '+':
        Suma suma= new Suma(num1, num2);
        suma.start();
        break;

      case '-':
      Resta resta= new Resta(num1, num2);
      resta.start();
        break;

      case '*':
      Mult mult= new Mult(num1, num2);
      mult.start();
        break;

      case '/':
      Div div= new Div(num1, num2);
      div.start();
        break;

      default:
        System.out.println("Error: operador no válido");
        return;
    }

}
   
}
 
}
