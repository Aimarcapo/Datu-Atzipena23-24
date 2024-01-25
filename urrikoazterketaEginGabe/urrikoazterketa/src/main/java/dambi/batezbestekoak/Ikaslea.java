package dambi.batezbestekoak;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "ikaslea", "batazbestekoak"})
@XmlRootElement(name = "Ikaslea")
public class Ikaslea {
    private String ikaslea;
    private double batezbestekoak;
  public Ikaslea(){
    
  }
    public Ikaslea(String ikaslea, Double batezbestekoak) {
        this.ikaslea=ikaslea;
        this.batezbestekoak=batezbestekoak;

    }
    public String getIkaslea() {
        return ikaslea;
    }
    public void setIkaslea(String ikaslea) {
        this.ikaslea = ikaslea;
    }
    public double getBatezbestekoak() {
        return batezbestekoak;
    }
    public void setBatezbestekoak(double batezbestekoak) {
        this.batezbestekoak = batezbestekoak;
    }
}
