//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.06 at 03:29:48 PM CST 
//


package example.com.flightoperations;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the example.com.flightoperations package. 
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

    private final static QName _GetFlightDetailsRequest_QNAME = new QName("http://com.example/FlightOperations", "getFlightDetailsRequest");
    private final static QName _UpdateFlightDetailsResponse_QNAME = new QName("http://com.example/FlightOperations", "updateFlightDetailsResponse");
    private final static QName _DeleteFlightDetailsRequest_QNAME = new QName("http://com.example/FlightOperations", "deleteFlightDetailsRequest");
    private final static QName _DeleteFlightDetailsResponse_QNAME = new QName("http://com.example/FlightOperations", "deleteFlightDetailsResponse");
    private final static QName _CreateFlightDetailsRequest_QNAME = new QName("http://com.example/FlightOperations", "createFlightDetailsRequest");
    private final static QName _CreateFlightDetailsResponse_QNAME = new QName("http://com.example/FlightOperations", "createFlightDetailsResponse");
    private final static QName _GetFlightDetailsResponse_QNAME = new QName("http://com.example/FlightOperations", "getFlightDetailsResponse");
    private final static QName _UpdateFlightDetailsRequest_QNAME = new QName("http://com.example/FlightOperations", "updateFlightDetailsRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: example.com.flightoperations
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFlightDetailsRequest }
     * 
     */
    public GetFlightDetailsRequest createGetFlightDetailsRequest() {
        return new GetFlightDetailsRequest();
    }

    /**
     * Create an instance of {@link UpdateFlightDetailsResponse }
     * 
     */
    public UpdateFlightDetailsResponse createUpdateFlightDetailsResponse() {
        return new UpdateFlightDetailsResponse();
    }

    /**
     * Create an instance of {@link DeleteFlightDetailsRequest }
     * 
     */
    public DeleteFlightDetailsRequest createDeleteFlightDetailsRequest() {
        return new DeleteFlightDetailsRequest();
    }

    /**
     * Create an instance of {@link DeleteFlightDetailsResponse }
     * 
     */
    public DeleteFlightDetailsResponse createDeleteFlightDetailsResponse() {
        return new DeleteFlightDetailsResponse();
    }

    /**
     * Create an instance of {@link CreateFlightDetailsRequest }
     * 
     */
    public CreateFlightDetailsRequest createCreateFlightDetailsRequest() {
        return new CreateFlightDetailsRequest();
    }

    /**
     * Create an instance of {@link CreateFlightDetailsResponse }
     * 
     */
    public CreateFlightDetailsResponse createCreateFlightDetailsResponse() {
        return new CreateFlightDetailsResponse();
    }

    /**
     * Create an instance of {@link GetFlightDetailsResponse }
     * 
     */
    public GetFlightDetailsResponse createGetFlightDetailsResponse() {
        return new GetFlightDetailsResponse();
    }

    /**
     * Create an instance of {@link UpdateFlightDetailsRequest }
     * 
     */
    public UpdateFlightDetailsRequest createUpdateFlightDetailsRequest() {
        return new UpdateFlightDetailsRequest();
    }

    /**
     * Create an instance of {@link FlightDetails }
     * 
     */
    public FlightDetails createFlightDetails() {
        return new FlightDetails();
    }

    /**
     * Create an instance of {@link Flight }
     * 
     */
    public Flight createFlight() {
        return new Flight();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightDetailsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.example/FlightOperations", name = "getFlightDetailsRequest")
    public JAXBElement<GetFlightDetailsRequest> createGetFlightDetailsRequest(GetFlightDetailsRequest value) {
        return new JAXBElement<GetFlightDetailsRequest>(_GetFlightDetailsRequest_QNAME, GetFlightDetailsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateFlightDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.example/FlightOperations", name = "updateFlightDetailsResponse")
    public JAXBElement<UpdateFlightDetailsResponse> createUpdateFlightDetailsResponse(UpdateFlightDetailsResponse value) {
        return new JAXBElement<UpdateFlightDetailsResponse>(_UpdateFlightDetailsResponse_QNAME, UpdateFlightDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFlightDetailsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.example/FlightOperations", name = "deleteFlightDetailsRequest")
    public JAXBElement<DeleteFlightDetailsRequest> createDeleteFlightDetailsRequest(DeleteFlightDetailsRequest value) {
        return new JAXBElement<DeleteFlightDetailsRequest>(_DeleteFlightDetailsRequest_QNAME, DeleteFlightDetailsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFlightDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.example/FlightOperations", name = "deleteFlightDetailsResponse")
    public JAXBElement<DeleteFlightDetailsResponse> createDeleteFlightDetailsResponse(DeleteFlightDetailsResponse value) {
        return new JAXBElement<DeleteFlightDetailsResponse>(_DeleteFlightDetailsResponse_QNAME, DeleteFlightDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateFlightDetailsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.example/FlightOperations", name = "createFlightDetailsRequest")
    public JAXBElement<CreateFlightDetailsRequest> createCreateFlightDetailsRequest(CreateFlightDetailsRequest value) {
        return new JAXBElement<CreateFlightDetailsRequest>(_CreateFlightDetailsRequest_QNAME, CreateFlightDetailsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateFlightDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.example/FlightOperations", name = "createFlightDetailsResponse")
    public JAXBElement<CreateFlightDetailsResponse> createCreateFlightDetailsResponse(CreateFlightDetailsResponse value) {
        return new JAXBElement<CreateFlightDetailsResponse>(_CreateFlightDetailsResponse_QNAME, CreateFlightDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.example/FlightOperations", name = "getFlightDetailsResponse")
    public JAXBElement<GetFlightDetailsResponse> createGetFlightDetailsResponse(GetFlightDetailsResponse value) {
        return new JAXBElement<GetFlightDetailsResponse>(_GetFlightDetailsResponse_QNAME, GetFlightDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateFlightDetailsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.example/FlightOperations", name = "updateFlightDetailsRequest")
    public JAXBElement<UpdateFlightDetailsRequest> createUpdateFlightDetailsRequest(UpdateFlightDetailsRequest value) {
        return new JAXBElement<UpdateFlightDetailsRequest>(_UpdateFlightDetailsRequest_QNAME, UpdateFlightDetailsRequest.class, null, value);
    }

}
