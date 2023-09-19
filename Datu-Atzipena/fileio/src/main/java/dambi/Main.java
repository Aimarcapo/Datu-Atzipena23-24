package dambi;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String path;
        String contenido;
        String text;
        Scanner in = new Scanner(System.in);
        System.out.println("Zer zoaz deskribatzera?");
        path = in.nextLine();
        System.out.println("Zein?");
        text = in.nextLine();

        String directoryPath = "C:\\Users\\alonso.aimar\\Desktop\\Datu-Atzipena\\fileio\\karpeta_berriak\\" + path;
        new File(directoryPath).mkdirs();

        try {
            
            String filePath = directoryPath + "\\" + text + ".txt";
            File file = new File(filePath);

            if (file.createNewFile()) {
                System.out.println("Sortutaako file-a: " + file.getName());
            } else {
                System.out.println("Existitxen du");
            }

            System.out.println("Nolakoa da?");
            contenido = in.nextLine();
            in.close();
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write(contenido);
            myWriter.close();
            System.out.println("Testua ondo sartu da filean");
        } catch (IOException e) {
            System.out.println("Errore bat okurritu da");
            e.printStackTrace();
        }
    }
}
