package Day4;

import java.io.BufferedReader;
import java.util.ArrayList;

import Utils.utils;

public class PrintingDept
{
  public static void main(String args[]) {

    try {
        ArrayList<String> grid = utils.prepareMatrix();
        int count = 0;
        for(int i=0;i<grid.size();i++)
        {
            for(int j = 0;j<grid.get(i).length();j++){
                char element = grid.get(i).charAt(j);
                if(element == '@'){
                    if(countRolls(i,j,grid.size(),grid.get(i).length(),grid)<4){
                        count++;
                    }
                        
                }
            }
        }

        System.out.println("Count is : " + count);
        
    } catch (Exception e) {
      
    }

  }

  private static int countRolls(int i, int j, int rows, int cols, ArrayList<String> grid){
    int[][] directions = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1},{1,-1}, {1,0},{1,1}};
    int count = 0;
    for(int[] arr : directions)
    {
        int new_i = i+arr[0];
        int new_j = j+arr[1];
        if(utils.isInGrid(new_i, new_j, rows, cols))
        {
            if(grid.get(new_i).charAt(new_j)=='@')
            {
                count++;
            }
        }
    }
    return count;
  }


}