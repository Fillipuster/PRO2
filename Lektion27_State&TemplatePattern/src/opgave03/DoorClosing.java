package opgave03;

public class DoorClosing extends DoorState {
    private Door door;

    public DoorClosing(Door door) {
        this.door = door;
    }

    @Override
    public String toString() {
        return "CLOSING";
    }

    @Override
    public void click() {
        door.setState(door.getOpeningState()); 
        door.startTimer(3000, event -> {
            door.getState().complete();
        });
    }
    
    @Override
    public void complete() {
    	door.setState(door.getClosedState());
    }
}
