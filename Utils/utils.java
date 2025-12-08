package Utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;

public class utils {
    public static final String INPUT_FILENAME = "input.txt";
    public static final String OUTPUT_FILENAME = "output.txt";
    
    public static PrintStream initializeOutputStream() {
        try {
           return new PrintStream(Files.newOutputStream(Paths.get(OUTPUT_FILENAME)));
        } catch (Exception e) {
            System.err.printf("Error initializing output stream: %s%n", e.getMessage());
            return null;
        }
    }

    public static BufferedReader initializeBufferedReader() throws IOException
    {
        return new BufferedReader(new FileReader(INPUT_FILENAME));
    }

    public static long getCurrentTime()
    {
        return Instant.now().getNano()/1000;
    }

    public static ArrayList<String> prepareMatrix() throws IOException
    {
        BufferedReader bufferedReader = initializeBufferedReader(); 
        ArrayList<String> matrix = new ArrayList<>();
        String line = bufferedReader.readLine();
        while(line!=null){
            matrix.add(line);
            line = bufferedReader.readLine();
        }

        return matrix;
    } 

    public static boolean isInGrid(int i, int j, int rows, int cols)
    {
        if(i>=0 && i<rows && j>=0 && j <cols)
        {
            return true;
        }
        return false;
    }
}