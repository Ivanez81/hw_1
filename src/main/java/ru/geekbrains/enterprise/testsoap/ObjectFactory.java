
package ru.geekbrains.enterprise.testsoap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.geekbrains.enterprise.testsoap package. 
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

    private final static QName _ResultDTO_QNAME = new QName("http://test.service.enterprise.geekbrains.ru/", "resultDTO");
    private final static QName _PingResponse_QNAME = new QName("http://test.service.enterprise.geekbrains.ru/", "pingResponse");
    private final static QName _Ping_QNAME = new QName("http://test.service.enterprise.geekbrains.ru/", "ping");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.geekbrains.enterprise.testsoap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Ping }
     * 
     */
    public Ping createPing() {
        return new Ping();
    }

    /**
     * Create an instance of {@link ResultDTO }
     * 
     */
    public ResultDTO createResultDTO() {
        return new ResultDTO();
    }

    /**
     * Create an instance of {@link PingResponse }
     * 
     */
    public PingResponse createPingResponse() {
        return new PingResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test.service.enterprise.geekbrains.ru/", name = "resultDTO")
    public JAXBElement<ResultDTO> createResultDTO(ResultDTO value) {
        return new JAXBElement<ResultDTO>(_ResultDTO_QNAME, ResultDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test.service.enterprise.geekbrains.ru/", name = "pingResponse")
    public JAXBElement<PingResponse> createPingResponse(PingResponse value) {
        return new JAXBElement<PingResponse>(_PingResponse_QNAME, PingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test.service.enterprise.geekbrains.ru/", name = "ping")
    public JAXBElement<Ping> createPing(Ping value) {
        return new JAXBElement<Ping>(_Ping_QNAME, Ping.class, null, value);
    }

}
