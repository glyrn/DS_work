//import java.sql.*;
//
//class InsertDataExample {
//    public static void main(String[] args) {
//        String url = "jdbc:mysql://localhost:3306/s-t"; // 替换为您的数据库连接URL
//        String username = "root"; // 替换为您的数据库用户名
//        String password = "200320abc"; // 替换为您的数据库密码
//
//        try {
//            // 连接到数据库
//            Connection conn = DriverManager.getConnection(url, username, password);
//
//            // 创建插入数据的语句
//            String sql = "INSERT INTO people (sno, sname, sage, sdept) VALUES ";
//
//            // 生成30个模拟数据并拼接到插入语句中
//            for (int i = 1; i <= 30; i++) {
//                String sno = "100" + i;
//                String sname = "Student " + i;
//                int sage = 18 + i;
//                String sdept = "Department " + i;
//
//                sql += "('" + sno + "', '" + sname + "', " + sage + ", '" + sdept + "')";
//
//                if (i != 30) {
//                    sql += ", ";
//                }
//            }
//
//            // 创建 Statement 对象
//            Statement statement = conn.createStatement();
//
//            // 执行插入数据操作
//            int rowsInserted = statement.executeUpdate(sql);
//
//            System.out.println(rowsInserted + " rows inserted successfully.");
//
//            // 关闭连接和资源
//            statement.close();
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
