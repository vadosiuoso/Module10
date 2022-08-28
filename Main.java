package Module10;
import java.io.*;

public class Main {
    private static final String RELATIVE_PATH1 = "src/Module10/file.txt";


    public static void main(String[] args) {
        final String regex1 = "^\\d\\d\\d\\-\\d\\d\\d\\-\\d\\d\\d\\d";
        final String regex2 = "\\(\\d\\d\\d\\)\\ \\d\\d\\d\\-\\d\\d\\d\\d";
        String str = "";
        File file = new File(RELATIVE_PATH1);
        try (FileWriter writer = new FileWriter(file))
        {
            String str1 = "987-123-4567\n" +
                    "123 456 7890\n" +
                    "(123) 456-7890";
            writer.write(str1);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (FileReader reader = new FileReader("file.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                str = str + (char) c;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String[] numbers = str.split("\n");
        for (int i = 0; i<numbers.length; i++){
            if (numbers[i].matches(regex1) || numbers[i].matches(regex2)){
                System.out.println(numbers[i]);
            }
        }



    }
}
