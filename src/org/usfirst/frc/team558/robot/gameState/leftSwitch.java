package org.usfirst.frc.team558.robot.gameState;

import org.usfirst.frc.team558.robot.autocommands.CrossTheLine;
import org.usfirst.frc.team558.robot.autocommands.ExchangeLeft;
import org.usfirst.frc.team558.robot.autocommands.scaleLeft;
import org.usfirst.frc.team558.robot.autocommands.switchLeft;
import org.usfirst.frc.team558.robot.util.gameState;
import org.usfirst.frc.team558.robot.util.gameState.Side;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class leftSwitch extends CommandGroup {

    public leftSwitch(gameState gameState) {
    	if(gameState.mySwitchSide == Side.LEFT) {
			
			addSequential(new switchLeft());
			
		}
    	else if(gameState.scaleSide == Side.LEFT) {
    			
    			addSequential(new scaleLeft());
    			
    	}
   		else {
    			
    			addSequential(new ExchangeLeft());
    			
    	}
    }
}
