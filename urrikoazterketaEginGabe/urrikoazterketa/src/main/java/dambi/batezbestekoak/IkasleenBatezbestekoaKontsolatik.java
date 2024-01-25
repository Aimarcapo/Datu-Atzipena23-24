package dambi.batezbestekoak;

import java.util.ArrayList;
import java.util.List;

import dambi.atzipenekoak.Csva;
import dambi.pojoak.Notak;

public class IkasleenBatezbestekoaKontsolatik {
    public static void main(String[] args) {

        double cantidad = 0;
        double notas = 0;
        Notak notak = new Notak();
        List<String> izenguztiak = new ArrayList<>();
        String izena;
        Csva csva = new Csva("data/Notak.csv");
        notak = csva.irakurri();
        System.out.println("\tIKASLEA\t\t\tBATEZBESTEKOA");
        System.out.println("===================================================");
        if (notak != null) {
            for (int i = 0; i < notak.getNotak().size(); i++) {
                izena = notak.getNotak().get(i).getIkaslea();
                if (!izenguztiak.contains(izena)) {
                    izenguztiak.add(izena);
                }
            }
            for (int i = 0; i < izenguztiak.size(); i++) {
                for (int x = 0; x < notak.getNotak().size(); x++) {
                    if (notak.getNotak().get(x).getIkaslea().equals(izenguztiak.get(i))) {
                        notas += notak.getNotak().get(x).getNota();
                        cantidad++;
                    }
                }
                System.out.println(izenguztiak.get(i) + "              " + notas / cantidad);
            }
            notas = 0;
            cantidad = 0;
        }
    }
}
