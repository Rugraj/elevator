package com.java.elevator;

public class ElevatorCar {
	
	
	private boolean [] floors;
	private int countUpward = 0;
	private int countDownward = 0;		
	private int minimam = ElevatorConstants.MIN_FLOOR;
	private int maximum = ElevatorConstants.MAX_FLOOR;
	private int numFloors;
	private int currentFloor = 0;
	private ELEATORDIRECTION elvatorDirection = ELEATORDIRECTION.STOPPED;
	private Boolean movement = false;
	
	
	private ElevatorRequests elevatorRequests;
	
	private ElevatorController elevatorController;
	
	public Boolean getMovement() {
		return movement;
	}


	public void setMovement(Boolean movement) {
		this.movement = movement;
	}


	public boolean[] getFloors() {
		return floors;
	}


	public void setFloors(boolean[] floors) {
		this.floors = floors;
	}


	public int getCountUpward() {
		return countUpward;
	}


	public void setCountUpward(int countUpward) {
		this.countUpward = countUpward;
	}


	public int getCountDownward() {
		return countDownward;
	}


	public void setCountDownward(int countDownward) {
		this.countDownward = countDownward;
	}


	

	public int getMinimam() {
		return minimam;
	}


	public void setMinimam(int minimam) {
		this.minimam = minimam;
	}


	public int getMaximum() {
		return maximum;
	}


	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}


	public int getCurrentFloor() {
		return currentFloor;
	}


	public int getNumFloors() {
		return numFloors;
	}


	public void setNumFloors(int numFloors) {
		this.numFloors = numFloors;
	}


	public ElevatorRequests getElevatorRequests() {
		return elevatorRequests;
	}


	public void setElevatorRequests(ElevatorRequests elevatorRequests) {
		this.elevatorRequests = elevatorRequests;
	}


	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	
	public ElevatorController getElevatorController() {
		return elevatorController;
	}


	public void setElevatorController(ElevatorController elevatorController) {
		this.elevatorController = elevatorController;
	}


	public ELEATORDIRECTION getElvatorDirection() {
		return elvatorDirection;
	}


	public ELEATORDIRECTION getElvatorDirection(FloorButton floorButton, int floor, ELEATORDIRECTION elvatorDirection) {
		
		elevatorRequests.pressButton(floorButton, floor, elvatorDirection);
		return elvatorDirection;
	}


	public void setElvatorDirection(ELEATORDIRECTION elvatorDirection) {
		this.elvatorDirection = elvatorDirection;
	}
	public ElevatorCar(int numFloors) {
		this.numFloors = numFloors;
		floors = new boolean [numFloors];
	}


	public Integer getCurrentFloorOfElevator() {
		return currentFloor;
	}
	
	public int getGoalFloorOfElevator() {
		if(elvatorDirection == ELEATORDIRECTION.UP ) return maximum;
		if(elvatorDirection == ELEATORDIRECTION.DOWN ) return minimam;
		return -1;
	}

	public void movementOfElevtor(){	
		if(elevatorController.weightOfElevatorCarPassanger()) {
			
		}
		if(!movement) {
			movement = (elvatorDirection != ELEATORDIRECTION.STOPPED);
			return;
		}
		if(elvatorDirection == ELEATORDIRECTION.UP) {
			if(floors[++currentFloor]) {
				floors[currentFloor] = false;
				if(--countUpward == 0) {
					elvatorDirection = (countDownward == 0)?(ELEATORDIRECTION.STOPPED):(ELEATORDIRECTION.DOWN);
					maximum = ElevatorConstants.MAX_FLOOR;
				}
				movement = false;
				if(elevatorRequests != null) elevatorRequests.onStopped(this);
			}
			return;
		}
		if (elvatorDirection == ELEATORDIRECTION.DOWN) {
			if(floors[--currentFloor]) {
				floors[currentFloor] = false;
				if(++countDownward == 0) { 
					elvatorDirection = (countUpward == 0)?(ELEATORDIRECTION.STOPPED):(ELEATORDIRECTION.UP);
					minimam = ElevatorConstants.MIN_FLOOR;
				}
				movement = false;
				if(elevatorRequests != null) elevatorRequests.onStopped(this);
			}
		}
	}

	public void setGoalFloor(int groundFloor) {
		if((groundFloor<0) || (groundFloor >= numFloors ) ) throw new IllegalArgumentException();
		if(currentFloor == groundFloor) return;
		if(floors[groundFloor]) return;
		floors[groundFloor] = true;
		if(groundFloor>currentFloor) { countUpward++;  	maximum = (groundFloor>maximum)?(groundFloor):(maximum); }
		if(groundFloor<currentFloor) { countDownward--; 	minimam = (groundFloor<minimam)?(groundFloor):(minimam); }
		if(elvatorDirection == ELEATORDIRECTION.STOPPED)
			elvatorDirection = (groundFloor>currentFloor)?(ELEATORDIRECTION.UP):(ELEATORDIRECTION.DOWN);
	}
	
	
	
	
	
	
	
}
