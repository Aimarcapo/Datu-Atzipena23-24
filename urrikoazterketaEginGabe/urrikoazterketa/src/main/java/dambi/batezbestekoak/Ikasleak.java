package dambi.batezbestekoak;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement( name = "Ikasleak" )
public class Ikasleak {
     public List<Ikaslea> ikasleak;

     public List<Ikaslea> getIkasleak() {
          return ikasleak;
     }

     public void setIkasleak(List<Ikaslea> ikasleak) {
          this.ikasleak = ikasleak;
     }
     public void add(Ikaslea ikaslea) {
        if (this.ikasleak == null) {
            this.ikasleak = new ArrayList<Ikaslea>();
        }
        this.ikasleak.add(ikaslea);

    }
}
