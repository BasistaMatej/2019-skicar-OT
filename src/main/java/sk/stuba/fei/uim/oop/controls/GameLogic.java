package sk.stuba.fei.uim.oop.controls;


import lombok.Getter;
import sk.stuba.fei.uim.oop.actions.Action;
import sk.stuba.fei.uim.oop.shapes.Canvas;
import sk.stuba.fei.uim.oop.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class GameLogic extends UniversalAdapter {
    public static final String BUTTON_CIRCLE_TEXT = "Medzikruzie";
    public static final String BUTTON_LINE_TEXT = "Usecka";
    public static final String BUTTON_COLOR_TEXT = "Zmena farby";

    @Getter
    private Canvas drawingPanel;
    @Getter
    private Choice changeColorButton;

    @Getter
    private JLabel label;

    private Action currentAction;
    private Shape currentShape;

    public GameLogic() {
        this.drawingPanel = new Canvas(this);
        this.changeColorButton = new Choice();
        this.changeColorButton.add("Modra");
        this.changeColorButton.add("ŽLta");
        this.changeColorButton.add("Čierna");
        this.label = new JLabel("Zbytocny label");
        this.currentAction = Action.NONE;
    }

    private Color getCurrentColor() {
        Color color = Color.BLUE;
        switch (this.changeColorButton.getSelectedItem()) {
            case "Modra":
                color = Color.BLUE;
                break;
            case "ŽLta":
                color = Color.YELLOW;
                break;
            case "Čierna":
                color = Color.BLACK;
                break;
        }
        return color;
    }

    private Shape findShapeOnPossition(int x, int y) {
        for(Shape shape : drawingPanel.getCircles()) {
            if (x >= shape.getStartX() && x <= shape.getEndX() && y >= shape.getStartY() && y <= shape.getEndY()) {
                return shape;
            }
        }
        for(Shape shape : drawingPanel.getLines()) {
            if (x >= shape.getStartX() && x <= shape.getEndX() && y >= shape.getStartY() && y <= shape.getEndY()) {
                return shape;
            }
        }
        return null;

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() instanceof JPanel) {
            if(currentAction == Action.LINE) {
                this.currentShape = new Shape(getCurrentColor(), e.getX(), e.getY());
                drawingPanel.addToLines(currentShape);
            } else if(currentAction == Action.CIRCLE) {
                this.currentShape = new Shape(getCurrentColor(), e.getX(), e.getY());
                drawingPanel.addToCircles(currentShape);
            } else if(e.getSource().equals(drawingPanel)) {
                currentShape = findShapeOnPossition(e.getX(),e.getY());
                if(currentShape != null) {
                    currentShape.setColor(getCurrentColor());
                    drawingPanel.repaint();
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            switch (button.getText()) {
                case BUTTON_CIRCLE_TEXT:
                    currentAction = Action.CIRCLE;
                    break;
                case BUTTON_LINE_TEXT:
                    currentAction = Action.LINE;
                    break;
                case BUTTON_COLOR_TEXT:
                    currentAction = Action.COLOR;
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(currentAction == Action.LINE || currentAction == Action.CIRCLE) {
            this.currentShape.setEndX(e.getX());
            this.currentShape.setEndY(e.getY());
            drawingPanel.revalidate();
            drawingPanel.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(currentAction == Action.LINE || currentAction == Action.CIRCLE) {
            this.currentShape.setEndX(e.getX());
            this.currentShape.setEndY(e.getY());
            drawingPanel.revalidate();
            drawingPanel.repaint();
        }
    }

}
