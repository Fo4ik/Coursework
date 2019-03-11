package com.company.Paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class Triangle extends BaseShape {
    Const cons = new Const();

    public Triangle(GraphicsContext gc, double x, double y, List<Shape> shapes) {
        super(gc, x, y, shapes);
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
        gc.setFill(Color.BLUE);
        gc.fillPolygon(new double[]{x + DIAMETR / 2, x + DIAMETR, x}, new double[]{y, y + DIAMETR, y + DIAMETR}, 3);

    }
}
