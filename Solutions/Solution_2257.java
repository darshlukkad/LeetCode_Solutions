class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        int ans=m*n;
        for(int i=0;i<guards.length;i++) {
            grid[guards[i][0]][guards[i][1]]=2;
            ans--;
        }
        for(int i=0;i<walls.length;i++) {
            grid[walls[i][0]][walls[i][1]]=3;
            ans--;
        }
        for(int i=0;i<guards.length;i++) {
            for(int j=guards[i][1]+1;j<n;j++) {
                //System.out.println("i:"+i+" j:"+j+" ans:"+ans);
                if(grid[guards[i][0]][j]>1)
                    break;
                if(grid[guards[i][0]][j]!=1)
                    ans--;
                grid[guards[i][0]][j]=1;
            }
            //System.out.println("ans:"+ans+" i:"+i);
            for(int j=guards[i][1]-1;j>=0;j--) {
                if(grid[guards[i][0]][j]>1)
                    break;
                if(grid[guards[i][0]][j]!=1)
                    ans--;
                grid[guards[i][0]][j]=1;
            }
            //System.out.println("ans:"+ans+" i:"+i);
            for(int j=guards[i][0]-1;j>=0;j--) {
                System.out.println("i:"+i+" j:"+j+" ans:"+ans);
                if(grid[j][guards[i][1]]>1)
                    break;
                if(grid[j][guards[i][1]]!=1)
                    ans--;
                grid[j][guards[i][1]]=1;
            }
            //System.out.println("ans:"+ans+" i:"+i);
            for(int j=guards[i][0]+1;j<m;j++) {
                //System.out.println("i:"+i+" j:"+j);
                if(grid[j][guards[i][1]]>1)
                    break;
                if(grid[j][guards[i][1]]!=1)
                    ans--;
                grid[j][guards[i][1]]=1;
            }
            //System.out.println("ans:"+ans+" i:"+i);
        }
        return ans;
    }
}