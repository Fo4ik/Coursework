package com.company.Paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class Ball extends BaseShape {
    public List<Shape> shapes;
    Const cons = new Const();

    public Ball(GraphicsContext gc, int x, int y, List<Shape> shapes) {
        super(gc, x, y, shapes);
    }

    public Ball(BaseShape baseShape) {
        super(baseShape);
    }


    @Override
    public void move(Direction direction) {

    }



    public void drawAll() {
        gc.setFill(Color.RED);
        gc.fillOval(x, y, DIAMETR, DIAMETR);

    }

    public void drawfill() {
        gc.setStroke(Color.RED);
        gc.setLineWidth(2);
        gc.strokeOval(x, y, DIAMETR, DIAMETR);
    }

    @Override
    public void add() {
    }


}
