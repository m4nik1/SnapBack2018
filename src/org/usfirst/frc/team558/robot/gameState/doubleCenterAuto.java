package org.usfirst.frc.team558.robot.gameState;

import org.usfirst.frc.team558.robot.autocommands.CrossTheLine;
import org.usfirst.frc.team558.robot.autocommands.doubleCenterRightSwitch;
import org.usfirst.frc.team558.robot.autocommands.doubleCenterSwitch;
import org.usfirst.frc.team558.robot.util.gameState;
import org.usfirst.frc.team558.robot.util.gameState.Side;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class doubleCenterAuto extends CommandGroup {

    public doubleCenterAuto(gameState gameState) {
    	if(gameState.mySwitchSide == Side.LEFT) {
			
			addSequential(new doubleCenterSwitch());
			
		}
		else if(gameState.mySwitchSide == Side.RIGHT){
			
			addSequential(new doubleCenterRightSwitch());
			
		}
		else {
			
			addSequential(new CrossTheLine());
			
		}
    }
}
