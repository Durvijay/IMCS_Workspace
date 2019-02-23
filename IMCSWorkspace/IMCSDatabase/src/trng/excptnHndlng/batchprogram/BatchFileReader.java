package trng.excptnHndlng.batchprogram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Manohar on 4/21/2017.
 */
public class BatchFileReader implements AutoCloseable {

    private FileReader fileReader;

    public BatchFileReader(String fileString) throws FileNotFoundException {
        File file = new File(fileString);

        if (! file.exists()) {
            //other steps.
            throw new FileNotFoundException("Batch File Not Found " + fileString);
        }

        fileReader = new FileReader(file);

/*
        try {
            statement1;
            statement2;
            fileReader = new FileReader(file);
            statement3;
        } catch (FileNotFoundException e) {
//            fileReader = new FileReader("c:\\alttemp\\" + file.getName());
            System.out.println("File not found " + file.getName());
            e.printStackTrace();
            throw new Exception("exception triggered");
        }

        statement6;
        statement7;
*/
    }

    public List<Employee> readEmployees() throws IOException {
        fileReader.read();
        return null;
    }

    public List<Employee> readEmployees(int deptNo) throws IOException, BatchException {
        StringBuffer stringBuffer = new StringBuffer();
        int data;
        while((data = fileReader.read()) != -1) {
            System.out.println((char)data);
            stringBuffer.append((char)data);
        }
        System.out.println(stringBuffer.toString());
        if(! stringBuffer.toString().contains("Raj")) {
            throw new BatchException("Required data is missing");
        }

        return null;
    }


    public void writeEmployee() throws IOException {
        throw new RuntimeException("This write issue");
    }

    @Override
    public void close() {
        System.out.println("close method called");
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
