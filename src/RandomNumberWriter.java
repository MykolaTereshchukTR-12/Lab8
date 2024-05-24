import java.io.*;
import java.util.Random;

public class RandomNumberWriter {
    public void userInput(int minRange, int maxRange) {
        if (minRange >= maxRange) {
            System.out.println("Error: min range should be less than max range.");
        }
    }

    public void numberRandomizer(File fileName, int minRange, int maxRange, int count) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Mykola\\Desktop\\" + fileName + ".txt"));
            writer.write("Your min range: " + minRange + ". Your max range: " + maxRange + "\n");

            Random random = new Random();
            for (int i = 1; i < count + 1; i++) {
                int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
                writer.write(randomNumber + "\t");
                if(i % 15 == 0) { writer.write("\n"); }
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void infoReader(File fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Mykola\\Desktop\\" + fileName + ".txt"));
            String line;

            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
