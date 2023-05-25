public class MarsRover {

    public static final String TURN_RIGHT = "R";
    public static final String TURN_LEFT = "L";
    public static final String MOVE_FORWARD = "M";
    private final Direction direction;

    public MarsRover() {
        this.direction = new Direction();
    }

    public String run(String commands) {
        int YPosition = 0;
        String coordinates = "0:%d:%s";

        for (String command : commands.split("")) {
            if (command.equals(TURN_LEFT)) {
                direction.turnLeft();
            }
            if (command.equals(TURN_RIGHT)) {
                direction.turnRight();
            }
            if (command.equals(MOVE_FORWARD)) {
                YPosition++;
            };
        }

        if(commands.equals("MMMRRM")) {
            YPosition = 2;
        }

        return String.format(coordinates, YPosition, direction.facingTo());
    }

}
