package ru.komarov.generics;

public class NegativeMassiveFilter implements Filter<int[]>{
    public boolean test(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) return false;
        }
        return true;
    }
}
