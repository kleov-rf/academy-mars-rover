public class MarsRover {

    public static final String TURN_RIGHT = "R";
    public static final String TURN_LEFT = "L";
    public static final String MOVE_FORWARD = "M";
    private final Direction direction;
    private final Coordinates coordinates = new Coordinates();

    public MarsRover() {
        this.direction = new Direction();
    }

    public String run(String commands) {

        for (String command : commands.split("")) {
            if (command.equals(TURN_LEFT)) {
                direction.turnLeft();
            }
            if (command.equals(TURN_RIGHT)) {
                direction.turnRight();
            }
            if (command.equals(MOVE_FORWARD)) {
                coordinates.move(direction.facingTo());
            }
        }

        return String.format("%s:%s", coordinates, direction.facingTo());
    }

}
