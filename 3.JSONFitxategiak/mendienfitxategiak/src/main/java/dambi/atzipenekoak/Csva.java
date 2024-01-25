package dambi.atzipenekoak;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import dambi.pojoak.*;

public class Csva {
    public String strFileIn;
    public String strFileOut;

    /**
     * Konstruktoreak parametro bakarra jasotzen badu,
     * sarrera fitxategiaren izena jaso dugula suposatuko dugu.
     */
    public Csva(String strFileIn) {
        this.strFileIn = strFileIn;
    }

    /**
     * Konstruktoreak parametro bi jasotzen baditu,
     * lehengoa, sarrera fitxategiaren izena dela eta bigarrena irteerakoarena
     * direla suposatuko dugu.
     * Sarrera fitxategirik erabiliko ez badugu, kate hutsa erabiliko dugu lehen
     * parametro moduan.
     */
    public Csva(String strFileIn, String strFileOut) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }
    /**
     * strFileIn atributoan zehaztutako fitxategia irakurriko du metodo honek.
     * 
     * @return Mendiak klaseko objetu bat fitxategian irakurritako informazioarekin
     */
    public Mendiak irakurri() {
        Mendiak mendiak = null;

        try (BufferedReader inputStream = new BufferedReader(new FileReader(strFileIn))) {
            String banatzailea = ";";
            String l;
            mendiak = new Mendiak();
            while ((l = inputStream.readLine()) != null) {
                String[] eremuak = l.split(banatzailea);
                if (!eremuak[0].equals("MENDIA")) {
                    Mendi mendi = new Mendi();
                    mendi.setId(mendiak.getMendiak() == null ? 0 : mendiak.getMendiak().size());
                    mendi.setIzen(eremuak[0]);
                    mendi.setAltuera(Integer.parseInt(eremuak[1]));
                    mendi.setProbintzia(eremuak[2]);
                    mendiak.add(mendi);
                }
            }
            // System.out.println(mendiak.getMendiak());
        } catch (FileNotFoundException e) {
            System.out.println("Ez da " + strFileIn + " fitxategia aurkitu.");

        } catch (IOException e) {
            System.out.println("IOsalbuespena gertatu da.");
        }
        return mendiak;
    }

    /**
     * strFileOut atributoan zehaztutako fitxategian, jasotako objetuko datuak idatziko ditu metodo honek.
     * 
     * @param mendiak
     * @return Fitxategian idatzitako mendi kopurua 
     */
    public int idatzi(Mendiak mendiak) {
        int mendiKopurua=0;        

        try (PrintWriter outputStream = new PrintWriter(new FileWriter(strFileOut))) {
            for (Mendi m : mendiak.getMendiak()) {
                if (mendiKopurua==0){
                    outputStream.println("MENDIA;ALTUERA;PROBINTZIA");
                }
                mendiKopurua++;
                
                outputStream.println(m.getIzen()+";"+m.getAltuera()+";"+m.getProbintzia());
            }
        } catch (IOException e) {
            System.out.println(strFileOut + " fitxategiarekin arazoren bat egon da.");
        }
        return mendiKopurua;
    }
     }

