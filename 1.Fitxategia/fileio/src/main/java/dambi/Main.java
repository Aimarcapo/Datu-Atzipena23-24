package dambi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     
         
     
        Scanner in = new Scanner(System.in);
        System.out.println("Zer zoaz deskribatzera?");
        String path = in.nextLine();
        System.out.println("Zein?");
        String text = in.nextLine();

        try {
            String directoryPath = "C:\\Users\\alonso.aimar\\Desktop\\Datu-Atzipena\\fileio\\karpeta_berriak\\" + path;
            new File(directoryPath).mkdirs();
            String filePath = directoryPath + "\\" + text + ".txt";
            File file = new File(filePath);

            if (file.createNewFile()) {
                System.out.println("Sortutako fitxategia: " + file.getName());
            } else {
                System.out.println("Existitxen du");
            }
            System.out.println("Nolakoa da?");
            String contenido = in.nextLine();
            in.close();
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write(contenido);
            myWriter.close();
            System.out.println("Testua ondo sartu da fitxategian");
        } catch (IOException e) {
            System.out.println("Errore bat okurritu da");
            /* e.printStackTrace(); */
        }
        catch(SecurityException e){
            System.out.println("Ezin izan dira baimenak konprobatu karpeta sortzerakoan");
        }
    }
}
