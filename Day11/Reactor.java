package Day11;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import Day8.Playground;
import Utils.utils;

public class Reactor {
    private static PrintStream out = utils.initializeOutputStream();
    private static long ans = 0L;
    public static void main(String[] args) {
        try {
            long startTime = utils.getCurrentTime();
            
            long ans = utils.readInputAndSolve(Reactor::solve);

            long endTime = utils.getCurrentTime();
            out.printf("Asnwer : %d\n", ans);
            System.out.println("Answer : " + ans);
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            e.printStackTrace(out);
        }  
    }

    private static long solve(ArrayList<String> input)
    {
        HashMap<String, ArrayList<String>> adj = new HashMap<>();
        HashSet<String> visited = new HashSet<>();
        for(String line : input)
        {
            String[] parts = line.split(": ");
            adj.put(parts[0], Arrays.stream(parts[1].split(" ")).collect(Collectors.toCollection(ArrayList::new)));
        }
        ArrayList<String> currList = new ArrayList<>();
        boolean isdac = false;
        boolean isfft = false;
        dfs(adj, "svr", "out" , visited, currList, isdac, isfft);
        return ans;
    }

    private static void dfs(HashMap<String, ArrayList<String>> adj, String source, String target, HashSet<String> visited,  ArrayList<String> currList, boolean isdac, boolean isfft)
    {
        if(source.equals(target)) {
            // out.printf("%s\n", currList);
            if(isdac && isfft){
                ans++;
                return;
            }
        }
        if(!adj.containsKey(source))
            return;
        if(source.equals("dac")){
            isdac = true;
        } 
        if (source.equals("fft")) {
            isfft = true;
        }
        // out.printf("Source = %s\n", source);
        currList.add(source);
        visited.add(source);
        for(String v : adj.get(source))
        {
            if(!visited.contains(v))
            {
                // out.printf("From source %s to %s \n", source, v);
                dfs(adj, v, target, visited, currList, isdac, isfft);
            }
        }
        visited.remove(source);
        currList.remove(source);
        if(source.equals("dac")){
            isdac = false;
        } 
        if (source.equals("fft")) {
            isfft = false;
        }
    }
}
