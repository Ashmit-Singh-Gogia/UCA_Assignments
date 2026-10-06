package DSU.Accounts_Merge;

import java.util.*;

class DSU {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    DSU(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public void union(int node1, int node2) {
        int ulmPNode1 = findP(node1), ulmPNode2 = findP(node2);
        if (ulmPNode1 == ulmPNode2)
            return;
        if (size.get(ulmPNode1) <= size.get(ulmPNode2)) {
            parent.set(ulmPNode1, ulmPNode2);
            size.set(ulmPNode2, size.get(ulmPNode1) + size.get(ulmPNode2));
        } else {
            parent.set(ulmPNode2, ulmPNode1);
            size.set(ulmPNode1, size.get(ulmPNode1) + size.get(ulmPNode2));
        }
    }

    public int findP(int node) {
        if (node == parent.get(node))
            return node;
        int p = findP(parent.get(node));
        parent.set(node, p);
        return p;
    }
}

public class Accounts_Merge {

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!map.containsKey(mail)) {
                    map.put(mail, i);
                } else {
                    if (dsu.findP(i) != dsu.findP(map.get(mail))) {
                        dsu.union(i, map.get(mail));
                    }
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dsu.findP(i) == i) {
                List<String> list = new ArrayList<>();
                for (String mail : map.keySet()) {
                    if (dsu.findP(map.get(mail)) == i) {
                        list.add(mail);
                    }
                }
                Collections.sort(list);
                list.add(0, accounts.get(i).get(0));
                ans.add(list);
            }
        }

        return ans;

    }
}
