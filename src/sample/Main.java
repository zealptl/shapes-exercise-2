package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("My Shapes");
        Group root = new Group();
        int w = 600, h = 350;
        Canvas canvas = new Canvas(w, h);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        double centerX = (double) w/2;
        double centerY = (double) h/2;
        
        double rect1Width = w*0.7;
        double rect1Height = h*0.7;
        MyRectangle rect1 = new MyRectangle(centerX, centerY,rect1Width, rect1Height);
        rect1.setColor(MyColor.BIEGE);
        rect1.draw(gc);
        System.out.println("-------\n" + rect1.toString());

        MyOval oval1 = new MyOval(centerX, centerY, rect1Width, rect1Height);
        oval1.setColor(MyColor.LIGHTGREEN);
        oval1.draw(gc);
        System.out.println("-------\n" + oval1.toString());

        double rect2Width = rect1Width / Math.sqrt(2);
        double rect2Height = rect1Height / Math.sqrt(2);
        MyRectangle rect2 = new MyRectangle(centerX, centerY, rect2Width, rect2Height);
        rect2.setColor(MyColor.LIGHTGRAY);
        rect2.draw(gc);
        System.out.println("-------\n" + rect2.toString());

        MyOval oval2 = new MyOval(centerX, centerY, rect2Width, rect2Height);
        oval2.setColor(MyColor.LIGHTBLUE);
        oval2.draw(gc);
        System.out.println("-------\n" + oval2.toString());

        double rect3Width = rect2Width / Math.sqrt(2);
        double rect3Height = rect2Height / Math.sqrt(2);
        MyRectangle rect3 = new MyRectangle(centerX, centerY, rect3Width, rect3Height);
        rect3.setColor(MyColor.LIGHTPINK);
        rect3.draw(gc);
        System.out.println("-------\n" + rect3.toString());

        MyOval oval3 = new MyOval(centerX, centerY, rect3Width, rect3Height);
        oval3.setColor(MyColor.YELLOW);
        oval3.draw(gc);
        System.out.println("-------\n" + oval3.toString());

        MyLine topBorder = new MyLine(w*0.05, h*0.05, w*0.95, h*0.05);
        MyLine rightBorder = new MyLine(w*0.95, h*0.05, w*0.95, h*0.95);
        MyLine bottomBorder = new MyLine(w*0.95, h*0.95, w*0.05, h*0.95);
        MyLine leftBorder = new MyLine(w*0.05, h*0.95, w*0.05, h*0.05);
        MyLine diagonalLeft = new MyLine(w*0.05, h*0.05, w*0.95, h*0.95);
//        MyLine diagonalRight = new MyLine(w*0.95, h*0.05, w*0.05, h*0.95);
        topBorder.draw(gc);
        rightBorder.draw(gc);
        bottomBorder.draw(gc);
        leftBorder.draw(gc);
        diagonalLeft.draw(gc);
//        diagonalRight.draw(gc);

        root.getChildren().add(canvas);
        Scene sc = new Scene(root, w, h);
        primaryStage.setScene(sc);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
