package com.yw.demo;

import java.util.ArrayList;
import java.util.List;

public class SortDemo {

	
	public static void main(String[] args) {
	}
	
	public boolean checkAscending(int[] nums) {
		if(nums == null || nums.length == 0) return true;
		System.out.println() ;
		int count = 0;
		for(int x:nums) {
			System.out.print(x + ", ") ;
			count++;
			if(count%30 == 0)
				System.out.println("");
		}
		System.out.println() ;
		int pre = 0;
		int index = 1;
		while(index<nums.length) {
			if(nums[index]<nums[pre]) {
				System.out.println("index:" + index + "|" + pre);
				return false;
			}
			index++;
			pre++;
		}
		return true;
	}
	
	private void printArrays(String title, int[] nums) {
		if(nums == null ||nums.length == 0) return;
		System.out.println(title) ;
		int count = 0;
		for(int x:nums) {
			System.out.print(x + ", ") ;
			count++;
			if(count%30 == 0)
				System.out.println("");
		}
		System.out.println("") ;
	}
	
	//选择排序：
	public int[] selectSort(int[] nums) {
		long start = System.currentTimeMillis();
		for(int i=0;i<nums.length;i++) {
			int minIndex = i;
			for(int j=i+1;j<nums.length;j++) {
				if(nums[j]<nums[minIndex]) {
					minIndex = j;
				}
			}
			swap(nums,i,minIndex);
		}
		System.out.println("Select Sort, count time = " + (System.currentTimeMillis()- start) + "ms");
		return nums;
	}
	
	
	//快速排序：
	public int[] quickSort(int[] nums) {
		long start = System.currentTimeMillis();
		if(nums == null ||nums.length == 0) return nums;
		quickSortByPivot(nums,0,nums.length-1);
		System.out.println("Quick Sort, count time = " + (System.currentTimeMillis()- start) + "ms");
		return nums;
	}
	

	private void quickSortByPivot(int[] nums,int left,int right) {
		//System.out.println("Start: left|right" + left + "|" + right);
		int l = left,r = right;
		int pivot = nums[left];
		
		while(l<r) {
			while(r>l && nums[r]>=pivot)
				r--;
			
			while(r>l && nums[l]<=pivot)
				l++;
			
			if(l<r)
				swap(nums,l,r);
		}
		swap(nums,left,l);
		
		//int index = l;
		//System.out.println("current index:" + index);
		if(l-1>left)
			quickSortByPivot(nums,left,l-1);
		//System.out.println(" the right sort,right = " + right + ",l=" + index);
		if(right>l+1)
			quickSortByPivot(nums,l+1,right);
	}
	
	private void swap(int[] nums,int x,int y) {
		if(x == y) return;
		//System.out.println(nums[x] + "|" + nums[y]);
		
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
		
		//System.out.println(nums[x] + "|" + nums[y]);
		
	}
	
	
	
	//简单插入排序：
	public int[] simpleInsertSort(int[] nums) {
		long start = System.currentTimeMillis();
		for(int i=1;i<nums.length;i++) {
			int pre = i-1,cur = i;
			while(pre>=0 && nums[pre]>nums[cur]) {
				swap(nums,pre,cur);
				cur = pre;
				pre--;
			}
		}
		System.out.println("Simple Insert Sort,count time = " + (System.currentTimeMillis()- start) + "ms");
		return nums;
	}
	
	//希尔排序	，
	public int[] shellSort(int[] nums) {
		long start = System.currentTimeMillis();
		if(nums ==  null || nums.length == 0) return null;
		int gap = nums.length/3;//步长
		
		while(gap>0) {
			for(int k=0;k<gap;k++) {
				int cur=k;
				int pre = k;
				while(cur<nums.length) {
					if(nums[cur]<nums[pre]) {
						swap(nums,cur,pre);
					}
					pre = cur;
					cur += gap;
				}
			}
			gap--;
		}
		System.out.println("Shell Sort,count time = " + (System.currentTimeMillis()- start) + "ms");
		return nums;
	}
	
	//冒泡排序:
	public int[] bubbleSort(int[] nums) {
		long start = System.currentTimeMillis();
		if(nums ==  null || nums.length == 0) return null;
		for(int i=0;i<nums.length;i++) {
			for(int j=1;j<nums.length-i;j++) {
				if(nums[j]<nums[j-1]) {
					swap(nums,j,j-1);
				}
			}	
		}
		System.out.println("Bubble Sort,count time = " + (System.currentTimeMillis()- start) + "ms");
		return nums;
	}
	
	
	//最大堆排序：
	public int[] heapSort(int[] nums) {
		long start = System.currentTimeMillis();
		if(nums ==  null || nums.length == 0) return null;

		buildMaxHeap(nums);
		
		System.out.println("Heap Sort,count time = " + (System.currentTimeMillis()- start) + "ms");
		return nums;
	}
	
	private void adjustHeapOfIndex(int[] nums,int index, int heapSize) {
		//System.out.println("index|heapSize:" + index + "|" + heapSize);
		int left = index * 2 +1;
		int right = index * 2 +2;
		int largest = index;
		if(left<heapSize && nums[left]>nums[largest])
			largest = left;
		if(right<heapSize && nums[right]>nums[largest])
			largest = right;
		if(index != largest) {
			swap(nums,index,largest);
			adjustHeapOfIndex(nums,largest,heapSize);
		}
		//this.printArrays("adjust heap", nums);
	}
	
	private int[] buildMaxHeap(int[] nums) {
		
		int heapSize = nums.length;
			
		while(heapSize>0) {//从nums.length到1，不断构建最大堆；
			
			//构建最大堆；
			for(int i=heapSize-1;i>=0;i--) { //针对每个index,不断调整堆;
				adjustHeapOfIndex(nums,i,heapSize);
			}
			//this.printArrays("build max heap:",nums);
			swap(nums,0,heapSize-1);	//堆构建完成后 最大的值为nums[0],完后交换放到最后
			
			heapSize--;
		}
		
		return nums;
	}
	
	//归并排序
	public int[] mergeSort(int[] nums) {
		long start = System.currentTimeMillis();
		if(nums ==  null || nums.length == 0) return null;
		//System.out.println("start to merge sort:");
		int[] temp = new int[nums.length];
		mergeSort(nums,0,nums.length-1,temp);
		System.out.println("Merge Sort,count time = " + (System.currentTimeMillis()- start) + "ms");
		return nums;
	}
	
	public void mergeSort(int[] nums,int start,int end,int[] temp) {
		if(end-start>0) {
			int sublength = (end-start)/2;
			mergeSort(nums,start,start + sublength,temp);//分别把两个子串排好序  即一直划分到只剩一个元素，则就是一个排好序的子串。
			mergeSort(nums,start + sublength+1,end,temp);
			//System.out.println("Merge Sort:" + start + "|" + sublength + "|" + end);
			mergeArrays(nums,start,start + sublength,start + sublength+1,end,temp);//把两个排好序的子串合并	
		}
	}
	
	private int[] mergeArrays(int[] nums,int lstart,int lend,int rstart,int rend,int[] temp) {
		if((lend-lstart)<0 && (rend-rstart)<0) return nums;
		
		int tempindex = lstart;
		int leftindex = lstart,rightindex = rstart;
		//System.out.println("tempindex|leftindex " + tempindex + "|" + leftindex);
		while(leftindex<=lend && rightindex<=rend) {
			if(nums[leftindex]<=nums[rightindex]) {
				temp[tempindex++] = nums[leftindex++];
			}else{
				temp[tempindex++] = nums[rightindex++];
			}
		}
		
		while(leftindex<=lend) {
			temp[tempindex++] = nums[leftindex++];
		}
		while(rightindex<=rend) {
			temp[tempindex++] = nums[rightindex++];
		}
		//System.out.println("fininsh index " + tempindex + "|" + leftindex);		
		for(int k=lstart;k<=rend;k++) {//把经过处理的数组里的值全部更新到原数组中
			nums[k] = temp[k];
		}
		//this.printArrays("Merge Arrays:", nums);
		return nums;
	}
	
	//基数排序  基数排序不能处理负数；
	public int[] radixSort(int[] nums) {
		long start = System.currentTimeMillis();
		if(nums ==  null || nums.length == 0) return null;
		
		int max = nums[0];
		for(int cur:nums) {//先得到最大数 
			if(cur>max)
				max = cur;
		}
		
		int[] temp = new int[nums.length];
		
		int exp = 1;
		do{
			int[] buckets = new int[10];//针对余数的桶 统计余数个数
			for(int j=0;j<nums.length;j++) {
				buckets[(nums[j]/exp)%10]++;//保存每个余数出现的个数 
			}
			//this.printArrays("buckets nums of exp:" + exp, buckets);
			
			for(int l=1;l<10;l++) {
				buckets[l] += buckets[l-1];//统计余数对应的数按顺序出现在整个数组中的位置 即余数越小 则其在数组中排在越前面 
			}
			//this.printArrays("buckets:", buckets);
			
			//this.printArrays("before bucket:", nums);
			//从数组最后往前循环   因为buckets中数据的位置从大到小递减.
			for(int m=nums.length-1;m>=0;m--) {
				//System.out.println("m, value:" + m + "|" + nums[m] + "|" + buckets[(nums[m]/exp)%10]);
				//this.printArrays("nums:", nums);	
				temp[buckets[(nums[m]/exp)%10]-1] = nums[m];//每存储一个数据后，则把buckets中对应的数据减一；
				buckets[(nums[m]/exp)%10]--;
				//this.printArrays("buckets:", buckets);	
			}
			
			
			for(int k=0;k<nums.length;k++) {//更新值
				nums[k] = temp[k];
			}
			
			//this.printArrays("After bucket:" + exp, temp);
			exp *= 10;
		}while(max/exp>0);
		
		
		System.out.println("Radix Sort,count time = " + (System.currentTimeMillis()- start) + "ms");
		return nums;
	}
	
	//桶排序算法
	public int[] bucketSort(int[] nums) {
		long start = System.currentTimeMillis();
		if(nums ==  null || nums.length == 0) return null;
		if(nums.length<=2) return this.quickSort(nums);
		
		//this.printArrays("bucket sort:", nums);
		//先得到待排序数据的范围
		int min = nums[0], max = nums[0];
		for(int curvalue:nums) {
			if(curvalue<min) min = curvalue;
			if(curvalue>max) max = curvalue;
		}
		
		//根据数的范围 确定桶的个数  以及桶的映射函数
		//在此假设最多分十个桶 然后把数据分别放入对应桶内
		//每个桶使用List
		int bucketNum = 10;
		int step = 0;
		if((max-min)<10)
			bucketNum = max-min;
		step = (max-min)/(bucketNum-1);// 根据bucketNum和step分bucketNum个桶，范围  [min,min+step); 
		//初始化桶
		List[] buckets = new ArrayList[bucketNum];
		for(int bk = 0;bk<buckets.length;bk++) {
			buckets[bk] = new ArrayList();
		}
		
		//遍历数组 把元素分别放入桶中
		for(int curnum:nums) {
			int curindex = (curnum-min)/step;
			//System.out.println("curnum:" + curnum + ",curindex = " + curindex + ",min = " + min + ",step = " + step);
			buckets[curindex].add(curnum);
		}
		
		//分别对各个桶采用快速排序 并且把每个桶中各元素合并
		int index = 0;
		for(List list:buckets) {
			int[] temp = new int[list.size()];
			for(int k=0;k<list.size();k++) {
				temp[k] = (Integer)list.get(k);				
			}
			int[] tempresult = quickSort(temp);
			for(int value:tempresult)
				nums[index++] = value; 
		}
		
		System.out.println("Bucket Sort,count time = " + (System.currentTimeMillis()- start) + "ms");
		return nums;
	}
}
