package dambi.mainklaseak;
import java.util.ArrayList;
import java.util.List;
import dambi.atzipenekoak.Csva;
import dambi.pojoak.Mendi;
import dambi.pojoak.Mendiak;

public class CSVWriter {
    public static void main(String[] args) {
        Csva csva = new Csva("output.csv");
         Mendi mendi0=new Mendi(0, "Aketegi", "Gipuzkoa", 9548);
        Mendi mendi1=new Mendi(1, "Aketegi", "Gipuzkoa", 9548);
        Mendiak mendiak=new Mendiak();
        List<Mendi> mendis=new ArrayList<>();
        mendis.add(0, mendi0);
        mendis.add(1, mendi1);
       mendiak.setMendiak(mendis);
       int i = csva.idatzi(mendiak);

       System.out.println("Number of entries written: " + i);
        }
}
