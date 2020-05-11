/**
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例 1:
 *
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 * 注意:
 *
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 */
public class FindMaxAverage {
    public double findMaxAverage1(int[] nums, int k) {
        int num=Integer.MIN_VALUE;
        int []a=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                a[i]=nums[i];
            }else{
                a[i]=a[i-1]+nums[i];
            }
            if(i>=k){
                num=Math.max(num,a[i]-a[i-k]);
            }

        }
        num=Math.max(num,a[k-1]);
        return (double)(num)/k;

    }
    public double findMaxAverage(int[] nums, int k) {
        int num=0;
        int []a=new int[nums.length];
        for(int i=0;i<k;i++){
            num+=nums[i];
        }
        int rs=num;
        int i=k;
        while(i<nums.length) {
            num=num + nums[i] - nums[i - k];
            rs = Math.max(rs, num);
            i++;
        }
        return (double)(rs)/k;

    }
}
