package com.company.Paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import java.util.List;

public abstract class BaseShape implements Shape {
    public int DIAMETR=30;
    protected GraphicsContext gc;
    protected double x;
    protected double y;
    private Stage primaryStage;
    public List<Shape> shapes;

    public BaseShape(GraphicsContext gc, double x, double y, List<Shape> shapes) {
        this.gc = gc;
        this.y = y;
        this.x = x;
        this.shapes = shapes;
    }

    public void move(Direction direction) {

    }


    @Override
    public abstract void drawAll();

    @Override
    public abstract void add();

    @Override
    public  abstract void drawfill();


}
