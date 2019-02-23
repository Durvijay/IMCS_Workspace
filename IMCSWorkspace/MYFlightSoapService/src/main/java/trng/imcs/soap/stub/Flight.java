
package trng.imcs.soap.stub;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Flight complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Flight">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="flightNo" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="seats" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="fare" type="{http://trng.imcs.soap/Flight}FlightFare"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Flight", namespace = "http://trng.imcs.soap/Flight", propOrder = {
    "flightNo",
    "name",
    "seats",
    "fare"
})
public class Flight {

    @XmlElement(required = true)
    protected BigInteger flightNo;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected List<String> seats;
    @XmlElement(required = true)
    protected FlightFare fare;

    /**
     * Gets the value of the flightNo property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFlightNo() {
        return flightNo;
    }

    /**
     * Sets the value of the flightNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFlightNo(BigInteger value) {
        this.flightNo = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the seats property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the seats property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSeats().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSeats() {
        if (seats == null) {
            seats = new ArrayList<String>();
        }
        return this.seats;
    }

    /**
     * Gets the value of the fare property.
     * 
     * @return
     *     possible object is
     *     {@link FlightFare }
     *     
     */
    public FlightFare getFare() {
        return fare;
    }

    /**
     * Sets the value of the fare property.
     * 
     * @param value
     *     allowed object is
     *     {@link FlightFare }
     *     
     */
    public void setFare(FlightFare value) {
        this.fare = value;
    }

}
