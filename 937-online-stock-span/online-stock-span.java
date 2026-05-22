class Pair{
    int f;
    int s;
    Pair(int f,int s){
        this.f=f;
        this.s=s;
    }
}

class StockSpanner {
   Stack<Pair> st;
   
    public StockSpanner() {
        st=new Stack<>();
    }
    
    public int next(int price) {
        int span=1;
        while(!st.isEmpty()&&st.peek().f<=price){
            span+=st.peek().s;
            st.pop();
        }
        st.push(new Pair(price,span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */