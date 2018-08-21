package ru.geekbrains.enterprise.testsoap;

import javax.xml.ws.WebServiceRef;

public class TestClient {

//    @WebServiceRef(wsdlLocation = "http://localhost:8080/TestSOAPService?wsdl")
    private static TestSOAPServiceService service = new TestSOAPServiceService();

    public static void main(String[] args) {
        TestSOAPService port = service.getTestSOAPServicePort();
        System.out.println(port.ping());
    }
}
