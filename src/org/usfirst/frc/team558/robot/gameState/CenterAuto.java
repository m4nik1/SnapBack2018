package org.usfirst.frc.team558.robot.gameState;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team558.robot.autocommands.*;
import org.usfirst.frc.team558.robot.util.*;
import org.usfirst.frc.team558.robot.util.gameState.Side;

/**
 *
 */
public class CenterAuto extends CommandGroup {

    public CenterAuto(gameState gameState) {
        
    		if(gameState.mySwitchSide == Side.LEFT) {
    			
    			addSequential(new CenterAutoLeft());
    			
    		}
    		else if(gameState.mySwitchSide == Side.RIGHT){
    			
    			addSequential(new CenterAutoRight());
    			
    		}
    		else {
    			
    			addSequential(new CrossTheLine());
    			
    		}
    		
    }
}
