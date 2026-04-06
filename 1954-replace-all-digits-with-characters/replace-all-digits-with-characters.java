class Solution {
    public String replaceDigits(String s) {
        StringBuilder result = new StringBuilder();
        char lastChar = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                result.append(c);
                lastChar = c;
            } else {
                int shift = c - '0';
                result.append((char)(lastChar + shift));
            }
        }
        return result.toString();
    }
}