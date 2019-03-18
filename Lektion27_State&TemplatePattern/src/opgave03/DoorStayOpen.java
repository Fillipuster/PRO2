package opgave03;

public class DoorStayOpen extends DoorState {
    private Door door;

    public DoorStayOpen(Door door) {
        this.door = door;
    }

    @Override
    public String toString() {
        return "STAY OPEN";
    }

    @Override
    public void click() {
    	door.setState(door.getClosingState());
    	door.startTimer(3000, e -> {
    		door.getState().complete();
    	});
    }
}
