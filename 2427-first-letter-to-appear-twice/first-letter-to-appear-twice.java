class Solution {
    public char repeatedCharacter(String s) {
        HashMap <Character , Integer> map = new HashMap<>();

        for(int i =0; i <s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i) , 0)+1);

            if (map.getOrDefault(s.charAt(i) , 0) == 2){
                return s.charAt(i);
            }
        }

       return '0';
    }
}