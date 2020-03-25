package sample;

import javafx.geometry.Point2D;

public interface MyPoint {
    double[] getPoints();
    void setPoints(double x, double y);
    void movePoints(double x, double y, double delX, double delY);
    void distanceTo(double x, double y);
}
