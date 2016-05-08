package com.izhaoyan.compent;

import com.izhaoyan.util.UiUtils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rockyan on 2016/5/7.
 */
public class BaseFrame extends JFrame{
    private int defaultWidth = 520;
    private int defalultHeight = 580;

    public BaseFrame(){
        setTitle("snail");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(defaultWidth,defalultHeight));
        UiUtils.placeToCenter(this);
//        setUndecorated (true); //去掉系统的边框
        this.setResizable(false);
    }
}
