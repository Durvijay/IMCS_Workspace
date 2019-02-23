
package trng.imcs.soap.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BookFlightRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BookFlightRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="flightNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="departureDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="arrivalDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="passengers" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BookFlightRequest", propOrder = {
    "flightNo",
    "departureDate",
    "arrivalDate",
    "passengers"
})
public class BookFlightRequest {

    @XmlElement(required = true)
    protected String flightNo;
    @XmlElement(required = true)
    protected String departureDate;
    @XmlElement(required = true)
    protected String arrivalDate;
    @XmlElement(required = true)
    protected String passengers;

    /**
     * Gets the value of the flightNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightNo() {
        return flightNo;
    }

    /**
     * Sets the value of the flightNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightNo(String value) {
        this.flightNo = value;
    }

    /**
     * Gets the value of the departureDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartureDate() {
        return departureDate;
    }

    /**
     * Sets the value of the departureDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartureDate(String value) {
        this.departureDate = value;
    }

    /**
     * Gets the value of the arrivalDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Sets the value of the arrivalDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalDate(String value) {
        this.arrivalDate = value;
    }

    /**
     * Gets the value of the passengers property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassengers() {
        return passengers;
    }

    /**
     * Sets the value of the passengers property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassengers(String value) {
        this.passengers = value;
    }

}
