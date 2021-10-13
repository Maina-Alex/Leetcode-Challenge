import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ch4 {
    public int solution(String S) {
        boolean isSmallLetters= S.equals(S.toLowerCase());
        char [] stringChars= S.toCharArray();
        if(!isSmallLetters){
            throw new RuntimeException("Invalid String case, must be small letters");

        }else if(S.length()<=0 || S.length()>300000 ){
            throw new RuntimeException("Invalid String length");
        }

        HashMap<Character,Integer> charMap = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        int charCount = 0;

        for (char stringChar : stringChars) {
            if (charMap.containsKey(stringChar)) {
                charMap.put(stringChar, charMap.get(stringChar) + 1);
            } else {
                charMap.put(stringChar, 1);
            }
        }
        charMap.forEach((key,value)->{
            priorityQueue.add(value);
        });

        while(!priorityQueue.isEmpty()){
            int current= priorityQueue.peek();
            priorityQueue.remove();

            if(priorityQueue.isEmpty()){
                return charCount;
            }
            if (current == priorityQueue.peek()){
                if(current>1){
                    priorityQueue.add(current - 1);
                }
                charCount++;
            }
        }
        return charCount;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > 1000 || nums2.length > 1000){
            return 0;
        }
        List<Integer> arraysCombined = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).boxed().collect(Collectors.toList());
        Collections.sort(arraysCombined);
        if(arraysCombined.size()==1){
            return arraysCombined.get(0);
        }else if(arraysCombined.size()==2) {
            return (arraysCombined.get(0)+ arraysCombined.get(1))/2.0;
        }

        if(arraysCombined.size()%2==0){
            int med= arraysCombined.size()/2;
            int med2=med+1;

            return (arraysCombined.get(med-1)+arraysCombined.get(med2-1))/2.0;
        }else{
            return arraysCombined.get( ((int)(Math.floor(arraysCombined.size()/2.0))));
        }
        //merge and sort the array
        //get the size of the array
        //if size is odd do a truncate truncate to floor
        //get the value of the next item
        //else if value is  get the median of an arraylist


    }

    public static void main(String[] args) {
        String str = "abbbcccd";
        ch4 test= new ch4();
        System.out.println(test.solution(str));

        int[] nums1={1,3};
        int [] nums2={2};
        System.out.println((int)Math.floor(2.7));

        System.out.println(test.findMedianSortedArrays(nums1,nums2));

    }
}
