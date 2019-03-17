package com.company.Paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class Triangle extends BaseShape {
    Const cons = new Const();

    public Triangle(GraphicsContext gc, int x, int y, List<Shape> shapes) {
        super(gc, x, y, shapes);
    }

    public Triangle(BaseShape baseShape) {
        super(baseShape);
    }


    @Override
    public void move(Direction direction) {

    }

    @Override
    public void drawAll() {
        gc.setFill(Color.BLUE);
        gc.fillPolygon(new double[]{x + DIAMETR / 2, x + DIAMETR, x}, new double[]{y, y + DIAMETR, y + DIAMETR}, 3);
    }

    @Override
    public void add() {

    }

    @Override
    public void drawfill() {
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(2);
        gc.strokePolygon(new double[]{x + DIAMETR / 2, x + DIAMETR, x}, new double[]{y, y + DIAMETR, y + DIAMETR}, 3);

    }
}
