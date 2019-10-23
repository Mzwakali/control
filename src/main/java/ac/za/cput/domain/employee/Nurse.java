package ac.za.cput.domain.employee;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Nurse extends Employee {

    private String type;

    public Nurse() {
    }

    public Nurse(NurseBuilder builder) {
        super(builder);
        this.type = builder.type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class NurseBuilder extends Employee.Builder{

        private String type;

        public NurseBuilder(){
            super();
        }

        public NurseBuilder type(String type){
            this.type = type;
            return this;
        }

        @Override
        public Employee build() {
            return new Nurse(this);
        }

        public NurseBuilder copy(Nurse nurse){
            this.empId(nurse.getEmpId());
            this.firstName(nurse.getFirstName());
            this.lastName(nurse.getLastName());
            this.idNum(nurse.getIdNum());
            this.jobTitle(nurse.getJobTitle());
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof NurseBuilder)) return false;
            NurseBuilder that = (NurseBuilder) o;
            return Objects.equals(type, that.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type);
        }

        @Override
        public String toString() {
            return "NurseBuilder{" +
                    "type='" + type + '\'' +
                    '}' +super.toString();
        }
    }
}
