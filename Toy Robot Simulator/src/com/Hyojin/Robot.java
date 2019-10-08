package com.Hyojin;

public class Robot {
	private int posX, posY; // coordinate variable position X and position Y
	private String direction; // direction variable
	private boolean valid = false; // validate variable robot is on the table

	public void setPosition(String i, String j) { // to set the coordinate value
		posX = Integer.parseInt(i);
		posY = Integer.parseInt(j);
	}

	public int getPosX() { // to get the coordinate x value
		return posX;
	}

	public int getPosY() { // to get the coordinate y value
		return posY;
	}

	public void setDirection(String dir) { // to set the direction value
		direction = dir.toUpperCase();
	}

	public String getDirection() { // to get the direction vlaue
		return direction;
	}

	public void setValid() { // to set the robot is on the table
		valid = true;
	}

	public boolean getValid() { // to get value of robot is on the table
		return valid;
	}

	public void move() { // move method that makes robot forward one step in coordinate which using
							// switch to control different 4 direction
		switch (direction) {
		case "NORTH":
			if (posY < 4) // if y is less than 4, move to north
				posY++; // add 1 on y coordinate
			else
				System.out.println("could not move to NORTH");
			break;

		case "SOUTH":
			if (posY > 0) // if y is grater than 0, move to south
				posY--; // subtract 1 on y coordinate
			else
				System.out.println("could not move to SOUTH");
			break;

		case "WEST": // if x is greater than 0, could not move to west
			if (posX > 0) // subtract 1 on x coordinate
				posX--;
			else
				System.out.println("could not move to WEST");
			break;

		case "EAST": // if x is less than 4, move to east
			if (posX < 4) // add 1 on x coordinate
				posX++;
			else
				System.out.println("could not move to EAST");
			break;
		}
	}

	public void turnRight() { // turn right method that makes robot turning 90 degree to right
		switch (direction) {
		case "NORTH":
			direction = "EAST";
			break;

		case "SOUTH":
			direction = "WEST";
			break;

		case "WEST":
			direction = "NORTH";
			break;

		case "EAST":
			direction = "SOUTH";
			break;
		}
	}

	public void turnLeft() { // turn left method that makes robot turning 90 degree to left
		switch (direction) {
		case "NORTH":
			direction = "WEST";
			break;

		case "SOUTH":
			direction = "EAST";
			break;

		case "WEST":
			direction = "SOUTH";
			break;

		case "EAST":
			direction = "NORTH";
			break;
		}
	}

	public void report() { // to display the result of the robot's coordinate and direction
		System.out.println("Output: " + posX + "," + posY + "," + direction);
	}
}