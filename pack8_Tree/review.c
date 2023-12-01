#include <stdio.h>  
#include <stdlib.h>  
#include <time.h>  
#include <omp.h>  
#define N 200  
float A[N][N], B[N][N], C[N][N]; // matrices of NxN elements  
    int main() {  
    /* DECLARING VARIABLES */  
        int i, j, k; // indices for matrix multiplication  
        double t_mul; // Multiply time 
        double start, stop; // start time and stop time  
    /* FILLING MATRICES WITH RANDOM NUMBERS */  
        srand(time(NULL));  
    for(i = 0; i < N; i++) {  
        for(j = 0; j < N; j++) {  
            A[i][j] = (float)rand() / RAND_MAX; // Random float between 0 and 1   
            B[i][j] = (float)rand() / RAND_MAX; // Random float between 0 and 1   }  
    }  
    /* MATRIX MULTIPLICATION */  
    printf("Max number of threads: %i \n", omp_get_max_threads());  
    #pragma omp parallel  
    {  
        printf("Number of threads: %i \n", omp_get_num_threads());   }  
    
    start = omp_get_wtime(); // time measure: start time  
    #pragma omp parallel for private(i, k)  
    for(i = 0; i < N; i++) {  
        for(j = 0; j < N; j++) {  
            C[i][j] = 0; // set initial value of resulting matrix C = 0   
            for(k = 0; k < N; k++) {  
                C[i][j] = C[i][j] + A[i][k] * B[k][j];  
            }  
        }  
    }  
    stop = omp_get_wtime(); // time measure: stop time  
    t_mul = stop - start; // Multiply time  
    printf("Multiply Time: %2.4f \n", t_mul);  
    /* TERMINATE PROGRAM */  
    return 0;  
}  }
