package sk.stuba.fei.uim.oop.shapes;

import lombok.Getter;
import sk.stuba.fei.uim.oop.controls.GameLogic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JPanel {
    @Getter
    private ArrayList<Shape> circles;
    @Getter
    private ArrayList<Shape> lines;

    public Canvas(GameLogic logic) {
        this.setLayout(null);
        circles = new ArrayList<>();
        lines = new ArrayList<>();
        this.addMouseMotionListener(logic);
        this.addMouseListener(logic);
    }

    public void addToLines(Shape line) {
        lines.add(line);
    }
    public void addToCircles(Shape circle) {
        circles.add(circle);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        for (Shape shape : circles) {
            int width = shape.getEndX()- shape.getStartX();
            int height = shape.getEndY()- shape.getStartY();
            int widthSymbol = 1;
            int heightSymbol = 1;
            int startX = shape.getStartX();
            int startY = shape.getStartY();

            if (width < 0) {
                widthSymbol = -1;
                startX = shape.getEndX();
            }
            if (height < 0) {
                heightSymbol = -1;
                startY = shape.getEndY();
            }
            g.setColor(shape.getColor());
            g.fillOval(startX,startY, (widthSymbol)*width, (heightSymbol)*height);
            g.setColor(Color.WHITE);
            g.fillOval(startX+(widthSymbol)*width/3,startY+(heightSymbol)*height/3,((widthSymbol)*width)/3,((heightSymbol)*height)/3);
        }
        for (Shape shape : lines) {
            g.setColor(shape.getColor());
            g.drawLine(shape.getStartX(),shape.getStartY(),shape.getEndX(),shape.getEndY());
        }
    }
}
