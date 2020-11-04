package Arrays;

public class RobotBoundedInCircle {
}

class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs ={{0,1}, {1,0}, {0,-1}, {-1,0}};
        // N = 0, E = 1, S = 2, W = 3
        int dir=0; // North
        int x=0, y=0;
        for(char ch:instructions.toCharArray()){
            if(ch=='R'){
                dir = (dir+1) % 4;
            }
            else if(ch=='L'){
                dir = (dir+3) % 4;
            }
            else {
                x+=dirs[dir][0];
                y+=dirs[dir][1];
            }
        }
        return (x==0 && y==0 ) || dir>0;
    }
}