package dambi.atzipenekoak;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import dambi.pojoak.*;

public class Csva {
    public String strFileIn;
     public String strFileOut;
     public Csva(){

     }
     public  Csva(String fileIn){
      this.strFileIn=fileIn;
     }
     public void Csva(String fileIn,String fileOut){
        this.strFileIn=fileIn;
         this.strFileOut=fileOut;
     }
     public Mendiak irakurri(){
        Mendiak mendiak=new Mendiak();
        List<Mendi> mendiakList = new ArrayList<>();
        try (BufferedReader inputStream = new BufferedReader(new FileReader(strFileIn))) {
            while (inputStream.readLine() != null) {
                String[] mendia = inputStream.readLine().split(";");
                Mendi mendiaObj = new Mendi(Integer.parseInt(mendia[0]), mendia[1], mendia[3],
                        Integer.parseInt(mendia[2]));
                mendiakList.add(mendiaObj);
            }
            mendiak.setMendiak(mendiakList);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return mendiak;

     }
     public int idatzi(Mendiak mendiak){
 int i = 0;
        List<Mendi> mendiakList = mendiak.getMendiak();
        try {
            //Declare and create file for writting. The file name and path are determined by strFileOut variable
            File mendiakFile = new File(strFileOut);
            mendiakFile.createNewFile();

            //Declare writer
            FileWriter fwMendiak = new FileWriter(mendiakFile, false);
            BufferedWriter writerMendiak = new BufferedWriter(fwMendiak);

            //Iterate over object Mendiak List<Mendia> and write the content into csv separated by ";"
            for (i = 0; i < mendiakList.size(); i++) {
                writerMendiak.write(mendiakList.get(i).getId() + ";" + mendiakList.get(i).getIzen() + ";"
                        + mendiakList.get(i).getProbintzia() + "\n");
            }
            fwMendiak.close();
            writerMendiak.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return i;
    }
     }

