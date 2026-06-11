class Solution {
    public int compress(char[] chars) {
         int i=0;
        int idx=0;
        while(i<chars.length){
            char curr=chars[i];
            int count=0;
            while(i<chars.length&&chars[i]==curr){
                count++;
                i++;
            }
            chars[idx++]=curr;
            if(count>1){
                String cnt=String.valueOf(count);
            for(char a:cnt.toCharArray()){
                chars[idx++]=a;
            }
         }
        }
        return idx;
    }
}