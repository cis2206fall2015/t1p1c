package employeefile;

import java.util.Scanner;

/**
 *
 * @author The Promised Lan
 */
public class EmployeeApp {

    EmployeeDAO empList = new EmployeeDAO();
    Scanner sc = new Scanner(System.in);

    public EmployeeApp() {
        menuLoop();
    }

    private void menuLoop() {
        int id, memberNumber, exerciseTime;
        String dateTime, exerciseType, comment;
        String choice = "1";
        while (!choice.equals("0")) {
            System.out.println("\nEmployee Exercise Club");
            System.out.println("0 = Quit");
            System.out.println("1 = List All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Record");
            System.out.println("4 = Update Record");
            System.out.println("5 = Delete Record");
            choice = Validator.getLine(sc, "Number of choice: ", "^[0-5]$");

            switch (choice) {
                case "1":
                    System.out.println(empList.toString());
                    break;
                case "2":
                    id = Validator.getInt(sc, "New employee ID: ");
                    memberNumber = Validator.getInt(sc, "Member Number: ");
                    dateTime = Validator.getLine(sc, "Date/Time (2015-09-01T10:15:00): ");
                    exerciseType = Validator.getLine(sc, "Exercise Type: ");
                    exerciseTime = Validator.getInt(sc, "Exercise Time (Exact minutes - 60, 45, etc): ");
		    comment = Validator.getLine(sc, "Comment: ");
                    empList.createRecord(new Employee(id, memberNumber, dateTime, exerciseType, exerciseTime, comment));
                    break;
                case "3":
                    id = Validator.getInt(sc, "Employee id to retrieve: ");
                    System.out.println(empList.retrieveRecord(id));
                    break;
                case "4":
                    id = Validator.getInt(sc, "Employee ID to update: ");
                    memberNumber = Validator.getInt(sc, "memberNumber: ");
                    dateTime = Validator.getLine(sc, "Date/Time (2015-09-01T10:15:00): ");
                    exerciseType = Validator.getLine(sc, "Exercise Type: ");
                    exerciseTime = Validator.getInt(sc, "Exercise Time (Exact minutes - 60, 45, etc): ");
		    comment = Validator.getLine(sc, "Comment: ");
                    empList.updateRecord(new Employee(id, memberNumber, dateTime, exerciseType, exerciseTime, comment));
                    break;
                case "5":
                    id = Validator.getInt(sc, "Employee ID to delete: ");
                    System.out.println(empList.retrieveRecord(id));
                    String ok = Validator.getLine(sc, "Deleter this record? (y/n) ", "^[yYnN]$");
                    if (ok.equalsIgnoreCase("Y")) {
                        empList.deleteRecord(id);
                    }
                    break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new EmployeeApp();
    }
}
