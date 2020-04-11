package com.java.elevator;

public class ElvatorButton extends Button {

	private ELEATORDIRECTION elevatorDirection;

	@Override
	public void iliminate() {
	}

	@Override
	public void indicator() {
	}

	public void reset(ElevatorCar elevatorCar) {
		elevatorCar.setCurrentFloor(0);
		elevatorCar.setCountUpward(0);
		elevatorCar.setCountDownward(0); 
		elevatorCar.setMovement(false);
		elevatorCar.setElvatorDirection(ELEATORDIRECTION.STOPPED);
		elevatorCar.setFloors(new boolean [elevatorCar.getNumFloors()]);
		elevatorCar.setMaximum(ElevatorConstants.MAX_FLOOR);
		elevatorCar.setMinimam(ElevatorConstants.MIN_FLOOR);
	}
	
	public void placeRequest(ElevatorCar elevatorCar,int floor) {
		if((floor<0) || (floor >= elevatorCar.getNumFloors() ) ) throw new IllegalArgumentException();
		reset(elevatorCar);
		elevatorCar.setCurrentFloor(floor);
	}
	
	

}
