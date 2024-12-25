public class LinearSearch{

    private static boolean Search(int arr[],int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]){
        int arr[]={12,34,51,2,6,2,35,12,4,45,3};
        basic.output.print(Search(arr, 51));
    }
}
