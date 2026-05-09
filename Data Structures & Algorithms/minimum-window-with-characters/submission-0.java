class Solution {

    public String minWindow(String s, String t) {

        int[] need = new int[128];
        for (char ch : t.toCharArray()) {
            need[ch]++;
        }

        int left = 0;
        int matched = 0;

        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);
            if (need[rightChar] > 0)  {
                matched++;
            }
            need[rightChar]--;

            while (matched == t.length()) {

                if (right - left + 1 < minLen) {

                    minLen = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);

                need[leftChar]++;

                if (need[leftChar] > 0) {
                    matched--;
                }

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(startIndex, startIndex + minLen);
    }
}