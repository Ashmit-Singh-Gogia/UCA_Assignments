package Sorting.Rank_Teams_By_Votes;

import java.util.*;

public class Rank_Teams_By_Votes {

    // APPROACH 1: Using 2D array + custom comparator on Arrays.sort()
    public String rankTeams(String[] votes) {
        int ranks = votes[0].length();
        int[][] rankData = new int[26][ranks + 1];
        for (String vote : votes) {
            for (int i = 0; i < ranks; i++) {
                char ch = vote.charAt(i);
                rankData[ch - 'A'][i]++;
            }
        }

        for (int i = 0; i < 26; i++) {
            rankData[i][ranks] = i;
        }
        Arrays.sort(rankData, (e1, e2) -> {
            for (int i = 0; i < ranks; i++) {
                if (e1[i] != e2[i]) {
                    return Integer.compare(e2[i], e1[i]);
                }
            }
            return Integer.compare(e1[ranks], e2[ranks]);
        });

        // Form the result string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ranks; i++) {
            char ch = (char) (rankData[i][ranks] + 'A');
            sb.append(ch);
        }

        return sb.toString();
    }
}
