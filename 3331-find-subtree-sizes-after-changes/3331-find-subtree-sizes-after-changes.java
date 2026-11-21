import java.util.*;
class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] children = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }
        int[] newParent = new int[n];
        int[] last = new int[26];
        int[] previous = new int[n];
        Arrays.fill(last, -1);
        int[] stack = new int[2 * n];
        int top = 0;
        stack[top++] = 0;
        while (top > 0) {
            int event = stack[--top];
            if (event < 0) {
                int u = ~event;
                last[s.charAt(u) - 'a'] = previous[u];
                continue;
            }
            int u = event;
            int c = s.charAt(u) - 'a';
            previous[u] = last[c];
            if (u == 0) {
                newParent[u] = -1;
            } else {
                newParent[u] = (last[c] == -1)
                        ? parent[u]
                        : last[c];
            }

            last[c] = u;
            stack[top++] = ~u;
            for (int v : children[u]) {
                stack[top++] = v;
            }
        }
        List<Integer>[] newChildren = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            newChildren[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            newChildren[newParent[i]].add(i);
        }
        int[] order = new int[n];
        top = 0;
        stack[top++] = 0;
        int index = 0;
        while (top > 0) {
            int u = stack[--top];
            order[index++] = u;
            for (int v : newChildren[u]) {
                stack[top++] = v;
            }
        }
        int[] answer = new int[n];
        Arrays.fill(answer, 1);

        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];

            if (newParent[u] != -1) {
                answer[newParent[u]] += answer[u];
            }
        }
        return answer;
    }
}