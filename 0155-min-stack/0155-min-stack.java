class MinStack {
    Stack<Integer > st;
    Stack<Integer > minValue;
    public MinStack() {
        st=new Stack<>();
        minValue = new Stack<>();
    }
    
    public void push(int value) {
        st.push(value);
        if(minValue.isEmpty()){
            minValue.push(value);
        }else{
            minValue.push(Math.min(minValue.peek(),value));
        }
    }
    
    public void pop() {
        st.pop();
        minValue.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minValue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */