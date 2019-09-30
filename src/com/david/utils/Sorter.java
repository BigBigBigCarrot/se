package com.david.utils;

public class Sorter {

	/**
	 * 直接插入排序（从小到大）
	 * @param a ：待排序的数组，a[0]要用来做哨兵
	 */
	public static void insertionSort(Comparable[] a){
		int i;
		int j;
		for (i = 2; i < a.length; i++) {
			if(a[i].compareTo(a[i-1])<0){
				a[0]=a[i];
				for(j=i-1;a[0].compareTo(a[j])<0;j--){
					a[j+1]=a[j];
				}
				a[j+1]=a[0];
			}
		}
	}
	
	/**
	 * 直接插入排序（从小到大）
	 * @param a ：待排序的数组，a[0]要用来做哨兵
	 */
	public static void insertionSort(int[] a){
		int i;
		int j;
		for (i = 2; i < a.length; i++) {
			if(a[i]>=a[i-1]){
				continue;
			}
			a[0]=a[i];
			for(j=i-1;a[0]<a[j];j--){
				a[j+1]=a[j];
			}
			a[j+1]=a[0];
		}
	}
	
	/**
	 * 折半插入排序（从小到大）
	 * @param a ：待排序的数组，a[0]要用来做哨兵
	 */
	public static void binaryInsertionSort(int[] a){
		int i;
		int j;
		int low;
		int high;
		int mid;
		for (i = 2; i < a.length; i++) {
			if(a[i]<a[i-1]){
				a[0]=a[i];
				low=1;
				high=i-1;
				while(low<=high){
					mid=(low+high)/2;
					if(a[mid]>a[0]){
						high=mid-1;
						continue;
					}
					low=mid+1;
				}
				
				for(j=i-1;j>=high+1;j--){
					a[j+1]=a[j];
				}
				a[high+1]=a[0];
			}
		}
	}
	
	/**
	 * 希尔排序（从小到大）
	 * @param a ：待排序的数组，a[0]要用来做哨兵
	 */
	public static void shellSort(int[] a){
		int dk;
		int i;
		int j;
		int N=a.length-1;
		for(dk=N/2;dk>=1;dk=dk/2){
			for(i=dk+1;i<=N;++i){
				if(a[i]<a[i-dk]){
					a[0]=a[i];
					for(j=i-dk;j>0&&a[0]<a[j];j-=dk){
						a[j+dk]=a[j];
					}
					a[j+dk]=a[0];
				}
			}
		}
	}
	

	/**
	 * 冒泡排序（从小到大）
	 * @param a ：待排序的数组，没有哨兵
	 */
	public static void bubbleSort(int a[]){
		int i;
		int j;
		boolean flag;
		int temp;
		for(i=0;i<=a.length-2;i++){
			flag=false;
			for(j=a.length-1;j>1;j--){
				if(a[j-1]>a[j]){
	//				swap(a[j-1],a[j]);
					temp=a[j-1];
					a[j-1]=a[j];
					a[j]=temp;
	
					flag=true;
				}
			}
			if(!flag){
				return;
			}
		}
	}

	/**
	 * 用于快速排序的表的划分
	 */
	private static int partition(int a[],int low,int high){
		int pivot=a[low];
		while(low<high){
			while(low<high&&a[high]>pivot){
				--high;
			}
			a[low]=a[high];
			while(low<high&&a[low]<=pivot){
				++low;
			}
			a[high]=a[low];
		}
		a[low]=pivot;
		return low;
	}

	/**
	 * 快速排序（从小到大）
	 * @param a
	 * @param low ：要排序的数组下标起始位置
	 * @param high ：要排序的数组下标终止位置
	 */
	public static void quickSort(int a[],int low,int high){
		if(low<high){
			int pivotPosition=partition(a,low,high);
			quickSort(a,low,pivotPosition-1);
			quickSort(a,pivotPosition+1,high);
		}
	}
	
	/**
	 * 简单选择排序（从小到大）
	 * @param a ：待排序的数组，没有哨兵
	 */
	public static void selectionSort(int a[]){
		int i;
		int j;
		int min;
		int temp;
		for ( i = 0; i <= a.length-1; ++i) {
			min=i;
			for ( j = i+1; j <= a.length-1; ++j) {
				if(a[j]<a[min]){
					min=j;
				}
			}
			if(min!=i){
//				swap(a[i],a[min]);
				temp=a[i];
				a[i]=a[min];
				a[min]=temp;
			}
		}
	}
	/**
	 * 用于建立大根堆的向下调整函数
	 */
	private static void adjustDown(int a[],int k,int len){

	}
	/**
	 * 用于建立大根堆的向上调整函数
	 */
	private static void adjustUp(int a[],int k){

	}
	/**
	 * 建立大根堆-用于堆排序
	 */
	private static void buildMaxHeap(int a[],int len){

	}
	/**
	 * 堆排序（从小到大）
	 */
	public static void heapSort(int a[],int len){

	}


	private static void printArray(Integer[] a){
		System.out.print("print begin:\t");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i].toString()+"\t");
		}
		System.out.println("print end");
	}
	
	private static void printArray(int[] a){
		System.out.print("print begin:\t");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+"\t");
		}
		System.out.println("print end");
	}

	public static void main(String[] args) {
//		//geneart a random a
		int ARRAY_LENGTH=8;
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
		int[] a=MyRandom.get_Non_repeated_1D_Array(1, 10, ARRAY_LENGTH);
		a[0]=0;
		printArray(a);
//		insertionSort(a);
//		binaryInsertionSort(a);
//		shellSort(a);
//		bubbleSort(a);
//		selectionSort(a);
		quickSort(a, 0, a.length-1);
		printArray(a);
		
	}

}
