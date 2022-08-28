package Module10;

import javax.imageio.IIOException;
import java.io.*;
import java.util.*;

public class Words {
    private static final String RELATIVE_PATH = "src/Module10/words.txt";
    public static void main(String[] args) throws FileNotFoundException {
        String str = "";
        File file = new File(RELATIVE_PATH);

        try (FileWriter writer = new FileWriter(file))
        {
            String text = "the day is sunny the the\n" +
                            "the sunny is is";
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (FileReader reader = new FileReader(file)) {
            int c;
            while ((c = reader.read()) != -1) {
                str += (char) c;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String str1 = str.replace("\n", " ");
        String[] words = str1.split(" ");

        List<String> list = Arrays.asList(words);
        Set<String> distinct = new HashSet<>(list);
        for (String s: distinct) {
            System.out.println(s + ": " + Collections.frequency(list, s));
        }
    }
}
