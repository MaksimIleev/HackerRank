import org.testng.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import stdin_stdout.StdInOut;
import java.io.ByteArrayInputStream;

public class SystemInTest {

    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
                {"Hello world", "1", "2"},
                {"Hello world", "1", "2.0"},
                {"Hello world", "1.0", "2.0"}
        };
    }

    @Test(dataProvider = "testData")
    public void testSystemIn(String s, String i, String d) {
        System.setIn( new ByteArrayInputStream((s + "\n" + i + "\n" + d).getBytes()));

            StdInOut.main(new String[]{});
            Assert.assertEquals(StdInOut.intInput, Integer.parseInt(i));
            Assert.assertEquals(StdInOut.stringInput, s);
            Assert.assertEquals(StdInOut.doubleInput, Double.valueOf(d));

    }

}
