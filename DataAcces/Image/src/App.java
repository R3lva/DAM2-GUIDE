import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
public class App {

    ///--- GET PHOTO VIA BINARY
    /// Made By : Fernando Relva
    /// Date : 02/10/26
    /// Github: @r3lva
    /// ---////////////////////////
    

public static byte[] tomarCaptura() {
        try {
            Dimension tamanoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle areaCaptura = new Rectangle(tamanoPantalla);
            Robot robot = new Robot();
            BufferedImage imagen = robot.createScreenCapture(areaCaptura);

            ByteArrayOutputStream bufferRAM = new ByteArrayOutputStream();
            ImageIO.write(imagen, "jpg", bufferRAM);
            
            byte[] imagenEnBytes = bufferRAM.toByteArray();
            return imagenEnBytes;
            
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
        return null; 
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Reescribir imagen en bytes");
        File fl = new File("src\\prueba.png");
        File fl2 = new File("prueba.dat");
        File fl3 = new File("prueba2.jpg");
        FileOutputStream fp = new FileOutputStream(fl2);
         FileOutputStream fp2 = new FileOutputStream(fl3);
        DataOutputStream DP = new DataOutputStream(fp2);
        DataOutputStream DP2 = new DataOutputStream(fp);
        FileInputStream fi = new FileInputStream(fl);
        DataInputStream DI = new DataInputStream(fi);
        //byte[] byle = DI.readAllBytes();
        //DP.write(byle);
        //DP2.write(byle);
        DP.write(tomarCaptura());
        DP.close();



    
    }
}
