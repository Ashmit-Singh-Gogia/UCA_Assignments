package DSU.Accounts_Merge;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        // Test 1: Standard case with merging
        List<List<String>> accounts1 = Arrays.asList(
            Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
            Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
            Arrays.asList("Mary", "mary@mail.com"),
            Arrays.asList("John", "johnnybravo@mail.com")
        );
        System.out.println("Test 1:");
        System.out.println("Expected: [[John, john00@mail.com, john_newyork@mail.com, johnsmith@mail.com], [John, johnnybravo@mail.com], [Mary, mary@mail.com]]");
        System.out.println("Result:   " + Accounts_Merge.accountsMerge(accounts1));
        System.out.println();
        
        // Test 2: All distinct accounts
        List<List<String>> accounts2 = Arrays.asList(
            Arrays.asList("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"),
            Arrays.asList("Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"),
            Arrays.asList("Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"),
            Arrays.asList("Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"),
            Arrays.asList("Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co")
        );
        System.out.println("Test 2:");
        System.out.println("Expected: [[Ethan, Ethan0@m.co, Ethan4@m.co, Ethan5@m.co], [Fern, Fern0@m.co, Fern1@m.co, Fern5@m.co], [Gabe, Gabe0@m.co, Gabe1@m.co, Gabe3@m.co], [Hanzo, Hanzo0@m.co, Hanzo1@m.co, Hanzo3@m.co], [Kevin, Kevin0@m.co, Kevin3@m.co, Kevin5@m.co]]");
        System.out.println("Result:   " + Accounts_Merge.accountsMerge(accounts2));
        System.out.println();

        // Test 3: Multiple merges into one
        List<List<String>> accounts3 = Arrays.asList(
            Arrays.asList("Alex", "Alex5@m.co", "Alex2@m.co", "Alex0@m.co"),
            Arrays.asList("Alex", "Alex0@m.co", "Alex1@m.co", "Alex3@m.co"),
            Arrays.asList("Alex", "Alex3@m.co", "Alex4@m.co", "Alex6@m.co")
        );
        System.out.println("Test 3:");
        System.out.println("Expected: [[Alex, Alex0@m.co, Alex1@m.co, Alex2@m.co, Alex3@m.co, Alex4@m.co, Alex5@m.co, Alex6@m.co]]");
        System.out.println("Result:   " + Accounts_Merge.accountsMerge(accounts3));
        System.out.println();
    }
}
