package employeefile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author The Promised Lan
 */
public class EmployeeDAO {

    private final String fileName;
    protected final List<Employee> myList;

    public EmployeeDAO() {
        this("empdata.txt");
    }

    public EmployeeDAO(String fileName) {
        this.fileName = fileName;
        this.myList = new ArrayList<>();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ioe) {
            System.out.println("Create file error with " + ioe.getMessage());
        }
        readList();
    }

    public void createRecord(Employee employee) {
        myList.add(employee);
        writeList();
    }

    public Employee retrieveRecord(int id) {
        for (Employee employee : myList) {
            if (employee.getEmpId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void updateRecord(Employee updatedEmployee) {
        for (Employee employee : myList) {
            if (employee.getEmpId() == updatedEmployee.getEmpId()) {
                employee.setMemberNumber(updatedEmployee.getMemberNumber());
                employee.setDateTime(updatedEmployee.getDateTime());
                employee.setExerciseType(updatedEmployee.getExerciseType());
                employee.setExerciseTime(updatedEmployee.getExerciseTime());
		employee.setComment(updatedEmployee.getComment());
                break;
            }
        }
        writeList();
    }

    public void deleteRecord(int id) {
        for (Employee employee : myList) {
            if (employee.getEmpId() == id) {
                myList.remove(employee);
                break;
            }
        }
        writeList();
    }

    public void deleteRecord(Employee employee) {
        myList.remove(employee);
        writeList();
    }

    protected void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                int memberNumber = Integer.parseInt(data[1]);
                String dateTime = data[2];
                String exerciseType = data[3];
                int exerciseTime = Integer.parseInt(data[4]);
		String comment = data[5];
                Employee employee = new Employee(id, memberNumber, dateTime, exerciseType, exerciseTime, comment);
                myList.add(employee);
            }
        } catch (IOException ioe) {
            System.out.println("Read file error with " + ioe.getMessage());
        }
    }

    protected void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Employee employee : myList) {
                writer.write(String.format("%d,%s,%s,%s,%.2f\n",
                        employee.getEmpId(),
                        employee.getMemberNumber(),
                        employee.getDateTime(),
                        employee.getExerciseType(),
			employee.getExerciseTime(),
                        employee.getComment()));
            }
        } catch (IOException ioe) {
            System.out.println("Write file error with " + ioe.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        myList.stream().forEach((employee) -> {
            sb.append(String.format("%5d : %s, %s, %s, %.2f\n", employee.getEmpId(),
                    employee.getMemberNumber(), employee.getDateTime(),
                    employee.getExerciseType(), employee.getExerciseTime, employee.getComment()));
        });

        return sb.toString();
    }
}
