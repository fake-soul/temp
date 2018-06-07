
public class inversions {
	public static void main(String args[])
	{
		int arr[]=new int[]{1, 20, 6, 4, 5};
		System.out.println("Number of inversions"+mergesort(arr,5));
	}

	private static int mergesort(int[] arr, int i) {
		// TODO Auto-generated method stub
		int temp[]=new int[i];
		return _mergesort(arr,temp,0,i-1);
	}

	private static int _mergesort(int[] arr, int[] temp, int left, int right) {
		// TODO Auto-generated method stub
		int mid,inv=0;
		if(right>left)
		{
			mid=(left+right)/2;
			inv=_mergesort(arr,temp,left,mid);
			inv+=_mergesort(arr,temp,mid+1,right);
			inv+=merge(arr,temp,left,mid+1,right);
		}
		return inv;
	}

	private static int merge(int[] arr, int[] temp, int left, int mid, int right) {
		// TODO Auto-generated method stub
		int i,j,k;
		int inv=0;
		i=left;
		k=right;
		j=mid;
		while((i<=mid-1)||(j<=right))
		{
			if(arr[i]<=arr[j])
				temp[k++]=arr[i++];
			else
			{
				temp[k++]=arr[j++];
				inv=inv+(mid-1);
			}
		}
		while (i <= mid - 1)
	        temp[k++] = arr[i++];
		while (j <= right)
	        temp[k++] = arr[j++];
		for (i=left; i <= right; i++)
	        arr[i] = temp[i];
		return inv;
	}
	
}
