import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileHandling {
    ArrayList<String> person;
    FileHandling(ArrayList<String> x){
        this.person=x;
        File arian1=new File("C:/Users/Dr Techno/Desktop/registrationRepository.txt");
        if (arian1.exists()){
            FileWriter arian= null;
            try {
                arian = new FileWriter("C:/Users/Dr Techno/Desktop/registrationRepository.txt", true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (arian!=null){
                    PrintWriter pw=new PrintWriter(arian);
                    pw.println(person);
                    pw.close();
                }
            }
            try {
                arian.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            FileWriter arian= null;
            try {
                arian = new FileWriter("C:/Users/Dr Techno/Desktop/registrationRepository.txt");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (arian!=null){
                    PrintWriter pw=new PrintWriter(arian);
                    pw.println(person);
                    pw.close();
                }
            }
            try {
                arian.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
