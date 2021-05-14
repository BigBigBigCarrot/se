package pers.david.se.utils;

@Deprecated
/**
 * 
 * @Description
 * 	学习和演示用，全部为从小到大排序
 * 	需要使用时，用自带的或者Collections和Arrays的排序和查找即可
 * @author Bu Dawei
 * @date 2020年1月21日
 * @version
 */
public class Sorter {

	/**
	 * 直接插入排序（从小到大）
	 * 
	 * @param a ：待排序的数组，a[0]要用来做哨兵
	 */
	public static void insertionSort(Comparable[] a) {
		int i;
		int j;
		for (i = 2; i < a.length; i++) {
			if (a[i].compareTo(a[i - 1]) < 0) {
				a[0] = a[i];
				for (j = i - 1; a[0].compareTo(a[j]) < 0; j--) {
					a[j + 1] = a[j];
				}
				a[j + 1] = a[0];
			}
		}
	}

	/**
	 * 直接插入排序（从小到大）
	 * 
	 * @param a ：待排序的数组，a[0]要用来做哨兵
	 */
	public static void insertionSort(int[] a) {
		int i;
		int j;
		for (i = 2; i < a.length; i++) {
			if (a[i] >= a[i - 1]) {
				continue;
			}
			a[0] = a[i];
			for (j = i - 1; a[0] < a[j]; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = a[0];
		}
	}

	/**
	 * 折半插入排序（从小到大）
	 * 
	 * @param a ：待排序的数组，a[0]要用来做哨兵
	 */
	public static void binaryInsertionSort(int[] a) {
		int i;
		int j;
		int low;
		int high;
		int mid;
		for (i = 2; i < a.length; i++) {
			if (a[i] < a[i - 1]) {
				a[0] = a[i];
				low = 1;
				high = i - 1;
				while (low <= high) {
					mid = (low + high) / 2;
					if (a[mid] > a[0]) {
						high = mid - 1;
						continue;
					}
					low = mid + 1;
				}

				for (j = i - 1; j >= high + 1; j--) {
					a[j + 1] = a[j];
				}
				a[high + 1] = a[0];
			}
		}
	}

	/**
	 * 希尔排序（从小到大）
	 * 
	 * @param a ：待排序的数组，a[0]要用来做哨兵
	 */
	public static void shellSort(int[] a) {
		int dk;
		int i;
		int j;
		int N = a.length - 1;
		for (dk = N / 2; dk >= 1; dk = dk / 2) {
			for (i = dk + 1; i <= N; ++i) {
				if (a[i] < a[i - dk]) {
					a[0] = a[i];
					for (j = i - dk; j > 0 && a[0] < a[j]; j -= dk) {
						a[j + dk] = a[j];
					}
					a[j + dk] = a[0];
				}
			}
		}
	}

	/**
	 * 冒泡排序（从小到大）
	 * 
	 * @param a ：待排序的数组，没有哨兵
	 */
	public static void bubbleSort(int a[]) {
		int i;
		int j;
		boolean flag;
		int temp;
		for (i = 0; i <= a.length - 2; i++) {
			flag = false;
			for (j = a.length - 1; j > 1; j--) {
				if (a[j - 1] > a[j]) {
					// swap(a[j-1],a[j]);
					temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;

					flag = true;
				}
			}
			if (!flag) {
				return;
			}
		}
	}

	/**
	 * 用于快速排序的表的划分
	 * 
	 * @param a
	 * @param low
	 * @param high
	 * @return 分组后的中枢元素的下标
	 */
	private static int partition(int a[], int low, int high) {
		int pivot = a[low];
		while (low < high) {
			while (low < high && a[high] > pivot) {
				--high;
			}
			a[low] = a[high];
			while (low < high && a[low] <= pivot) {
				++low;
			}
			a[high] = a[low];
		}
		a[low] = pivot;
		return low;
	}

	/**
	 * 快速排序（从小到大）
	 * 
	 * @param a
	 * @param low  ：要排序的数组下标起始位置
	 * @param high ：要排序的数组下标终止位置
	 */
	public static void quickSort(int a[], int low, int high) {
		if (low < high) {
			int pivotPosition = partition(a, low, high);
			quickSort(a, low, pivotPosition - 1);
			quickSort(a, pivotPosition + 1, high);
		}
	}

	/**
	 * 简单选择排序（从小到大）
	 * 
	 * @param a ：待排序的数组，没有哨兵
	 */
	public static void selectionSort(int a[]) {
		int i;
		int j;
		int min;
		int temp;
		for (i = 0; i <= a.length - 1; ++i) {
			min = i;
			for (j = i + 1; j <= a.length - 1; ++j) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			if (min != i) {
//				swap(a[i],a[min]);
				temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
		}
	}

	/**
	 * 用于建立大根堆的向下调整函数
	 */
	private static void adjustDown(int a[], int k, int len) {
		a[0] = a[k];
		int i;
		for (i = 2 * k; i <= len; i = i * 2) {// a[2k]:a[k]的左孩子；当i>len说明指针超出了这颗二叉树的范围
			if (i < len && a[i] < a[i + 1]) {// a[i==2k]<a[i+1==2k+1]：左孩子小于右孩子
				i++;// 如果左孩子小于右孩子，则指针i指向右孩子
			}
			if (a[0] >= a[i]) {// a[0]:当前元素,a[i]当前元素的左右孩子中最大的那一个
				break;// 如果当前操作的元素大于当前元素的左右孩子中最大的那一个，则跳出循环，不用调整
			}
			a[k] = a[i];// 令当前元素的位置设置为当前元素的左右孩子中最大的那一个
			k = i;// k指向现在代替原先操作元素的那个元素的本来位置，
					// 在下一轮循环中i=2k，即下一轮会判断与a[k]对换位置后
		}
		a[k] = a[0];
	}

//	/**
//	 * 用于建立大根堆的向上调整函数
//	 */
//	private static void adjustUp(int a[], int k) {
//		a[0] = a[k];
//		int i = k / 2;
//		while (i > 0 && a[i] < a[0]) {
//			a[k] = a[i];
//			k = i;
//			i = k / 2;
//		}
//		a[k] = a[0];
//	}

	/**
	 * 建立大根堆-用于堆排序
	 */
	private static void buildMaxHeap(int a[], int len) {
		int i;
		for (i = len / 2; i > 0; i--) {// i=len/2:从最后一个元素a[len]的父节点a[len/2]开始按编号递减的顺序逐个调整
			// 使得以每个一个结点结点作为根结点的树都是大根堆，整个树最后变成大根堆
			adjustDown(a, i, len);// 调整方法为向下调整
		} // 循环完成有所有元素都满足其子结点比它小，整棵树满足大根堆的定义

	}

	/**
	 * 堆排序（从小到大）
	 * 
	 * @param a
	 */
	public static void heapSort(int[] a) {
		buildMaxHeap(a, a.length - 1);// 构造一个大根堆
		int i;
		int temp;
		for (i = a.length - 1; i > 1; i--) {// 不断地取出大根堆中的最大元素交换到有序表的对应位置
//			swap(a[i],a[1]);
			temp = a[i];
			a[i] = a[1];
			a[1] = temp;

			adjustDown(a, 1, i - 1);// 将本轮循环中被取出的元素排除在大根堆外，并重新调整使之扔满足大根堆
		}
	}

	private static void printArray(Integer[] a) {
		System.out.print("print begin:\t");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i].toString() + "\t");
		}
		System.out.println("print end");
	}

	private static void printArray(int[] a) {
		System.out.print("print begin:\t");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
		System.out.println("print end");
	}
	
	/**
	 * 
	 * @param a
	 * @param low 待排序的有序表的起始元素数组下标
	 * @param high 待排序的有序表的终止元素数组下标
	 */
	public static void mergeSort(int a[],int low,int high){
		if(low<high){
			int mid=(low+high)/2;

			mergeSort(a,low,mid);
			mergeSort(a,mid+1,high);

			merge(a,low,mid,high);
		}
	}
	
	/**
	 * 合并两张表（又成为归并段），其中表1（归并段1）为a[low]到a[mid]，表2（归并段2）为a[mid+1]到a[high]，
	 * @param a 
	 * @param low
	 * @param mid
	 * @param high
	 */
	private static void merge(int a[],int low,int mid,int high){
		int[] b=new int[a.length];
		int i,j,k;
		//将要归并的两张表复制到辅助数组B中
		for(k=low;k<=high;k++){
			b[k]=a[k];
		}

		for(i=low,j=mid+1,k=low;i<=mid&&j<=high;k++){//i和k均从表1的第一个元素开始，
				//k每轮循环后向后指向下一位，i不超过表1，
				//j从表2的第一个元素开始
			if(b[i]<=b[j]){
				a[k]=b[i++];
				//等价于a[k]=b[i];i++;
			}else{
				a[k]=a[j++];
			}
		}
		while(i<=mid){
			a[k++]=b[i++];
		}
		while(j<=high){
			a[k++]=b[j++];
		}
	}

	public static void main(String[] args) {
//		//geneart a random a
		int ARRAY_LENGTH = 8;
//		
//		Integer[] a=new Integer[ARRAY_LENGTH];
////		int[] tempA=MyRandom.get_1D_Array(1, 10, ARRAY_LENGTH);
//		int[] tempA=MyRandom.get_Non_repeated_1D_Array(1, 10, ARRAY_LENGTH);
//		for (int i = 0; i < ARRAY_LENGTH; i++) {
//			a[i]=new Integer(tempA[i]);
//		}
//		printArray(a);
//		//sort
//		insertionSort(a);
//		printArray(a);

//		int[] a=MyRandom.get_1D_Array(1, 10, ARRAY_LENGTH);
		int[] a = MyRandom.get_Non_repeated_1D_Array(1, 10, ARRAY_LENGTH);
		a[0] = 0;
		printArray(a);
//		insertionSort(a);
//		binaryInsertionSort(a);
//		shellSort(a);
//		bubbleSort(a);
//		selectionSort(a);
//		quickSort(a, 0, a.length - 1);
//		heapSort(a);
		mergeSort(a,0,a.length-1);
		printArray(a);

	}

}
