
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class findKFrequentinArray {
    public static int[] findkthLargest(int[] input, int K)
    {
        Map<Integer, Integer> hmap = new HashMap<>();
        int[] res = new int[K];

        for (int idx =0; idx < input.length; idx++)
        {
            hmap.put(input[idx], hmap.getOrDefault(input[idx], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pQue = new PriorityQueue<>(
                (a,b) -> a.getValue().equals(b.getValue())
                        ? Integer.compare(b.getKey(), a.getKey())
                        : Integer.compare(b.getValue(), a.getValue())
        );

        for (Map.Entry<Integer, Integer> entryVal: hmap.entrySet())
        {
            pQue.offer(entryVal);
        }

        for (int i = 0; i < K; i++) {
            res[i] = pQue.poll().getKey();
        }
        return res;
    }
    public static void main(String[] args) {
        int[] Arr = {3,9,2,8,6,5,4,6,2,1,4,3,9,2,6};

        int[] result = findkthLargest(Arr, 4);

        System.out.println("Top elements : " + Arrays.toString(result));
    }
}
