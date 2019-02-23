package trng.imcs.hibernate.assignment4.service;

import java.util.List;

import trng.imcs.hibernate.assignment4.bean.Customer;

public interface CustomerDao {
	Customer saveCustomer(Customer customer);

	Customer findCustomer(Integer customer);

	Customer findCustomerFullData(Integer custId);

	Customer deleteCustomer(Integer custId);

	Customer updateCustomer(Customer customer);

	List<Customer> getAllCustomers();
}
