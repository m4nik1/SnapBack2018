package org.usfirst.frc.team558.robot.gameState;

import org.usfirst.frc.team558.robot.autocommands.CrossTheLine;
import org.usfirst.frc.team558.robot.autocommands.ExchangeLeft;
import org.usfirst.frc.team558.robot.autocommands.doubleLeftScale;
import org.usfirst.frc.team558.robot.autocommands.doubleRightScale;
import org.usfirst.frc.team558.robot.autocommands.rightExchange;
import org.usfirst.frc.team558.robot.autocommands.switchLeft;
import org.usfirst.frc.team558.robot.autocommands.switchRight;
import org.usfirst.frc.team558.robot.util.gameState;
import org.usfirst.frc.team558.robot.util.gameState.Side;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class doubleRightScaleAuto extends CommandGroup {

    public doubleRightScaleAuto(gameState gameState) {
    	if(gameState.scaleSide == Side.RIGHT) {
			
			addSequential(new doubleRightScale());
			
    		}
    		else if(gameState.mySwitchSide == Side.RIGHT) {
    			
    			addSequential(new switchRight());
    			
    		}
    		else {
    			
    			addSequential(new CrossTheLine());
    			
    		}
    }
}
