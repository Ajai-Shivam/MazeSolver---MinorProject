import java.util.List;

public class DFSSolving {
     static boolean found= false;
    int[] rowArray = {1,0,-1,0};
    int[] colArray = {0,1,0,-1};
    public void DFSAlgo(int x, int y, List<Pair> path, boolean[][] visted, int[][] maze) {
        if(maze[x][y] == 9){
            found = true;
            path.add(new Pair(x,y));
            return;
        }

        if(!found) {
            visted[x][y] = true;
            path.add(new Pair(x, y));

            for (int i = 0; i < rowArray.length; i++) {
                int nbrRow = x + rowArray[i];
                int nbrCol = y + colArray[i];

                if (nbrRow >= 0 && nbrRow < maze.length && nbrCol >= 0 && nbrCol < maze[0].length && !visted[nbrRow][nbrCol] && (maze[nbrRow][nbrCol] == 0 || maze[nbrRow][nbrCol] == 9)) {
                    DFSAlgo(nbrRow, nbrCol, path, visted, maze);
                    if (!found) {
                        path.remove(path.size() - 1);
                    }
                }

            }

            visted[x][y] = false;
        }

    }
}
