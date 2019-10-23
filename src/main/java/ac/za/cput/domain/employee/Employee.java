package ac.za.cput.domain.employee;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Employee {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String empId;
    private String firstName;
    private String lastName;
    private String idNum;
    private String jobTitle;

    public Employee() {
    }

    public Employee(Builder builder) {
        this.empId = builder.empId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.idNum = builder.idNum;
        this.jobTitle = builder.jobTitle;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
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

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public static abstract class Builder{
        private String empId;
        private String firstName;
        private String lastName;
        private String idNum;
        private String jobTitle;

        public Builder empId(String empId){
            this.empId = empId;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public Builder idNum(String idNum){
            this.idNum = idNum;
            return this;
        }
        public Builder jobTitle(String jobTitle){
            this.jobTitle = jobTitle;
            return this;
        }
        public abstract Employee build();

        @Override
        public String toString() {
            return "Builder{" +
                    "empId='" + empId + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", idNum='" + idNum + '\'' +
                    ", jobTitle='" + jobTitle + '\'' +
                    '}';
        }
    }
}
