package dambi;
import java.io.File;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class MendiBatSortu {
    public static void main(String[] args) {
        // Create a Mendi object
        Mendi mendia = new Mendi();
        mendia.setIzen("MendiBat");
        mendia.setProbintzia("Gipuzkoa");
        mendia.setAltuera(1500);

        try {
            // Create a JAXBContext for the Mendi class
            JAXBContext context = JAXBContext.newInstance(Mendi.class);

            // Create a Marshaller
            Marshaller marshaller = context.createMarshaller();

            // Marshal the Mendi object to an XML file
            marshaller.marshal(mendia, new File("mendibat.xml"));

            System.out.println("Mendiaren informazioa XML fitxategian idatzi da (mendibat.xml).");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
