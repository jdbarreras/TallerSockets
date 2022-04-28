import java.io.*;
import java.net.Socket;

public class Cliente {
    
    public static void main(String[] args){
        Socket S=null;
        BufferedReader BR=null;
        PrintWriter PW=null;
    
        try{
            S=new Socket("localhost", 9090);
            OutputStream OS=S.getOutputStream();
            PW=new PrintWriter(OS, true);
            for (int i=0;i<3;i++){
                PW.println("Hola mundo.");
            }
            S.shutdownOutput();
            InputStream IS=S.getInputStream();
            BR=new BufferedReader(new InputStreamReader(IS));

            String Str=null;
            while((Str=BR.readLine())!=null){
                System.out.println(Str);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(S!=null){
                    S.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}