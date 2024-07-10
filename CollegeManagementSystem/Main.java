import java.util.Scanner;

// Main class with the main menu and interaction logic
public class Main {

    static void main_menu() {
        System.out.println();
        System.out.println("======================= *** WELCOME TO COLLEGE MANAGEMENT SYSTEM *** =======================");
        System.out.println();
        System.out.println("=============================== *** ENTER YOUR CHOICE *** ===============================");
        System.out.println();
        System.out.println("1].ADD STUDENT \t\t\t 2].VIEW STUDENT");
        System.out.println("3].ADD COURSE \t\t\t 4].VIEW COURSE");
        System.out.println("5].ADD DEPARTMENT\t\t 6].VIEW DEPARTMENT");
        System.out.println("7].ADD FACULTY \t\t\t 8].VIEW FACULTY");
        System.out.println("9].VIEW STUDENT MARKS");
        System.out.println("=============================== *** ENTER 0 TO EXIT *** ===============================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Department departments[] = new Department[5];
        Course courses[] = new Course[5];
        Student students[] = new Student[5];
        Faculty faculties[] = new Faculty[5];

        int department_counter = 0;
        int course_counter = 0;
        int student_counter = 0;
        int faculty_counter = 0;
        int choice = 100;

        while (choice != 0) {
            main_menu();
            choice = sc.nextInt();

            while (choice != 0) {
                switch (choice) {
                    case 1:
                        students[student_counter] = new Student();
                        students[student_counter].set_details(sc);
                        student_counter++;
                        break;
                    case 2:
                        for (int i = 0; i < student_counter; i++) {
                            students[i].get_details();
                        }
                        break;
                    case 3:
                        courses[course_counter] = new Course();
                        courses[course_counter].set_details(sc);
                        course_counter++;
                        break;
                    case 4:
                        for (int i = 0; i < course_counter; i++) {
                            courses[i].get_details();
                        }
                        break;
                    case 5:
                        departments[department_counter] = new Department();
                        departments[department_counter].set_details(sc);
                        department_counter++;
                        break;
                    case 6:
                        for (int i = 0; i < department_counter; i++) {
                            departments[i].get_details();
                        }
                        break;
                    case 7:
                        faculties[faculty_counter] = new Faculty();
                        faculties[faculty_counter].set_details(sc);
                        faculty_counter++;
                        break;
                    case 8:
                        for (int i = 0; i < faculty_counter; i++) {
                            faculties[i].get_details();
                        }
                        break;
                    case 9:
                        System.out.print("Enter student ID to view marks: ");
                        String studentId = sc.next();
                        for (int i = 0; i < student_counter; i++) {
                            if (students[i].get_id().equals(studentId)) {
                                students[i].get_marks();
                                break;
                            }
                        }
                        break;
                    default:
                        System.out.println("ENTER VALID CHOICE: ");
                        break;
                }
                main_menu();
                choice = sc.nextInt();
            }
        }
        sc.close();
    }
}

// Base class for common attributes and methods
class CollegeEntity {
    String id;
    String name;

    public String get_id() {
        return id;
    }

    public void get_details() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }

    public void set_details(Scanner sc) {
        System.out.print("Enter ID: ");
        id = sc.nextLine();
        sc.nextLine();
        System.out.print("Name: ");
        name = sc.nextLine();
    }
}

// Department class
class Department extends CollegeEntity {
    String headOfDepartment;

    @Override
    public void get_details() {
        super.get_details();
        System.out.println("Head of Department: " + headOfDepartment);
    }

    @Override
    public void set_details(Scanner sc) {
        super.set_details(sc);
        System.out.print("Head of Department: ");
        headOfDepartment = sc.nextLine();
    }
}

// Course class
class Course extends CollegeEntity {
    String courseCode;
    int creditHours;

    @Override
    public void get_details() {
        super.get_details();
        System.out.println("Course Code: " + courseCode);
        System.out.println("Credit Hours: " + creditHours);
    }

    @Override
    public void set_details(Scanner sc) {
        super.set_details(sc);
        System.out.print("Course Code: ");
        courseCode = sc.nextLine();
        System.out.print("Credit Hours: ");
        creditHours = sc.nextInt();
        sc.nextLine(); // Consume the remaining newline
    }
}

// Student class
class Student extends CollegeEntity {
    String departmentId;
    double[] marks = new double[5]; // Assuming 5 courses per student

    @Override
    public void get_details() {
        super.get_details();
        System.out.println("Department ID: " + departmentId);
    }

    @Override
    public void set_details(Scanner sc) {
        super.set_details(sc);
        System.out.print("Department ID: ");
        departmentId = sc.nextLine();
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter marks for course " + (i + 1) + ": ");
            marks[i] = sc.nextDouble();
        }
        sc.nextLine(); // Consume the remaining newline
    }

    public void get_marks() {
        System.out.println("Marks for student " + name + ":");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Course " + (i + 1) + ": " + marks[i]);
        }
    }
}

// Faculty class
class Faculty extends CollegeEntity {
    String departmentId;
    String title;

    @Override
    public void get_details() {
        super.get_details();
        System.out.println("Department ID: " + departmentId);
        System.out.println("Title: " + title);
    }

    @Override
    public void set_details(Scanner sc) {
        super.set_details(sc);
        System.out.print("Department ID: ");
        departmentId = sc.nextLine();
        System.out.print("Title: ");
        title = sc.nextLine();
    }
}
