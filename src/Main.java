import java.io.*;
import java.net.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        try {
            URI uri=new URI("http://www.google.es");
            URL url=uri.toURL();
            //mostramos informacion sobre la URL
            System.out.println("PROTOCOLO:"+url.getProtocol());
            System.out.println("HOST:"+url.getHost());
            System.out.println("PUERTO:"+url.getPort());
            System.out.println("PUERTO POR DEFECTO:"+url.getDefaultPort());
            URLConnection conexion= url.openConnection();
            //leemos toda la informacion que nos sirven, la guardamos en archivo
            BufferedReader flujoEntrada=new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            PrintWriter flujoSalida=new PrintWriter("pagina.html");

            String linea;
            while((linea= flujoEntrada.readLine())!=null){
                System.out.println(linea);
                flujoSalida.println(linea);
            }
            flujoEntrada.close();
            flujoSalida.close();
        } catch (URISyntaxException e) {
            System.out.println("Error syntactico en la URI");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }
