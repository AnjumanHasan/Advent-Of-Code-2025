package Day5;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

import Utils.utils;

public class Cafeteria {

    private static PrintStream out = utils.initializeOutputStream();
    
    public static void main(String[] args) {
        
        try
        {
            BufferedReader bufferedReader = utils.initializeBufferedReader();
            ArrayList<ArrayList<Long>> ranges = new ArrayList<>(); 
            ArrayList<Long> ingredients = new ArrayList<>();
            String line = bufferedReader.readLine();
            while(line!=null)
            {
                
                if(line.isEmpty())
                {
                    break;
                }
                // out.printf("Line : %s\n", line);
                String[] rangeArray = line.split("-");
                ranges.add(new ArrayList<Long>() {{
                    add(Long.parseLong(rangeArray[0]));
                    add(Long.parseLong(rangeArray[1]));
                }});
                line = bufferedReader.readLine();
            }
            if(line!=null && line.isEmpty())
            {
                line = bufferedReader.readLine();
                while (line!=null) {
                    ingredients.add(Long.parseLong(line));
                     line = bufferedReader.readLine();
                }
            }

            int freshCount = countFreshIngredients(ranges, ingredients);
            out.printf("Total Fresh Ingredients are : %d\n", freshCount);
            // out.printf("Ranges : %s \n Ingredients : %s\n", ranges, ingredients);
        }
        catch(Exception e)
        {
            System.out.println("Exception ocurred : " + e);
        }
       
    }

        private static int countFreshIngredients(ArrayList<ArrayList<Long>> ranges, ArrayList<Long> ingredients)
        {
            int count = 0;

            for (Long ingredient : ingredients) {
                boolean isFresh = false;
                for (ArrayList<Long> arr : ranges) {
                    if(ingredient>=arr.get(0) && ingredient<=arr.get(1))
                    {
                        isFresh = true;
                        break;
                    }
                }
                if(isFresh)
                    {
                        count++;
                    }   
            }
            return count;
        }
}