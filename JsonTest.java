import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonTest {

    private static final String RELATIVE_PATH = "src/main/java/file1.txt";
    public static void main(String[] args) {
        File file1 = new File(RELATIVE_PATH);
        try (FileWriter writer = new FileWriter(file1))
        {
            String str1 = "name age\nalice 21\nryan 30";
            String str2 = str1.replace("name age", "");
            writer.write(str2);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        List<Person> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file1));
            String line = null;
            while ((line = reader.readLine()) != null) {
                int index = line.lastIndexOf(' ');
                if (index == -1) {
                } else {
                    String[] str = line.split(" ");
                    String name = str[0];
                    Integer age = Integer.parseInt(str[1]);
                    try {

                    } catch (NumberFormatException e) {

                    }
                    list.add(new Person(name, age));
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(list);
        System.out.println(json);

    }
}
