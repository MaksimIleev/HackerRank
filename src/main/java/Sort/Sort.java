package Sort;

import java.util.*;

public class Sort {

    public static int numberOfStudents;
    public static int id;
    public static String firstName;
    public static double cgpa;

    public static List<Student> studentList;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        numberOfStudents = Integer.parseInt(in.nextLine());
        if(!(numberOfStudents >= 2 && numberOfStudents <= 1000))
            throw new InputMismatchException("numberOfStudents >= 2 && numberOfStudents <= 1000");

        studentList = new ArrayList<Student>();

        while(numberOfStudents > 0) {

            int id = in.nextInt();

            if(String.valueOf(id).startsWith("0") && String.valueOf(id).length() > 1)
                throw new InputMismatchException("id should not contain leading zero");

            if(!(id >= 0 && id <= 100000))
                throw new InputMismatchException("id >= 0 && id <= 100000");

            firstName = in.next();

            if(!(firstName.matches("[A-Z]{1}[a-z]*")))
                throw new InputMismatchException("First letter should be uppercase rest letters - lowercase");

            if(!(firstName.length() >= 5 && firstName.length() <= 30))
                throw new InputMismatchException("fname.length() >= 5 && fname.length() <= 30");

            cgpa = in.nextDouble();

            if((String.valueOf(cgpa).matches("(\\.\\d{3})+")))
                throw new InputMismatchException("max 2 decimal point required for CGPA");

            if(!(cgpa >= 0 && cgpa <= 4.00))
                throw new InputMismatchException("cgpa >= 0 && cgpa <= 4.00");

            Student st = new Student(id, firstName, cgpa);
            studentList.add(st);

            numberOfStudents--;
        }

        Collections.sort(studentList, new CompareByDescCGPA());

        for(Student st: studentList){
            System.out.println(st.getFname());
        }
    }
}

class CompareByDescCGPA implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getId() == o2.getId())
            throw new InputMismatchException(o1.getId()
                    + " duplicate id for " + o1.getFname()
                    + " and " + o2.getFname()
            );
        /*
        *  if CGPA are equal -> compare by Name ASC
        *  if Names are equal -> compare by ID ASC
        * */
        if(Double.compare(o2.getCgpa(), o1.getCgpa()) == 0) {
            if(o1.getFname().compareTo(o2.getFname()) == 0) {
                return o1.getId() - o2.getId();
            } else {
                return o1.getFname().compareTo(o2.getFname());
            }
        }
        return Double.compare(o2.getCgpa(), o1.getCgpa());
    }
}

class CompareByAscCGPA implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.getCgpa(), o2.getCgpa());
    }
}
