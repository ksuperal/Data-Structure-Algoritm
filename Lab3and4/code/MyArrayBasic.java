package Lab3and4.code;

import java.util.ArrayList;
import java.util.Arrays;

import javax.naming.NameNotFoundException;

public class MyArrayBasic {
    protected int MAX_SIZE = 5;
    protected int data[] = new int[MAX_SIZE];
    protected int size = 0;

    public void add(int d){
        data[size]=d;
        size=size+1;
    }
    public void insert(int d, int index){
        data[size++]=data[index];
        data[index] = d;
    }
    public int find(int d){
        int index=-1;
        for(int i=0; i<size; i++) {
            if(data[i]==d) {
                index = i;
                break;
            }
        }
        return index;
    }
    public int binarySearch(int d){
        int a = 0, b=size-1;
        while(a<=b) {
            int m = (a+b)/2;
            if(data[m]==d) return m;
            if(d<data[m]) b = m-1;
            else a = m+1; 
        }
        return -1;
    }
    public void delete(int index){
        for(int i=index; i<size-1; i++) {
            data[i] = data[i+1];
            }
            size--;
    }
    public MyArrayBasic(int ... a){
        if(a != null)
        for(int i=0; i< a.length; i++)
            add(a[i]);
        
    }
    @Override
    public String toString() {
        return "MyArrayBasic [MAX_SIZE=" + MAX_SIZE + ", data=" + Arrays.toString(data) + ", size=" + size + "]";
    }
}