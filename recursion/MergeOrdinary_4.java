package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeOrdinary_4 {
    static int count=0;
    static int K;
    static int result=-1;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String[] num=br.readLine().split(" ");

        int[] A=new int[Integer.parseInt(num[0])];
        //저장할 횟수
        K=Integer.parseInt(num[1]);

        String[] nums=br.readLine().split(" ");

        //nums 배열에 각 값 저장
        for (int i=0;i<A.length;i++){
            A[i]=Integer.parseInt(nums[i]);
        }
        merge_sort(A,0,A.length-1);
        if(K>count)System.out.println(result);
        else System.out.println(-1);

    }

    public static void merge_sort(int[] A,int p,int r){


        if(p<r){
            int q=Math.abs((p+r)/2);

            //전반부 정렬
            merge_sort(A,p,q);

            //후반부 정렬
            merge_sort(A,q+1,r);
            merge(A,p,q,r);
        }

    }

    public static void merge(int[] A,int start,int mid,int end){
        int[] tmp=new int[A.length];
        int i=start,j=mid+1,t=0;
        while (i<=mid&&j<=end){
            if(A[i]<=mid&&mid<=A[j]){
                tmp[t++]=A[i++];
            }
            else tmp[t++]=A[j++];
        }
        //왼쪽 배열이 남은 경우
        while (i<=mid) tmp[t++]=A[i++];
        while (j<=end)tmp[t++]=A[j++];
        i=start;t=0;
        while (i<=end)//결과를 A[p,r]에 저장
        {   count++;
            if(count==K){
                result=tmp[t];
                break;
            }
            A[i++]=tmp[t++];
        }

    }



}
