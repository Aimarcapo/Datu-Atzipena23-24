package dambi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class JsonZuhaitzaSortuBi {
    public static void main(String[] args)  throws FileNotFoundException {
        JsonObject model = Json.createObjectBuilder()
                .add("menu", Json.createObjectBuilder()
                        .add("id", "file")
                        .add("value", "File")
                        .add("popup", Json.createObjectBuilder()
                                .add("menuitem", Json.createArrayBuilder()
                                        .add(Json.createObjectBuilder()
                                                .add("value", "New")
                                                .add("onCLick", "CreateNewDoc()"))
                                        .add(Json.createObjectBuilder()
                                                .add("value", "Open")
                                                .add("onclick", "OpenDoc()"))
                                        .add(Json.createObjectBuilder()
                                                .add("value", "Close")
                                                .add("onclick", "CloseDoc()")))))
                .build();
try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream("data/jsondatabi.json"))) {
   jsonWriter.writeObject(model);
}
    }
}
