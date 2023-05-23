package sk.stuba.fei.uim.oop.gui;

import sk.stuba.fei.uim.oop.controls.GameLogic;

import javax.swing.*;
import java.awt.*;

public class Skicar extends JFrame {
    private static final int FRAME_SIZE = 700;

    public Skicar() {
        super();
        this.setTitle("Skicar 2019 - OT");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FRAME_SIZE, FRAME_SIZE);
        this.setLayout(new BorderLayout());

        GameLogic logic = new GameLogic();
        this.add(new SideMenu(logic), BorderLayout.PAGE_START);
        this.add(logic.getDrawingPanel(), BorderLayout.CENTER);

        JPanel bottomMenu = new JPanel();
        bottomMenu.setLayout(new GridLayout(1,2));
        bottomMenu.add(logic.getChangeColorButton());
        bottomMenu.add(logic.getLabel());

        this.add(bottomMenu, BorderLayout.PAGE_END);
        this.setFocusable(true);
        this.setVisible(true);
    }
}
