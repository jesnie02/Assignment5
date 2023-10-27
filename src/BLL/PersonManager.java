package BLL;

import BE.Person;
import BE.Student;
import BE.Teacher;

import java.util.ArrayList;
import java.util.List;

public class PersonManager {
    List<Person> persons = new ArrayList<>();

    public Person getPerson(int id) {
        for (Person p : persons)
            if (p.getId()==id)
                return p;
        return null;
    }

    public void addPerson(Person p) {

        for (Person pe : persons)
            if (pe.equals(p))
                return;
        persons.add(p);
    }

    public void removePerson(int id) {
        Person toBeRemoved = null;
        for (Person p : persons) {
            if (p.getId() == id) {
                toBeRemoved = p;
                break;
            }
        }
        if (toBeRemoved != null) {
            persons.remove(toBeRemoved);
            System.out.println("BE.Person removed successfully.");
        } else {
            System.out.println("No person found with ID " + id);
        }
        /*
        BE.Person toBeRemoved = null;
        for (BE.Person p : persons)
            if (p.getId()==id) {
                toBeRemoved = p;
                break;
            }
        persons.remove(toBeRemoved);
*/
    }

    public List<Person> getAllPersons() {
            return persons;
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        for (Person person : persons) {
            if (person instanceof Teacher) {
                teachers.add((Teacher) person);
            }
        }
        return teachers;
    }


    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        for (Person p : persons)
            if (p instanceof Student)
                students.add((Student) p);
        return students;
    }



    @Override
    public String toString() {
        String out = "ID         NAME                           EMAIL\n";
        for (Person currentPerson : persons) {
           out += currentPerson + "\n";
        }
        return out;
    }
}
