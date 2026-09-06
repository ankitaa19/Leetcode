class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] count = new int[26];
        String letters = "abcdefghijklmnopqrstuvwxyz";

        // Count characters in magazine
        for (char c : magazine.toCharArray()) {
            int index = letters.indexOf(c);
            count[index]++;
        }

        // Use characters for ransomNote
        for (char c : ransomNote.toCharArray()) {
            int index = letters.indexOf(c);

            if (count[index] == 0) {
                return false;
            }

            count[index]--;
        }

        return true;
    }
}