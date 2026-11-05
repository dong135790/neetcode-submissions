class Solution {
    //  [1, 1, 2, 8]
    //  [48, 24, 6, 1]
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        prefix[0] = 1;
        suffix[nums.length -1] = 1;

        int i = 1;
        int j = nums.length - 2;

        while (i < nums.length) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
            suffix[j] = suffix[j + 1] * nums[j + 1];
            i++;
            j--;
        }

        for (i = 0; i < nums.length; i++) {
            // System.out.println(prefix[i]);/

            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}  
