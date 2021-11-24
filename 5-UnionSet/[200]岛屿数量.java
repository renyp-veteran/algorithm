//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 1411 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        UnionSet u = new UnionSet(grid.length * grid[0].length);
        int rowCapacity = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < rowCapacity; j++) {
                if (grid[i][j] == '0') continue;
                if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                    u.merge((i + 1) * rowCapacity + j, i * rowCapacity + j);
                }
                if (j + 1 < rowCapacity && grid[i][j + 1] == '1') {
                    u.merge(i * rowCapacity + j + 1, i * rowCapacity + j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < rowCapacity; j++) {
                if (grid[i][j] == '1' && u.get(i * rowCapacity + j) == i * rowCapacity + j) ans++;
            }
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

//    class UnionSet {
//        int[] fa;
//        int[] sizes;
//        int size;
//
//        public UnionSet(int size) {
//            this.size = size;
//            this.sizes = new int[size];
//            this.fa = new int[size];
//            for (int i = 0; i < size; i++) {
//                fa[i] = i;
//                sizes[i] = 1;
//            }
//        }
//
//        public int get(int x) {
//            if (x == fa[x]) return x;
//            int root = get(fa[x]);
//            fa[x] = root;
//            return root;
//        }
//
//        public void merge(int a, int b) {
//            System.out.println(a + " " + b);
//            int ffa = get(a);
//            int ffb = get(b);
//            if (ffa == ffb) return;
//            if (sizes[ffa] < sizes[ffb]) {
//                fa[ffa] = ffb;
//                sizes[ffb] += sizes[ffa];
//            } else {
//                fa[ffb] = ffa;
//                sizes[ffa] += sizes[ffb];
//            }
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
