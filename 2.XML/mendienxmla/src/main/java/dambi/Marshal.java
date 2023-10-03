package dambi;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Marshal {
    public static void main(String[] args) {
        // Hiru mendien zerrenda sortu
        List<Mendi> hiruMendiak = new ArrayList<>();

        // ... Hiru Mendi objektuak sortu eta zerrendan gorde

        // Kargatu XML fitxategia memorian
        try {
            JAXBContext context = JAXBContext.newInstance(Mendiak.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Mendiak wrapper = (Mendiak) unmarshaller.unmarshal(new File("hirumendi.xml"));
            
            // Lortu Mendi objektuen zerrenda
            hiruMendiak = wrapper.getMendiak();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        // XML fitxategiak sortu eta gorde hainbat baldintza eta informazio aldaketekin
        // XML fitxategia hainbat izenpean (mendiakaltueraoinatan.xml, gipuzkoakomendiak.xml, ...) sortu eta gorde

        // XML fitxategia "mendiakaltueraoinatan.xml" izenpean gorde
        marshalAndSave(hiruMendiak, "mendiakaltueraoinatan.xml");

        // XML fitxategia "gipuzkoakomendiak.xml" izenpean gorde
          marshalAndSave(hiruMendiak, "gipuzkoakomendiak.xml");
    }

    private static void marshalAndSave(List<Mendi> mendiak, String fileName) {
        try {
            JAXBContext context = JAXBContext.newInstance(Mendiak.class);
            Marshaller marshaller = context.createMarshaller();
            Mendiak wrapper = new Mendiak();
            wrapper.setMendiak(mendiak);
            marshaller.marshal(wrapper, new File(fileName));
            System.out.println("Mendiak XML fitxategian gordeta (" + fileName + ").");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
