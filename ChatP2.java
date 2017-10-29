import java.net.InetAddress;
import java.util.Scanner;

public class ChatP2 {
    
    public static void main (String[] args){
        String perro="";
        if (args.length != 3) 
            System.out.println("Este progrma requiere 3 argumentos de linea de mandato");
        else {
            try{
                InetAddress maquinaReceptora = InetAddress.getByName(args[0]);
                int puertoReceptor = Integer.parseInt(args[1]);
                int miPuerto = Integer.parseInt(args[2]);
                MiSocketDatagrama miSocket = new MiSocketDatagrama(miPuerto);
                while(true){ 
                    Scanner leer = new Scanner(System.in);
                    System.out.print("Tu:");
                    perro = leer.next();          
                    String mensaje = perro;
                    miSocket.enviaMensaje(maquinaReceptora, puertoReceptor, mensaje);
                    if (perro.equals("adios")){						                  
                            miSocket.enviaMensaje(maquinaReceptora, puertoReceptor, mensaje);
                            miSocket.close();  
			    break;
                        }
                    String respuesta = miSocket.recibeMensaje();
                    System.out.print("Respuesta:");
                    System.out.println(respuesta); 
                    
                }
            }

            catch (Exception e){
                e.printStackTrace();                
            }
        }        
    }
}

