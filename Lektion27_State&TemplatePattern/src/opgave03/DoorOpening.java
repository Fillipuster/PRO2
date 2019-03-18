package opgave03;

public class DoorOpening extends DoorState {
    private Door door;

    public DoorOpening(Door door) {
        this.door = door;
    }

    @Override
    public String toString() {
        return "OPENING";
    }

    @Override
    public void click() {
        door.setState(door.getClosingState());
        door.startTimer(3000, event -> {
            door.getState().complete();
        });
    }
    
    @Override
    public void complete() {
    	door.setState(door.getOpenState());
    	door.startTimer(3000, e -> {
    		System.out.println(door.getState());
    		door.getState().timeout();
    	});
    }
}
