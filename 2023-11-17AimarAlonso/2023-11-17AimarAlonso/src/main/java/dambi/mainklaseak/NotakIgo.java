package dambi.mainklaseak;


import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Nota;
import dambi.pojoak.Notak;

/**
 * Datu-iturria: Notak.csv
 * Sortutako fitxategia: NotaHobetuak.xml
 * Programa honek nota guztiak puntu bat igoko ditu,
 * kontutan izanik notarik altuena 10 dela.
 * 
 */
public class NotakIgo {
  public static void main(String[] args) {
    Notak notak = new Notak();
    Notak notaBerriak = new Notak();

    Csva csva = new Csva("datuak/Notak.csv");
    Xmla xmla = new Xmla("", "datuak/NotaHobetuak.xml");

    notak = csva.irakurri();

    if (notak != null) {
        for (Nota n : notak.getNotak()) {
            double nuevaNota = n.getNota() + 1;
            if (nuevaNota <= 10) {
                n.setNota(nuevaNota);
            } else {
                nuevaNota = 10;
                n.setNota(nuevaNota);
            }
            notaBerriak.add(n);
        }

        System.out.println(xmla.idatzi(notaBerriak) + " nota idatzi dira xml fitxategian.");
    }
   
  }
}