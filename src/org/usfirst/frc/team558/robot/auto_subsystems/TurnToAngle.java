package org.usfirst.frc.team558.robot.auto_subsystems;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class TurnToAngle extends PIDCommand {

    public TurnToAngle(double angle) {
        super(0.02, 0, 0);
        requires(Robot.driveTrain);
        requires(Robot.rollerClaw);
        getPIDController().setAbsoluteTolerance(1);
        getPIDController().setInputRange(-180, 180);
        getPIDController().setOutputRange(-.7, .7);
        getPIDController().setContinuous(true);
        
        setSetpoint(angle);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	
        return getPIDController().onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		
		
		return Robot.rollerClaw.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
		Robot.driveTrain.drive(-output, output);
		
		
	}
}
