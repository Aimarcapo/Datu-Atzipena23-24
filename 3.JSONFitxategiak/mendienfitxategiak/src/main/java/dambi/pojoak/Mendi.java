package dambi.pojoak;

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
    private int id;

    
    public Mendi(int id,String izen, String probintzia, int altuera){
     this.id = id; 
        this.izen = izen;
        this.probintzia = probintzia;
        this.altuera = altuera;
       
    }


    public String getIzen() {
        return izen;
    }


    public void setIzen(String izen) {
        this.izen = izen;
    }


    public String getProbintzia() {
        return probintzia;
    }


    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }


    public int getAltuera() {
        return altuera;
    }


    public void setAltuera(int altuera) {
        this.altuera = altuera;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Mendi [izen=" + izen + ", probintzia=" + probintzia + ", altuera=" + altuera + ", id=" + id + "]";
    }



}
