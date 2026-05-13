class Solution {
    public List<Integer> findGoodIntegers(int n) {
        List<Integer> list=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
         HashSet<Integer> visited=new HashSet<>();
         int limit=(int)Math.cbrt(n);
         for(int i=1;i<=limit;i++){
            for(int j=i;j<=limit;j++){
                int icube=i*i*i;
                int jcube=j*j*j;
                int cubeSum=icube+jcube;
                if(cubeSum>n)break;
                if(set.contains(cubeSum)&&!visited.contains(cubeSum)){
                    list.add(cubeSum);
                    visited.add(cubeSum);
                }
                set.add(cubeSum);
            }
         }
         Collections.sort(list);
         return list;
    }
}