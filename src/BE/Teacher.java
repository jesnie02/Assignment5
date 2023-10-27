package BE;

import BE.Person;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

    private List<String> subjects = new ArrayList<>();
    private String initials;
    private double salary;

    public Teacher(int id, String name, String email, String initials) {
        super(id, name);
        this.initials = initials;
        setEmail(email);
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void addSubject(String subject) {
       subjects.add(subject);
    }

    public String getInitials() {
        return initials;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        String out = super.toString();
        out += "" + initials + "                      " + subjects.get(0);
        return out;
    }


}
