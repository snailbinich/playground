package com.izhaoyan.dragdrop;

import com.izhaoyan.compent.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;

/**
 * Created by Rockyan on 2016/5/7.
 */
public class DragFrame extends BaseFrame {

    JPanel jPanel ;
    JLabel jLabel;

    public DragFrame() {
        jPanel = new JPanel();
        jPanel.setBackground(Color.ORANGE);
        jLabel = new JLabel();
        jPanel.add(jLabel);
        add(jPanel);
        drag();
    }

    public void drag(){
        new DropTarget(jPanel, DnDConstants.ACTION_COPY_OR_MOVE, new DropTargetAdapter() {
            @Override
            public void drop(DropTargetDropEvent dtde) {
                try {
                    if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                        dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                        java.util.List<File> list = (java.util.List<File>) (dtde.getTransferable()
                                .getTransferData(DataFlavor.javaFileListFlavor));
                        String temp="<html>";
                        for(File file:list) {
                            temp += file.getAbsolutePath() + "<br/>";
                        }
                        temp+="</html>";
//                        JOptionPane.showMessageDialog(null, temp);
                        jLabel.setText(temp);
                        dtde.dropComplete(true);//指示拖拽操作已完成
                    }else {
                        dtde.rejectDrop();
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }


    public static void main(String[] args) {
        DragFrame dragFrame = new DragFrame();
        dragFrame.setVisible(true);
    }
}
