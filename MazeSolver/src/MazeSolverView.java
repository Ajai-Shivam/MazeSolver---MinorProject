import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MazeSolverView extends JFrame{
    private JButton Solve;
    private final int [][] maze = {{1,1,1,1,1,1,1,1,1,1,1,1,1},{1,0,1,0,1,0,1,0,0,0,0,0,1},{1,0,1,0,1,0,1,0,0,0,0,0,1},{1,0,1,0,0,0,1,0,1,1,1,0,1},{1,0,1,1,1,1,1,0,0,0,0,0,1},
            {1,0,0,1,0,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,0,0,1},

            {1,0,1,0,1,0,0,0,1,1,1,0,1},

            {1,0,1,0,1,1,1,0,1,0,1,0,1},

            {1,0,0,0,0,0,0,0,0,0,1,9,1},

            {1,1,1,1,1,1,1,1,1,1,1,1,1}};

    private List<Pair> path = new ArrayList<>();

    MazeSolverView(){
        this.setTitle("Maze Solver");
        this.setVisible(true);
        this.setBounds(100,100,640,720);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        DFSSolving dfsSolving = new DFSSolving();
        boolean[][] visted = new boolean[maze.length][maze[0].length];
        dfsSolving.DFSAlgo(1,3,path,visted,maze);
        for (int i = 0; i < path.size(); i++) {
            System.out.println(path.get(i).x+"    "+path.get(i).y);
        }
    }


    @Override
    public void paint(Graphics g) {
        g.translate(100,50);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                Color color ;
                switch (maze[i][j]){
                    case 1: color = Color.ORANGE;
                        break;
                    case 9: color = Color.green;
                        break;
                    default:
                        color= Color.white;

                }
                g.setColor(color);
                g.fillRect(30*j,30*i,30,30);
                g.setColor(Color.black);
                g.drawRect(30*j,30*i,30,30);
                
            }
        }
        for (int i = 0; i < path.size(); i++) {
            int x = path.get(i).x;
            int y = path.get(i).y;

            g.setColor(Color.RED);
            g.fillOval(30*y,30*x,20,20);
        }
    }

    public static void main(String[] args) {
        MazeSolverView appView = new MazeSolverView();
    }
}
class Pair{

    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
