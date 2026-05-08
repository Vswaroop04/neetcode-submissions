class Solution {

    public int lengthOfLongestSubstring(String s) {

        int i = 0;
        int j = 0;

        int maxLength = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {

            char ch = s.charAt(j);

            if (map.containsKey(ch)) {

                i = Math.max(i, map.get(ch) + 1);
            }

            map.put(ch, j);

            maxLength = Math.max(maxLength, j - i + 1);

            j++;
        }

        return maxLength;
    }
}