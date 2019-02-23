package trng.excptnHndlng.batchprogram;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Manohar on 4/22/2017.
 */
public class BatchApplication {
    public static void main(String[] args) throws BatchException {

        try (BatchFileReader batchFileReader = new BatchFileReader("C:\\temp\\EmployeeData.csv")) {
            List<Employee> employees = batchFileReader.readEmployees();
            batchFileReader.readEmployees(10);
            batchFileReader.writeEmployee();
        } catch (FileNotFoundException | NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
//            e.printStackTrace();
            throw new BatchException("I am handling here", e);
        }
        /*finally {
            batchFileReader.close();
        }*/

        System.out.println("After try block");
    }
}
