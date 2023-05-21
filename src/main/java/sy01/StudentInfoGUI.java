package sy01;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentInfoGUI extends JFrame {
    private JPanel buttonPanel;
    private JPanel tablePanel;
    private JTable table;

    public StudentInfoGUI() {
        setTitle("学生信息管理系统");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 按钮面板
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        JButton addButton = new JButton("添加");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 弹出对话框，让用户输入新学生的信息
                String name = JOptionPane.showInputDialog("请输入学生姓名：");
                String age = JOptionPane.showInputDialog("请输入学生年龄：");
                String gender = JOptionPane.showInputDialog("请输入学生性别：");

                // 添加新行到表格中
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{name, age, gender});
            }
        });

        JButton deleteButton = new JButton("删除");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取用户选择的行
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // 从表格中删除该行
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(StudentInfoGUI.this, "请选择要删除的学生信息！");
                }
            }
        });

        JButton searchButton = new JButton("查询");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 弹出对话框，让用户输入要查询的学生姓名
                String name = JOptionPane.showInputDialog("请输入要查询的学生姓名：");

                // 在表格中查找并选中该学生
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    if (model.getValueAt(i, 0).equals(name)) {
                        table.setRowSelectionInterval(i, i);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(StudentInfoGUI.this, "没有找到该学生的信息！");
            }
        });
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);
        add(buttonPanel, BorderLayout.NORTH);

        // 学生信息表格
        tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        table = new JTable(new DefaultTableModel(
                new Object[][]{
                        {"张三", "18", "男"},
                        {"李四", "20", "女"},
                        {"王五", "22", "男"}
                },
                new Object[]{"姓名", "年龄", "性别"}
        ));
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane);
        add(tablePanel, BorderLayout.CENTER);
    }

//    public static void main(String[] args) {
//        StudentManagementSystemGUI gui = new StudentManagementSystemGUI();
//        gui.setVisible(true);
//    }
}
