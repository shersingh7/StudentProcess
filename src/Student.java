

public class Student {

    private String firstName;
    private String lastName;
    private double grade;
    private String department;

    public Student(String firstName, String lastName, double grade, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.department = department;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return firstName + '\t' + lastName + "\t\t" + grade + '\t' + department + '\t';
    }

    public boolean equals(Student student){
        return this.getFirstName() == student.getFirstName() &&
                this.getLastName() == student.getLastName() &&
                this.getGrade() == student.getGrade() &&
                this.getDepartment() == student.getDepartment();
    }
}
