package dambi.mainklaseak;
import dambi.pojoak.*;
import dambi.atzipenekoak.*;
public class Irakurketak {
    public static void main(String[] args) {
        Csva csva = new Csva("datuak.csv");
        Mendiak mendiak=csva.irakurri();
        for (Mendi mendia : mendiak.getMendiak()) {
            System.out.println("ID: " + mendia.getId());
            System.out.println("Izena: " + mendia.getIzen());
            System.out.println("Probintzia: " + mendia.getProbintzia());
        }

    }
}
