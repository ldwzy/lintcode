import java.util.Arrays;
import java.util.*;


public class testArray{
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Time limit  Exceeded !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        // Write your code here
        if(k<=1)return 0;
        
        int count = 0;
        int product;
         
        for(int i=0;i<nums.length;i++){
            if(nums[i] >= k)continue;
            product = nums[i];
            count += 1;
            for(int j=i+1;j<nums.length;j++){
                product = product*nums[j];
                if(product<k)count++;
                else break;
            }    
        }
        
    return count;      
    }
    
    //每一个循环都向数组right位置相乘，乘积product如果小于k,则增加的连续子数组数目是 right-left+1个。
    //计算方法是从right向left组合，计算子数组。即必须包含right，向左的子数组。
    //如果product大于等于k,则left需要向右移，因为当前left,right之间合适的子数组已计算完。具体操作是直接除掉left的值，然后left+1。循环操作至乘积小于k。
    //增加的连续子数组数目是仍然是right-left+1个,因为是从right位置开始向左计算，且左边乘right位置前已计算完。
    //对于连续的子数组而言，滑动窗口应该是比较直观的解决方法。
    //但是对于个人而言，滑动窗口法的理解难点是，窗口的左右边界改变的时机是什么，窗口滑动时是否会遗漏解法。
    //在本问题中，右窗口边界移动依据数组的长度，因为要找到整个数组中的连续子数组。
    //左窗口边界移动的依据是，包括左边界边界的数组已经不符合要求。且向右移动不会遗漏解法，因为计算的开端，左右边界一样的，是从数组的开端计算。每次计算都会从右向左，包括左边界。
    //其实对于个人来说，仍习惯于从左端固定向右分析问题，需要打破思维定式。
    //另有数组中有值大于等于k的极端情况，但是不影响。此时left会超过right，下一个循环时越过该值为同一个位置。
    public int numSubarrayProductLessThanK_2(int[] nums, int k) {
        
        // Write your code here
        
        if(k<=1)return 0;
        int count = 0;
        int product = 1;
        int right = 0, left = 0;
        
        for(right=0;right<nums.length;right++){
            product = product * nums[right];
            while(product>=k){
                product = product / nums[left];
                left++;
            }                
            count += right - left + 1;            
        }    
        
        return count;      
    }
    
    public static void main(String[] args){
        int[] a = {10, 5, 2, 6};
        testArray t = new testArray();
        //System.out.println(t.numSubarrayProductLessThanK(a, 100));
        System.out.println(t.numSubarrayProductLessThanK_2(a, 100));
        System.out.println();
        
    }
    
}