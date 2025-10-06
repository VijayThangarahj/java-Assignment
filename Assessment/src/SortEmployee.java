import java.util.*;

class Employ {
    int id;
    String name;
    double salary;

    Employ(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + salary;
    }
}

public class SortEmployee {
    public static void main(String[] args) {
        List<Employ> employees = new ArrayList<>();
        employees.add(new Employ(101, "Alice", 50000));
        employees.add(new Employ(102, "Bob", 40000));
        employees.add(new Employ(103, "Charlie", 60000));
        employees.add(new Employ(104, "David", 45000));

        Collections.sort(employees, new Comparator<Employ>() {
            @Override
            public int compare(Employ e1, Employ e2) {
                // For ascending order
                return Double.compare(e1.salary, e2.salary);
            }
        });

        System.out.println("Employees sorted by salary:");
        for (Employ e : employees) {
            System.out.println(e);
        }
    }
}
