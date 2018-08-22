import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import String.*;
public class AnagramTests {

    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
                {"anagram", "margana", true, ""},
                {"anagram", "margan", false, ""},
                {"abba", "baba", true, ""},
                {"", "", true, "Input shold be in range of n >=1 && n <= 50"},
                {"a", "a", true, ""},
                {"a", "b", false, ""},
                {"a", "b", false, ""},
                {"молоко", "молоко", true, "Only English letters can be used"},
        };
    }

    @Test(dataProvider = "testData")
    public void testAnagram(String one, String two, boolean isAnagram, String message) {
        Anagrams anagrams = new Anagrams();
        boolean isTrue = false;
        try {
            isTrue = anagrams.isAnagram(one, two);
            Assert.assertTrue(isTrue == isAnagram);

        } catch (Throwable ex) {
            Assert.assertEquals(ex.getMessage(), message);
        }
    }
}
