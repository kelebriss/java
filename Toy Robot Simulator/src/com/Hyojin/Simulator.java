package com.Hyojin;

import com.Hyojin.Robot;
import java.util.Scanner;

public class Simulator {

	public static void main(String[] args) {

		String input;
		String[] order = null;
		String[] dir = null;
		Robot robot = new Robot();
		Scanner scan = null;

		// loop start here

		do {
			try {
				scan = new Scanner(System.in);
				input = scan.nextLine(); // read the input from console command line
				// input = scan.nextLine().toUpperCase(); read the input from console command
				// line and it makes case insensitive

				order = input.split(" "); // separate 'PLACE' and rest part
				if (order[0].contentEquals("PLACE")) // if first word is 'PLACE' then do second split process(coordinate
														// and direction)
					dir = order[1].split(",");

				if (order[0].matches("PLACE")) {
					if (dir[0].matches(".*[0-4].*") && dir[0].matches(".*[0-4].*") // to verify coordinate and direction
																					// value are valid
							&& dir[2].matches("WEST|EAST|NORTH|SOUTH")) {
						robot.setValid(); // set coordinate and direction of robot
						robot.setPosition(dir[0], dir[1]);
						robot.setDirection(dir[2]);
					} else {
						System.out.println("Coordinate values or direction input are invalid"); // this will display
																								// when command line
																								// input is incorrect
						System.out.println(
								"Coordinate values must between 0 to 4 and direction must be one of these (NORTH,SOUTH,WEST,EAST)");
					}
				} else if (order[0].matches("MOVE|LEFT|RIGHT|REPORT") && robot.getValid() == true) { // to verify other
																										// commands and
																										// validate
																										// robot is on
																										// the table
					switch (order[0]) {
					case "MOVE": // call move function for robot
						robot.move();
						break;
					case "LEFT": // call turnLeft function for robot
						robot.turnLeft();
						break;
					case "RIGHT": // call turnRight function for robot
						robot.turnRight();
						break;
					case "REPORT": // calal report function for displaying output
						robot.report();
						break;
					}
				} else { // all of invalid command will display this message
					if (robot.getValid() == false && !order[0].matches("(?i)place")) // check robot is valid and make
																						// lower case 'place'command not
																						// process this.
						
						System.out.println("you need to place the robot on the table"); // if robot is not placed on
																						// table and invalid command
																						// then display this.
					else
						System.out.println("invalid command line input"); // if robot is placed on table and invalid
																			// command then display this
				}
			} catch (Exception e) { // when exception occur from read input process it will catch and display this
				System.out.println("Error Occur: " + e.getMessage()); // catch the error and display what kind of error
																		// it is
				System.out.println("please enter valid input value");
			} finally {
				if (scan.equals(null)) // to prevent resource leaking from scanner
					scan.close();
			}
		} while (true); // infinite loop for do above task
	}

}