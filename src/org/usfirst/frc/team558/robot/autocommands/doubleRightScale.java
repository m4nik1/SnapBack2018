package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.auto_subsystems.Arm;
import org.usfirst.frc.team558.robot.auto_subsystems.FollowArc;
import org.usfirst.frc.team558.robot.auto_subsystems.PunchWithSensors;
import org.usfirst.frc.team558.robot.auto_subsystems.rollerClawSensor;
import org.usfirst.frc.team558.robot.auto_subsystems.zeroPidgeotto;
import org.usfirst.frc.team558.robot.scale_Paths.doubleLeftScaleBack2Arc;
import org.usfirst.frc.team558.robot.scale_Paths.doubleLeftScaleBackArc;
import org.usfirst.frc.team558.robot.scale_Paths.doubleLeftScaleFrontArc;
import org.usfirst.frc.team558.robot.scale_Paths.doubleRightScaleBack2Arc;
import org.usfirst.frc.team558.robot.scale_Paths.doubleRightScaleBackArc;
import org.usfirst.frc.team558.robot.scale_Paths.doubleRightScaleFrontArc;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class doubleRightScale extends CommandGroup {

    public doubleRightScale() {
	    	addSequential(new Arm(0, .25));
	    	addParallel(new PunchWithSensors(4.5));
	    	addSequential(new FollowArc(new doubleRightScaleBackArc()));
	    	addSequential(new zeroPidgeotto());
	    	addSequential(new Arm(-10600, .25));
	    	addParallel(new rollerClawSensor(1, 2));
	    	addSequential(new FollowArc(new doubleRightScaleFrontArc()));
	    	addSequential(new zeroPidgeotto());
	    	addSequential(new Arm(0, .1));
	    	addParallel(new PunchWithSensors(3));
	    	addSequential(new FollowArc(new doubleRightScaleBack2Arc()));
    }
}
