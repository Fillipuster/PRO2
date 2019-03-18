package opgave03;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class Door {
	private final DoorState closedState;
	private final DoorState openingState;
	private final DoorState openState;
	private final DoorState closingState;
	private final DoorState stayOpenState;
	
	private DoorState state;
	private ArrayList<Observer> observers;
    private Timeline timer;

	public Door() {
		closedState = new DoorClosed(this);
		openingState = new DoorOpening(this);
		openState = new DoorOpen(this);
		closingState = new DoorClosing(this);
		stayOpenState = new DoorStayOpen(this);
		
		observers = new ArrayList<Observer>();
		state = this.closedState;
	}
	
    public DoorClosed getClosedState() {
    	return (DoorClosed) closedState;
    }
    
    public DoorOpening getOpeningState() {
    	return (DoorOpening) openingState;
    }
    
    public DoorOpen getOpenState() {
    	return (DoorOpen) openState; 
    }
    
    public DoorClosing getClosingState() {
    	return (DoorClosing) closingState;
    } 
    
    public DoorStayOpen getStayOpenState() {
    	return (DoorStayOpen) stayOpenState;
    }

	public DoorState getState() {
		return state;
	}

	public void startTimer(double duration, EventHandler<ActionEvent> event) {
	    if (timer != null) {
	        stopTimer();        
	    }
		timer = new Timeline(new KeyFrame(Duration.millis(duration), event));
		timer.play();
	}
	
	public void stopTimer() {
	    timer.stop();
	}
	
	public void click() {
	    this.state.click();
	}

	public void setState(DoorState state) {
		this.state = state;
		notifyObservers();
	}

	public void addObserver(Observer obs) {
		observers.add(obs);
	}

	private void notifyObservers() {
		for (Observer obs : observers) {
			obs.update(this);
		}
	}

}