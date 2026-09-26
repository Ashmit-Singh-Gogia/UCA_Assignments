package Sorting.Rank_Teams_By_Votes;

public class Main {

    public static void main(String[] args) {
        Rank_Teams_By_Votes solution = new Rank_Teams_By_Votes();

        // Test 1: Standard case — C beats B on 2nd-position vote count
        // Expected: "ACB"
        String[] votes1 = {"ABC", "ACB", "ABC", "ACB", "ACB"};
        System.out.println("Test 1: Expected: ACB, Result: " + solution.rankTeams(votes1));

        // Test 2: Tie on first position, resolved by second position votes
        // Expected: "XWYZ"
        String[] votes2 = {"WXYZ", "XYZW"};
        System.out.println("Test 2: Expected: XWYZ, Result: " + solution.rankTeams(votes2));

        // Test 3: Single voter — output matches the single vote exactly
        // Expected: "ZMNAGUEDSJYLBOPHRQICWFXTVK"
        String[] votes3 = {"ZMNAGUEDSJYLBOPHRQICWFXTVK"};
        System.out.println("Test 3: Expected: ZMNAGUEDSJYLBOPHRQICWFXTVK, Result: " + solution.rankTeams(votes3));

        // Test 4: Only one team — trivially returns that team
        // Expected: "A"
        String[] votes4 = {"A", "A", "A"};
        System.out.println("Test 4: Expected: A, Result: " + solution.rankTeams(votes4));

        // Test 5: All voters agree on the same ranking
        // Expected: "BCA"
        String[] votes5 = {"BCA", "BCA", "BCA"};
        System.out.println("Test 5: Expected: BCA, Result: " + solution.rankTeams(votes5));

        // Test 6: Complete tie across all positions — alphabetical tiebreaker
        // Expected: "AB"
        String[] votes6 = {"AB", "BA"};
        System.out.println("Test 6: Expected: AB, Result: " + solution.rankTeams(votes6));

        // Test 7: Larger set — ties resolved at deeper positions
        // Expected: "ESFVIDJHMZ"
        String[] votes7 = {"FVSHJIEMEZ", "EIDSVJFHZM", "EIDSMJHVFZ", "EFHMDIJSVZ", "SFJEIDMHVZ"};
        System.out.println("Test 7: Expected: ESFVIDJHMZ, Result: " + solution.rankTeams(votes7));
    }

}
