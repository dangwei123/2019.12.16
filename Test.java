有 A 和 B 两种类型的汤。一开始每种类型的汤有 N 毫升。有四种分配操作：

提供 100ml 的汤A 和 0ml 的汤B。
提供 75ml 的汤A 和 25ml 的汤B。
提供 50ml 的汤A 和 50ml 的汤B。
提供 25ml 的汤A 和 75ml 的汤B。
当我们把汤分配给某人之后，汤就没有了。每个回合，我们将从四种概率同为0.25的操作中进行分配选择。如果汤的剩余量不足以完成某次操作，我们将尽可能分配。当两种类型的汤都分配完时，停止操作。

注意不存在先分配100 ml汤B的操作。

需要返回的值： 汤A先分配完的概率 + 汤A和汤B同时分配完的概率 / 2。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/soup-servings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public double soupServings(int N) {
        if(N>4800){
            return 1.0;
        }
        N=N/25+((N%25==0)?0:1);
        double[][] dp=new double[N+1][N+1];
        dp[0][0]=0.5;
        for(int i=1;i<N+1;i++){
            dp[0][i]=1;
            dp[i][0]=0;
        }
        for(int i=1;i<=N;i++){
            int a1=i-4>0?i-4:0;
            int a2=i-3>0?i-3:0;
            int a3=i-2>0?i-2:0;
            int a4=i-1>0?i-1:0;
            for(int j=1;j<=N;j++){
                int b1=j;
                int b2=j-1>0?j-1:0;
                int b3=j-2>0?j-2:0;
                int b4=j-3>0?j-3:0;
                dp[i][j]=0.25*(dp[a1][b1]+dp[a2][b2]+dp[a3][b3]+dp[a4][b4]);
            }
        }
        return dp[N][N];
    }
}

