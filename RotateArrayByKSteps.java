import java.util.Arrays;
import java.util.Scanner;
/*

[1,2,3,4,5] k=2 n=5
[1,2,3] [4,5]
[3,2,1] [5,4]
[4,5,1,2,3]
[ ,
 */
public class RotateArrayByKSteps {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6,7};
        rotate2(arr,1);
        Arrays.stream(arr).forEach(i-> System.out.print(i+"  "));
    }

    /*
    TC:- O(K*N)
    SC:- O(1)
     */
    public static void  rotate(int nums[],int k){
        int len=nums.length;
        k=k%nums.length;
        while (k!=0){
            int last=nums[len-1];
            for(int i=len-1;i>0;i--){
                nums[i]=nums[i-1];
            }
            nums[0]=last;
            k-=1;
        }
    }

    /*
    TC:- 0(N)
    SC:- O(N)
     */
    public static void rotate1(int arr[],int k){
        int len=arr.length;
        int [] newArray=new int[len];
        k=k%len;
        int j=0;
        for(int i=len-k;i<len;i++){
            newArray[j]=arr[i];
            j+=1;
        }
        for(int i=0;i<len-k;i++){
            newArray[j]=arr[i];
            j+=1;
        }
        System.arraycopy(newArray,0,arr,0,len);
    }

    public static void rotate2(int arr[], int k){
        int len=arr.length;
        k=k%len;
        reverse(arr,0,len-k-1);
        reverse(arr,len-k,len-1);
        reverse(arr,0,len-1);
    }

    public static void reverse(int []arr,int i,int j){
        int len=j-i+1;
        if(i>j || i==j ||  len==1 ||len==0){
            return;
        }
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        reverse(arr,i+1,j-1);
    }
}
