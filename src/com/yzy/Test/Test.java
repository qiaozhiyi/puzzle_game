package com.yzy.Test;
//常见的组件监听KeyListener MouseListener ActionListener
//三个分别是键盘监听，鼠标监听，动作监听

import com.yzy.ui.myactionlisten;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame implements ActionListener {
    public static void main(String[] args) {
        //设置宽和高
        JFrame jFrame =new JFrame();
        //设置宽高
        jFrame.setSize(603,680);
        //设置标题
        jFrame.setTitle("事件演示");
        //设置界面居中
        jFrame.setLocationRelativeTo(null);
        //设置界面置顶
        jFrame.setAlwaysOnTop(true);
        //设置界面关闭模式
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置取消居中放置
        jFrame.setLayout(null);







        //创建第一个按钮
        JButton JTB1 = new JButton("好兄弟来戳我");
        JTB1.setBounds(0,0,100,50);
        //动作监听:鼠标左键单击和空格
        JTB1.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("你好香啊兄弟");
        }
        }
        );


        //创建第二个按钮
        JButton jtb2 = new JButton("请再次点击我");
        jtb2.setBounds(100,0,100,50);






        //按钮添加到界面之中
        jFrame.getContentPane().add(JTB1);

        //设置界面可视化
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //对当前按钮进行判断
        //获取当前被操作的按钮对象
        Object source = e.getSource();
    }
}
