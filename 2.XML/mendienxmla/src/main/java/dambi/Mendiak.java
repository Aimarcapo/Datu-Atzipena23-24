package dambi;

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

    public void setMendiak(List<Mendi> mendiak) {
        this.mendiak = mendiak;
    }

    /**
     * This method is not used by jaxb, just used for business reasons. In the case that this class
     * would be generated using xml schemas definitions, this method has to be added to the
     * generated class or to some helper or util one
     * 
     * @param country
     */
   



}
