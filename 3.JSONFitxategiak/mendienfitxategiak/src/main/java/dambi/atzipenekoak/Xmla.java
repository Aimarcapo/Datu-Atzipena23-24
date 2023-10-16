package dambi.atzipenekoak;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import dambi.pojoak.Mendiak;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Xmla {
    private String strFileIn;
     private String strFileOut;
     public void Xmla(String fileIn){
      this.strFileIn = "data/" + fileIn;
     }
     public void Xmla(String fileIn,String fileOut){
      this.strFileIn = "data/" +fileIn;
      this.strFileOut = "data/" +fileOut;
     }
     public Mendiak irakurri(){
        Mendiak mendia=new Mendiak();
         try{
            File fileIn = new File(strFileIn);
            JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);

            Unmarshaller jaxbUnmar = jaxbContext.createUnmarshaller();
            mendia = (Mendiak) jaxbUnmar.unmarshal(fileIn);

        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return mendia;

     }
     public int idatzi(Mendiak mendiak){
 try{

            JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            new File(strFileOut);
            OutputStream os = new FileOutputStream(strFileOut);

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(mendiak, os);

        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return mendiak.getMendiak().size();
     }
}
