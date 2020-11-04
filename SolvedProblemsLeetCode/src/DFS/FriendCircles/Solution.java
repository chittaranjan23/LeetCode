package DFS.FriendCircles;

// Stright forward solution calculate number of connected components
//Do a dfs and marked as connected nodes as visited and Increment count

import java.util.LinkedList;
import java.util.Queue;

//DFS implementation
class Solution {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(visited, i, M);
            }
        }
        return count;
    }

    public void dfs(boolean[] visited, int i, int[][] M) {
        for (int j = 0; j < M[0].length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(visited, j, M);
            }
        }
    }
}


class Solution_BFS {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                queue.offer(i);
                count++;
                while (!queue.isEmpty()) {
                    int index = queue.poll();
                    visited[index] = true;
                    count++;
                    for (int j = 0; j < M[0].length; j++) {
                        if (M[index][j] == 1 && !visited[j]) {
                            queue.offer(j);
                        }
                    }
                }
            }
        }
        return count;
    }
}
