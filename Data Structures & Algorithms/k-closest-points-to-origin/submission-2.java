class Solution {
    public int[][] kClosest(int[][] points, int k) {

        //we create a max heap to store the calculations
        //heap can only have k elements 

        //base case 
        if(points.length == k) return points;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], 
                                      a[0] * a[0] + a[1] * a[1])
        );

        for(int[] point : points){
            maxHeap.offer(point); 

            if(maxHeap.size() > k){
                maxHeap.poll(); 
            }
        }

        //convert heap to array
        int[][] result = new int[k][2]; 

        for(int i = 0; i < k; i++){
            result[i] = maxHeap.poll(); 
        }

        return result; 
 


    }
}
