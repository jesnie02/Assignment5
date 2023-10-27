import BE.GradeInfo;
import BE.Person;
import BE.Student;
import BE.Teacher;
import BLL.PersonManager;
import GUI.MainMenu;

import java.util.ArrayList;
import java.util.List;

public class PersonData {
    private PersonManager pm = new PersonManager();
    public void start() {
        List<Person> persons = new ArrayList<>();

        MainMenu menu = new MainMenu(pm);
        setupData();
        menu.run();

        }

    public void setupData() {

        Teacher t = new Teacher(202, "Bent H. Pedersen", "bhp@asv.dk", "bhp");
        t.addSubject("Programming");

        pm.addPerson(t);

        Teacher t2 = new Teacher(203, "Lise M. Hansen", "lmh@asv.dk", "lmh");
        t2.addSubject("Programming");

        pm.addPerson(t2);

        Teacher t3 = new Teacher(204, "Claus A. Sørensen", "cas@asv.dk", "cas");
        t3.addSubject("Programming");

        pm.addPerson(t3);


        Student student = new Student(105, "Bo Ibsen", "CS");
        student.setEmail("bib@easv.dk");
        student.addGrade(new GradeInfo(7, "SCO"));
        student.addGrade(new GradeInfo(10, "ITO"));
        student.addGrade(new GradeInfo(10, "SDE"));
        pm.addPerson(student);

    }

}

