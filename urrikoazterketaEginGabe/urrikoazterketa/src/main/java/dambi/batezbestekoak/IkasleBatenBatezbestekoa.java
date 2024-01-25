package dambi.batezbestekoak;

import java.util.Scanner;

import dambi.atzipenekoak.Csva;
import dambi.pojoak.Nota;
import dambi.pojoak.Notak;

public class IkasleBatenBatezbestekoa {
    public static void main(String[] args) {
              Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.print("\tZein ikasleren batezbestekoa nahi duzu kalkulatu? ");
        String sarturikoIzena = scanner.next();
        sarturikoIzena = sarturikoIzena.toLowerCase();
        double cantidad=0;
        double notas=0;
          Notak notak = new Notak();
         Csva csva = new Csva("data/Notak.csv");
          notak = csva.irakurri();
        if (notak != null) {
            for (Nota n : notak.getNotak()) {
                if(n.getIkaslea().equals(sarturikoIzena)){
                    cantidad++;
                    notas+=n.getNota();
                }
              
                  
                
            }
            System.out.println(sarturikoIzena+"ren noten bataz bestekoa "+notas/cantidad+" da");
        }
    }
}
