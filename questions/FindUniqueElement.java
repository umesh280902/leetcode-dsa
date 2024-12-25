public class FindUniqueElement {
    public static void main(String[] args){
        int arr[]={1,2,2,3,4,4,5,3,6,7,6,7,8,9,8,9,0,1};
        int ans=0;
        for(int i=0;i<arr.length;i++){
            ans=ans^arr[i];
        }
        System.out.print(ans);
    }   
}
