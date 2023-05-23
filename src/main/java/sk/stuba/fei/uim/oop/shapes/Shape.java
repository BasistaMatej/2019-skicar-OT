package sk.stuba.fei.uim.oop.shapes;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public class Shape {
    @Getter
    private int startX;
    @Getter
    private int startY;
    @Getter @Setter
    private int endX;
    @Getter @Setter
    private int endY;
    @Getter @Setter
    private Color color;

    public Shape(Color color, int startX, int startY) {
        this.color = color;
        this.startY = startY;
        this.startX = startX;
        this.endX = startX;
        this.endY = startY;
    }
}
