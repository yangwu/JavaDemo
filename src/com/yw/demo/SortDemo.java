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
	
	//ѡ������
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
	
	
	//��������
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
	
	
	
	//�򵥲�������
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
	
	//ϣ������	��
	public int[] shellSort(int[] nums) {
		long start = System.currentTimeMillis();
		if(nums ==  null || nums.length == 0) return null;
		int gap = nums.length/3;//����
		
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
	
	//ð������:
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
	
	
	//��������
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
			
		while(heapSize>0) {//��nums.length��1�����Ϲ������ѣ�
			
			//�������ѣ�
			for(int i=heapSize-1;i>=0;i--) { //���ÿ��index,���ϵ�����;
				adjustHeapOfIndex(nums,i,heapSize);
			}
			//this.printArrays("build max heap:",nums);
			swap(nums,0,heapSize-1);	//�ѹ�����ɺ� ����ֵΪnums[0],��󽻻��ŵ����
			
			heapSize--;
		}
		
		return nums;
	}
	
	//�鲢����
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
			mergeSort(nums,start,start + sublength,temp);//�ֱ�������Ӵ��ź���  ��һֱ���ֵ�ֻʣһ��Ԫ�أ������һ���ź�����Ӵ���
			mergeSort(nums,start + sublength+1,end,temp);
			//System.out.println("Merge Sort:" + start + "|" + sublength + "|" + end);
			mergeArrays(nums,start,start + sublength,start + sublength+1,end,temp);//�������ź�����Ӵ��ϲ�	
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
		for(int k=lstart;k<=rend;k++) {//�Ѿ���������������ֵȫ�����µ�ԭ������
			nums[k] = temp[k];
		}
		//this.printArrays("Merge Arrays:", nums);
		return nums;
	}
	
	//��������  ���������ܴ�������
	public int[] radixSort(int[] nums) {
		long start = System.currentTimeMillis();
		if(nums ==  null || nums.length == 0) return null;
		
		int max = nums[0];
		for(int cur:nums) {//�ȵõ������ 
			if(cur>max)
				max = cur;
		}
		
		int[] temp = new int[nums.length];
		
		int exp = 1;
		do{
			int[] buckets = new int[10];//���������Ͱ ͳ����������
			for(int j=0;j<nums.length;j++) {
				buckets[(nums[j]/exp)%10]++;//����ÿ���������ֵĸ��� 
			}
			//this.printArrays("buckets nums of exp:" + exp, buckets);
			
			for(int l=1;l<10;l++) {
				buckets[l] += buckets[l-1];//ͳ��������Ӧ������˳����������������е�λ�� ������ԽС ����������������Խǰ�� 
			}
			//this.printArrays("buckets:", buckets);
			
			//this.printArrays("before bucket:", nums);
			//�����������ǰѭ��   ��Ϊbuckets�����ݵ�λ�ôӴ�С�ݼ�.
			for(int m=nums.length-1;m>=0;m--) {
				//System.out.println("m, value:" + m + "|" + nums[m] + "|" + buckets[(nums[m]/exp)%10]);
				//this.printArrays("nums:", nums);	
				temp[buckets[(nums[m]/exp)%10]-1] = nums[m];//ÿ�洢һ�����ݺ����buckets�ж�Ӧ�����ݼ�һ��
				buckets[(nums[m]/exp)%10]--;
				//this.printArrays("buckets:", buckets);	
			}
			
			
			for(int k=0;k<nums.length;k++) {//����ֵ
				nums[k] = temp[k];
			}
			
			//this.printArrays("After bucket:" + exp, temp);
			exp *= 10;
		}while(max/exp>0);
		
		
		System.out.println("Radix Sort,count time = " + (System.currentTimeMillis()- start) + "ms");
		return nums;
	}
	
	//Ͱ�����㷨
	public int[] bucketSort(int[] nums) {
		long start = System.currentTimeMillis();
		if(nums ==  null || nums.length == 0) return null;
		if(nums.length<=2) return this.quickSort(nums);
		
		//this.printArrays("bucket sort:", nums);
		//�ȵõ����������ݵķ�Χ
		int min = nums[0], max = nums[0];
		for(int curvalue:nums) {
			if(curvalue<min) min = curvalue;
			if(curvalue>max) max = curvalue;
		}
		
		//�������ķ�Χ ȷ��Ͱ�ĸ���  �Լ�Ͱ��ӳ�亯��
		//�ڴ˼�������ʮ��Ͱ Ȼ������ݷֱ�����ӦͰ��
		//ÿ��Ͱʹ��List
		int bucketNum = 10;
		int step = 0;
		if((max-min)<10)
			bucketNum = max-min;
		step = (max-min)/(bucketNum-1);// ����bucketNum��step��bucketNum��Ͱ����Χ  [min,min+step); 
		//��ʼ��Ͱ
		List[] buckets = new ArrayList[bucketNum];
		for(int bk = 0;bk<buckets.length;bk++) {
			buckets[bk] = new ArrayList();
		}
		
		//�������� ��Ԫ�طֱ����Ͱ��
		for(int curnum:nums) {
			int curindex = (curnum-min)/step;
			//System.out.println("curnum:" + curnum + ",curindex = " + curindex + ",min = " + min + ",step = " + step);
			buckets[curindex].add(curnum);
		}
		
		//�ֱ�Ը���Ͱ���ÿ������� ���Ұ�ÿ��Ͱ�и�Ԫ�غϲ�
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
