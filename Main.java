package studentmanagement;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static void pressEnterKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("press enter to continue!");
        scanner.nextLine();
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner input = new Scanner(System.in); // for user input
        int option; // option for user to choose
        do {
            System.out.println("----------------| Student management System |---------------");
            System.out.println("    1. Add new student");
            System.out.println("    2. Edit student information");
            System.out.println("    3. Delete student");
            System.out.println("    4. Show student information");
            System.out.println("    5. Search student");
            System.out.println("    6. Exit");
            System.out.println();// for blank space
            System.out.println("choose option from 1 to 6 :");
            //            menu validation
            try {
                option = input.nextInt();
            } catch (Exception e) {
                input.nextLine();
                option = 0;
                System.out.println("invalid option input! use Integer only");
                pressEnterKey();
            }
//            end of menu validation
            switch (option) {
                case 1:
                    System.out.println("--------| Add new student |-------");
                    Student newStudent = new Student();
                    newStudent.inputInfo(input);
                    students.add(newStudent);
                    System.out.println();
                    System.out.println("student added successfully!");
                    pressEnterKey();
                    break;
                case 2:
                    System.out.println("-------| Edit Student information |-------");
                    System.out.println("    Enter student Id : ");
                    int editId = input.nextInt();
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).id == editId) {
                            Student student = new Student();
                            input.nextLine();
                            student.id = students.get(i).id; // keep original id
                            student.updateInfo(input);
                            students.set(i, student);
                            System.out.println("student information updated!");
                            students.get(i).showStudentInfo();
                            pressEnterKey();
                        }

                    }
                    break;
                case 3:
                    System.out.println("-------| Delete Student |----------");
                    System.out.println("    Enter student Id : ");
                    int rmId = input.nextInt(); //rmId = remove id
                    //students.removeIf(student -> student.id == rmId);

                    for (int i = 0; i < students.size(); i++) {
                        if (rmId == students.get(i).id) {
                            students.remove(i);
                            System.out.println("student id :" + rmId + " was deleted!");
                            break;
                        }
                        if (rmId != students.get(i).id) {
                            System.out.println("Id not match");
                            break;
                        }
                    }

                    pressEnterKey();
                    break;
                case 4:
                    System.out.println("-------| Show student information |--------");
                    for (Student student : students) {
                        student.showStudentInfo();

                    }
                    pressEnterKey();
                    break;
                case 5:
                    System.out.println("-------| Search student |------------");
                    System.out.println();
                    System.out.println("    1. Search by ID : ");
                    System.out.println("    2. Search by Name : ");
                    System.out.println("    3. Search by Gender : ");
                    System.out.println("    4. Search by Class room : ");
                    System.out.println("choose from 1 to 4 ");
                    int searchOption = input.nextInt();
                    boolean isStudentExist = false;
                    switch (searchOption) {
                        case 1:
                            int searchId;
                            boolean idValid = false;

                            System.out.println("--------| search by ID |----------");
                            System.out.println();
                            do {
                                System.out.println("    Enter student ID :");
                                try {
                                    searchId = input.nextInt();
                                    idValid = true;
                                    for (int i = 0; i < students.size(); i++) {
                                        if (searchId == students.get(i).id) {
                                            isStudentExist = true;
                                            students.get(i).showStudentInfo();
                                        }

                                    }
                                    if (!isStudentExist) {
                                        System.out.println("Opp! sorry Id not match any student!");
                                    }

                                } catch (Exception e) {
                                    System.out.println("Invalid Id use integer only!");
                                    input.nextLine(); // to prevent recursion
                                }

                            } while (!idValid);

                            pressEnterKey();
                            break;
                        case 2:
                            String searchName;
                            System.out.println("-------| search by name |---------");
                            input.nextLine();// prevent skip
                            System.out.println("Enter student name : ");
                            searchName = input.nextLine();
                            for (int i = 0; i < students.size(); i++) {
                                if (Objects.equals(searchName, students.get(i).name)) {
                                    isStudentExist = true;
                                    students.get(i).showStudentInfo();
                                }

                            }
                            if (!isStudentExist) {
                                System.out.println("Name not found");

                            }
                            pressEnterKey();
                            break;
                        case 3:
                            String searchGender;
                            System.out.println("-------| search by Gender |---------");
                            input.nextLine();// prevent skip
                            System.out.println("Enter student Gender: ");
                            searchGender = input.nextLine();
                            for (int i = 0; i < students.size(); i++) {
                                if (Objects.equals(searchGender, students.get(i).gender)) {
                                    isStudentExist = true;
                                    students.get(i).showStudentInfo();
                                }

                            }
                            if (!isStudentExist) {
                                System.out.println("Student not found");

                            }
                            pressEnterKey();
                            break;
                        case 4:
                            String searchClassRoom;
                            System.out.println("-------| search by Class room |---------");
                            input.nextLine();// prevent skip
                            System.out.println("Enter Class room : ");
                            searchClassRoom = input.nextLine();
                            for (int i = 0; i < students.size(); i++) {
                                if (Objects.equals(searchClassRoom, students.get(i).classRoom)) {
                                    isStudentExist = true;
                                    students.get(i).showStudentInfo();
                                }

                            }

                            if (!isStudentExist) {
                                System.out.println("Class room not found");

                            }
                            pressEnterKey();
                            break;
                        default:
                            System.out.println("Invalid option please choose from 1 to 4 :");
                            break;
                    }

                case 6:
                    System.out.println("-------| Exit |---------");
                    break;
                default:
                    System.out.println("Wrong option! please choose from 1 to 6 : ");

            }


        } while (option != 6);


    }
}

class Student {
    int id;
    String name;
    String gender;
    int age;
    String classRoom;
    float score;

    //    no argu constructor
    Student() {
    }

    public Student(int id, String name, String gender, int age, String classRoom, float score) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.classRoom = classRoom;
        this.score = score;
    }

    void inputInfo(Scanner input) {
        boolean isIdValid = false;
        do {
//            String strId;
            System.out.println("Enter Student Id: ");
            try {
                id = input.nextInt();
                isIdValid = true;

            } catch (Exception e) {
                System.out.println("Invalid Id use integer only");
                input.nextLine();

            }
        } while (!isIdValid);
        input.nextLine();

        System.out.println("Enter Student name : ");
        name = input.nextLine();
        System.out.println("Enter Student gender : ");
        gender = input.nextLine();
        boolean isAgeValid = false;
        do {

            System.out.println("Enter student age : ");
            try {
                age = input.nextInt();
                isAgeValid = true;
            } catch (Exception e) {
                System.out.println("Invalid age use integer only");
                input.nextLine();

            }
        } while (!isAgeValid);
        boolean isScoreValid = false;
        do {

            System.out.println("Enter student score : ");
            try {
                score = input.nextFloat();
                isScoreValid = true;
            } catch (Exception e) {
                System.out.println("Invalid score use integer only");
                input.nextLine();

            }
        } while (!isScoreValid);
        input.nextLine();
        System.out.println("Enter student's class room : ");
        classRoom = input.nextLine();

    }

    //    show student information
    void showStudentInfo() {
        System.out.println();
        System.out.println("    ID:" + id + ", Name : " + name + " , Gender : " + gender + ", Age : " + age + " ,Class room : " + classRoom + " , Score : " + score);
        System.out.println(); //blank space
        //System.out.println("***********************************************************************************************************");
    }

    void updateInfo(Scanner input) {
        boolean isIdValid = false;

        System.out.println("Enter Student name : ");
        name = input.nextLine();
        System.out.println("Enter Student gender : ");
        gender = input.nextLine();
        boolean isAgeValid = false;
        do {

            System.out.println("Enter student age : ");
            try {
                age = input.nextInt();
                isAgeValid = true;
            } catch (Exception e) {
                System.out.println("Invalid age use integer only");
                input.nextLine();

            }
        } while (!isAgeValid);
        boolean isScoreValid = false;
        do {

            System.out.println("Enter student score : ");
            try {
                score = input.nextFloat();
                isScoreValid = true;
            } catch (Exception e) {
                System.out.println("Invalid score use integer only");
                input.nextLine();

            }
        } while (!isScoreValid);
        input.nextLine();
        System.out.println("Enter student's class room : ");
        classRoom = input.nextLine();

    }

}
