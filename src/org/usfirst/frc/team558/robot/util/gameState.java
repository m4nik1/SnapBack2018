package org.usfirst.frc.team558.robot.util;

public class gameState {

		public Side mySwitchSide;
		public Side scaleSide;
		public Side theirSwitchSide;

		public gameState(String gameSpecificMessage) {

			if (gameSpecificMessage != null && gameSpecificMessage.length() == 3) {

				if (gameSpecificMessage.charAt(0) == 'L') {
					this.mySwitchSide = Side.LEFT;
				} else {
					this.mySwitchSide = Side.RIGHT;
				}

				if (gameSpecificMessage.charAt(1) == 'L') {
					this.scaleSide = Side.LEFT;
				} else {
					this.scaleSide = Side.RIGHT;
				}

				if (gameSpecificMessage.charAt(2) == 'L') {
					this.theirSwitchSide = Side.LEFT;
				} else {
					this.theirSwitchSide = Side.RIGHT;
				}
			}

		}

		public enum Side {
			LEFT, RIGHT
		}

	    public void initDefaultCommand() {
	        // Set the default command for a subsystem here.
	        //setDefaultCommand(new MySpecialCommand());
	    }
	}
