package com.yzy.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        //判断
        if (obj == replayItem) {
            step = 0;
            initData();
            initImage();

        } else if (obj == reLoginItem) {
            this.setVisible(false);
            new LoginJFrame();

        }else if (obj == closeItem) {
            System.exit(0);
        }
        else if (obj == accountItem) {
            JDialog jDialog = new JDialog();
            JLabel jLabel1 = new JLabel(new ImageIcon("C:\\Users\\sakura\\Desktop\\a.jpg"));
            jLabel1.setBounds(0, 0, 300, 300);
            jDialog.getContentPane().add(jLabel1);
            //窗口大小
            jDialog.setSize(344,510);
            //让弹窗置顶
            jDialog.setAlwaysOnTop(true);
            //让弹窗居中
            jDialog.setLocationRelativeTo(null);
            //弹窗不关闭则无法操作以下界面
            jDialog.setModal(true);
            jDialog.setVisible(true);
        }
    }
//这里写和游戏相关的所有逻辑

    //创建一个二维数组目的是用来管理数据
    //加载图片的时候会根据二维数组进行加载
    int[][] data = new int[4][4];
    int[][] win = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0},
    };
    //写一个路径
    String path = "C:\\Users\\sakura\\IdeaProjects\\untitled1\\src\\com\\yzy\\素材\\image\\girl\\girl3\\";
    //记录空白方块在二维数组中的位置
    int x = 0;
    int y = 0;

    //定义一个步数
    int step = 0;

    //创建选项下边的条目对象
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem accountItem = new JMenuItem("公众号");


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
            if (tempArr[i] == 0){
                x = i/4;
                y = i%4;
            }

                data[i / 4][i % 4] = tempArr[i];


        }
    }


    //初始化图片
    //添加图片按照二维数组中数据进行添加操作
    private void initImage() {
        //清空原本已经出现的所有图片
        this.getContentPane().removeAll();
        //定义一个步数
        JLabel stepCount = new JLabel("步数"+ step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);
        //调用一下vic
        if (victory()){
            //显示胜利的图标
            JLabel winJLabel = new JLabel(new ImageIcon("C:\\Users\\sakura\\IdeaProjects\\untitled1\\src\\com\\yzy\\素材\\image\\win.png"));
            winJLabel.setBounds(203,283,197,73);
            this.getContentPane().add(winJLabel);
        }

        //创建一个JLabel对象
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //获取当前需要加载图片的序号
                int num = data[i][j];
                JLabel jLabel = new JLabel(new ImageIcon(path+num+".jpg"));
                //指定图片位置
                jLabel.setBounds(105*j+83,105*i+134,105,105);
                //设置边框
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                //把管理容器添加到界面之中
                this.getContentPane().add(jLabel);
            }
        }


        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\sakura\\IdeaProjects\\untitled1\\src\\com\\yzy\\素材\\image\\background.png"));
        //设置背景图片的位置
        background.setBounds(40,40,508,560);
        //把背景图片添加到界面之中
        this.getContentPane().add(background);

        //刷新界面
        this.getContentPane().repaint();

    }

    private void initJFrameBar() {
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();
        //创建两个功能
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        //将每一个选项下边的条目添加到选项之中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);
        aboutJMenu.add(accountItem);

        //给条目绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

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
        //添加键盘监听方法
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);
            //添加背景图片
            JLabel background = new JLabel(new ImageIcon("C:\\Users\\sakura\\IdeaProjects\\untitled1\\src\\com\\yzy\\素材\\image\\background.png"));
            //设置背景图片的位置
            background.setBounds(40,40,508,560);
            //把背景图片添加到界面之中
            this.getContentPane().add(background);
            //刷新界面
            this.getContentPane().repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        //左上右下
        //37 38 39 40
        int code= e.getKeyCode();
        if (code == 37){
            System.out.println("向左移动");
            //逻辑：
            //把空白方块下方的数字向上移动
            //x,y代表空白方块
            //x+1代表把空白方块上边的数字赋值给空白方块
            if (y == 3){
                return;
            }
            data[x][y] = data[x][y+1];
            data[x][y+1] = 0;
            y++;
            step++;
            //按照最新的数字加载图片
            initImage();
        } else if (code == 38) {
            System.out.println("向上移动");
            //逻辑：
            //把空白方块下方的数字向上移动
            //x,y代表空白方块
            //x+1代表把空白方块下边的数字赋值给空白方块
            if (x == 3){
                return;
            }
            data[x][y] = data[x+1][y];
            data[x+1][y] = 0;
            x++;
            step++;
            //按照最新的数字加载图片
            initImage();
        }else if (code == 39) {
            System.out.println("向右移动");
            //逻辑：
            //把空白方块下方的数字向上移动
            //x,y代表空白方块
            //x+1代表把空白方块上边的数字赋值给空白方块
            if (y == 0){
                return;
            }

            data[x][y] = data[x][y-1];
            data[x][y-1] = 0;
            y--;
            step++;
            //按照最新的数字加载图片
            initImage();
        }else if (code == 40) {
            System.out.println("向下移动");
            //逻辑：
            //把空白方块下方的数字向上移动
            //x,y代表空白方块
            //x+1代表把空白方块上边的数字赋值给空白方块
            if (x == 0){
                return;
            }
            data[x][y] = data[x-1][y];
            data[x-1][y] = 0;
            x--;
            step++;
            //按照最新的数字加载图片
            initImage();
        } else if (code == 65) {
            initImage();
        } else if (code == 87) {
            data = new int [][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0},
            };
            initImage();

        }
    }
    //判断victor数组与win相同与否
    public boolean victory(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0 ;j<data[i].length;j++) {
                if (data[i][j] != win[i][j]){
                    //只要有一个不一样false
                    return false;
                }

            }
        }
        //循环结束数组遍历比较完毕,全部一样返回true
        return true;


    }
}
