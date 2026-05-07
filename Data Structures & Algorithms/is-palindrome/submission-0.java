class Solution {
    public boolean isPalindrome(String s) {
        int i  = 0;
        int j = s.length() - 1;
        while(i<j){
            char ch = s.charAt(i);

if (!((ch >= 'A' && ch <= 'Z') ||
      (ch >= 'a' && ch <= 'z') ||
      (ch >= '0' && ch <= '9'))) {

    i++;
    continue;
}

ch = s.charAt(j);

if (!((ch >= 'A' && ch <= 'Z') ||
      (ch >= 'a' && ch <= 'z') ||
      (ch >= '0' && ch <= '9'))) {

    j--;
    continue;
}
            if((Character.toLowerCase(s.charAt(i)) !=
    Character.toLowerCase(s.charAt(j)))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
