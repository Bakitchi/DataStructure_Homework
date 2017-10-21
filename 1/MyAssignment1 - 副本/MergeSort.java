//归并排序
public class MergeSort {

	void sort(int[] array) {
		subSort(array, 0, array.length);
	}

	void subSort(int[] array, int l, int r) {
		int mid = (l + r) / 2;
		if(l == r) return;	//只有一个元素时，返回 
		//左边
		subSort(array, l, mid);
		//右边
		subSort(array, mid + 1, r);
		//归并两个有序数组
		int[] temp = new int[r - l + 1];
		int i = l;// 左指针
		int j = mid + 1;// 右指针
		int k = 0;

		// 把较小的数先移到新数组中
		while (i <= mid && j <= r) {
			if (array[i] < array[j]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];
			}
		}

		// 把左边剩余的数移入数组
		while (i <= mid) {
			temp[k++] = array[i++];
		}

		// 把右边边剩余的数移入数组
		while (j <= r) {
			temp[k++] = array[j++];
		}

		// 把新数组中的数覆盖array数组
		for (int k2 = 0; k2 < temp.length; k2++) {
			array[k2 + l] = temp[k2];
		}
	}