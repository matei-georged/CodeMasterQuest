class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numberPresent = new HashMap<Integer, Integer>();
        Integer                   numIndex      = 0;

        for (Integer num : nums)
        {
            if (numberPresent.get(target - num) != null)
            {
                return new int[]{numIndex, numberPresent.get(target - num)};
            }
            numberPresent.put(num, numIndex++);
        }

        //or throw some exception here. Example: throw IOException("Input does not have a solution")
        return null;
    }
}
