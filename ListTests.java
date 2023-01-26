import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ListTests {

    public class containsCharacter implements StringChecker {
        char character;
        public containsCharacter (char character) {
            this.character = character;
        }

        @Override
        public boolean checkString(String s) {
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == character) {
                    return true;
                }
            }

            return false;
        }
    }

    @Test
    public void filterTest () {
        List<String> input1 = 
            Arrays.asList(new String[]{"Apple", "Banana", "Carrot", "Dog"});
        StringChecker checkForA = new containsCharacter('a');
        
        String[] expected = {"Apple", "Banana", "Carrot"};
        assertArrayEquals(expected, ListExamples.filter(input1, checkForA).toArray());
    }

    @Test
    public void mergeTest() {
        List<String> input1 = 
            Arrays.asList(new String[]{"Apple", "Carrot"});
        List<String> input2 = 
            Arrays.asList(new String[]{"Banana", "Dog"});
        
        List<String> expected1 = Arrays.asList(new String[]{"Apple", "Banana", "Carrot", "Dog"});
        List<String> merged = ListExamples.merge(input1, input2);

        for (int i = 0; i < expected1.size(); ++i) {
            assertEquals(expected1.get(i), merged.get(i));
        }
    }

}