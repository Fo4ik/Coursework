package com.company.Paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import java.util.List;

public abstract class BaseShape implements Shape {
    public int DIAMETR = 30;
    protected GraphicsContext gc;
    public int x;
    public int y;
    private Stage primaryStage;
    public List<Shape> shapes;

    protected BaseShape(BaseShape baseShape) {
        this(baseShape.gc, baseShape.x, baseShape.y, baseShape.shapes);
        this.DIAMETR = baseShape.DIAMETR;
    }


    public BaseShape(GraphicsContext gc, int x, int y, List<Shape> shapes) {
        this.gc = gc;
        this.y = y;
        this.x = x;
        this.shapes = shapes;
    }

    public void move(Direction direction) {

    }

    public  int getDiameter(){
        return DIAMETR;
    }
    public  int getX(){
        return x;
    }
    public  int getY(){
        return y;
    }


    @Override
    public abstract void drawAll();

    @Override
    public abstract void add();

    @Override
    public abstract void drawfill();


}
