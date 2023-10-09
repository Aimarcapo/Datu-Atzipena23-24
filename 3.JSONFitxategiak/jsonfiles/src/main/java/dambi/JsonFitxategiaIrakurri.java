package dambi;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonStructure;
public class JsonFitxategiaIrakurri {
   /**
 * @param args
 */
public static void main(String[] args) throws FileNotFoundException {
    JsonReader reader = Json.createReader(new FileReader("data/jsondata.json"));
    JsonStructure jsonst = reader.read();
    System.out.println(jsonst);
   }


}
