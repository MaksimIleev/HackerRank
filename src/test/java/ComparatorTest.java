import Sort.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

/*
 *  if CGPA are equal -> compare by Name ASC
 *  if Names are equal -> compare by ID ASC
 * */
public class ComparatorTest {

    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
            {  new Student[] {
                   // pass parameters
                   new Student(1, "Aaaaa", 0),
                   new Student(2, "Bbbbb", 3.9)
                },
                new Student[] {
                    // expected order
                    new Student(2, "Bbbbb", 3.9),
                    new Student(1, "Aaaaa", 0),

                },
            },
            {  new Student[] {
                    // pass parameters
                    new Student(1, "Aaaaa", 2.22),
                    new Student(2, "Bbbbb", 2.22)
                },
                new Student[] {
                    // expected order
                    new Student(1, "Aaaaa", 2.22),
                    new Student(2, "Bbbbb", 2.22)
                },
            },
            {  new Student[] {
                    // pass parameters
                    new Student(1, "Aaaaa", 2.22),
                    new Student(2, "Aaaaa", 2.22)
                },
                new Student[] {
                    // expected order
                    new Student(1, "Aaaaa", 2.22),
                    new Student(2, "Aaaaa", 2.22)
                },
            },
            {  new Student[] {
                    // pass parameters
                    new Student(1, "Aaaaa", 2.22),
                    new Student(2, "Aaaaa", 2.22)
                },
                new Student[] {
                    // expected order
                    new Student(1, "Aaaaa", 2.22),
                    new Student(2, "Aaaaa", 2.22)
                },
            },

        };
    }

    @Test(dataProvider = "testData")
    public void testSort(Student[] students, Student[] expectedOrder) {

        StringBuilder sb = new StringBuilder();

        for(Student student: students) {
            sb.append(student.getId() + "\n" + student.getFname() + "\n" + student.getCgpa() + "\n");
        }

        System.setIn( new ByteArrayInputStream((students.length + "\n" + sb.toString()).getBytes()));
        System.out.println("System.in():\n" + students.length + "\n" + sb.toString());

        Sort.main(new String[]{});

        for(int i = 0; i < expectedOrder.length; i++) {
            Assert.assertEquals(Sort.studentList.get(i).getFname(), expectedOrder[i].getFname());
            Assert.assertEquals(Sort.studentList.get(i).getCgpa(), expectedOrder[i].getCgpa());
            Assert.assertEquals(Sort.studentList.get(i).getId(), expectedOrder[i].getId());
        }


    }
}


