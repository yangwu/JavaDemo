package com.yw.demo.test;

import static org.junit.Assert.*;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

import com.yw.demo.SortDemo;

public class SortDemoTest {

	private SortDemo demo = new SortDemo();
	
	int[] nums0 = new int[] {};
	int[] nums1 = new int[]{55,2,92,4,5,88,32,62,12,1,34,52,3};
	int[] nums2 = new int[] {2};
	int[] nums3 = new int[] {100,9,29,39};
	int[] nums4 = new int[] {-100,9,-29,39,87};
	int[] nums5 = new int[] {94,4,6,8,19,20,34};
	
	private int[] getLargeNums() {
		return getLargeNums(1000);
	}
	private int[] getLargeNums(int count) {
		int[] largenums = new int[count];
		for(int j=0;j<count;j++) {
			largenums[j] = ThreadLocalRandom.current().nextInt(10000);
		}
		return largenums;
	}
	
	@Test
	public void testSelectSort() {
		assertTrue(demo.checkAscending(demo.selectSort(nums0)));
		assertTrue(demo.checkAscending(demo.selectSort(nums1)));
		assertTrue(demo.checkAscending(demo.selectSort(nums2)));
		assertTrue(demo.checkAscending(demo.selectSort(nums3)));
		assertTrue(demo.checkAscending(demo.selectSort(nums4)));
		assertTrue(demo.checkAscending(demo.selectSort(getLargeNums(1000))));
		assertTrue(demo.checkAscending(demo.selectSort(getLargeNums(955))));
	}
	
	@Test
	public void testQuickSort() {
		assertTrue(demo.checkAscending(demo.quickSort(nums0)));
		assertTrue(demo.checkAscending(demo.quickSort(nums1)));
		assertTrue(demo.checkAscending(demo.quickSort(nums2)));
		assertTrue(demo.checkAscending(demo.quickSort(nums3)));
		assertTrue(demo.checkAscending(demo.quickSort(nums4)));
		assertTrue(demo.checkAscending(demo.quickSort(getLargeNums(1000))));
		assertTrue(demo.checkAscending(demo.quickSort(getLargeNums(955))));
	}
	
	@Test
	public void testSimpleInsertSort() {
		assertTrue(demo.checkAscending(demo.simpleInsertSort(nums0)));
		assertTrue(demo.checkAscending(demo.simpleInsertSort(nums1)));
		assertTrue(demo.checkAscending(demo.simpleInsertSort(nums2)));
		assertTrue(demo.checkAscending(demo.simpleInsertSort(nums3)));
		assertTrue(demo.checkAscending(demo.simpleInsertSort(nums4)));
		assertTrue(demo.checkAscending(demo.simpleInsertSort(getLargeNums(1000))));
		assertTrue(demo.checkAscending(demo.simpleInsertSort(getLargeNums(955))));
	}
	
	@Test
	public void testShellSort() {
		assertTrue(demo.checkAscending(demo.shellSort(nums0)));
		assertTrue(demo.checkAscending(demo.shellSort(nums1)));
		assertTrue(demo.checkAscending(demo.shellSort(nums2)));
		assertTrue(demo.checkAscending(demo.shellSort(nums3)));
		assertTrue(demo.checkAscending(demo.shellSort(nums4)));
		assertTrue(demo.checkAscending(demo.shellSort(getLargeNums(1000))));
		assertTrue(demo.checkAscending(demo.shellSort(getLargeNums(955))));
	}
	
	@Test
	public void testBubbleSort() {
		assertTrue(demo.checkAscending(demo.bubbleSort(nums0)));
		assertTrue(demo.checkAscending(demo.bubbleSort(nums1)));
		assertTrue(demo.checkAscending(demo.bubbleSort(nums2)));
		assertTrue(demo.checkAscending(demo.bubbleSort(nums3)));
		assertTrue(demo.checkAscending(demo.bubbleSort(nums4)));
		assertTrue(demo.checkAscending(demo.bubbleSort(nums5)));
		//assertTrue(demo.checkAscending(demo.bubbleSort(getLargeNums(1000))));
		//assertTrue(demo.checkAscending(demo.bubbleSort(getLargeNums(955))));
	}
	
	@Test
	public void testHeapSort() {
		assertTrue(demo.checkAscending(demo.heapSort(nums0)));
		assertTrue(demo.checkAscending(demo.heapSort(nums1)));
		assertTrue(demo.checkAscending(demo.heapSort(nums2)));
		assertTrue(demo.checkAscending(demo.heapSort(nums3)));
		assertTrue(demo.checkAscending(demo.heapSort(nums4)));
		assertTrue(demo.checkAscending(demo.heapSort(getLargeNums(1000))));
		assertTrue(demo.checkAscending(demo.heapSort(getLargeNums(955))));
	}
	
	@Test
	public void testMergeSort() {
		assertTrue(demo.checkAscending(demo.mergeSort(nums0)));
		assertTrue(demo.checkAscending(demo.mergeSort(nums1)));
		assertTrue(demo.checkAscending(demo.mergeSort(nums2)));
		assertTrue(demo.checkAscending(demo.mergeSort(nums3)));
		assertTrue(demo.checkAscending(demo.mergeSort(nums4)));
	    assertTrue(demo.checkAscending(demo.mergeSort(getLargeNums(1000))));
	    assertTrue(demo.checkAscending(demo.mergeSort(getLargeNums(955))));
	}
	
	@Test
	public void testRadixSort() {
		assertTrue(demo.checkAscending(demo.radixSort(nums0)));
		assertTrue(demo.checkAscending(demo.radixSort(nums1)));
		assertTrue(demo.checkAscending(demo.radixSort(nums2)));
		assertTrue(demo.checkAscending(demo.radixSort(nums3)));
		//assertTrue(demo.checkAscending(demo.radixSort(nums4)));//注意基数排序不能处理负数
	    assertTrue(demo.checkAscending(demo.radixSort(getLargeNums(1000))));
	    assertTrue(demo.checkAscending(demo.radixSort(getLargeNums(955))));
	}
	
	@Test
	public void testBucketSort() {
		assertTrue(demo.checkAscending(demo.bucketSort(nums0)));
		assertTrue(demo.checkAscending(demo.bucketSort(nums1)));
		assertTrue(demo.checkAscending(demo.bucketSort(nums2)));
		/*assertTrue(demo.checkAscending(demo.bucketSort(nums3)));
		assertTrue(demo.checkAscending(demo.bucketSort(nums4)));
	    assertTrue(demo.checkAscending(demo.bucketSort(getLargeNums(1000))));
	    assertTrue(demo.checkAscending(demo.bucketSort(getLargeNums(955))));*/
	}
	
	@Test
	public void testCountingSort() {
		assertTrue(demo.checkAscending(demo.countingSort(nums0)));
		assertTrue(demo.checkAscending(demo.countingSort(nums1)));
		assertTrue(demo.checkAscending(demo.countingSort(nums2)));
		assertTrue(demo.checkAscending(demo.countingSort(nums3)));
		assertTrue(demo.checkAscending(demo.countingSort(nums4)));
	    assertTrue(demo.checkAscending(demo.countingSort(getLargeNums(1000))));
	    assertTrue(demo.checkAscending(demo.countingSort(getLargeNums(955))));
	}
}
