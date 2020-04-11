package com.java.elevator;

public class ElevatorController implements ElevatorControllerInterface {

	private int weight;
	
	
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public void statusOfElevator() {
		
	}

	@Override
	public ElevatorCar getElevatorCar(int elevatorID) {
		return null;
	}

	@Override
	public void update(int elevatorId, int floor) {
		
	}

	@Override
	public void pickup(int floor, boolean direction) {
		
	}

	@Override
	public void reset(int elevatorId, int floor) {
		
	}

	@Override
	public void step() {
		
	}
	
	public void initElevetorController() {
		
	}
	public void status() {
		
	}
	
	
	public boolean weightOfElevatorCarPassanger() {
		
		if(weight>100) {
			beapSign();
			return false;
		}else {
			return true;
		}
	}

	private void beapSign() {
		
	}

}
