public class MarsRover {

    public static final String TURN_RIGHT = "R";
    public static final String TURN_LEFT = "L";
    private final Direction direction;

    public MarsRover() {
        this.direction = new Direction();
    }

    public String run(String commands) {
        String coordinates = "0:0:";

        for (String command : commands.split("")) {
            if(command.equals(TURN_LEFT)) {
                direction.turnLeft();
            }
            if(command.equals(TURN_RIGHT)) {
                direction.turnRight();
            }
        }

        return coordinates + direction.facingTo();
    }

}
