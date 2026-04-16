public class Solution {
    public int LastStoneWeight(int[] stones) {
        //priority queue in c# requires two elements -> element and priority
        var queue = new PriorityQueue<int, int>(Comparer<int>.Create((a,b) => b.CompareTo(a)));


        foreach(int i in stones){
            queue.Enqueue(i, i);
        }

        while(queue.Count > 1){

            int y = queue.Dequeue();
            int x = queue.Dequeue();

            if(x != y){
                queue.Enqueue(y - x, y - x);
            }
        }

        queue.Enqueue(0, 0);
        return Math.Abs(queue.Peek());

    }
}
