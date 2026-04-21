class Solution {
    public String toGoatLatin(String sentence) {
        String[] strs = sentence.split(" ");

        // StringBuilder to store increasing 'a's ("a", "aa", "aaa", ...)
        StringBuilder a = new StringBuilder("a");
        StringBuilder res = new StringBuilder();
        for (String str : strs) {

            StringBuilder sb = new StringBuilder();
            // If word starts with a vowel
            if (isVowel(str.charAt(0))) {
                sb.append(str);     
                sb.append("ma");
            }
            // If word starts with a consonant
            else {
                sb.append(str.substring(1));   // remove first character
                sb.append(str.charAt(0));      // move first character to end
                sb.append("ma");
            }
            // Append increasing 'a's based on word index
            sb.append(a);
            // Add transformed word to result with space
            res.append(" ").append(sb);

            // Increase 'a' count for next word
            a.append("a");
        }

        // Remove leading space and return
        return res.toString().trim();
    }

    // Helper method to check if a character is a vowel
    boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}