package trng.imcs.hibernate.assignment4.serviceImpl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import trng.imcs.hibernate.assignment4.bean.Address;
import trng.imcs.hibernate.assignment4.bean.Customer;
import trng.imcs.hibernate.assignment4.bean.Payment;
import trng.imcs.hibernate.assignment4.service.AddressDao;
import trng.imcs.hibernate.assignment4.service.CustomerDao;
import trng.imcs.hibernate.assignment4.service.CustomerService;
import trng.imcs.hibernate.assignment4.service.PaymentDao;

@Path("orderLibrary/")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class CustomerServiceImpl implements CustomerService {
	CustomerDao customerDaoImpl = new CustomerDaoImpl();
	AddressDao addressDaoImpl = new AddressDaoImpl();
	PaymentDao paymentDaoImpl = new PaymentDaoImpl();

	
	public void updateAddress(Address address) {
		addressDaoImpl.updateAddress(address);
	}

	public void updateCustomer(Customer customer) {
		customerDaoImpl.updateCustomer(customer);

	}
	@DELETE
	@Path("/{custId}")
	public Customer deleteCustomer(Integer custId) {
		return customerDaoImpl.deleteCustomer(custId);

	}
	@DELETE
	@Path("/{custId}/Payments")
	public int deletePaymentMethods(Integer custId) {
		return paymentDaoImpl.deletePaymentMethods(custId);
	}
	
	@PUT
	@Path("/customer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer createCustomer(Customer customer) {
		return customerDaoImpl.saveCustomer(customer);
	}

	@POST
	@Path("/payment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Payment updatePaymentMethod(Payment paymentMethod) {
		return paymentDaoImpl.updatePaymentMethod(paymentMethod);
	}

	@PUT
	@Path("/payment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Payment newPaymentMethod(Payment paymentMethod) {
		return paymentDaoImpl.newPaymentMethod(paymentMethod);
	}
	
	@GET
	@Path("/customer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer findCustomerFullData(Integer custId) {
		return customerDaoImpl.findCustomerFullData(custId);
	}

	public Customer findCustomer(Integer custId) {
		return customerDaoImpl.findCustomer(custId);
	}

	public List<Payment> findPaymentMehods(Integer custId) {
		return paymentDaoImpl.findPaymentMehods(custId);
	}

	public List<Customer> getAllCustomers() {
		return customerDaoImpl.getAllCustomers();
	}

}
