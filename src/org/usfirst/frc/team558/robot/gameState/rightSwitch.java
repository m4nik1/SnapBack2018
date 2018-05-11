package org.usfirst.frc.team558.robot.gameState;

import org.usfirst.frc.team558.robot.autocommands.CrossTheLine;
import org.usfirst.frc.team558.robot.autocommands.ExchangeLeft;
import org.usfirst.frc.team558.robot.autocommands.rightExchange;
import org.usfirst.frc.team558.robot.autocommands.scaleLeft;
import org.usfirst.frc.team558.robot.autocommands.scaleRight;
import org.usfirst.frc.team558.robot.autocommands.switchLeft;
import org.usfirst.frc.team558.robot.autocommands.switchRight;
import org.usfirst.frc.team558.robot.util.gameState;
import org.usfirst.frc.team558.robot.util.gameState.Side;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class rightSwitch extends CommandGroup {

    public rightSwitch(gameState gameState) {
	    	if(gameState.mySwitchSide == Side.RIGHT) {
				
				addSequential(new switchRight());
				
			}
	    	else if(gameState.scaleSide == Side.RIGHT) {
	    			
	    			addSequential(new scaleRight());
	    			
	    	}
	   		else {
	    			
	    			addSequential(new CrossTheLine());
	    			
	    	}
    }
}
