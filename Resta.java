
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Resta extends Thread {
    float num1, num2;

    public Resta(Float num1, float num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override

    public void run()
    {
      
        try {
	float num3;
        num3= num1-num2;
	String r = Float.toString(num3);
            Scanner sn = new Scanner(System.in);
            sn.useDelimiter("\n");
            
            Socket sc = new Socket("127.0.0.1", 5000);
            
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());
            
            // Leer mensaje del servidor
            String r1 = in.readUTF();
            
            // Escribe el nombre y se lo manda al servidor
            out.writeUTF(r);
            
            // ejecutamos el hilo
            ClienteHilo hilo = new ClienteHilo(in, out);
            hilo.start();
            hilo.join();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

 }
}