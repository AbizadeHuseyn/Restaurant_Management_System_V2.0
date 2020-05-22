public class Personnel extends Person {
    private String workHours;
    private float salary;
     public Personnel(String name, String surname, int age, String email, String workHours, float salary){
         super(name,surname,age,email);
         this.salary = salary;
         this.workHours = workHours;

     }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
