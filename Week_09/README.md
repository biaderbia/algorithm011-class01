学习笔记
### 不同路径II
```java
    // 1.定义
    dp[i][j]为走到第i行j列位置包含的路径个数
    // 2.初始化首行和首列
    // 第一行的格子只可能是从开始一直横着走过来，所以最多有一种走法。如果前边有障碍物则路径个数是0；同理可初始化第一列数据。
    // 这里注意hasStone的初始值依赖obstacleGrid[0][0]而不是false
    boolean hasStone = obstacleGrid[0][0] == 1;
    for (int i = 1; i < m; i++) {
        if (obstacleGrid[i][0] == 1) {
            hasStone = true;
        } else if (!hasStone) {
            dp[i][0] = 1;
        }
    }
    // 3.动态方程
    if (obstacleGrid[i][j] == 1) { // 如果是障碍物，路径个数只能是0
        dp[i][j] = 0;
    } else { // 一般情况，可能从左边或者上边走过来，路径个数等于两种可能步数之和
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    }
```