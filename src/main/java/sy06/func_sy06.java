//import java.util.ArrayList;
//
//public class Main {
//
//    public static void main(String[] args) {
//        ArrayList<Node> arrayList = new ArrayList<Node>();
//        arrayList.add(new Node(Integer.MIN_VALUE)); // 哨兵位置
//        System.out.println("下面是排序前: ");
//        int i = 0, j = 0;
//        //填充数组
//        for (i = 1; i < 21; i++) {
//            arrayList.add(1, new Node((int) (Math.random() * 100)));
//        }
//        //展示排序前的内容
//        for (i = 1; i < 21; i++) {
//            System.out.print(arrayList.get(i).key + " ");
//        }
//        System.out.println();
//        for (i = 2; i < 21; i++) {
//            if (arrayList.get(i).key < arrayList.get(i - 1).key) {
//                Node current = arrayList.get(i);
//                arrayList.set(0, current);
//                for (j = i - 1; arrayList.get(j).key > current.key; j--) {
//                    arrayList.set(j + 1, arrayList.get(j));
//                }
//                arrayList.set(j + 1, current);
//            }
//        }
//        //展示排序后的内容
//        System.out.println("下面是排序后：");
//        for (i = 1; i < 21; i++) {
//            System.out.print(arrayList.get(i).key + " ");
//        }
//    }
//}
//
//class Node<T> {
//    public int key;
//    public T value;
//
//    public Node(int key) {
//        this.key = key;
//        value = null;
//    }
//
//    public Node(int key, T value) {
//        this.key = key;
//        this.value = value;
//    }
//}
//----------------------------------------------------------------------------------------------------------------------

//import java.util.ArrayList;
//
//public class Main {
//
//    public static void main(String[] args) {
//        ArrayList<Integer> arrayList = new ArrayList<Integer>();
//        arrayList.add(Integer.MIN_VALUE);
//        for (int i = 1; i < 21; i ++) {
//            arrayList.add(i, (int) (Math.random() * 100));
//        }
//        System.out.print(testTime(arrayList, 0));
//
//    }
//
//    public static long testTime (ArrayList<Integer> arrayList, int method) {
//        long startTime, endTime, testTime;
//        startTime = System.currentTimeMillis();
//        switch (method) {
//            case 0:
//                bubbleSort(arrayList);
//                break;
//            case 1:
//                quickSort(arrayList, 1, 20);
//                break;
//            case 2:
//                charuSort(arrayList);
//                break;
//            default:
//                break;
//        }
//        endTime = System.currentTimeMillis();
//        testTime = endTime - startTime;
//        return testTime;
//    }
//    public static void quickSort(ArrayList<Integer> arrayList, int low, int high) {
//        if (low < high) {
//            int pivotloc = partition(arrayList, low, high);
//            quickSort(arrayList, low, pivotloc - 1);
//            quickSort(arrayList, pivotloc + 1, high);
//        }
//    }
//    public static int partition(ArrayList arrayList, int low, int high) {
//        arrayList.set(0, arrayList.get(low));
//        int k = (Integer) arrayList.get(low);
//        while (low < high) {
//            while (low < high && (Integer)arrayList.get(high) >= k) {
//                high --;
//            }
//            arrayList.set(low, arrayList.get(high));
//            while (low < high && (Integer)arrayList.get(low) <= k) {
//                low ++;
//            }
//            arrayList.set(high, arrayList.get(low));
//        }
//        arrayList.set(low, arrayList.get(0));
//        return low;
//    }
//    public static void bubbleSort(ArrayList<Integer> arrayList) {
//        int m = 0, i = 0, j = 0;
//        int x = 0;
//        int flag = 1;
//        for (m = 1; m <= 19 && flag == 1; m ++) {
//            flag = 0;
//            for (j = 1; j < 19 - m; j ++) {
//                if ((Integer) arrayList.get(j) > (Integer) arrayList.get(j + 1)) {
//                    flag = 1;
//                    x = (Integer) arrayList.get(j);
//                    arrayList.set(j, arrayList.get(j + 1));
//                    arrayList.set(j + 1, x);
//                }
//            }
//        }
//    }
//    public static void charuSort(ArrayList<Integer> arrayList) {
//        int i = 0;
//        int j = 0;
//        int x = 0;
//        for (i = 2; i < 21; i ++) {
//            if ((Integer) arrayList.get(i) < (Integer) arrayList.get(i - 1)) {
//                arrayList.set(0, arrayList.get(i));
//                x = (Integer) arrayList.get(i);
//                for (j = i - 1; (Integer) arrayList.get(j) >= (Integer) arrayList.get(0); j --) {
//                    arrayList.set(j+1, arrayList.get(j));
//                }
//                arrayList.set(j + 1, x);
//            }
//        }
//    }
//}
////用来记录移动次数和比较次数
//class CopareMoveNum{
//    public int copareNum;
//    public int moveNum;
//}
//
//import java.util.ArrayList;
//
//public class Main {
//    static CopareMoveNum compareMoveNum;
//
//    public static void main(String[] args) {
//        ArrayList<Integer> arrayList = new ArrayList<Integer>();
//        arrayList.add(Integer.MIN_VALUE);
//        for (int i = 1; i <= 50000; i++) {
//            arrayList.add((int) (Math.random() * 100));
//        }
//        compareMoveNum = new CopareMoveNum();
//        long bubbleSortTime = testTime(arrayList, 0);
//        System.out.println("冒泡排序用时: " + bubbleSortTime + " ms");
//        System.out.println("比较次数: " + compareMoveNum.compareNum);
//        System.out.println("移动次数: " + compareMoveNum.moveNum);
//
//        compareMoveNum = new CopareMoveNum();
//        long quickSortTime = testTime(arrayList, 1);
//        System.out.println("快速排序用时: " + quickSortTime + " ms");
//        System.out.println("比较次数: " + compareMoveNum.compareNum);
//        System.out.println("移动次数: " + compareMoveNum.moveNum);
//
//        compareMoveNum = new CopareMoveNum();
//        long insertionSortTime = testTime(arrayList, 2);
//        System.out.println("插入排序用时: " + insertionSortTime + " ms");
//        System.out.println("比较次数: " + compareMoveNum.compareNum);
//        System.out.println("移动次数: " + compareMoveNum.moveNum);
//    }
//
//    public static long testTime(ArrayList<Integer> arrayList, int method) {
//        ArrayList<Integer> copyList = new ArrayList<>(arrayList);
//        long startTime, endTime, testTime;
//        compareMoveNum.reset();
//        startTime = System.currentTimeMillis();
//        switch (method) {
//            case 0:
//                bubbleSort(copyList);
//                break;
//            case 1:
//                quickSort(copyList, 1, copyList.size() - 1);
//                break;
//            case 2:
//                insertionSort(copyList);
//                break;
//            default:
//                break;
//        }
//        endTime = System.currentTimeMillis();
//        testTime = endTime - startTime;
//        return testTime;
//    }
//
//    public static void quickSort(ArrayList<Integer> arrayList, int low, int high) {
//        if (low < high) {
//            int pivotLoc = partition(arrayList, low, high);
//            quickSort(arrayList, low, pivotLoc - 1);
//            quickSort(arrayList, pivotLoc + 1, high);
//        }
//    }
//
//    public static int partition(ArrayList<Integer> arrayList, int low, int high) {
//        int pivot = arrayList.get(low);
//        while (low < high) {
//            while (low < high && arrayList.get(high) >= pivot) {
//                compareMoveNum.compareNum++;
//                high--;
//            }
//            arrayList.set(low, arrayList.get(high));
//            compareMoveNum.moveNum++;
//            while (low < high && arrayList.get(low) <= pivot) {
//                compareMoveNum.compareNum++;
//                low++;
//            }
//            arrayList.set(high, arrayList.get(low));
//            compareMoveNum.moveNum++;
//        }
//        arrayList.set(low, pivot);
//        return low;
//    }
//
//    public static void bubbleSort(ArrayList<Integer> arrayList) {
//        int n = arrayList.size() - 1;
//        boolean swapped;
//        for (int i = 0; i < n; i++) {
//            swapped = false;
//            for (int j = 0; j < n - i; j++) {
//                compareMoveNum.compareNum++;
//                if (arrayList.get(j) > arrayList.get(j + 1)) {
//                    swap(arrayList, j, j + 1);
//                    compareMoveNum.moveNum++;
//                    swapped = true;
//                }
//            }
//            if (!swapped) {
//                break;
//            }
//     wochaonima   }
//    }
//
//    public static void insertionSort(ArrayList<Integer> arrayList) {
//        int n = arrayList.size();
//        for (int i = 1; i < n; i++) {
//            int key = arrayList.get(i);
//            int j = i - 1;
//            while (j >= 0 && arrayList.get(j) > key) {
//                compareMoveNum.compareNum++;
//                arrayList.set(j + 1, arrayList.get(j));
//                compareMoveNum.moveNum++;
//                j--;
//            }
//            arrayList.set(j + 1, key);
//            compareMoveNum.moveNum++;
//        }
//    }
//
//    public static void swap(ArrayList<Integer> arrayList, int i, int j) {
//        int temp = arrayList.get(i);
//        arrayList.set(i, arrayList.get(j));
//        arrayList.set(j, temp);
//        compareMoveNum.moveNum += 3;
//    }
//}
//
//class CopareMoveNum {
//    public int compareNum;
//    public int moveNum;
//
//    public CopareMoveNum() {
//        this.compareNum = 0;
//        this.moveNum = 0;
//    }
//
//    public void reset() {
//        this.compareNum = 0;
//        this.moveNum = 0;
//    }
//}
