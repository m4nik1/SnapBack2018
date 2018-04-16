/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team558.robot;

import org.usfirst.frc.team558.robot.commands.ArmFloor;
import org.usfirst.frc.team558.robot.commands.ArmFrontSwitch;
import org.usfirst.frc.team558.robot.commands.ArmHP;
import org.usfirst.frc.team558.robot.commands.ArmManual;
import org.usfirst.frc.team558.robot.commands.ArmReset;
import org.usfirst.frc.team558.robot.commands.ArmScale;
import org.usfirst.frc.team558.robot.commands.AutoShootDrive;
import org.usfirst.frc.team558.robot.commands.ZeroArmEncoder;
import org.usfirst.frc.team558.robot.commands.punch;
import org.usfirst.frc.team558.robot.commands.weakPunch;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	
	XboxController driveStick = new XboxController(0);
	XboxController operatorStick = new XboxController(1);
	
	public OI() {
		
		JoystickButton punchButton = new JoystickButton(operatorStick ,6);
		JoystickButton armScale = new JoystickButton(operatorStick, 4);
		JoystickButton weakPunch = new JoystickButton(operatorStick, 5);
		JoystickButton armHP = new JoystickButton(operatorStick, 2);
		JoystickButton armFloor = new JoystickButton(operatorStick, 1);
		JoystickButton armFrontSwitch = new JoystickButton(operatorStick, 3);
		JoystickButton resetEncoder = new JoystickButton(operatorStick, 7);
		JoystickButton manualMode = new JoystickButton(operatorStick, 8);
		
		JoystickButton autoShootDriveButton = new JoystickButton(driveStick,5);
		//JoystickButton gripper = new JoystickButton(operatorStick, 5);
		
		
		punchButton.whileHeld(new punch());
		armScale.whenPressed(new ArmScale());
		armHP.whenPressed(new ArmHP());
		armFloor.whenPressed(new ArmFloor());
		armFrontSwitch.whenPressed(new ArmFrontSwitch());
		resetEncoder.whenPressed(new ArmReset());
		//resetArm.whenPressed(new ZeroArmEncoder());
		weakPunch.whileHeld(new weakPunch());
		autoShootDriveButton.whileHeld(new AutoShootDrive());
		
		//gripper.whileHeld(new OpenCloseGripper());
		manualMode.whenPressed(new ArmManual());
	}
	
	public double GetRollerStick(){
		
		double power = operatorStick.getRawAxis(1);
		
		if ((power < .1) && (power > -.1)){
    		return 0;
    	}
    	else{
    		return power;
    	}
	}	
	public double GetArmStick(){
		
		double armPower = operatorStick.getRawAxis(5);
		
		if ((armPower < .1) && (armPower > -.1)){
    		return 0;
    	}
    	else
    		return armPower;
		
	}
	
	//Elm City Drive OI Methods
		public boolean GetQuickTurn(){
			return driveStick.getRawButton(RobotMap.quickTurnButton);
				
		}
		public double Arm() {
			
			return operatorStick.getRawAxis(1);
			
		}
		public double GetThrottle(){
			double reverse = driveStick.getRawAxis(RobotMap.throttleForwardAxis);
		   	double forward = driveStick.getRawAxis(RobotMap.throttleReverseAxis);

	//***This might be a redundant deadband or the elm city command might be**//
		    	
		    	if ((reverse > .1) && (forward >.1)){
		    		return 0;
		    	}
		    	else if (forward > .1){
		    		return forward;
		    	}
		    	else if (reverse > .1){
		    		return -reverse;
		    	}
		    	else
		    		return 0;
			}

			
		public double GetTurn(){
			return driveStick.getRawAxis(RobotMap.turnAxis);
		}
		
		public double VacuumAxis() {
			
			return operatorStick.getRawAxis(0);
			
		}
		
		public double getClimberPOV(){
			
			return operatorStick.getPOV();
			
			
		}
	
		
		public double GetGripperAxis(){
			return operatorStick.getRawAxis(3);
		}
		public double GetGripperAxisOverRide(){
			
			return operatorStick.getRawAxis(2);
			
		}
		public void rumble(double rumble){
			
			driveStick.setRumble(GenericHID.RumbleType.kLeftRumble, rumble);
			driveStick.setRumble(GenericHID.RumbleType.kRightRumble, rumble);
			operatorStick.setRumble(GenericHID.RumbleType.kLeftRumble, rumble);
			operatorStick.setRumble(GenericHID.RumbleType.kRightRumble, rumble);
			
		}
}
