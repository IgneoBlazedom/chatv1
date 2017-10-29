import java.net.*;
import java.io.*;
/**
 *
 * @author Hot Cakes
 */
public class MiSocketDatagrama extends DatagramSocket{
    static final int MAX_LON = 100;
    
    MiSocketDatagrama(int numPuerto) throws IOException{
        super (numPuerto);
    }
    
    public void enviaMensaje(InetAddress maquinaReceptora, 
        int puertoReceptor, String mensaje) throws IOException {
        
        byte[] almacenEnvio = mensaje.getBytes();
        DatagramPacket datagrama = 
                new DatagramPacket (almacenEnvio, almacenEnvio.length,
                maquinaReceptora, puertoReceptor);
        this.send(datagrama);
    } // fin de envíaMensaje
    
    public String recibeMensaje() throws IOException {
        byte[] almacenRecepcion = new byte[MAX_LON];
        DatagramPacket datagrama = 
                new DatagramPacket(almacenRecepcion, MAX_LON);
        this.receive(datagrama);
        String mensaje = new String(almacenRecepcion);
        return mensaje;
        
    }
}
