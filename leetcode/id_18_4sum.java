class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashMap<Long, Integer> numberPresent = new HashMap<Long, Integer>();
        List<List<Integer>> sol = new LinkedList<List<Integer>>();
        int index = 0;

        Arrays.sort(nums); 

        for (int num: nums)
        {
            numberPresent.put(Long.valueOf(num), index++);
        }
        
        for (int i = 0; i < nums.length; ++i)
        {               
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            for (int j = i + 1; j < nums.length; ++j)
            {   
                if ( j > i + 1 && nums[j] == nums[j-1])
                    continue;

                for (int k = j + 1; k < nums.length; ++k)
                {   
                    if ( k > j + 1 && nums[k] == nums[k-1])
                        continue;

                    Long sum = Long.valueOf(target);
                    sum -= nums[i];
                    sum -= nums[j];
                    sum -= nums[k];

                    Integer lastNum = numberPresent.get(sum);

                    if (lastNum != null && lastNum > k )
                    {   
                        List<Integer> partialSol = new LinkedList<Integer>();
                        partialSol.add(nums[i]); 
                        partialSol.add(nums[j]);
                        partialSol.add(nums[k]);

                        partialSol.add(sum.intValue());
                        sol.add(partialSol);
                    }
                }
            }
        }

        return sol;

    }
}