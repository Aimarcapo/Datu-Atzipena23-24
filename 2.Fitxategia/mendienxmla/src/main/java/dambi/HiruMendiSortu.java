package dambi;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class HiruMendiSortu {
    public static void main(String[] args) {
        // Hiru mendien zerrenda sortu
        List<Mendi> hiruMendiak = new ArrayList<>();

        Mendi mendi1 = new Mendi();
        mendi1.setIzen("Mendi1");
        mendi1.setProbintzia("Probintzia1");
        mendi1.setAltuera(1000);
        hiruMendiak.add(mendi1);

        Mendi mendi2 = new Mendi();
        mendi2.setIzen("Mendi2");
        mendi2.setProbintzia("Probintzia2");
        mendi2.setAltuera(1200);
        hiruMendiak.add(mendi2);

        Mendi mendi3 = new Mendi();
        mendi3.setIzen("Mendi3");
        mendi3.setProbintzia("Probintzia3");
        mendi3.setAltuera(800);
        hiruMendiak.add(mendi3);

        try {
            // Create a JAXBContext for the List<Mendi> class
            JAXBContext context = JAXBContext.newInstance(Mendiak.class);

            // Create a Marshaller
            Marshaller marshaller = context.createMarshaller();

            // Marshal the list of Mendi objects to an XML file
            Mendiak wrapper = new Mendiak();
            wrapper.setMendiak(hiruMendiak);
            marshaller.marshal(wrapper, new File("hirumendi.xml"));

            System.out.println("Hiru mendiak XML fitxategian idatzi dira (hirumendi.xml).");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

