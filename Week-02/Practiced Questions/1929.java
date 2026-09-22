class Solution {
    public int[] getConcatenation(int[] nums) {
        int b=2*(nums.length);
        int[] a=new int[b];
        for(int i=0;i<b;i++){
            if(i<nums.length){
                a[i]=nums[i];
            }
            else{
                a[i]=nums[i-nums.length];
            }
        }
        return a;
    }
}