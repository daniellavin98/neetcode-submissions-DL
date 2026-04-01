class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //run binary search on smaller of arrays 
        //set the smaller to A 
        //get left partition from A and right from B 
        //for odd, get the max of A left and B left
        //for even add the max of aleft and bleft and min of aright and bright 
        int[] A = nums1; 
        int[] B = nums2; 

        int total = A.length + B.length; 
        int half = (total + 1) / 2; 

        if(B.length < A.length){
            int[] temp = A; 
            A = B; 
            B = temp;
        }

        int l = 0; 
        int r = A.length; 

        while(l <= r){
            int mid1 = (l + r) / 2;         //mid for A 
            int mid2 = half - mid1;     //mid for B

            int Aleft = mid1 > 0 ? A[mid1 - 1] : Integer.MIN_VALUE; 
            int Aright = mid1 < A.length ? A[mid1] : Integer.MAX_VALUE; 

            int Bleft = mid2 > 0 ? B[mid2 - 1] : Integer.MIN_VALUE; 
            int Bright = mid2 < B.length ? B[mid2] : Integer.MAX_VALUE; 

            if(Aleft <= Bright && Bleft <= Aright){
                if(total % 2 != 0){
                    return Math.max(Aleft, Bleft);  
                }
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0; 
               
            }
            else if(Aleft > Bright){
                r = mid1 - 1; 
            }
            else{
                l = mid1 + 1;
            }
        }

        return -1; 

    }
}
