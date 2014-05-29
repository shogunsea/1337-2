// There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

public class Solution {
    public static double findMedianSortedArrays(int A[], int B[]){
		int aLen = A.length;
		int bLen= B.length;
		int len = aLen + bLen;

		if(len % 2 == 0){
			double left = findKth(A, 0, aLen, B, 0, bLen, len / 2);
			double right = findKth(A, 0, aLen, B, 0, bLen, len / 2 - 1);
			return (left + right) / 2.0;
		}else{
			double mid = findKth(A, 0, aLen, B, 0, bLen, len / 2);
			return mid;
		}    	
    } 

    public double findKth(int[] A, int aIndex, int aLen, int[] B, int bIndex, int bLen, int k){
    	// when A or B is empty
    	if(aIndex == aLen || bIndex == bLen ){
    		return aIndex == aLen? B[k] : A[k];
    	}

    	if(k == 1){
    		return Math.min(A[aIndex], B[bIndex]);
    	}


    }

  //   public double findMedianSortedArrays(int A[], int B[]) {
  //   	int aLen = A.length;
  //   	int bLen = B.length;
  //   	int len = aLen + bLen;
  //   	boolean even = len % 2 == 0? true : false;
  //   	int[] merge = new int[len / 2 + 1];
  //   	int pA = 0, pB = 0;

  //   	for(int i = 0; i < merge.length; i++){
  //   		if(pA < aLen && pB < bLen){
  //   			if(A[pA] < B[pB]){
  //   				merge[i] = A[pA];
  //   				pA++;
  //   			}else{
  //   				merge[i] = B[pB];
  //   				pB++;
  //   			}
  //   			continue;
  //   		}

  //   		if(pA < aLen){
  //   			merge[i] = A[pA];
  //   			pA++;
  //   		}

  //   		if(pB < bLen){
  //   			merge[i] = B[pB];
  //   			pB++;
  //   		}
  //   	}

  //   	double res = 0;
		// int last = merge.length - 1;

  //   	if(even){
  //   		res = (merge[last] + merge[last - 1]) / 2.0;
  //   		return res; 
  //   	}

  //   	res = merge[last];
  //   	return res;
  //   }
}