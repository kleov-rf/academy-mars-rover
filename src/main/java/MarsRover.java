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
        int XPosition = 0;
        String coordinates = "%d:%d:%s";

        for (String command : commands.split("")) {
            if (command.equals(TURN_LEFT)) {
                direction.turnLeft();
            }
            if (command.equals(TURN_RIGHT)) {
                direction.turnRight();
            }
            if (command.equals(MOVE_FORWARD)) {
                if(direction.facingTo().equals("S")) {
                    YPosition--;
                }

                if(direction.facingTo().equals("N")){
                    YPosition++;
                }

                if(direction.facingTo().equals("E")){
                    XPosition++;
                }
            };
        }

        return String.format(coordinates, XPosition, YPosition, direction.facingTo());
    }

}
