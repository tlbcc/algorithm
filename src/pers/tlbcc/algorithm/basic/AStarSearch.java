package pers.tlbcc.algorithm.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author tlbcc
 * @description A星寻路
 * @date 2019-11-26 16:54
 */
public class AStarSearch {

    public static int[][] MAP = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
    };

    static class Grid {
        int x; // 横坐标
        int y; // 纵坐标
        int f; // h + g
        int g; // 从起点到当前点需要多少步
        int h; // 从当前点到终点需要多少步（不考虑障碍）
        Grid father; // 父节点

        public Grid(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void initGrid(Grid father, Grid end) {
            this.father = father;
            if (father != null) {
                this.g = father.g + 1;
            } else {
                this.g = 1;
            }
            this.h = Math.abs(this.x - end.x) + Math.abs(this.y - end.y);
            this.f = this.h + this.g;
        }
    }

    public static Grid aStarSearch(int[][] maze, Grid start, Grid end) {
        // 可达位置数组
        ArrayList<Grid> openList = new ArrayList<>();
        ArrayList<Grid> closeList = new ArrayList<>();
        // 将起点加入到openList
        openList.add(start);
        while (openList.size() > 0) {
            // 寻找F值最小的节点,作为当前节点
            Grid current = findMinGrid(openList);
            // 将当前节点加入closeList
            closeList.add(current);
            // 将当前节点从openList中删除
            openList.remove(current);
            // 寻找当前节点的邻居节点
            List<Grid> neighborList = findNeighbor(current, openList, closeList);
            // 将邻居节点加入到openList
            for (Grid grid : neighborList) {
                // 通过当前节点和终点初始化当前节点的father节点与f,g,h值
                grid.initGrid(current, end);
                openList.add(grid);
            }
            // 检查终点是否在openList中
            for (Grid grid : openList) {
                if (end.x == grid.x && end.y == grid.y) {
                    return grid;
                }
            }
        }
        // 未到达终点
        return null;
    }

    /**
     * 寻找最小F最小的节点
     */
    public static Grid findMinGrid(List<Grid> openList) {
        Grid min = openList.get(0);
        for (Grid grid : openList) {
            if (grid.f < min.f) {
                min = grid;
            }
        }
        return min;
    }

    public static List<Grid> findNeighbor(Grid current, List<Grid> openList, List<Grid> closeList) {
        ArrayList<Grid> neighborList = new ArrayList<>();
        // 上
        if (isVaildGrid(current.x, current.y - 1, openList, closeList)) {
            neighborList.add(new Grid(current.x, current.y - 1));
        }
        // 下
        if (isVaildGrid(current.x, current.y + 1, openList, closeList)) {
            neighborList.add(new Grid(current.x, current.y + 1));
        }
        // 左
        if (isVaildGrid(current.x - 1, current.y, openList, closeList)) {
            neighborList.add(new Grid(current.x - 1, current.y));
        }
        // 右
        if (isVaildGrid(current.x + 1, current.y, openList, closeList)) {
            neighborList.add(new Grid(current.x + 1, current.y));
        }
        return neighborList;
    }

    /**
     * 判断是否为边界节点，或为障碍物，或已存在openList中或者closeList中
     * @return
     */
    public static boolean isVaildGrid(int x, int y, List<Grid> openList, List<Grid> closeList) {
        if (y < 0 || y >= MAP.length) {
            return false;
        }
        if (x < 0 || x >= MAP[0].length) {
            return false;
        }
        // 是否有障碍物
        if (MAP[y][x] == 1) {
            return false;
        }
        if (containXY(openList, x, y)) {
            return false;
        }
        if (containXY(closeList, x, y)) {
            return false;
        }
        return true;
    }

    public static boolean containXY(List<Grid> list, int x, int y) {
        for (Grid grid : list) {
            if (grid.x == x && grid.y == y) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Grid end = aStarSearch(MAP, new Grid(1, 2), new Grid(5, 2));
        Stack<Grid> stack = new Stack<>();
        Grid temp = end;
        stack.push(temp);
        while (temp.father != null) {
            temp = temp.father;
            stack.push(temp);
        }
        while (!stack.empty()) {
            Grid tmp = stack.pop();
            System.out.println(String.format("%d, %d", tmp.x, tmp.y));
        }
    }
}
