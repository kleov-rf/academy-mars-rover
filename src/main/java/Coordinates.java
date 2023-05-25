public class Coordinates {

    private final int MAX_WIDTH = 9;
    private int yPosition;
    private int xPosition;

    public Coordinates() {
        yPosition = 0;
        xPosition = 0;
    }

    void move(String direction) {
        if (direction.equals("S")) {
            yPosition--;
        }

        if (direction.equals("N")) {
            yPosition++;
        }

        if (direction.equals("E")) {
            xPosition++;
        }

        if (direction.equals("W")) {
            xPosition--;
            if(xPosition < 0) {
                xPosition = MAX_WIDTH;
            }
        }
    }

    @Override
    public String toString() {
        return xPosition + ":" + yPosition;
    }
}