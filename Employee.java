package employeefile;

/**
 *
 * @author The Promised Lan
 */
public class Employee {

    private int empId;
    private int memberNumber;
    private String dateTime;
    private String exerciseType;
    private int exerciseTime;
    private String comment;

    public Employee() {
        empId = 0;
        memberNumber = 0;
        dateTime = "";
        exerciseType = "";
        exerciseTime = 0;
	comment = "";
    }

    public Employee(int empId, int memberNumber, String dateTime, String exerciseType, int exerciseTime, String comment) {
        this.empId = empId;
        this.memberNumber = memberNumber;
        this.dateTime = dateTime;
        this.exerciseType = exerciseType;
        this.exerciseTime = exerciseTime;
	this.comment = comment;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public int getExerciseTime() {
        return exerciseTime;
    }

    public void setExerciseTime(int exerciseTime) {
        this.exerciseTime = exerciseTime;
    }
    
    public String getComment() {
	return comment;
    }

    public void setComment(String comment) {
	this.comment = comment;
    }

    @Override
    public String toString() {
        return "Employee{" + "empId=" + empId + ", memberNumber=" + memberNumber 
                + ", dateTime=" + dateTime + ", exerciseType=" + exerciseType 
                + ", exerciseTime=" + exerciseTime + ", comment=" + comment + '}';
    }
}
