package sample;

public interface MyShapePosition extends MyPoint {
    public MyRectangle getBoundingBox();
    boolean doOverlap(MyShape shape1, MyShape shape2);

}
