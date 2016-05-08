package com.izhaoyan.util;

import java.awt.*;

/**
 * Created by Rockyan on 2016/5/7.
 */
public class UiUtils {

    public static void placeToCenter(Container container) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dimension.getWidth() - container.getWidth()) / 2;
        int y = (int) (dimension.getHeight() - container.getHeight()) / 2;
        container.setBounds(x, y, container.getWidth(), container.getHeight());
    }
}
