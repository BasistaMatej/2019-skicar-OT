package sk.stuba.fei.uim.oop.gui;

import sk.stuba.fei.uim.oop.controls.GameLogic;

import javax.swing.*;
import java.awt.*;

public class SideMenu extends JPanel {

    public SideMenu(GameLogic logic) {
        this.setLayout(new GridLayout(1,3));
        this.add(createJButton(GameLogic.BUTTON_CIRCLE_TEXT,logic));
        this.add(createJButton(GameLogic.BUTTON_LINE_TEXT,logic));
        this.add(createJButton(GameLogic.BUTTON_COLOR_TEXT,logic));

    }

    private JButton createJButton(String text, GameLogic logic) {
        JButton button = new JButton(text);
        button.addActionListener(logic);
        button.setFocusable(false);
        return button;
    }
}
