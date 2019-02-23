package trng.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerilizationTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Address address = new Address("123", "Rajiv Street");
			
//		Employee emp = new Employee("Raj", "101", 2000f, "123-45-6345", address);
//		emp.setCompanyName();
//		emp.display();
//		EmpSerilizationUtil.serilizeEmployee(emp, "c:\\temp\\EmpData10.txt");
		
		Employee oldEmp = EmpSerilizationUtil.deSerilizeEmployee("c:\\temp\\EmpData1.txt");
		oldEmp.display();
	}
}



class EmpSerilizationUtil {
	static void serilizeEmployee(Employee e, String file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(e);
		
		oos.flush();
		fos.flush();
		fos.close();
		oos.close();
	}
	
	static Employee deSerilizeEmployee(String file) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(file);
		
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Employee e = (Employee) ois.readObject();
		

		fis.close();
		ois.close();

		return e;
	}
}
