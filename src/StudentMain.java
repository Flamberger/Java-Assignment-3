import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) throws java.io.IOException{
        Student student = new Student("Bert Smith", "Computing", 21, "bsmit123", 12345, true);
        student.grades.add(0, new Grade("Algorithm", 68));
        student.grades.add(0, new Grade("Maths", 76));
        student.grades.add(0, new Grade("Web Dev", 63));
        student.grades.add(0, new Grade("Programming", 52));
        students.add(0, student);

        student = new Student("Olivia Green", "Computing", 19, "ogree234", 23464, true);
        student.grades.add(0, new Grade("Programming", 73));
        student.grades.add(student.grades.size(), new Grade("Web Dev", 82));
        student.grades.add(student.grades.size(), new Grade("Maths", 72));
        student.grades.add(student.grades.size(), new Grade("Algorithm", 66));
        students.add(students.size(), student);

        student = new Student("Eloise Jones", "Computing", 18, "ejone347", 34744, true);
        student.grades.add(0, new Grade("Programming", 65));
        student.grades.add(student.grades.size(), new Grade("Web Dev", 63));
        student.grades.add(student.grades.size(), new Grade("Maths", 37));
        student.grades.add(student.grades.size(), new Grade("Algorithm", 40));
        students.add(students.size(), student);

        student = new Student("Ben Bird", "Computing", 42, "bbird348", 34834, false);
        student.grades.add(0, new Grade("Programming", 55));
        student.grades.add(student.grades.size(), new Grade("Web Dev", 29));
        student.grades.add(student.grades.size(), new Grade("Maths", 56));
        student.grades.add(student.grades.size(), new Grade("Algorithm", 38));
        students.add(students.size(), student);

        student = new Student("Karen Brown", "Computing", 25, "kbrow456", 45632, false);
        student.grades.add(0, new Grade("Programming", 62));
        student.grades.add(student.grades.size(), new Grade("Web Dev", 51));
        student.grades.add(student.grades.size(), new Grade("Maths", 43));
        student.grades.add(student.grades.size(), new Grade("Algorithm", 43));
        students.add(students.size(), student);

//        for (int i = 0; i < students.size(); i++) {
//            System.out.println(students.get(i).GetName());
//        }

        Scanner scanner = new Scanner(System.in);
        int ch;
        do{
            System.out.println("Welcome to the EH Academic Quanto-Bigmus Arraysystemsoft Tech database of Primal Cruelty!");
            System.out.println("Please select a service:");
            System.out.println("1. View Students");
            System.out.println("2. Distinguish Sinners and Failures—let the SCUM float to the forefront of your conscious awareness");
            System.out.println("3. Print Grade Average for each student :D");
            System.out.println("4. Imprint Soul(tm) into Systemtek Damnation(c) Archive");
            System.out.println("5. KILL KILL DIE DEATH DESPAIR THE END OF THOUGHT end program");
            ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("");
                    System.out.println("Here are the Students enrolled and their accolades. Look upon their Works, ye Mighty, and despair!");
                    System.out.println("");
                    for (int i = 0; i < students.size(); i++) {
                        Student currentStudent = students.get(i);
                        System.out.println(currentStudent.GetName());
                        for (int j = 0; j < currentStudent.grades.size(); j++) {
                            Grade currentGrades = currentStudent.grades.get(j);
                            char grade = Grade.GetLetterGrade(currentGrades.GetScore());
                            System.out.println(currentGrades.GetSubject() + ": " + grade);
                        }
                        System.out.println("");
                    }
                    System.out.println("press ENTER to continue");
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("These are the faces of failure. Ontological evils. No act against them can ever be unethical.");
                    System.out.println("");
                    for (int i = 0; i < students.size(); i++) {
                        Student currentStudent = students.get(i);
                        for (int j = 0; j < currentStudent.grades.size(); j++) {
                            Grade currentScore = currentStudent.grades.get(j);
                            char grade = Grade.GetLetterGrade(currentScore.GetScore());
                            if (grade == 'F') {
                                System.out.println(currentStudent.GetName());
                                break;
                            }
                        }
                    }
                    System.out.println("");
                    System.out.println("press ENTER to continue");
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("The students and their average grades:");
                    System.out.println("");
                    for (int i = 0; i < students.size(); i++) {
                        Student currentStudent = students.get(i);
                        System.out.println(currentStudent.GetName());
                        double total = 0;
                        for (int j = 0; j < currentStudent.grades.size(); j++) {
                            Grade currentGrades = currentStudent.grades.get(j);
                            total += currentGrades.GetScore();
                        }
                        double avg = total/currentStudent.grades.size();
                        System.out.println(avg);
                        System.out.println(Grade.GetLetterGrade(avg));
                        System.out.println("");
                    }
                    System.out.println("press ENTER to continue");
                    break;
                case 4:
                    Student xStudent = new Student("","",0,"",0,true);
                    xStudent.grades.add(0, new Grade("Programming", 0));
                    xStudent.grades.add(xStudent.grades.size(), new Grade("Web Dev", 0));
                    xStudent.grades.add(xStudent.grades.size(), new Grade("Maths", 0));
                    xStudent.grades.add(xStudent.grades.size(), new Grade("Algorithm", 0));
                    students.add(0, xStudent);
                    xStudent = students.get(0);
                    scanner.nextLine();
                    System.out.println("");
                    System.out.println("The process has started, there is no going back. What is their name:");
                    String n = scanner.nextLine();
                    System.out.println("What is their department:");
                    String dep = scanner.nextLine();
                    System.out.println("What is their age:");
                    int age = scanner.nextInt();
                    System.out.println("What is their student number:");
                    int sn = scanner.nextInt();
                    for (int i = 0; i < xStudent.grades.size(); i++) {
                        System.out.println("What is their " + xStudent.grades.get(i).GetSubject() + " grade:");
                        double sc = scanner.nextDouble();
                        xStudent.grades.get(i).SetScore(sc);
                    }
                    xStudent.SetName(n);
                    xStudent.SetDepartment(dep);
                    xStudent.SetAge(age);
                    xStudent.SetStudentNumber(sn);
                    System.out.println("Student created ——— Press ENTER to continue");
                    break;
                case 5:
                    System.out.println("Good Riddance and Alas! Press ENTER to confirm shutdown.");
                    break;
                default:
                    System.out.println("Invalid selection. If you're having trouble press ENTER to refresh the terminal");
            }
            System.in.read();//Skipping to go back to press enter and buffer just want to come statement to show the entered value
        }while (ch != 5);
    }
}
