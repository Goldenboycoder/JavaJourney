/*
 * https://leetcode.com/problems/number-of-islands/description/
 * 
 */


package Exercises.Extra;



import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    public static void dfs(char[][] grid, char[][] visited, int row, int col) {
        // set as visited
        visited[row][col] = '1';
        int length = grid.length;
        int width = grid[0].length;

        int[] rowinc = new int[] { -1, 0, 1, 0 };
        int[] colinc = new int[] { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            int newRow = row + rowinc[i];
            int newCol = col + colinc[i];
            if (newRow >= 0 && newRow < length &&
                    newCol >= 0 && newCol < width &&
                    visited[newRow][newCol] == '0' &&
                    grid[newRow][newCol] == '1') {
                dfs(grid, visited, newRow, newCol);
            }
        }
    }

    public static class Pair{
        public int row;
        public int col;

        public Pair(int i,int j){
            row = i;
            col=j;
        }
    }

    public static void bfs(char[][] grid, char[][] visited, int row, int col){
        Deque<Pair> stack = new ArrayDeque<Pair>();
        visited[row][col] = '1';
        int length = grid.length;
        int width = grid[0].length;

        int[] rowinc = new int[] { -1, 0, 1, 0 };
        int[] colinc = new int[] { 0, 1, 0, -1 };

        
        stack.add(new Pair(row,col));
        try {
            while(!stack.isEmpty()){
            Pair ele = stack.pollLast(); // use popFirst  stack.pollFirst() so that it becomes dfs but iterative
            
            for (int i = 0; i < 4; i++) {
                int newRow = ele.row + rowinc[i];
                int newCol = ele.col + colinc[i];

                if (newRow >= 0 && newRow < length &&
                        newCol >= 0 && newCol < width &&
                        visited[newRow][newCol] == '0' &&
                        grid[newRow][newCol] == '1') {

                    stack.add(new Pair(newRow, newCol));
                    visited[newRow][newCol] = '1';
                }
            }

        }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        

    }

    public static int numIslands(char[][] grid) {
        if(grid.length == 0 ){
            return 0;
        }
            

        int rows = grid.length;
        int cols = grid[0].length;

        char[][] visited = new char[rows][cols];
        for (char[] col : visited) { // mark all as not visited
            Arrays.fill(col, '0');
        }
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (
                    visited[r][c] == '0' &&
                    grid[r][c] == '1') 
                {
                    count++;

                    dfs(grid, visited, r, c);


                }
            }
        }
        return count;

    }

    // [[1,2,3,4],[2,1,3,4],[3,1,2,4],[4,1,2,3]]

    public static void main(String[] args) {
        char[][] grid = new char[][]{
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        int res = numIslands(grid);
        System.out.println(res);
    }

}