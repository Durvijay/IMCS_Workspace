package trng.imcs.soap.serviceImpl;

import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imcs.soap.stub.CreateCustomerRequest;
import com.imcs.soap.stub.CreateCustomerResponse;
import com.imcs.soap.stub.OrderLibrary;

import trng.imcs.hibernate.assignment4.bean.Customer;
import trng.imcs.hibernate.assignment4.serviceImpl.CustomerServiceImpl;
import trng.imcs.hibernate.assignment4.util.CustomerUtil;

@WebService(endpointInterface="com.imcs.soap.stub.OrderLibrary")
@Service("libraryWs")
public class OrderLibraryServiceImpl implements OrderLibrary{
	CustomerServiceImpl customerservice=new CustomerServiceImpl();
	

	@Override
	public CreateCustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest) {
		System.out.println("Request is coming");
		Customer customer=CustomerUtil.copyfromWsdlCustomer(createCustomerRequest.getCustomer());
		CreateCustomerResponse createCustomerResponse=new CreateCustomerResponse();
		try {
			createCustomerResponse.setCustomer(CustomerUtil.copyToWsdlCustomer(customerservice.createCustomer(customer)));
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return createCustomerResponse;
	}

}
