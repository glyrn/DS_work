package sy01;

public class part4 {
    public static void removepublic(SqList A, SqList B, SqList C) throws Exception {
        int aIndex = 0, bIndex = 0, cIndex = 0;
        //寻找B和C中的公共元素
        while (bIndex < B.length() && cIndex < C.length()) {
            if ((Integer) B.get(bIndex) < (Integer) C.get(cIndex))
                bIndex++;
            else if ((Integer) B.get(bIndex) > (Integer) C.get(cIndex))
                cIndex++;
            else {
                //查找A表中是否有这个元素 如果存在就删除
                while (aIndex < A.length() && (Integer) A.get(aIndex) < (Integer) B.get(bIndex))
                    aIndex++;
                if (aIndex < A.length() && (Integer) A.get(aIndex) == (Integer) B.get(bIndex))
                    A.remove(aIndex);
                bIndex++;
                cIndex++;
            }
        }
    }
}
//    SqList A = new SqList(5);
//        for (int i = 0; i < 5; i ++) {
//        A.insert(i, i + 1);
//        }
//        A.display();
//
//        SqList B = new SqList(3);
//        B.insert(0, 2);
//        B.insert(1, 4);
//        B.insert(2, 6);
//        B.display();
//
//        SqList C = new SqList(2);
//        C.insert(0, 2);
//        C.insert(1, 5);
//        C.display();
//
//        part4.removepublic(A, B, C);
//        A.display();
