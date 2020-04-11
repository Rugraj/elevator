package com.java.elevator;

public class ElevatorRequests {

	public void onStopped(ElevatorCar elevatorCar) {
		
	}
	
	private ElevatorCar elevatorCar;
	
	public void pressButton(Button buttonType, int floor, ELEATORDIRECTION direction) {
		
		if(buttonType instanceof ElvatorButton) {
			((ElvatorButton) buttonType).placeRequest(elevatorCar, floor);
		}else if(buttonType instanceof FloorButton) {
			((FloorButton) buttonType).getDirection(direction);	
		}
		
	}

}
