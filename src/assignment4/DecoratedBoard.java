package assignment4;

public class DecoratedBoard extends BoardDecorator {
    public DecoratedBoard()
    {
        super();
    }

    public int backgroundNum;

    public void setBackgroundNum(int backgroundNum) {
        this.backgroundNum = backgroundNum;
    }
}
