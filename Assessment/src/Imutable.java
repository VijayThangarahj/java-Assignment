final class Imutable {
    private final int id;
    private final String name;
    private final double salary;


    public Imutable (int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class Imutable {
    public static void main(String[] args) {
        Employee emp = new Employee(101, "John Doe", 50000.0);

        System.out.println(emp);

        // We can only read values
        System.out.println("ID: " + emp.getId());
        System.out.println("Name: " + emp.getName());
        System.out.println("Salary: " + emp.getSalary());
    }
}
