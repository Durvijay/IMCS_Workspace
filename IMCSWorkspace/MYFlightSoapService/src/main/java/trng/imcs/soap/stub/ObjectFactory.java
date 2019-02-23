
package trng.imcs.soap.stub;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the trng.imcs.soap.stub package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BookFlightResponse_QNAME = new QName("http://trng.imcs.soap/FlightOperations", "BookFlightResponse");
    private final static QName _GetFlightsResponse_QNAME = new QName("http://trng.imcs.soap/FlightOperations", "GetFlightsResponse");
    private final static QName _GetFlightsRequest_QNAME = new QName("http://trng.imcs.soap/FlightOperations", "GetFlightsRequest");
    private final static QName _BookFlightRequest_QNAME = new QName("http://trng.imcs.soap/FlightOperations", "BookFlightRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: trng.imcs.soap.stub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BookFlightResponse }
     * 
     */
    public BookFlightResponse createBookFlightResponse() {
        return new BookFlightResponse();
    }

    /**
     * Create an instance of {@link GetFlightsResponse }
     * 
     */
    public GetFlightsResponse createGetFlightsResponse() {
        return new GetFlightsResponse();
    }

    /**
     * Create an instance of {@link GetFlightsRequest }
     * 
     */
    public GetFlightsRequest createGetFlightsRequest() {
        return new GetFlightsRequest();
    }

    /**
     * Create an instance of {@link BookFlightRequest }
     * 
     */
    public BookFlightRequest createBookFlightRequest() {
        return new BookFlightRequest();
    }

    /**
     * Create an instance of {@link FlightFare }
     * 
     */
    public FlightFare createFlightFare() {
        return new FlightFare();
    }

    /**
     * Create an instance of {@link Flight }
     * 
     */
    public Flight createFlight() {
        return new Flight();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookFlightResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://trng.imcs.soap/FlightOperations", name = "BookFlightResponse")
    public JAXBElement<BookFlightResponse> createBookFlightResponse(BookFlightResponse value) {
        return new JAXBElement<BookFlightResponse>(_BookFlightResponse_QNAME, BookFlightResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://trng.imcs.soap/FlightOperations", name = "GetFlightsResponse")
    public JAXBElement<GetFlightsResponse> createGetFlightsResponse(GetFlightsResponse value) {
        return new JAXBElement<GetFlightsResponse>(_GetFlightsResponse_QNAME, GetFlightsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://trng.imcs.soap/FlightOperations", name = "GetFlightsRequest")
    public JAXBElement<GetFlightsRequest> createGetFlightsRequest(GetFlightsRequest value) {
        return new JAXBElement<GetFlightsRequest>(_GetFlightsRequest_QNAME, GetFlightsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookFlightRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://trng.imcs.soap/FlightOperations", name = "BookFlightRequest")
    public JAXBElement<BookFlightRequest> createBookFlightRequest(BookFlightRequest value) {
        return new JAXBElement<BookFlightRequest>(_BookFlightRequest_QNAME, BookFlightRequest.class, null, value);
    }

}
