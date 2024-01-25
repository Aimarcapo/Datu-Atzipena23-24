package dambi.pojoak;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;



/**
 * JaxB is not capable of marshal lists directly as root elements, so we need a container for the
 * list of countries. Getter and Setter are used by jaxb
 * 
 * @author dgutierrez-diez
 */
@XmlRootElement( name = "Countries" )
public class Mendiak
{
    private List<Mendi> mendiak;
    @XmlElement(name = "mendi")
    public List<Mendi> getMendiak() {
        return mendiak;
    }
public List<Mendi> getMendiak(int i) {
        return mendiak;
    }
    public void setMendiak(List<Mendi> mendiak) {
        this.mendiak = mendiak;
    }
    public void add(Mendi mendi) {
        if (this.mendiak == null) {
            this.mendiak = new ArrayList<Mendi>();
        }
        this.mendiak.add(mendi);

    }

   

}
