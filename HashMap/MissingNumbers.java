package HashMap;
import java.util.*;

public class MissingNumbers{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }

        int m = sc.nextInt();
        int brr[] = new int[m];
        for(int i=0; i<m; i++){
            brr[i]= sc.nextInt();
        }

        Solution Obj = new Solution();
        Obj.missingNumbers(n,arr,m,brr);
    }
}

class Solution {
    static void missingNumbers(int n, int arr[], int m, int brr[]) {
        //Write your code here
		HashMap<Integer,Integer> hmap1 = new HashMap<>();
		HashMap<Integer,Integer> hmap2 = new HashMap<>();
		
        for(int i=0;i<n;i++){
            if(hmap1.containsKey(arr[i])==false){
                hmap1.put(arr[i],1);
            }
            else{
                int oldoccur = hmap1.get(arr[i]);
                hmap1.put(arr[i],oldoccur+1);
            }
        }
	
		for(int i=0;i<m;i++){
			if(hmap2.containsKey(brr[i])==false)
				hmap2.put(brr[i],1);
			else{
				 int lastoccur = hmap2.get(brr[i]);
				 hmap2.put(brr[i],lastoccur+1);
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		boolean flag=true;
		for(Integer ele : hmap2.keySet()){
            if(hmap1.get(ele)!=hmap2.get(ele)){
				 // System.out.print(ele+" ");
				list.add(ele);
				flag=false;
			}
        }
		if(flag){
			System.out.print("-1");
		}
		else{
			Collections.sort(list);
			for(Integer i: list){
				System.out.print(i+" ");
			}	
		}
    }
}
