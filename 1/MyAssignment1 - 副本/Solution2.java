public class Solution2{
	public int majorElement(int [] arr){
		int partition(int a[],int l,int r){      
    int pivotkey = a[l];      
    while(l < r){          
        if(l < r && a[r] >= pivotkey)             
            --r;          
        if(l < r){  
            a[l] = a[r];  
            l++;  
        }          
        if(l < r && a[l] <= pivotkey)   
            ++l;       
        if(l < r){  
            a[r] = a[l];  
            --r;  
        }          
    }         
    a[l] = pivotkey;        
    return l;
	}  
		//快排  
		void quick_sort(int [] a, int l, int r){     
    	if(l < r){         
        int position = partition(a,l,r);          
        if(position > n / 2)             
            quick_sort(a, l, position - 1);         
        else if(position < n / 2)            
            quick_sort(a,position + 1,r);         
        else             
            mid = a[position];//找到中位数      
    	}
    int l = 0;
    int r = arr.length - 1;
		}
	}
}