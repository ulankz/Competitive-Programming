/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrix;

/**
 *
 * @author Ulan
 */
public class Matrix {
    public static void main(String args[]){
        char[][] M = new char[][]{{'a','b','c','d','e'},
                              {'f','g','h','i','j'},
                              {'u','v','m','n','o'},
                              {'p','q','r','s','t'}};
       int[][] A = new int[][]{{10,20,30,40,50},
                              {15,22,34,43,56},
                              {17,25,35,45,57},
                              {21,31,39,49,59},
                              {23,34,44,53,71}};
       new Matrix().print_spiral(4,5,M);
       new Matrix().search_sorted_matrix(5,A,57);
       new Matrix().diagonal_print(5, 5, A);
       new Matrix().first_diagonal_print(5, 5, A);
       new Matrix().second_diagonal_print(5, 5, A);
       
    }
    private void print_spiral(int m,int n,char mat[][]){
    int i ,k = 0,l = 0;
    int last_row = m - 1,last_col = n - 1;
    while(k <= last_row && l <= last_col ){
        for(i = l; i <= last_col; i++){
            System.out.print(mat[k][i]);
        }
    k++;
    for(i = k; i <= last_row;i++){
        System.out.print(mat[i][last_col]);
    }
    last_col--;
    
    if(k <= last_row){
        for(i = last_col; i >= l;i--){
            System.out.print(mat[last_row][i]);
        }
        last_row--;
    }
    if(l <= last_col){
        for(i = last_row; i >= k;i--){
            System.out.print(mat[i][l]);
        }
        l++;
    }
    }
}
    private void search_sorted_matrix(int n,int[][] M,int s){
        System.out.println();
        int i = 0, j = n - 1;
        while(i < n && j >= 0){
            if(s == M[i][j]){
                System.out.println("Found");
                return;
            }
            else {
                if(s < M[i][j]){
                    j--;
                }
                else{
                    i++;    
                }
            }            
        }
    }
    private void diagonal_print(int m,int n,int [][] A){
        int k = 0,i = 0,j = 0;
        for(k = 0; k <= m - 1;k++){
            i = k;
            j = 0;
            while(i >= 0){
             System.out.print(A[i][j] + " ");
             i = i - 1;
             j = j + 1;
            }
            System.out.println();
        }
        for(k = 1; k <= n-1;k++){
            i = m - 1;
            j = k;
            while(j <= n - 1){
                System.out.print(A[i][j]+ " ");
                i = i - 1;
                j = j + 1; 
            }
            System.out.println();
        }
    }
    private void first_diagonal_print(int m,int n,int [][] A){
        System.out.println();
       for(int i = 0; i <= m - 1; i++){
           System.out.print(A[i][i] + " ");               
       }
    }
     private void second_diagonal_print(int m,int n,int [][] A){
        System.out.println();
//        int r = m-1,c = 0;
//        while( r >= 0 && c < n){
//            System.out.print(A[r][c] + " ");
//            r--;
//            c++;
//        }     
        for(int i = 0; i < m; i++){
            System.out.print(A[m - 1 - i][i] + " ");
        } 
    }
}   
