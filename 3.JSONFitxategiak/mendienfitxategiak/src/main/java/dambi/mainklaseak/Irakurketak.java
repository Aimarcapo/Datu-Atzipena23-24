package dambi.mainklaseak;
import dambi.pojoak.*;
import dambi.atzipenekoak.*;
public class Irakurketak {
    public static void main(String[] args) {

        Mendiak mendiak = new Mendiak();
        Csva csva = new Csva("data/Mendiak.csv");
        mendiak = csva.irakurri();
        if (mendiak != null) {
            System.out.println(csva.strFileIn + " fitxategian mendi hauek daude: ");
            System.out.println(mendiak);
        }
        Xmla xmla = new Xmla("data/Hirumendi.xml");
        mendiak = xmla.irakurri();
        if (mendiak != null) {
            System.out.println(xmla.strFileIn + " fitxategian mendi hauek daude: ");
            System.out.println(mendiak);
        }
        Jsona jsona = new Jsona("data/Mendiak.json");
        mendiak = jsona.irakurri();
        if (mendiak != null) {
            System.out.println(jsona.strFileIn + " fitxategian mendi hauek daude: ");
            System.out.println(mendiak);
        }
    }
}
