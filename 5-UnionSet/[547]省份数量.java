//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 
// 👍 654 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionSet us = new UnionSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 0) continue;
                us.merge(i, j);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (us.get(i) != i) continue;
            ans++;
        }
        return ans;
    }

    class UnionSet {
        int[] fa;
        int size;
        int[] sizes;

        public UnionSet(int size) {
            this.size = size;
            this.sizes = new int[size];
            this.fa = new int[size];
            for (int i = 0; i < size; i++) {
                fa[i] = i;
                sizes[i] = 1;
            }
        }

        public int get(int x) {
            if (x == fa[x]) return x;
            int root = get(fa[x]);
            // 最短路径优化
            fa[x] = root;
            return root;
        }

        public void merge(int a, int b) {
            int ffa = get(a);
            int ffb = get(b);
            if (ffa == ffb) return;
            // 避免 树 退化为 链表 优化
            if (sizes[a] < sizes[b]) {
                fa[ffa] = ffb;
                sizes[b] += sizes[a];
            } else {
                fa[ffb] = ffa;
                sizes[a] += sizes[b];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
