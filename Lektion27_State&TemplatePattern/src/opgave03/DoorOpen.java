package opgave03;

public class DoorOpen extends DoorState {
    private Door door;

    public DoorOpen(Door door) {
        this.door = door;
    }

    @Override
    public String toString() {
        return "OPEN";
    }

    @Override
    public void click() {
    	door.stopTimer();
    	door.setState(door.getStayOpenState());
    }
    
    @Override
    public void timeout() {
    	door.setState(door.getClosingState());
    	door.startTimer(3000, e -> {
    		door.getState().complete();
    	});
    }
}
