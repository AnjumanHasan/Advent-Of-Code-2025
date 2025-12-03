package Day3;

import Utils.utils;
import java.io.BufferedReader;
import java.io.PrintStream;
public class Lobby {
 
 private static PrintStream out = utils.initializeOutputStream();
    public static void main(String[] args) {
        int sum = 0;

        try
        {
            BufferedReader reader = utils.initializeBufferedReader();
            long startTime = utils.getCurrentTime();
            String line = reader.readLine();
            while(line!=null)
            {
                int n = computeJoltage(line);
                sum+=n;
                line = reader.readLine();
            }
            long endTime = utils.getCurrentTime();
            out.printf("Answer is : %d\n" , sum);
            out.printf("Total time taken is : %d", endTime - startTime);
        }
        catch (Exception e)
        {
            System.out.println("Exception occurred e : " + e);
        }
    }
    private static int computeJoltage(String line)
    {
        int firstIndex = findMaxIndex(0,line.length()-1,line);
        int secondIndex;
        if(firstIndex==line.length()-1)
        {
         secondIndex = firstIndex;
         firstIndex = findMaxIndex(0, secondIndex-1, line);
        }
        else
        {
         secondIndex = findMaxIndex(firstIndex+1, line.length()-1, line);
        }
        int firstDigit = line.charAt(firstIndex);
        int secondDigit = line.charAt(secondIndex);
        return firstDigit*10+secondDigit;
    }

    private static int findMaxIndex(int start, int end, String line)
    {
        int maxNum = -1;
        int index=0;
        for(int i = start; i<=end; i++ )
        {
            int digit = line.charAt(i) - '0';
            if(digit>maxNum)
            {
                maxNum = digit;
                index = i; 
            }
        }
        return index;
    }
}
