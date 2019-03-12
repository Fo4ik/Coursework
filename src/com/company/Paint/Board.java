package com.company.Paint;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private GraphicsContext gc;
    public List<Shape> shapes = new ArrayList<>();
    public BaseShape baseShape;
    Const cons = new Const();


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

    public enum Figures {
        BALL, SQUARE, TRIANGLE;
    }

    public Board(GraphicsContext gc) {
        this.gc = gc;
    }


    public int getActiveShape() {
        return cons.activeShapeIndex;
    }

    public void add(Figures figures) {
        switch (figures) {
            case BALL:
                shapes.add(new Ball(gc, 10, 10, shapes));
                baseShape = (BaseShape) shapes.get(shapes.size() - 1);
                cons.count++;
                System.out.println(cons.count);
                break;
            case SQUARE:
                shapes.add(new Square(gc, 10, 10, shapes));
                baseShape = (BaseShape) shapes.get(shapes.size() - 1);
                System.out.println("count " + cons.count);
                break;
            case TRIANGLE:
                shapes.add(new Triangle(gc, 10, 10, shapes));
                baseShape = (BaseShape) shapes.get(shapes.size() - 1);
                System.out.println("count " + cons.count);
                break;
        }
    }

    public void remove() {
        if (baseShape != null && shapes.size() > 0) {
            try {
                BaseShape tmp = baseShape;
                shapes.remove(baseShape);
                cons.count--;
                System.out.println("count " + cons.count);
                if (shapes.size() > 0) {
                    baseShape = (BaseShape) shapes.get(shapes.indexOf(tmp) + 1);

                } else {
                    clean();
                }
            } catch (IndexOutOfBoundsException e) {
                baseShape = (BaseShape) shapes.get(0);
            }
        }
    }

    public void next() {
        if (baseShape != null && shapes.size() > 0) {
            try {
                baseShape = (BaseShape) shapes.get(shapes.indexOf(baseShape) + 1);
                cons.activeShapeIndex = shapes.indexOf(baseShape);
                System.out.println("index " + cons.activeShapeIndex);
            } catch (IndexOutOfBoundsException e) {
                baseShape = (BaseShape) shapes.get(0);
            }
        }
    }

    public void previous() {
        if (baseShape != null && shapes.size() > 0) {
            try {
                baseShape = (BaseShape) shapes.get(shapes.indexOf(baseShape) - 1);
                cons.activeShapeIndex = shapes.indexOf(baseShape);
                System.out.println("index " + cons.activeShapeIndex);
            } catch (IndexOutOfBoundsException e) {
                baseShape = (BaseShape) shapes.get(0);
            }
        }
    }

    public void resizeMinus() {
        if (baseShape != null) {
            if (baseShape.DIAMETR > 6) {
                baseShape.DIAMETR -= 5;
            }
        }
    }

    public void resizePlus() {
        clean();
        if (baseShape != null) {
            if (baseShape.DIAMETR < gc.getCanvas().getHeight() && baseShape.DIAMETR < gc.getCanvas().getWidth()) {
                baseShape.DIAMETR += 5;
            }
        }
    }


    public void drawAll() {
        clean();
        if (shapes.size() > 0) {
            if (baseShape != null) {
                if (baseShape.equals(cons.activeShapeIndex)) {
                    baseShape.drawAll();
                } else {
                    baseShape.drawfill();
                }
            }
            for (Shape shape : shapes) {
                shape.drawAll();
            }
        }
    }

    private void clean() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    public void mainObject() {

    }
}
