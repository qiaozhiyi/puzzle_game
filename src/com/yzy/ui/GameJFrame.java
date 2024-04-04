package com.yzy.ui;

import javax.swing.*;
import java.util.Random;

public class GameJFrame extends JFrame {
    //这里写和游戏相关的所有逻辑

    //创建一个二维数组目的是用来管理数据
    //加载图片的时候会根据二维数组进行加载
    int[][] data = new int[4][4];

    public GameJFrame(){
        //初始化菜单
        initJFrame();

        //初始化菜单
        initJFrameBar();

        //初始化数据
        initData();

        //初始化图片
        initImage();

        //设置可视化
        this.setVisible(true);
    }
    //初始化数据
    private void initData(){
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        //给二维数组添加数据
        //解法一
        //遍历一维数组得到每一个元素
        //将每一个元素依次添加到二维数组中
        for (int i = 0; i < tempArr.length; i++) {
            data[i / 4][i % 4] = tempArr[i];
        }
    }


    //初始化图片
    //添加图片按照二维数组中数据进行添加操作
    private void initImage() {

        //先加载的图片在上方后加载的在下边

        //创建一个JLabel对象
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //获取当前需要加载图片的序号
                int num = data[i][j];
                JLabel jLabel = new JLabel(new ImageIcon("C:\\Users\\sakura\\IdeaProjects\\untitled1\\src\\com\\yzy\\素材\\image\\animal\\animal3\\"+num+".jpg"));
                //指定图片位置
                jLabel.setBounds(105*j+83,105*i+134,105,105);
                //把管理容器添加到界面之中
                this.getContentPane().add(jLabel);
            }
        }
        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\sakura\\IdeaProjects\\untitled1\\src\\com\\yzy\\素材\\image\\background.png"));
        background.setBounds(40,40,508,560);
        //把背景图片添加到界面之中
        this.getContentPane().add(background);



    }

    private void initJFrameBar() {
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();
        //创建两个功能
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        //创建选项下边的条目对象
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");
        JMenuItem accountItem = new JMenuItem("公众号");
        //将每一个选项下边的条目添加到选项之中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);
        aboutJMenu.add(accountItem);
        //将菜单中的两个选项添加到菜单之中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);
        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        this.setSize(630,680);
        //设置界面头
        this.setTitle("拼图单机版v1.0");
        //设置置顶
        this.setAlwaysOnTop(true);
        //设置居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的居中放置
        this.setLayout(null);
    }

}
