import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<stu> arrayList = new ArrayList<stu>();
        arrayList.add(new stu(1, "x", 999999, 9999999));
        int value = 1;
        while (value == 1) {
            value = 0;
            System.out.println("请输入学生信息");
            stu stu = new stu(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.nextInt());
            arrayList.add(1, stu);
            System.out.println("是否选择继续");
            value = scanner.nextInt();

        }
        System.out.println("学号    姓名    英语    数学    总分");
        for (int i = 1; i < arrayList.size(); i++) {
            stu student = arrayList.get(i);
            System.out.printf("%-6d  %-6s  %-6d  %-6d  %-6d%n", student.Snum, student.Sname, student.English, student.Math, student.Score);
        }
        System.out.println("下面对总成绩进行排序");
        sort(arrayList);
        System.out.println("学号    姓名    英语    数学    总分");
        for (int i = 1; i < arrayList.size(); i++) {
            stu student = arrayList.get(i);
            System.out.printf("%-6d  %-6s  %-6d  %-6d  %-6d%n", student.Snum, student.Sname, student.English, student.Math, student.Score);
        }

    }

    public static void sort(ArrayList<stu> arrayList) {
        for (int i = 1; i < arrayList.size(); i++) {
            stu key = arrayList.get(i);
            int j = i - 1;
            while (j >= 0 && arrayList.get(j).Score < key.Score) {
                arrayList.set(j + 1, arrayList.get(j));
                j--;
            }
            arrayList.set(j + 1, key);
        }
    }

}

class stu {
    public int Snum;
    public String Sname;
    public int English;
    public int Math;
    public int Score;

    public stu(int snum, String sname, int English, int Math) {
        Snum = snum;
        Sname = sname;
        this.English = English;
        this.Math = Math;
        Score = English + Math;

    }
}
