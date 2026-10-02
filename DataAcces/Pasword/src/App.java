import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class App {
    public static void main(String[] args) throws Exception {
        String Password = "Password";
        File file = new File("password.bin");
        try {
            FileOutputStream fStream = new FileOutputStream(file);
            DataOutputStream writer = new DataOutputStream(fStream);
            writer.writeUTF(Password);
            writer.close();

            FileInputStream fis = new FileInputStream(file);
            DataInputStream reader = new DataInputStream(fis);
            String line = reader.readUTF();
            System.out.println(line);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
