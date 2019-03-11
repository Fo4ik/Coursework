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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public int count;
    private Direction direction;
    private boolean closed;
    private int BOARD_WIDTH = 800;
    public int BOARD_HEIGHT = 500;
    private GraphicsContext gc;
    private Board board;
    Const cons = new Const();
    private static final int FPS = 60;
    public int activeShapeIndex;
    public BaseShape baseShape;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        for (int i = -1; i < cons.activeShapeIndex; i++) {
            primaryStage.setTitle(String.valueOf(cons.activeShapeIndex));
        }
        Canvas canvas = new Canvas();
        canvas.setWidth(BOARD_WIDTH);
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
                case W: {
                    board.move(Direction.UP);
                    Logger.log("Up");
                }
                break;
                case S: {
                    board.move(Direction.DOWN);
                    Logger.log("Down");
                }
                break;
                case A: {
                    board.move(Direction.LEFT);
                    Logger.log("Left");
                }
                break;
                case D: {
                    board.move(Direction.RIGHT);
                    Logger.log("Right");
                }
                break;
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
            // run in UI thread
            Platform.runLater(this::drawFrame);
            try {
                int pauseBetweenFramesMillis = 1000 / FPS;
                Thread.sleep(pauseBetweenFramesMillis);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    private void drawFrame()
    {
        board.drawAll();
    }

    private void clean() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

}
