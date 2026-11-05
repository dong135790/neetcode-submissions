class Solution {
    //  [1, 1, 2, 8]
    //  [48, 24, 6, 1]
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) { 
                prefix[i] = 1;
            } else {
                prefix[i] = prefix[i - 1] * nums[i - 1];
            }
            // System.out.println(prefix[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                suffix[i] = 1;
            } else {
                suffix[i] = suffix[i + 1] * nums[i + 1];
            }
            // System.out.println(suffix[i]);
            
        }

        for (int i = 0; i < nums.length; i ++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}  
