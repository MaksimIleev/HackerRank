import data_structures_algorithms.Stack.Paranthesis;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

public class BalancedParanthesisTest {

    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
                {"", true},
                {" ", true},
                {"{}", true},
                {"[]", true},
                {"()", true},
                {"{[()]}", true},
                {"{ [ ( )]}", true},
                {"{[}", false},
                {"{{", false},
                {" ]", false},
        };
    }

    @Test(dataProvider = "testData")
    public void testBalancedMain(String input, boolean isBalanced) {
        System.out.println("'" + input + "'" + " isBalanced?");

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Paranthesis paranthesis = new Paranthesis();

        Assert.assertEquals(isBalanced, paranthesis.isBalanced(input));
    }


}
