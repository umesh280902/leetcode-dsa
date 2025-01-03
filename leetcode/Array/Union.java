// Union of Arrays with Duplicates
// Difficulty: EasyAccuracy: 42.22%Submissions: 411K+Points: 2
// Given two arrays a[] and b[], the task is to find the number of elements in the union between these two arrays.

// The Union of the two arrays can be defined as the set containing distinct elements from both arrays. If there are repetitions, then only one element occurrence should be there in the union.

// Note: Elements of a[] and b[] are not necessarily distinct.

// Examples

// Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3]
// Output: 5
// Explanation: Union set of both the arrays will be 1, 2, 3, 4 and 5. So count is 5.
// Input: a[] = [85, 25, 1, 32, 54, 6], b[] = [85, 2] 
// Output: 7
// Explanation: Union set of both the arrays will be 85, 25, 1, 32, 54, 6, and 2. So count is 7.
// Input: a[] = [1, 2, 1, 1, 2], b[] = [2, 2, 1, 2, 1] 
// Output: 2
// Explanation: We need to consider only distinct. So count of elements in union set will be 2.
// Constraints:
// 1 ≤ a.size(), b.size() ≤ 106
// 0 ≤ a[i], b[i] ≤ 105
import java.util.Arrays;
import java.util.ArrayList;
public class Union {
    class Solution {
        public static int findUnion(int a[], int b[]) {
            // code here
            Arrays.sort(a);
            Arrays.sort(b);
            ArrayList<Integer> answer=new ArrayList<>();
            int i=0;
            int j=0;
            while(i<a.length&&j<b.length){
                if(a[i]==b[j]){
                    if(answer.isEmpty()||answer.get(answer.size()-1)!=a[i]){
                    answer.add(a[i]);
                    }
                    i++;
                    j++;
                }else if(a[i]<b[j]){
                    if(answer.isEmpty()||answer.get(answer.size()-1)!=a[i]){
                    answer.add(a[i]);
                    }
                        i++;
                    }else{
                    if(answer.isEmpty()||answer.get(answer.size()-1)!=b[j]){
                    answer.add(b[j]);
                    }
                        j++;
                    }
                 }
            
            while(i<a.length){
                if(answer.isEmpty()||answer.get(answer.size()-1)!=a[i]){
                    answer.add(a[i]);
                    }
                        i++;
            }
            while(j<b.length){
                if(answer.isEmpty()||answer.get(answer.size()-1)!=b[j]){
                    answer.add(b[j]);
                    }
                        j++;
            }
            
            return answer.size();
        }
    }
}
