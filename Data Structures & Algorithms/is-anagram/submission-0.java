class Solution {
    public boolean isAnagram(String s, String t) {
        char[] st1 = s.toCharArray();
        char[] st2 = t.toCharArray();
        Arrays.sort(st1);
        Arrays.sort(st2);
        if(st1.length!=st2.length)return false;
        for(int i=0;i<st1.length;i++){
            if(st1[i]!=st2[i])return false;
        }
        return true;
    }
}
