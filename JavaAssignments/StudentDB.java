class Student {
    String name;
    int rollNumber;
    double marks;

    Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("----------------------");
    }
}

public class StudentDB {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", 101, 89.5);
        Student student2 = new Student("Bob", 102, 76.0);

        System.out.println("=== Student Details ===");
        student1.displayDetails();
        student2.displayDetails();
    }
}
