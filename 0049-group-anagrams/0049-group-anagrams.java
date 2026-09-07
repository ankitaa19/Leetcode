import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        // Check for empty inputs
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> frequencyStringsMap = new HashMap<>();

        for (String str : strs) {

            String frequencyString = getFrequencyString(str);

            // If frequency string is already present
            if (frequencyStringsMap.containsKey(frequencyString)) {

                frequencyStringsMap.get(frequencyString).add(str);

            } else {

                // Create a new list
                List<String> strList = new ArrayList<>();

                strList.add(str);

                frequencyStringsMap.put(frequencyString, strList);
            }
        }

        return new ArrayList<>(frequencyStringsMap.values());
    }


    private String getFrequencyString(String str) {

        // Frequency buckets
        int[] freq = new int[26];

        // Count frequency of each character
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        // Create frequency string
        StringBuilder frequencyString = new StringBuilder("");

        char c = 'a';

        for (int i : freq) {

            frequencyString.append(c);
            frequencyString.append(i);

            c++;
        }

        return frequencyString.toString();
    }
}