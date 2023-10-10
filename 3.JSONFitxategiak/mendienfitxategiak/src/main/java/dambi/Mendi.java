package dambi;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Country containing a name, a capital city, a foundation date and the
 * continent it belongs to,
 * these attributes are going to be represented in this order in the generated
 * XML as described in
 * the annotation XmlType
 * 
 * @author dgutierrez-diez
 */
@XmlType(propOrder = { "probintzia", "izen", "altuera" })
@XmlRootElement(name = "Mendi")
public class Mendi {
    private String izen;
    private String probintzia;
    private int altuera;

    public Mendi(String izen, String probintzia, int altuera) {
        this.izen = izen;
        this.probintzia = probintzia;
        this.altuera = altuera;
    }

    public int getAltuera() {
        return altuera;
    }

    @XmlElement(name = "Altuera")
    public void setAltuera(int altuera) {
        this.altuera = altuera;
    }

    public String getIzen() {
        return izen;
    }

    @XmlAttribute(name = "probintzia", required = true)
    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }

    public String getProbintzia() {
        return this.probintzia;
    }

    @XmlElement(name = "Mendi_Izen")
    public void setIzen(String izen) {
        this.izen = izen;
    }

    public String toString() {
        String message = "\nName: " + this.izen + "\nAltuera: " + this.altuera + "\nProbintzia: " + this.probintzia;
        return message;
    }

}
