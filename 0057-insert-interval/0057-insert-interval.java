class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // int start =newInterval[0];
        // ArrayList <int[]> res=new ArrayList<>();
        // boolean insert=false;
        // for(int i=0;i<intervals.length;i++){
        //     if(insert == false && intervals[i][0] > start ){
        //         res.add(newInterval);
        //         insert=true;
        //     }
        //     res.add(new int []{intervals[i][0],intervals[i][1]});
        //     }
        //             if (!insert) {
        //     res.add(newInterval);
        // }

        //     int [][] output=res.toArray(new int [res.size()][2]);
        //      ArrayList <int[]> out=new ArrayList<>();
        //     int s=output[0][0];
        //     int e=output[0][1];
        //     for(int i=1;i< output.length;i++){
        //         if(output[i][0]<= e){
        //             e=Math.max(output[i][1] ,e);
        //         }else{
        //             out.add(new int[]{s,e});
        //             s=output[i][0];
        //             e=output[i][1];
        //         }
        //     }
        //     out.add(new int[]{s,e});
        // return out.toArray(new int [out.size()][2]);

        ArrayList<int[]> res = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        res.add(newInterval);

        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][2]);
    }
}