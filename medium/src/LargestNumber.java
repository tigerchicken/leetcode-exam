import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestNumber {
    //其实就是一个排序问题，对于a，b谁排在前面，其实只需要比较a+b和b+a谁大就行了
    public static String largestNumber(int[] nums) {
        /**
         * 注意这里对基本数据类型发进行重写时会出错，Arrays.sort重写Comparator，不可以用基本类型数组，当然也就不能用int[]数组
         *
         * Arrays.sort(nums, new Comparator<Integer >() {
         *             @Override
         *             public int compare(Integer o1, Integer o2) {
         *                 return 0;
         *             }
         *         });
         */
        //首先定义一个Integer数组，复制nums
        Integer a[]=new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            a[i]=nums[i];
        }
        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //返回字符串ab和ba的比较结果
                return -(o1+""+o2).compareTo(o2+""+o1);
            }
        });
        String rs="";
        for(Integer k:a){
            rs=rs+k;
        }
        //特殊情况处理
        if(a[0]==0&&a[nums.length-1]==0){
            rs="0";
        }
        return rs;
    }

    public static void main(String[] args) {
        int []nums={10,2};
        System.out.println(largestNumber(nums));

    }
}
