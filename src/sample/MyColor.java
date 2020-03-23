package sample;

import javafx.scene.paint.Color;

public enum  MyColor {

    BLACK,
    WHITE,
    RED,
    LIGHTGREEN,
    LIGHTBLUE,
    LIGHTPINK,
    LIGHTGRAY,
    MAGENTA,
    YELLOW,
    BIEGE;

    Color c;

    MyColor() {
        switch (this.ordinal()) {
            case 0:
                this.c = Color.BLACK;
                break;
            case 1:
                this.c = Color.WHITE;
                break;
            case 2:
                this.c = Color.RED;
                break;
            case 3:
                this.c = Color.LIGHTGREEN;
                break;
            case 4:
                this.c = Color.LIGHTBLUE;
                break;
            case 5:
                this.c = Color.LIGHTPINK;
                break;
            case 6:
                this.c = Color.LIGHTGRAY;
                break;
            case 7:
                this.c = Color.MAGENTA;
                break;
            case 8:
                this.c = Color.YELLOW;
                break;
            case 9:
                this.c = Color.BEIGE;
                break;
            default:
                this.c = null;
        }
    }

    public Color getColor() {
        return c;
    }


}
