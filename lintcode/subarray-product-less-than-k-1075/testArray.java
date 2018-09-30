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
    
    //ÿһ��ѭ����������rightλ����ˣ��˻�product���С��k,�����ӵ�������������Ŀ�� right-left+1����
    //���㷽���Ǵ�right��left��ϣ����������顣���������right������������顣
    //���product���ڵ���k,��left��Ҫ�����ƣ���Ϊ��ǰleft,right֮����ʵ��������Ѽ����ꡣ���������ֱ�ӳ���left��ֵ��Ȼ��left+1��ѭ���������˻�С��k��
    //���ӵ�������������Ŀ����Ȼ��right-left+1��,��Ϊ�Ǵ�rightλ�ÿ�ʼ������㣬����߳�rightλ��ǰ�Ѽ����ꡣ
    //������������������ԣ���������Ӧ���ǱȽ�ֱ�۵Ľ��������
    //���Ƕ��ڸ��˶��ԣ��������ڷ�������ѵ��ǣ����ڵ����ұ߽�ı��ʱ����ʲô�����ڻ���ʱ�Ƿ����©�ⷨ��
    //�ڱ������У��Ҵ��ڱ߽��ƶ���������ĳ��ȣ���ΪҪ�ҵ����������е����������顣
    //�󴰿ڱ߽��ƶ��������ǣ�������߽�߽�������Ѿ�������Ҫ���������ƶ�������©�ⷨ����Ϊ����Ŀ��ˣ����ұ߽�һ���ģ��Ǵ�����Ŀ��˼��㡣ÿ�μ��㶼��������󣬰�����߽硣
    //��ʵ���ڸ�����˵����ϰ���ڴ���˹̶����ҷ������⣬��Ҫ����˼ά��ʽ��
    //������������ֵ���ڵ���k�ļ�����������ǲ�Ӱ�졣��ʱleft�ᳬ��right����һ��ѭ��ʱԽ����ֵΪͬһ��λ�á�
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