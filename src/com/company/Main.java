package com.company;

import com.company.Paint.BaseShape;
import com.company.Paint.Board;
import com.company.Paint.Const;
import com.company.Paint.Direction;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public int count;
    private Direction direction;
    private boolean closed;
    private GraphicsContext gc;
    private Board board;
    private Const cons = new Const();
    private static final int FPS = 60;
    public BaseShape baseShape;
    private int index = cons.activeShapeIndex;

    public static void main(String[] args) {
        launch(args);
    }

    public void activityObject(Stage primaryStage) {
        String s = Integer.toString(index);
        primaryStage.setTitle(s);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas();
        int BOARD_WIDTH = 800;
        canvas.setWidth(BOARD_WIDTH);
        int BOARD_HEIGHT = 500;
        canvas.setHeight(BOARD_HEIGHT);
        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();
        Const cons = new Const();
        Logger.log("Game Started");
        gc = canvas.getGraphicsContext2D();


        board = new Board(gc);
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case C:{
                    board.copy();
                    Logger.log("Copy");
                }break;
                case DIGIT1: {
                    board.add(Board.Figures.BALL);
                    Logger.log("Add BALL");
                }
                break;
                case DIGIT2: {
                    board.add(Board.Figures.SQUARE);
                    Logger.log("Add SQUARE");
                }
                break;
                case DIGIT3: {
                    board.add(Board.Figures.TRIANGLE);
                    Logger.log("Add TRIANGLE");
                }
                break;
                case DELETE: {
                    board.remove();
                    Logger.log("Remove");
                }
                break;
                case Z: {
                    board.resizePlus();
                    Logger.log("Plus");
                }
                break;
                case X: {
                    board.resizeMinus();
                    Logger.log("Minus");
                }
                break;
                case PAGE_UP: {
                    board.next();
                    Logger.log("Next");
                }
                break;
                case PAGE_DOWN: {
                    board.previous();
                    Logger.log("Previous");
                }
                break;
                case UP: {
                    board.move(Direction.UP);
                    Logger.log("Up");
                }
                break;
                case DOWN: {
                    board.move(Direction.DOWN);
                    Logger.log("Down");
                }
                break;
                case LEFT: {
                    board.move(Direction.LEFT);
                    Logger.log("Left");
                }
                break;
                case RIGHT: {
                    board.move(Direction.RIGHT);
                    Logger.log("Right");
                }
                break;
                case ALT: {
                    board.changeFigure();
                    Logger.log("changeFigure");
                }
                break;
            }
        });
        scene.setOnMousePressed(event -> {
            if (event.isControlDown()) {
                board.merge((int) event.getSceneX(), (int) event.getSceneY());
            }
        });

        new Thread(this::runMainGameLoopInThread).start();
        board.drawAll();
    }

    @Override
    public void stop() {
        closed = true;
    }


    private void runMainGameLoopInThread() {
        while (!closed) {

            Platform.runLater(this::drawFrame);
            try {
                int pauseBetweenFramesMillis = 1000 / FPS;
                Thread.sleep(pauseBetweenFramesMillis);
            } catch (InterruptedException e) {
                break;
            }
        }
    }


    private void drawFrame() {
        board.drawAll();

    }

    private void clean() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

}
