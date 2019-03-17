package com.company.Paint;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Group extends BaseShape {
    private BaseShape baseShape;
    List<BaseShape> shapesGroup = new ArrayList<>();

    private int maxX;
    private int maxY;
    private int minX;
    private int minY;
    protected int diameterX;
    protected int diameterY;
    private GraphicsContext gc;

    Group(GraphicsContext gc, int x, int y, List<Shape> shapes) {
        super(gc, x, y, shapes);
    }

    @Override
    public void drawAll() {
        clean();
        if (shapes.size() > 0) {
            if (baseShape != null) {
                baseShape.drawAll();
            }
            for (Shape shape : shapes) {
                shape.drawfill();
            }
        }
    }

    @Override
    public void add() {

    }

    @Override
    public void drawfill() {

    }

    private void clean() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }


    public void move(Direction direction) {
        switch (direction) {
            case UP:
                if (baseShape.y > 0) {
                    baseShape.y -= 5;
                }
                break;
            case RIGHT:
                if (baseShape.x + baseShape.DIAMETR < gc.getCanvas().getWidth()) {
                    baseShape.x += 5;
                }
                break;
            case DOWN:
                if (baseShape.y + baseShape.DIAMETR < gc.getCanvas().getHeight()) {
                    baseShape.y += 5;
                }
                break;
            case LEFT:
                if (baseShape.x > 0) {
                    baseShape.x -= 5;
                }
                break;
        }

    }

    void addGroup(BaseShape baseShape) {
        shapesGroup.add(baseShape);
        chenger();
    }

    private void chenger(){
        for (BaseShape baseShape : shapesGroup) {
            if (maxX < baseShape.x) {
                maxX = baseShape.x;
                diameterX = baseShape.DIAMETR;
            }
            if (maxY < baseShape.y) {
                maxY = baseShape.y;
                diameterY = baseShape.DIAMETR;
            }
            if (minX > baseShape.x) {
                minX = baseShape.x;
            }
            if (minY > baseShape.y) {
                minY = baseShape.y;
            }
        }
    }
}
