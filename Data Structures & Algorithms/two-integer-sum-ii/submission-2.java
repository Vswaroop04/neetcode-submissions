class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int j = numbers.length - 1;
        while(0<j){
            if(numbers[0] + numbers[j] == target){
                return new int[]{1, j+1};
            }
            int difference = target - numbers[j];
            for(int a = 0; a<j ; a++){
                if(numbers[a] + numbers[j] == target){
                    return new int[]{a + 1, j + 1};
                }
            }
            j--;
        }
        return new int[]{0,0};
    }
}
