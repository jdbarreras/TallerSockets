import java.io.*;
import java.net.Socket;
 
public class Cliente{
 
    public static void main(String[] args) {
 
        Socket S=null;
        BufferedOutputStream BOS=null;
        BufferedInputStream BIS=null;
 
        try {
            S=new Socket("192.168.20.30",9898);
            OutputStream OS = S.getOutputStream();
            BOS=new BufferedOutputStream(OS);
            BIS=new BufferedInputStream (new FileInputStream ("C://Users/57321/Documents/Ing Electónica/Énfasis 3 Tm/New/Parte 1/TallerSockets/2/Escudo_Universidad_Cauca.png"));
            byte[] bytes=new byte[1024];
            int Len;
            while((Len=BIS.read(bytes))!=-1){
                BOS.write(bytes,0,Len);
                BOS.flush();
            }
            S.shutdownOutput();
 
            BIS=new BufferedInputStream(S.getInputStream());
            byte[] bytess=new byte[1024];
            int lenn;
            while((lenn=BIS.read(bytess))!=-1){
                System.out.println(new String(bytess,0,lenn));
            }
 
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