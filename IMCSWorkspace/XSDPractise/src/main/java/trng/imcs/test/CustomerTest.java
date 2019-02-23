package trng.imcs.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import trng.imcs.jaxb.Address;
import trng.imcs.jaxb.Customer;
import trng.imcs.jaxb.PaymentMethod;

public class CustomerTest {

	public static void main(String[] args) throws DatatypeConfigurationException, JAXBException {
		Customer customer = new Customer();
		customer.setName("Sam");
		customer.setAnualSalary(0.05);
		customer.setCustomerId(01);
		customer.setDataOfBirth(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));

		Address address = new Address();
		address.setStreetName("5801 preston oaks");
		address.setStreetNo("5801");
		address.setZipCode("75254");
		List<Address> addList = customer.getAddress();
		addList.add(address);

		PaymentMethod paymentMethod = new PaymentMethod();
		paymentMethod.setCardName("Sammarth");
		paymentMethod.setCardNumber("123456789");
		paymentMethod.setCardType("CARDTYPE1");
		List<PaymentMethod> listPayment = customer.getPayment();
		listPayment.add(paymentMethod);

		File f = new File("customer.xml");
		JAXBContext context = JAXBContext.newInstance(Customer.class);
		Marshaller jaxbMarshaller = context.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(customer, f);
		// jaxbMarshaller.marshal(customer, System.out);

		Unmarshaller unmarshaller = context.createUnmarshaller();
		Customer customer2 = (Customer) unmarshaller.unmarshal(f);
		System.out.println(customer2);
		
		System.out.println("Serializing started");
		serialize(customer2);
		System.out.println("Serializing complete");
		deserialize();

	}

	public static void deserialize() {
		try {
			byte[] data = Files.readAllBytes(Paths.get("gen.json"));
			ObjectMapper objectMapper = new ObjectMapper();
			Customer customer = objectMapper.readValue(data, Customer.class);
			System.out.println(customer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void serialize(Customer customer) {
		ObjectMapper objectMapper = new ObjectMapper();

		File file = new File("gen.json");
		FileOutputStream fos = null;
		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			fos = new FileOutputStream(file);

			objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			objectMapper.writeValue(fos, customer);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
