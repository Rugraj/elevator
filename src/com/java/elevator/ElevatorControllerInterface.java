package com.java.elevator;

public interface ElevatorControllerInterface {

	public void statusOfElevator ();
	public ElevatorCar getElevatorCar(int elevatorID);
	public void update(int elevatorId, int floor);
	public void pickup(int floor , boolean direction);
	public void reset(int elevatorId, int floor);
	public void step();
}
