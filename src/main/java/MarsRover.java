public class MarsRover {

    public static final String TURN_RIGHT = "R";
    public static final String TURN_LEFT = "L";
    public static final String MOVE_FORWARD = "M";
    private final Direction direction;
    private int yPosition;
    private int xPosition;

    public MarsRover() {
        this.yPosition = 0;
        this.xPosition = 0;
        this.direction = new Direction();
    }

    public String run(String commands) {
        String coordinates = "%d:%d:%s";

        for (String command : commands.split("")) {
            if (command.equals(TURN_LEFT)) {
                direction.turnLeft();
            }
            if (command.equals(TURN_RIGHT)) {
                direction.turnRight();
            }
            if (command.equals(MOVE_FORWARD)) {
                move();
            };
        }

        return String.format(coordinates, xPosition, yPosition, direction.facingTo());
    }

    private void move() {
        if(direction.facingTo().equals("S")) {
            yPosition--;
        }

        if(direction.facingTo().equals("N")){
            yPosition++;
        }

        if(direction.facingTo().equals("E")){
            xPosition++;
        }
    }

}
