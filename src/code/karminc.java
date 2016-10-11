package code;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by william_lee on 8/9/16.
 */
public class karminc {

    public static final int num = 200;
    public static int eco=0;
    public static int vco=num;

    public static int[][]arro;

    public static void main(String[]args){

        Scanner in = new Scanner(System.in);

        arro = new int[num][num];
        StringTokenizer st;
        for(int i=1;i<=num;i++){
            st = new StringTokenizer(in.nextLine());

            int v = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()){
                int x = Integer.parseInt(st.nextToken());
                arro[v-1][x-1]++;
                eco++;
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=1000;i++){
            min=Math.min(min,iter());
        }
        System.out.println(min);
    }

    public static int iter(){
        int vc=vco;
        int ec=eco;
        int rand;

        int[][]arr=new int[arro.length][arro.length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                arr[i][j]=arro[i][j];
            }
        }

        while(vc>2){
            rand=(int)(Math.random()*ec)+1;
            int ct=0;
            int u=-1;
            int v=-1;
            boolean val=false;
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr.length;j++){
                    if(arr[i][j]>0){
                        if(ct+arr[i][j]>=rand){
                            u=i;
                            v=j;
                            val=true;
                            break;
                        }
                        else{
                            ct+=arr[i][j];
                        }
                    }
                }
                if(val){
                    break;
                }
            }
            //v becomes u

            ec-=2*arr[u][v];
            for(int j=0;j<arr.length;j++){
                if(arr[v][j]>0){
                    arr[u][j]+=arr[v][j];
                    arr[j][v]=0;
                    arr[j][u]=arr[u][j];
                }
            }
            arr[u][u]=0;
            for(int j=0;j<arr.length;j++){
                arr[v][j]=0;
                arr[j][v]=0;
            }
            vc--;
        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i][j]>0){
                    return arr[i][j];
                }
            }
        }
        return Integer.MAX_VALUE;
//        int ctr=0;
//        for(int i=0;i<arr.length;i++){
//            for(int j=0;j<arr.length;j++){
//                if(arr[i][j]>0){
//                    ctr++;
//                }
//            }
//        }
//        if(ctr!=2){
//            System.out.print("oops ");
//        }

//        for(int i=0;i<arr.length;i++){
//            for(int j=0;j<arr.length;j++){
//                if(arr[i][j]>0){
//                    System.out.println("("+i+", "+j+") "+arr[i][j]);
//                }
//            }
//        }


    }

}
