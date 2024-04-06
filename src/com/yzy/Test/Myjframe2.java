package com.yzy.Test;

import javax.swing.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Myjframe2 extends JFrame implements MouseListener {
    JButton jbt1 = new JButton("点击我啊！");
    //创建一个按钮对象
    JButton jbt2 = new JButton("请再次点击我！！");

    public Myjframe2() {
        //设置界面宽高
        this.setSize(603, 680);
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
        jbt1.setBounds(0, 0, 100, 50);
        //给按钮绑定鼠标事件
        jbt1.addMouseListener(this);

        //设置按钮位置
        jbt2.setBounds(200, 0, 100, 50);


        //把按钮添加到界面之中
        this.getContentPane().add(jbt1);
        this.getContentPane().add(jbt2);

        //设置界面可视化
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
