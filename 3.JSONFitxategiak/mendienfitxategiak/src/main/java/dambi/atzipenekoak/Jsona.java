package dambi.atzipenekoak;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

import dambi.pojoak.Mendi;
import dambi.pojoak.Mendiak;

public class Jsona {
    private String strFileIn;
    private String strFileOut;

    public void Jsona(String fileIn) {
        this.strFileIn = fileIn;
    }

    public void Jsona(String fileIn, String fileOut) {
        this.strFileIn = fileIn;
        this.strFileOut = fileOut;
    }

    public Mendiak irakurri() {
        Mendiak mendia = new Mendiak();
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jStructure = reader.read();

            JsonArray jArray = jStructure.asJsonArray();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return mendia;

    }

    public int idatzi(Mendiak mendiak) {
        try {
            JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
            List<Mendi> mendia = mendiak.getMendiak();
            for (Mendi mendi : mendia) {
                JsonObject mendiJson = Json.createObjectBuilder()
                        .add("id", mendi.getId())
                        .add("izen", mendi.getIzen())
                        .add("probintzia", mendi.getProbintzia())
                        .add("altuera", mendi.getAltuera())
                        .build();
                jsonArrayBuilder.add(mendiJson);
            }
            JsonArray jsonArray = jsonArrayBuilder.build();
            try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream(strFileOut))) {
                jsonWriter.writeArray(jsonArray);
            }
            return 0;
        } catch (FileNotFoundException e) {
            System.out.println("Fitxategia ezin izan da sortu.");

            return -1;
        }
    }
}