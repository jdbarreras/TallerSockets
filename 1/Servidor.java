import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Servidor {
 
    public static void main(String[] args) {
        ServerSocket SS=null;
        Socket S=null;
 
        BufferedReader BR=null;
        PrintWriter PW=null;
 
        try {
            SS=new ServerSocket(9090);
            S=SS.accept();
 
            InputStream IS = S.getInputStream();
            BR=new BufferedReader(new InputStreamReader(IS));
 
            String Str=null;
            while((Str=BR.readLine())!=null){
                System.out.println(Str);
            }
 
            OutputStream OS = S.getOutputStream();
            PW=new PrintWriter(OS,true);
 
            for(int i=0;i<3;i++){
                PW.println("Hola mundo.");
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