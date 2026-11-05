class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        prefix[0] = nums[0];
        postfix[nums.length - 1] = nums[nums.length - 1];
        int i = 1;
        int j = nums.length - 2;
        while (i < nums.length) {
            prefix[i] = nums[i] * prefix[i - 1]; 
            postfix[j] = nums[j] * postfix[j + 1];
            i++;
            j--;
        }
        int index = 0;
        while (index < nums.length) {
            if (index == 0) {
                result[index] = postfix[index + 1];
            } else if (index == nums.length - 1) {
                result[index] = prefix[index -  1];
            } else {
                result[index] = prefix[index - 1] * postfix[index + 1];
            }
            index++;
        }
        return result;
    }
}  
