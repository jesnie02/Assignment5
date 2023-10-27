package GUI;

import BE.GradeInfo;
import BE.Student;
import BE.Teacher;
import BLL.PersonManager;

import java.util.Scanner;

public class MainMenu extends Menu {
    private PersonManager personManager;


    public MainMenu(PersonManager personManager) {


      super("Main Menu", "Add Teacher", "Add Student", "Remove Person", "View All Persons", "View All Teachers", "View All Students", "Exit");
        this.personManager = personManager;
    }


    @Override
    protected void doAction(int option) {
        switch (option) {
            case 1:
                // Add Teacher
                // Implementer logikken for at tilføje en lærer
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter teacher ID:");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter teacher name:");
                String name = scanner.nextLine();

                System.out.println("Enter teacher email:");
                String email = scanner.nextLine();

                System.out.println("Enter teacher username:");
                String username = scanner.nextLine();

                System.out.println("Enter teacher subject:");
                String subject = scanner.nextLine();

                Teacher teacher = new Teacher(id, name, email, username);
                teacher.addSubject(subject);

                System.out.println("Teacher added successfully.");
                break;


            case 2:
                // Add Student
                // Implementer logikken for at tilføje en elev
                Scanner studentScanner = new Scanner(System.in);

                System.out.println("Enter student ID:");
                int studentid = studentScanner.nextInt();
                studentScanner.nextLine(); // Consume newline character

                System.out.println("Enter student name:");
                String studentname = studentScanner.nextLine();

                System.out.println("Enter student email:");
                String studentemail = studentScanner.nextLine();

                System.out.println("Enter student education:");
                String studenteducation = studentScanner.nextLine();

                System.out.println("ITO:");
                int itoGrade = studentScanner.nextInt();

                System.out.println("SCO:");
                int scoGrade = studentScanner.nextInt();

                System.out.println("SDE:");
                int sdeGrade = studentScanner.nextInt();

                Student student = new Student(studentid, studentname, studenteducation);
                student.addGrade(new GradeInfo(itoGrade,"ITO"));
                student.addGrade(new GradeInfo(scoGrade,"SCO"));
                student.addGrade(new GradeInfo(sdeGrade,"SDE"));
                student.setEmail(studentemail);
                personManager.addPerson(student);

                System.out.println("Student added successfully.");
                break;


            case 3:
                // Remove Person
                // Implementer logikken for at fjerne en person
                Scanner removescanner = new Scanner(System.in);
                System.out.println("Enter ID of the person to remove:");
                int idToRemove = removescanner.nextInt();
                personManager.removePerson(idToRemove);
                break;
            case 4:
                // View All Persons
                System.out.println("All Persons");
                personManager.getAllPersons().forEach(System.out::println);
                break;
            case 5:
                // View All Teachers

                System.out.println("All Teachers");
               personManager.getAllTeachers().forEach(System.out::println);
                break;
            case 6:
                // View All Students
                System.out.println("All Students");
                personManager.getAllStudents().forEach(System.out::println);
                break;
            case 7:
                // Exit
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");


        }
    }
}
