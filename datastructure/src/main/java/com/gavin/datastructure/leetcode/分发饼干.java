package com.gavin.datastructure.leetcode;
/**
 * 解题思路
 * 因为饥饿度最小的孩子最容易吃饱，所以先满足了这个孩子之后，我们再采取同样的策略，考虑剩下孩子里饥饿度最小的孩子，直到没有满足条件的饼干存在。
 * 简而言之，这里的贪心策略是，给剩余孩子里最小饥饿度的孩子分配最小的能饱腹的饼干。 至于具体实现，因为我们需要获得大小关系，一个便捷的方法就是把孩子和饼干分别排序。 这样我们就可以从饥饿度最小的孩子和大小最小的饼干出发，计算有多少个对子可以满足条件。
 *
 * 作者：duan-xian-de-feng-zheng-3
 * 链接：https://leetcode-cn.com/problems/assign-cookies/solution/man-zu-hai-zi-li-zui-xiao-ji-e-du-de-hai-zi-fen-pe/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

import java.util.Arrays;


public class 分发饼干 {
    public static void main(String[] args) {
        int[] g = {1,3,2,3};
        int[] s = {1,3,2};
        System.out.println(findContentChildren(g,s));
    }

    public static int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);
        int child=0,cookie=0;
        while(child < children.length && cookie < cookies.length){
            if(children[child] <= cookies[cookie]) {
                child ++;
                cookie ++;
            }
        }
        return child;
    }

}
