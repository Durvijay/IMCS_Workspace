package trng.imcs.hibernate.assignment4.serviceImpl;

import java.util.List;

import trng.imcs.hibernate.assignment4.bean.Address;
import trng.imcs.hibernate.assignment4.bean.Customer;
import trng.imcs.hibernate.assignment4.bean.Payment;
import trng.imcs.hibernate.assignment4.service.AddressDao;
import trng.imcs.hibernate.assignment4.service.CustomerDao;
import trng.imcs.hibernate.assignment4.service.CustomerService;
import trng.imcs.hibernate.assignment4.service.PaymentDao;

public class CustomerServiceImpl implements CustomerService {
	CustomerDao customerDaoImpl = new CustomerDaoImpl();
	AddressDao addressDaoImpl = new AddressDaoImpl();
	PaymentDao paymentDaoImpl = new PaymentDaoImpl();

    public String getIt() {
        return "Got it!";
    }
	public void updateAddress(Address address) {
		addressDaoImpl.updateAddress(address);
	}

	public void updateCustomer(Customer customer) {
		customerDaoImpl.updateCustomer(customer);

	}
	public Customer deleteCustomer(Integer custId) {
		return customerDaoImpl.deleteCustomer(custId);

	}
	public int deletePaymentMethods(Integer custId) {
		return paymentDaoImpl.deletePaymentMethods(custId);
	}
	
	public Customer createCustomer(Customer customer) {
		return customerDaoImpl.saveCustomer(customer);
	}

	public Payment updatePaymentMethod(Payment paymentMethod) {
		return paymentDaoImpl.updatePaymentMethod(paymentMethod);
	}

	public Payment newPaymentMethod(Payment paymentMethod) {
		return paymentDaoImpl.newPaymentMethod(paymentMethod);
	}
	
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
