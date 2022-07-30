class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       int n = nums.length;
       if (n == 0 || k == 0) {
          return new int[0];
       }
       int[] result = new int[n - k + 1]; // number of windows
       Deque<Integer> dq = new ArrayDeque<>(); // stores indices
  
       for (int i = 0; i < n; ++i) {
           // remove indices that are out of bound
          while (dq.size() > 0 && dq.peekFirst() <= i - k) {
            dq.pollFirst();
          }
           // remove indices whose corresponding values are less than nums[i]
          while (dq.size() > 0 && nums[dq.peekLast()] < nums[i]) {
            dq.pollLast();
           }
           // add nums[i]
           dq.offerLast(i);
           // add to result
           if (i >= k - 1) {
             result[i - k + 1] = nums[dq.peekFirst()];
           }
        }
        return result;
       
     }
}
