学习笔记
#### 1.冒泡排序

```java
public void bubbleSort(int[] array) {
  int n = array.length;
  for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - 1 - i; j++) {
      if (array[j] > array[j + 1]) { // 相邻元素对比，不是正序则交换
        int temp = array[j + 1];
        array[j + 1] = array[j];
        array[j] = temp;
      }
    }
  }
}
```

#### 2.选择排序

```java
public void selectionSort(int[] arr) {
  int n = arr.length;
  int minIndex,temp;
  for (int i = 0; i < n - 1; i++) {
    minIndex = i;
    for (int j = i + 1; j < n; j++) {
      if (arr[j] < arr[minIndex]) { // 如果当前元素比“最小值”小，则更新最小值的索引
        minIndex = j;
      }
    }
    temp = arr[i];
    arr[i] = arr[minIndex];
    arr[minIndex] = temp;
  }
}
```

#### 3.插入排序

```java
public void insertionSort(int[] arr) {
  int n = arr.length;
  int preIndex, current;
  for (int i = 1; i < n; i++) {
    preIndex = i - 1;
    current = arr[i];
    while (preIndex >=0 && current < arr[preIndex]) {
      arr[preIndex + 1] = arr[preIndex];
      preIndex --;
    }
    arr[preIndex + 1] = current;
  }
}
```

#### 4.希尔排序

```java
public void shellSort(int[] arr) {
  int n = arr.length;
  for (int gap = n / 2; gap > 0; gap = gap / 2) {
    for (int i = gap; i < n; i++) {
      int j = i;
      int current = arr[i];
      while (j - gap >= 0 && current < arr[j - gap]) {
        arr[j] = arr[j - gap];
        j = j - gap;
      }
      arr[j] = current;
    }
  }
}
```
