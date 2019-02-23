package trng.imcs.hibernate.assignment4.util;

import java.math.BigInteger;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import trng.imcs.hibernate.assignment4.bean.Address;
import trng.imcs.hibernate.assignment4.bean.Customer;
import trng.imcs.hibernate.assignment4.bean.Payment;

public class CustomerUtil {

	public static Customer copyfromWsdlCustomer(com.imcs.soap.stub.Customer customer) {
		if (customer != null) {
			Customer customer2 = new Customer();
			if (customer.getCustomerId() != null)
				customer2.setCustomerId(customer.getCustomerId().intValue());
			if (customer.getCustomerName() != null)
				customer2.setCustomerName(customer.getCustomerName());
			if (customer.getDob() != null)
				customer2.setDob(customer.getDob().toGregorianCalendar().getTime());
			if (customer.getAnualSalary() > 0)
				customer2.setAnualSalary(customer.getAnualSalary());
			if (customer.getAddress() != null)
				customer2.setAddress(copyfromWsdlAddress(customer.getAddress()));
			for (com.imcs.soap.stub.Payment payment : customer.getPaymentMethod()) {
				customer2.getPaymentMethods().add(copyfromWsdlPayment(payment));
			}
			return customer2;
		}
		return null;
	}

	public static Address copyfromWsdlAddress(com.imcs.soap.stub.Address address) {
		if (address != null) {
			Address address2 = new Address();
			if (address.getAddressId() != null)
				address2.setAddressId(address.getAddressId().intValue());
			if (address.getCity() != null)
				address2.setCity(address.getCity());
			if (address.getState() != null)
				address2.setState(address.getState());
			if (address.getCountry() != null)
				address2.setCountry(address.getCountry());
			return address2;
		}
		return null;
	}

	public static Payment copyfromWsdlPayment(com.imcs.soap.stub.Payment payment) {
		if (payment != null) {
			Payment payment2 = new Payment();
			if (payment.getCardId() != null)
				payment2.setCardId(payment.getCardId().intValue());
			if (payment.getCardName() != null)
				payment2.setCardName(payment.getCardName());
			if (payment.getCardNumber() != null)
				payment2.setCardNumber(payment.getCardNumber());
			if (payment.getCardType() != null)
				payment2.setCardType(payment.getCardType());
			if (payment.getCustomer() != null && payment.getCustomer().getCustomerId() != null)
				payment2.getCustomer().setCustomerId(payment.getCustomer().getCustomerId().intValue());
			return payment2;
		}
		return null;
	}

	public static com.imcs.soap.stub.Customer copyToWsdlCustomer(Customer customer)
			throws DatatypeConfigurationException {
		if (customer != null) {

			com.imcs.soap.stub.Customer customer2 = new com.imcs.soap.stub.Customer();
			if (customer.getCustomerId() != null)
				customer2.setCustomerId(BigInteger.valueOf(customer.getCustomerId()));
			if (customer.getCustomerName() != null)
				customer2.setCustomerName(customer.getCustomerName());
			if (customer.getDob() != null) {
				GregorianCalendar gCalendar = new GregorianCalendar();
				gCalendar.setTime(customer.getDob());
				customer2.setDob(DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar));
			}
			if (customer.getAnualSalary() > 0)
				customer2.setAnualSalary(customer.getAnualSalary());
			if (customer.getAddress() != null)
				customer2.setAddress(copyToWsdlAddress(customer.getAddress()));
			for (Payment payment : customer.getPaymentMethods()) {
				customer2.getPaymentMethod().add(copyToWsdlPayment(payment));
			}
			return customer2;
		}
		return null;
	}

	public static com.imcs.soap.stub.Address copyToWsdlAddress(Address address) {
		if (address != null) {
			com.imcs.soap.stub.Address address2 = new com.imcs.soap.stub.Address();
			if (address.getAddressId() > 0)
				address2.setAddressId(BigInteger.valueOf(address.getAddressId()));
			if (address.getCity() != null)
				address2.setCity(address.getCity());
			if (address.getState() != null)
				address2.setState(address.getState());
			if (address.getCountry() != null)
				address2.setCountry(address.getCountry());
			return address2;
		}
		return null;
	}

	public static com.imcs.soap.stub.Payment copyToWsdlPayment(Payment payment) {
		if (payment != null) {
			com.imcs.soap.stub.Payment payment2 = new com.imcs.soap.stub.Payment();
			if (payment.getCardId() != null)
				payment2.setCardId(BigInteger.valueOf(payment.getCardId()));
			if (payment.getCardName() != null)
				payment2.setCardName(payment.getCardName());
			if (payment.getCardNumber() != null)
				payment2.setCardNumber(payment.getCardNumber());
			if (payment.getCardType() != null)
				payment2.setCardType(payment.getCardType());
			if (payment.getCustomer() != null && payment.getCustomer().getCustomerId() != null)
				payment2.getCustomer().setCustomerId(BigInteger.valueOf(payment.getCustomer().getCustomerId()));
			return payment2;
		}
		return null;
	}
}
