class Solution {
    public int[] scoreValidator(String[] events) {
        int n=events.length;
        int score=0,counter=0;
        for(int i=0;i<n;i++){
            if(counter==10)return new int[]{score,counter};
             String s=events[i];
             if(s.equals("WD")||s.equals("NB")){
              score++;
            }
        
            else if(s.equals("W")){
                counter++;
            }
            else {
                int run=Integer.parseInt(events[i]);
                  if(run==1||run==2||run==3||run==4||run==6||run==0){
                     score+=run;
                    }
                 }
        }
        return new int[]{score,counter};
    }
}