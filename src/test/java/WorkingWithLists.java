import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WorkingWithLists {
    @Test
    public void createAndWorkWithLists() {
        Student valera = new Student();
        valera.setFirstName("Valera");
        valera.setLastName("Tester");
        valera.setEmail("velerunchik@test.lv");
        valera.setPhone("+371585858");

        Student elina = new Student("Elina", "Barzilovicha", "elina@test.lv", "+371858585");
        Student edik = new Student("Edik", "Barzilovich", "edik@tester", "+371656565");
        Student luke = new Student("Luke", "Skywalker", "skywalker1987@test.lv", "+3710000000");

        valera.setLastName("Kurochkin");


        List<Student> students = new ArrayList<>();
        students.add(valera);
        students.add(elina);
        students.add(edik);
        students.add(luke);

        //--------FOR---------
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getFirstName());
            System.out.println(students.get(i).getLastName());
            System.out.println(students.get(i).getEmail());
            System.out.println(students.get(i).getPhone());
        }

        //-------FOREACH--------
        for (Student s : students){
           // System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getEmail() + " " + s.getPhone());
            System.out.println(s.getFullName());

        }
        //----------FOREACH with IF-----------
        System.out.println("Students with phone starting with +371");
        for (Student s : students){

            if (s.getPhone().startsWith("+371")){
                System.out.println(s.getFullName());
            }
        }

    }
}
