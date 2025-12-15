package Day4;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import Utils.utils;

public class PrintingDept {
   static PrintStream out = utils.initializeOutputStream();
    public static void main(String args[]) {

        try {
            ArrayList<String> grid = utils.prepareMatrix();
            ArrayDeque<int[]> deque = new ArrayDeque();
            for (int i = 0; i < grid.size(); i++) {
                for (int j = 0; j < grid.get(i).length(); j++) {
                    char element = grid.get(i).charAt(j);
                    if (element == '@' && countRolls(i, j, grid.size(), grid.get(i).length(), grid) < 4) {
                        deque.add(new int[] { i, j });
                    }
                }
            }
            System.out.println("First Count is : " + deque.size());
            int ans = removeRolls(grid, deque);
            System.out.println("First Count is : " + deque.size());
            System.out.println("Second Count is : " + ans);
        } catch (Exception e) {
            System.out.println("Exception ocurred : " + e);
            e.printStackTrace();
        }

    }

    private static int countRolls(int i, int j, int rows, int cols, ArrayList<String> grid) {
        int[][] directions = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
        int count = 0;
        for (int[] arr : directions) {
            int new_i = i + arr[0];
            int new_j = j + arr[1];
            if (utils.isInGrid(new_i, new_j, rows, cols)) {
                if (grid.get(new_i).charAt(new_j) == '@') {
                    count++;
                }
            }
        }
        return count;
    }

    public static int removeRolls(ArrayList<String> grid, ArrayDeque<int[]> deque) {
        int ans = 0;
        while (!deque.isEmpty()) {
            int[] a = deque.poll();
            int i = a[0];
            int j = a[1];
            if(grid.get(i).charAt(j)!='@')
            {
                continue;
            }
            String tmp = grid.get(i).substring(0, j) + 'x' + grid.get(i).substring(j + 1);
            out.printf("Temp String at %d %d : %s\n", i,j, tmp);
            grid.set(i, tmp);
            ans++;
            for (int[] arr : utils.directions) {
                int new_i = i + arr[0];
                int new_j = j + arr[1];
                if (utils.isInGrid(new_i, new_j, grid.size(), grid.get(0).length())) {
                    char element = grid.get(new_i).charAt(new_j);
                    if (element == '@' && countRolls(new_i, new_j, grid.size(), grid.get(0).length(), grid) < 4) {
                        deque.add(new int[] { new_i, new_j });
                    }
                }
            }
        }

        return ans;
    }
}