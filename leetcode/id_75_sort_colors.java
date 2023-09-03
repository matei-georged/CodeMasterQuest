class Solution {
    public void sortColors(int[] nums) {
        int swap_min_index = 0;
        int swap_max_index = nums.length - 1;

        for (int i = 0; i <= swap_max_index; ++i) {

            switch (nums[i]) {
                case 0: {
                    this.swap(nums, swap_min_index, i);
                    swap_min_index++;
                    break;
                }
                case 2: {
                    this.swap(nums, swap_max_index, i);
                    swap_max_index--;
                    i--;
                }
                default:
            }
            ;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];

        nums[i] = nums[j];
        nums[j] = temp;
    }

}