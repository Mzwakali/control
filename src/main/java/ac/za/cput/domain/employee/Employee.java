package ac.za.cput.domain.employee;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

   // @Id
     //@GeneratedValue(strategy = GenerationType.IDENTITY)
   // @GeneratedValue(generator = "uuid")
   // @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "emp_id", nullable = false, columnDefinition = "VARCHAR(20)")
    private String empId;
    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "id_Num", nullable = false)
    private String idNum;
    @Column(name = "job_Title", nullable = false)
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

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
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

    public static class Builder{
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
        public Employee build(){
            return new Employee(this);
        }

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
