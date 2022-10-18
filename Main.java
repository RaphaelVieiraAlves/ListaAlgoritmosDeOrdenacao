import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		int[] array20 = new int[20];
		int[] array20000 = new int[20000];
		
    	Random objGenerator = new Random();
    	
        for (int i = 0; i < 20; i++){
        	int randomNumber = objGenerator.nextInt(10000);
        	array20[i] = randomNumber;
         }
        
        for (int j = 0; j < 20000; j++){
        	int randomNumber = objGenerator.nextInt(10000);
        	array20000[j] = randomNumber;
         }
        
        long startInsercionSort20 = System.nanoTime();
        
        iS(array20);
        
        long endInsercionSort20 = System.nanoTime(); 
        
        long startMergeSort20 = System.nanoTime();
		
		mS(array20,0,array20.length-1);
		
		long endMergeSort20 = System.nanoTime(); 
		

		long startInsercionSort20000 = System.nanoTime();
        iS(array20000);
        long endInsercionSort20000 = System.nanoTime();
		
        long startMergeSort20000 = System.nanoTime();
		mS(array20000,0,array20000.length-1);
		long endMergeSort20000 = System.nanoTime();
		
		long tInsercionSort20 = endInsercionSort20 - startInsercionSort20;
		
		long tMergeSort20 = endMergeSort20 - startMergeSort20;
		
		long tInsercionSort20000 = endInsercionSort20000 - startInsercionSort20000;
		
		long tMergeSort20000 = endMergeSort20000-startMergeSort20000;
		
		
		System.out.println("Tempo insertion sort 20:    "+ tInsercionSort20);
		System.out.println("Tempo merge sort 20:        "+ tMergeSort20);
		System.out.println("Tempo insertion sort 20000: "+ tInsercionSort20000);
		System.out.println("Tempo merge sort 20000:     " + tMergeSort20000);
		
		System.out.println("");
		
		System.out.println("-------------------ANÁLISE---------------------------");
		
		if(tInsercionSort20 > tMergeSort20)
			System.out.println("- Merge sort é mais rápido com 20");
		else
			System.out.println("- Insertion sort é mais rápido com 20");
		
		System.out.println("");
		
		if(tInsercionSort20000 > tMergeSort20000)
			System.out.println("- Merge sort é mais rápido com 20000");
		else
			System.out.println("- Insertion sort é mais rápido com 20000");
		
		System.out.println("-----------------------------------------------------");
		
		
	}
	
	static int[] iS(int a[])
    {
        int n = a.length;
        for (int i = 1; i < n; ++i) {
            int key = a[i];
            int j = i - 1;
  
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
        
        return a;
    }
	
    static void printArray(int a[])
    {
        int n = a.length;
        for (int i = 0; i < n; ++i)
            System.out.print(a[i] + " ");
  
        System.out.println();
    }
    
	public static int[] mS(int[] arr,int l,int h) {
		
		if(l==h) {
			int[] na=new int[1];
			na[0]=arr[l];
			return na;
		}
		
		int meio=(l+h)/2;
		int ar1[]=mS(arr,l,meio);
		int ar2[]=mS(arr,meio+1,h);
		return mesclar_array(ar1,ar2);
	}
	
	public static int[] mesclar_array(int[] ar1,int[] ar2) {
		int i=0,j=0,k=0;
		int n=ar1.length;
		int m=ar2.length;
		int[] ar3=new int[m+n];
		while(i<n && j<m) {
			if(ar1[i]<ar2[j]) {
				ar3[k]=ar1[i];
				i++;
			}
			else {
				ar3[k]=ar2[j];
				j++;
			}
			k++;
		}
		
		while(i<n) {
			ar3[k]=ar1[i];
			i++;
			k++;
		}
		
		while(j<m) {
			ar3[k]=ar2[j];
			j++;
			k++;
		}
		
		return ar3;
		
	}
}
