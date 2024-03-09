package PracticePrograms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static void main(String[] args) {
        String path = "testdata.csv";
        List<UserDetails> users = readUsersFromCSV(path);

        // Print the list of users
        for (UserDetails u : users) {
            System.out.println(u);
        }
    }

    private static List<UserDetails> readUsersFromCSV(String fileName) {
        List<UserDetails> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Read the first line from the text file which will be header
            String line;

            // Loop until all lines are read
            while ((line = br.readLine()) != null) {
                String[] attributes = line.split(",");

                if (attributes.length > 2) {
                    UserDetails user = createUser(attributes);
                    users.add(user);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return users;
    }

    private static UserDetails createUser(String[] metadata) {
        String name = metadata[0];
        String email = metadata[1];
        int age = Integer.parseInt(metadata[2]);

        // Create and return a user of this metadata
        return new UserDetails(name, email, age);
    }
}
