import java.util.*;

class StudentManagementSystem {

    public static void main(String[] args) {

        /* =====================================================
           SECTION 1 : DECLARATIONS
           ===================================================== */
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();


        /* =====================================================
           SECTION 2 : MAIN MENU LOOP
           ===================================================== */
        while (true) {

            System.out.println("\n=====================================================");
            System.out.println("         STUDENT MANAGEMENT SYSTEM");
            System.out.println("=====================================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll No");
            System.out.println("4. Delete Student by Roll No");
            System.out.println("5. Update Student by Roll No");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();


            /* =================================================
               SECTION 3 : SWITCH CASE MENU OPERATIONS
               ================================================= */
            switch (choice) {

                /* =============================================
                   CASE 1 : ADD STUDENT
                   ============================================= */
                case 1:

                    System.out.println("\n------------- ADD STUDENT -------------");

                    System.out.print("Enter Roll No: ");
                    int rollNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    Student student = new Student(rollNo, name, age, course);
                    students.add(student);

                    System.out.println("Student Added Successfully!");
                    break;


                /* =============================================
                   CASE 2 : VIEW ALL STUDENTS
                   ============================================= */
                case 2:

                    System.out.println("\n------------- VIEW STUDENTS -------------");

                    if (students.isEmpty()) {
                        System.out.println("No Students Found.");
                    } else {
                        for (Student s : students) {
                            System.out.println(s);
                            System.out.println("-------------------------------------");
                        }
                    }
                    break;


                /* =============================================
                   CASE 3 : SEARCH STUDENT
                   ============================================= */
                case 3:

                    System.out.println("\n------------- SEARCH STUDENT -------------");

                    System.out.print("Enter Roll No to Search: ");
                    int searchRollNo = sc.nextInt();
                    sc.nextLine();

                    boolean found = false;

                    for (Student s : students) {
                        if (searchRollNo == s.getRollNo()) {
                            System.out.println(s);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student Not Found.");
                    }

                    break;


                /* =============================================
                   CASE 4 : DELETE STUDENT
                   ============================================= */
                case 4:

                    System.out.println("\n------------- DELETE STUDENT -------------");

                    System.out.print("Enter Roll No to Delete: ");
                    int deleteRollNo = sc.nextInt();
                    sc.nextLine();

                    boolean deleted = false;

                    for (int i = 0; i < students.size(); i++) {

                        Student s = students.get(i);

                        if (deleteRollNo == s.getRollNo()) {
                            students.remove(i);
                            deleted = true;
                            System.out.println("Student Deleted Successfully!");
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Student Not Found.");
                    }

                    break;


                /* =============================================
                   CASE 5 : UPDATE STUDENT
                   ============================================= */
                case 5:

                    System.out.println("\n------------- UPDATE STUDENT -------------");

                    System.out.print("Enter Roll No to Update: ");
                    int updateRollNo = sc.nextInt();
                    sc.nextLine();

                    boolean updated = false;

                    for (Student s : students) {

                        if (updateRollNo == s.getRollNo()) {

                            System.out.print("Enter New Name: ");
                            String newName = sc.nextLine();

                            System.out.print("Enter New Age: ");
                            int newAge = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter New Course: ");
                            String newCourse = sc.nextLine();

                            s.setName(newName);
                            s.setAge(newAge);
                            s.setCourse(newCourse);

                            updated = true;
                            System.out.println("Student Updated Successfully!");
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Student Not Found.");
                    }

                    break;


                /* =============================================
                   CASE 6 : EXIT
                   ============================================= */
                case 6:

                    System.out.println("\nExiting Program...");
                    return;


                /* =============================================
                   DEFAULT CASE : INVALID CHOICE
                   ============================================= */
                default:

                    System.out.println("\nInvalid Choice. Please Try Again.");
            }
        }
    }
}