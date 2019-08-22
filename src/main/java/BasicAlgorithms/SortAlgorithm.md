**稳定排序：**

- 冒泡排序           — O(n²)
- 插入排序           — O(n²)
- 桶排序               — O(n); 需要 O(k) 额外空间
- 归并排序           — O(nlogn); 需要 O(n) 额外空间
- 二叉排序树排序— O(n log n) 期望时间; O(n²)最坏时间; 需要 O(n) 额外空间
- 基数排序            — O(n·k); 需要 O(n) 额外空间

**不稳定排序**

- 选择排序— O(n²)
- 希尔排序— O(nlogn)
- 堆排序    — O(nlogn)
- 快速排序— O(nlogn) 期望时间, O(n²) 最坏情况; 对于大的、乱数串行一般相信是最快的已知排序

#### **1、冒泡排序 **-O(n²) -稳定

a[i] 和a[i+1]相比，每比完一次最后一位为最大，下一次可省略比较，所以j<=n-1-i。第一层循环i表示排序的轮数，第二层循环j表示比较的次数

1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。

2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。

3、针对所有的元素重复以上的步骤，除了最后一个。

![img](https://www.runoob.com/wp-content/uploads/2019/03/bubbleSort.gif)

```java
public class BubbleSort {
    public int[] sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
 // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;         
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) 
                break;
        }
        return arr;
    }
}
```

```python
def bubbleSort(arr):
    for i in range(1, len(arr)):
        for j in range(0, len(arr)-i):
            if arr[j] > arr[j+1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    return arr
```

#### **2、选择排序**-O(n²)-不稳定

1、在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。

2、从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。

3、重复第二步，直到所有元素均排序完毕。

![img](https://www.runoob.com/wp-content/uploads/2019/03/selectionSort.gif)

```java
public class SelectionSort {
    public void sort(int[] a){

        for (int i = 0; i < a.length - 1; i++){
            //每轮遍历开始都认为min在未排序的第一位
            int min = i;
            //遍历一遍查找最小值
            //j从i+1位置开始查找
            for (int j = i+1; j < a.length; j++){
                if (a[j] < a[min]){
                    min = j;
                }
            }

            if (min != i){
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }
}
```

```python
def selection_sort(arr):
    for i in range(len(arr)-1):
        min_index  = i 
        for j in range(i+1, len(arr)):
            if arr[j] < arr[min_index]:
                min_index = j
        if min_index != i:
            arr[i], arr[min_index] = arr[min_index], arr[i]
```

#### **3、插入排序**-O(n²)-稳定

将一个数插入有序数组，数组[2,5,7,9,  6], 视为将6插入有序数组，当6>5时停止。i从1开始，视为将第一个数视为有序数组。i看成指向需要插入的数的引用。

1、将第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。

2、从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。

![img](https://www.runoob.com/wp-content/uploads/2019/03/insertionSort.gif)

```java
public class InsertSort {
    public void sort(int[] a){
        for (int i = 1; i < a.length; i++){
            int temp = a[i];
            int j = i-1;
            while (j>=0 && temp < a[j]){
                a[j+1] = a[j];
                j--;
            }
            if (j+1 != i)
                a[j+1] = temp;
        }
    }
}
```

```python
def insert_sort(a):
    for i in range(1,len(a)):
        temp = a[i]
        j = i-1
        while j >=0 and temp < a[j]:
            a[j+1] = a[j]
            j -= 1
        a[j+1] = temp
```

#### 4、希尔排序-O(nlogn)-不稳定

每隔一个gap（增量因子）选取为一个分组内的数

![img](http://p1.pstatp.com/large/pgc-image/1523763390411731c4d486d)

- 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
- 按增量序列个数k，对序列进行k 趟排序；
- 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。

![img](http://p3.pstatp.com/large/pgc-image/153317637365518c476eba9)

```java
public class shellSort {
    public void sort(int[] arr){
        
        //分成长度大小为len/3的组
        int gap = (int) Math.floor(arr.length/3);
        while (gap > 0){
                for (int i = gap; i < arr.length; i++){
                    int temp = arr[i];
                    int j = i - gap;
                    while (j>=0 && temp < arr[j]){
                        //需要注意增量gap
                        arr[j+gap] = arr[j];
                        j -= gap;
                    }
                    arr[j+gap] = temp;
                }
            	//增长因子变为原来的1/3
                gap = (int) Math.floor(gap/3);
        }
    }
}
```

```python
def shell_sort(a):
    gap = floor(len(a) / 3)
    while gap > 0:
        for i in range(gap, len(a)):
            tmp = a[i]
            j = i - gap
            while j>=0 and tmp < a[j]:
                a[j+gap] = a[j]
                j -= gap
            a[j+gap] = tmp
        gap = floor(gap/3)
```

#### 5、归并排序

1、归并排序的流程

![img](https://upload-images.jianshu.io/upload_images/7789414-b410a7c0fea50eba.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1000/format/webp)

2、合并两个有序数组的流程

![img](https://upload-images.jianshu.io/upload_images/7789414-4b8f4cb3cb5f0a9f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1000/format/webp)

![img](https://upload-images.jianshu.io/upload_images/7789414-2737ec30a70ff74f.gif?imageMogr2/auto-orient/strip%7CimageView2/2/w/811/format/webp)

```java
public class MergeSort {

    //两路归并算法，两个排好序的子序列合并为一个子序列
    public void merge(int []a,int left,int mid,int right){
        int []tmp=new int[a.length];//辅助数组
        int p1=left,p2=mid+1,k=left;//p1、p2是检测指针，k是存放指针

        while(p1<=mid && p2<=right){
            if(a[p1]<=a[p2])
                tmp[k++]=a[p1++];
            else
                tmp[k++]=a[p2++];
        }

        while(p1<=mid) tmp[k++]=a[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while(p2<=right) tmp[k++]=a[p2++];//同上

        //复制回原素组
        for (int i = left; i <=right; i++)
            a[i]=tmp[i];
    }

    public void mergeSort(int [] a,int start,int end){
        if(start<end){//当子序列中只有一个元素时结束递归
            int mid=(start+end)/2;//划分子序列
            mergeSort(a, start, mid);//对左侧子序列进行递归排序
            mergeSort(a, mid+1, end);//对右侧子序列进行递归排序
            merge(a, start, mid, end);//合并
        }
    }
}
```

```python
def merge(arr, l, m, r): 
    # 创建临时数组
    left = arr[l : m+1]
    right = arr[m+1 : r+1]   
    # 归并临时数组到 arr[l..r] 
    k = l     # 初始归并子数组的索引  
    while left and right : 
        if left[0] <= right[0]: 
            arr[k] = left.pop(0) 
        else: 
            arr[k] = right.pop(0)
        k += 1  
    # 拷贝 L[] 的保留元素
    while left: 
        arr[k] = left.pop(0) 
        k += 1
    # 拷贝 R[] 的保留元素
    while right: 
        arr[k] = right.pop(0)
        k += 1
  
def mergeSort(arr,l,r): 
    if l < r:         
        m = int((l+(r-1))/2)
        mergeSort(arr, l, m) 
        mergeSort(arr, m+1, r) 
        merge(arr, l, m, r) 
        
a = [22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70]
mergeSort(a,0,len(a)-1)
```

#### 6、快速排序-O(nlogn)-不稳定

1. 从数列中挑出一个元素，称为 "基准"（pivot）;
2. 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
3. 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序

![img](https://www.runoob.com/wp-content/uploads/2019/03/quickSort.gif)

![img](https://img-blog.csdn.net/20180910121224126?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25yc2MyNzI0MjAxOTk=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![img](https://img-blog.csdn.net/20180910121350322?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25yc2MyNzI0MjAxOTk=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![img](https://img-blog.csdn.net/20180910121503615?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25yc2MyNzI0MjAxOTk=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![img](https://img-blog.csdn.net/20180910121538339?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25yc2MyNzI0MjAxOTk=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![img](https://img-blog.csdn.net/20180910121618344?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25yc2MyNzI0MjAxOTk=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)



```java
public class QuickSort {
    public void sort(int[] arr, int left, int right){
        int povit = arr[left];
        int l = left;
        int h = right;

        while (l < h){
            //从后往前搜索，查到比基准小的放到基准的位置上
            while (h > l && arr[h] >= povit)
                h--;
            if (l < h){
                arr[l] = arr[h];
                l++;
            }

            //
            while (l < h && arr[l] <= povit)
                l++;
            if (l < h){
                arr[h] = arr[l];
                h--;
            }
        }

        arr[l] = povit;

        if (l - 1 > left) sort(arr, left, l - 1);
        if (h + 1 < right) sort(arr, h + 1, right);
    }
}
```

```python
def Quicksort(a, left, right):
    povit = a[left]
    l = left
    h = right
    
    while l < h:
        while h > l and a[h] >= povit:
            h -= 1
        if h > l:
            a[l] = a[h]
        
        while l < h and a[l] <= povit:
            l += 1
        if l < h:
            a[h] = a[l]
    a[l] = povit
    
    if l-1 > left:
        Quicksort(a, left, l-1)
    if h+1 < right:
        Quicksort(a, h+1, right)
```

