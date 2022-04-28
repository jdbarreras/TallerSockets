import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Servidor {
 
    public static void main(String[] args) {
        ServerSocket SS=null;
        Socket S=null;
        BufferedInputStream BIS=null;
        BufferedOutputStream BOS=null;
 
        try {
            SS=new ServerSocket(9898);
            S=SS.accept();
 
            InputStream IS = S.getInputStream();
            BIS=new BufferedInputStream(IS);
            BOS=new BufferedOutputStream(new FileOutputStream("C://Users/57321/Documents/Ing Electónica/Énfasis 3 Tm/New/Parte 1/TallerSockets/Escudo_.png"));
            byte[] bytes=new byte[1024];
            int Len;
            while((Len=BIS.read(bytes))!=-1){
 
                BOS.write(bytes,0,Len);
                BOS.flush();
            }
            OutputStream OS = S.getOutputStream();
            OS.write ("Recibido" .getBytes ());
 
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(S!=null)
                    S.close();
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
    }
}