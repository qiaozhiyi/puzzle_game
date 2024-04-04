package com.yzy.ui;

import com.yzy.ui.myactionlisten;

import javax.swing.*;

public class Test extends JFrame {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(630,680);
        //设置界面头
        jFrame.setTitle("拼图单机版v1.0");
        //设置置顶
        jFrame.setAlwaysOnTop(true);
        //设置居中
        jFrame.setLocationRelativeTo(null);
        //设置关闭模式
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的居中放置
        jFrame.setLayout(null);

        //设置一个按钮对象
        JButton jtb = new JButton("点击我！");
        jtb.setBounds(0,0,100,55);

        //参数：事件被触发之后要执行的代码
        jtb.addActionListener(new myactionlisten());

       //把按钮添加到页面中
        jFrame.getContentPane().add(jtb);



        jFrame.setVisible(true);
    }
}