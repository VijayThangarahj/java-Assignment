final class Employee {

    private final int id;

    private final String name;

    private final double salary;

    public Employee(int id, String name, double salary) {

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

        return "Employ {" +

                "id=" + id +

                ", name='" + name + '\'' +

                ", salary=" + salary +

                '}';

    }

    @Override

    public int hashCode() {

        return id;

    }


    @Override

    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Employee)) return false;

        Employee other = (Employee) obj;

        return id == other.id &&

                Double.compare(salary, other.salary) == 0 &&

                name.equals(other.name);

    }

}
