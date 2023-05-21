package sy01;

import java.util.Scanner;

public class stuManageSystem {
    int trueLength = 6;

    public stuManageSystem() throws Exception {
        //建立顺序表
        SqList stuMessage = new SqList(20);
        stuMessage.insert(0, new student("2008001", "Alan", "F", "13305731238", "浙江省嘉兴市"));
        stuMessage.insert(1, new student("2008002", "Danie", "M", "0573-82283288", "浙江省嘉兴市"));
        stuMessage.insert(2, new student("2008003", "Helen", "M", "13507942222", "江西省抚州市"));
        stuMessage.insert(3, new student("2008004", "Bill", "F", "0571-72529911", "浙江省杭州市"));
        stuMessage.insert(4, new student("2008005", "Peter", "M", "13857354444", "浙江省嘉兴市"));
        stuMessage.insert(5, new student("2008006", "Amy", "F", "13956367777", "安徽省蚌埠市"));
        //输入程序可用
        //stuMessage.insert(0, inputStu());
        stuMessage.display();
    }

    //插入函数
    public student inputStu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入学号：");
        String stuNum = scanner.next();

        System.out.println("请输入姓名：");
        String name = scanner.next();

        System.out.println("请输入性别：");
        String sex = scanner.next();

        System.out.println("请输入电话：");
        String telNum = scanner.next();

        System.out.println("请输入地址：");
        String address = scanner.next();

        return new student(stuNum, name, sex, telNum, address);
    }


    //查询函数
//    public student find(String message, SqList stuMessage) {
//        for (int i = 0; i < trueLength; i++) {
//            if (stuMessage.getListElem()[i].equals(message))
//        }
//    }


}
