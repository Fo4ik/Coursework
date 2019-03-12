package com.company.Paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class Square  extends  BaseShape {
    Const cons = new Const();

    public Square(GraphicsContext gc, double x, double y, List<Shape> shapes) {
        super(gc, x, y, shapes);
    }


    @Override
    public void move(Direction direction) {

    }

    @Override
    public void drawAll() {
        gc.setFill(Color.GREEN);
        gc.fillRect(x, y, DIAMETR, DIAMETR);
    }

    @Override
    public void add() {

    }


    @Override
    public void drawfill() {
        gc.setFill(Color.GREEN);
        gc.fillRect(x, y, DIAMETR, DIAMETR);
    }
}
