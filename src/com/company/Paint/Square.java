package com.company.Paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class Square  extends  BaseShape {
    Const cons = new Const();

    public Square(GraphicsContext gc, int x, int y, List<Shape> shapes) {
        super(gc, x, y, shapes);
    }

    public Square(BaseShape baseShape) {
        super(baseShape);
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
        gc.setStroke(Color.GREEN);
        gc.setLineWidth(2);
        gc.strokeRect(x, y, DIAMETR, DIAMETR);
    }
}
