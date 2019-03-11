package com.company.Paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class Ball extends BaseShape {
    public List<Shape> shapes;
    Const cons = new Const();

    public Ball(GraphicsContext gc, double x, double y, List<Shape> shapes) {
        super(gc, x, y, shapes);
    }


    @Override
    public void move(Direction direction) {

    }



    public void drawAll() {
        gc.setStroke(Color.RED);
        gc.setLineWidth(2);
        gc.strokeOval(cons.x, cons.y, DIAMETR, DIAMETR);
        gc.setFill(Color.RED);
        gc.fillOval(cons.x, cons.y, DIAMETR, DIAMETR);
    }

    public void drawfill() {
        gc.setFill(Color.RED);
        gc.fillOval(cons.x, cons.y, 30, 30);
    }

    @Override
    public void add() {
    }
}
