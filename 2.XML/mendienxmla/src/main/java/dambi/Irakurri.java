package dambi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

public class Irakurri {
    public static void main(String[] args) {

        BufferedReader br;
        String line;
        Mendiak mendiak = new Mendiak();
        ArrayList<Mendi> list = new ArrayList();

        // read the csv file and collect the person objects
        try {
            br = new BufferedReader(new FileReader("Mendiak.csv"));
            boolean firstLine = true; // Flag to skip the first line
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip the first line (column headers)
                    continue;
                } // get every single line individually in csv file
                String[] value = line.split(";"); // collect the comma separated values into array
                Mendi mendi = new Mendi();
                int altura = Integer.parseInt(value[1]);

                mendi.setIzen(value[0]); // first element of an array is id
                mendi.setAltuera(altura); // second element of an array is firstName
                mendi.setProbintzia(value[2]); // third element of an array is lastName
                list.add(mendi); // add person object into the list
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        mendiak.setMendiak(list); // set person object list to people
        mendiak.getMendiak().remove(0); // remove the first person object of list. because it holds the column's names

        // marshaling with java
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);
            jakarta.xml.bind.Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(jakarta.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(mendiak, new File("Mendiak.xml"));
            jaxbMarshaller.marshal(mendiak, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
