class Solution {
    List<String> list=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
       return helper(list,"",0,0,n);
    }

    public List<String> helper(List<String> list,String s, int open ,int close ,int n){
        if(s.length() == 2*n){
            list.add(s);
            return list;
        }

        if(open <n){
            helper(list,s+"(" ,open+1, close, n);
        }
        if(close< open ){
            helper(list,s+")" ,open,close+1,n);
        }

        return list;
    }
}