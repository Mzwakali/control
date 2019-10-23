package ac.za.cput.domain.employee;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Veterinarian extends Employee {

    private String specializing;

    public Veterinarian() {
    }

    public Veterinarian(VetBuilder builder) {
        super(builder);
        this.specializing = builder.specializing;
    }

    public String getSpecializing() {
        return specializing;
    }

    public void setSpecializing(String specializing) {
        this.specializing = specializing;
    }

    public static class VetBuilder extends Employee.Builder{

        private String specializing;

        public VetBuilder(){
            super();
        }
        public VetBuilder specializing(String specializing){
            this.specializing = specializing;
            return this;
        }

        public Builder copy(Veterinarian veterinarian){
            this.empId(veterinarian.getEmpId());
            this.firstName(veterinarian.getFirstName());
            this.lastName(veterinarian.getLastName());
            this.idNum(veterinarian.getIdNum());
            this.jobTitle(veterinarian.getJobTitle());
            this.specializing(veterinarian.getSpecializing());
            return this;
        }

        @Override
        public Employee build() {
            return new Veterinarian(this);
        }

        @Override
        public String toString() {
            return "VetBuilder{" +
                    "specializing='" + specializing + '\'' +
                    '}' +super.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof VetBuilder)) return false;
            VetBuilder that = (VetBuilder) o;
            return specializing.equals(that.specializing);
        }

        @Override
        public int hashCode() {
            return Objects.hash(specializing);
        }
    }
}
