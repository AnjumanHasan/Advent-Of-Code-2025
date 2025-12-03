package day2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import Utils.utils;

public class day_2
{
    public static void main(String[] args)
    {
        try(BufferedReader br = new BufferedReader(new FileReader(utils.INPUT_FILENAME))){
            utils.initializeOutputStream();
            ArrayList<ArrayList<Long>> list = new ArrayList<>(); 
            String input = br.readLine();
            
            Arrays.stream(input.split(","))
                .forEach((element) -> {
                    String[] ranges = element.split("-");
                    ArrayList<Long> temp = new ArrayList<>();
                    temp.add(Long.parseLong(ranges[0]));
                    temp.add(Long.parseLong(ranges[1]));
                    list.add(temp);
                });

            long sum = sumOfInvalidIDs(list);
            System.out.printf("\nAnswer : %d\n", sum);
            
        } catch(Exception e) {
            System.out.printf("\nException occured : %s\n", e.getMessage());
        }
       
    }

    private static long sumOfInvalidIDs(ArrayList<ArrayList<Long>> list) {
        AtomicLong sum = new AtomicLong(0);
        list.forEach(range -> {
            long start = range.get(0);
            long end = range.get(1);
            for(long i = start;i<=end;i++)
            {
                if(isInvalid(i))
                {
                    utils.out.printf("Invalid Num : %d\n", i);
                    sum.addAndGet(i);
                }
            }
        });
        return sum.get();
    }

    private static boolean isInvalid(long num)
    {
        String s = Long.toString(num);
        if(s.length()%2==1)
            return false;

        long first = Long.parseLong(s.substring(0,s.length()/2));
        long second =  Long.parseLong(s.substring(s.length()/2, s.length()));
        return first==second;
    }
}