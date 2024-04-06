package com.yzy.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {
    //创建一个按钮对象
    JButton jbt1 =new JButton("点击我啊！");
    //创建一个按钮对象
    JButton jbt2 =new JButton("请再次点击我！！");

    public MyJFrame() {
        //设置界面宽高
        this.setSize(603,680);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置界面标题
        this.setTitle("拼图游戏单机版 v1.0");
        //设置置顶
        this.setAlwaysOnTop(true);
        //设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置取消默认居中放置
        this.setLayout(null);




        //设置按钮位置
        jbt1.setBounds(0,0,100,50);
        //给按钮添加事件
        jbt1.addActionListener(this);


        //设置按钮位置
        jbt2.setBounds(200,0,100,50);
        //给按钮添加事件
        jbt2.addActionListener(this);

        //把按钮添加到界面之中
        this.getContentPane().add(jbt1);
        this.getContentPane().add(jbt2);

        //设置界面可视化
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //对当前按钮进行判断

        //获取当前被操作的按钮对象
        Object source = e.getSource();

        if(source == jbt1){
            jbt1.setSize(200,200);

        }
        else if(source == jbt2){
            Random r = new Random();
            jbt2.setLocation(r.nextInt(500),r.nextInt(500));
        }

    }
}
