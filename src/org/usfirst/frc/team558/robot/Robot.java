/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team558.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team558.robot.autocommands.CenterAutoLeft;
import org.usfirst.frc.team558.robot.autocommands.CrossTheLine;
import org.usfirst.frc.team558.robot.autocommands.DoNothing;
import org.usfirst.frc.team558.robot.autocommands.doubleCenterRightSwitch;
import org.usfirst.frc.team558.robot.autocommands.doubleLeftScale;
import org.usfirst.frc.team558.robot.autocommands.doubleScaleSwitch;
import org.usfirst.frc.team558.robot.autocommands.*;
import org.usfirst.frc.team558.robot.autocommands.scaleRight;
import org.usfirst.frc.team558.robot.autocommands.switchRight;
import org.usfirst.frc.team558.robot.autocommands.threeFeet;
import org.usfirst.frc.team558.robot.autocommands.tripleLeftScale;
import org.usfirst.frc.team558.robot.commands.*;
import org.usfirst.frc.team558.robot.gameState.CenterAuto;
import org.usfirst.frc.team558.robot.gameState.buttShotLeftAuto;
import org.usfirst.frc.team558.robot.gameState.buttShotRightAuto;
import org.usfirst.frc.team558.robot.gameState.doubleCenterAuto;
import org.usfirst.frc.team558.robot.gameState.doubleLeftScaleAuto;
import org.usfirst.frc.team558.robot.gameState.doubleLeftScaleSwitchAuto;
import org.usfirst.frc.team558.robot.gameState.doubleRightScaleAuto;
import org.usfirst.frc.team558.robot.gameState.doubleRightScaleSwitchAuto;
import org.usfirst.frc.team558.robot.gameState.leftScale;
import org.usfirst.frc.team558.robot.gameState.leftSwitch;
import org.usfirst.frc.team558.robot.gameState.rightScale;
import org.usfirst.frc.team558.robot.gameState.rightSwitch;
import org.usfirst.frc.team558.robot.subsystems.*;
import org.usfirst.frc.team558.robot.util.gameState;


public class Robot extends TimedRobot {
	public static OI m_oi;

	public static DriveTrain driveTrain = new DriveTrain();
	public static rollerclaw rollerClaw = new rollerclaw();
	public static ShoulderArm Arm =new ShoulderArm();
	public static SuckerPunch punch = new SuckerPunch();
	public static GripperSolenoid gripper = new GripperSolenoid();
	public static HighPressureGrip highGrip = new HighPressureGrip();
	public static DetentSolenoid detent = new DetentSolenoid();
	public static CubeDetector cubeDetector = new CubeDetector();
	public static LineSensor lineSensor = new LineSensor();
	public static Climber climber = new Climber();
	private DigitBoard digit = DigitBoard.getInstance();
	public static Gyro gyro = new Gyro();
	public gameState GameState;
	
	public static Compressor pcm = new Compressor();
	public static Relay compressor = new Relay(0);
	
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	Command Auto;
	
	
	
	@Override
	public void robotInit() {
		
		CameraServer.getInstance().startAutomaticCapture();
		
		m_oi = new OI();
		
		
		
	}

	
	@Override
	public void disabledInit() {

		Robot.climber.ClimberDown();
		Robot.punch.resetPunch();
		
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
		this.GameState = new gameState(DriverStation.getInstance().getGameSpecificMessage());
		
		int val = (int) digit.getPotentiometer();
		
		switch(val) {
			
			case 0:
				digit.writeDigits("M&JO");
				Auto = new DoNothing();
				break;
			case 1:
				digit.writeDigits("FOSS");
				Auto = new CrossTheLine();
				break;
			case 2:
				digit.writeDigits("ALAN");
				Auto = new doubleLeftScaleAuto(GameState);
				break;
			case 3:
				digit.writeDigits("MANK");
				Auto = new doubleRightScaleAuto(GameState);
				break;
			case 4:
				digit.writeDigits("ERIK");
				Auto = new CenterAuto(GameState); 
				break;
			case 5:
				digit.writeDigits("ROB");
				Auto = new leftScale(GameState);
				break;
			case 6:
				digit.writeDigits("ANDY");
				Auto = new rightScale(GameState);
				break;
			case 7:
				digit.writeDigits("DAVE");
				Auto = new leftSwitch(GameState);
				break;
			case 8:
				digit.writeDigits("SELM");
				Auto = new rightSwitch(GameState);
				break;
			case 9:
				digit.writeDigits("B.LI");
				Auto = new ExchangeLeft();
				break;
			case 10:
				digit.writeDigits("CLIF");
				Auto = new rightExchange();
				break;
			case 11:
				digit.writeDigits("SKIP");
				Auto = new doubleLeftScaleSwitchAuto(GameState);
				break;
			case 12:
				digit.writeDigits("FSU");
				Auto = new doubleRightScaleSwitchAuto(GameState);
				break;
			case 13:
				digit.writeDigits("SHAM");
				Auto = new doubleCenterAuto(GameState);
				break;
			case 14:
				digit.writeDigits("SETH");
				Auto = new buttShotLeftAuto(GameState);
				break;
			case 15:
				digit.writeDigits("SUMI");
				Auto = new buttShotRightAuto(GameState);
				break;
		}
		
		
	}

	
	@Override
	public void autonomousInit() {
		m_autonomousCommand = Auto;

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
		
		SmartDashboard.putString("GameState", DriverStation.getInstance().getGameSpecificMessage());
		SmartDashboard.putNumber("Selected Auto", digit.getPotentiometer());
		
		Robot.rollerClaw.zeroAngle();
		Robot.detent.FireDetent();
		Robot.Arm.resetEncoder();
		Robot.punch.resetPunch();
		
	}

	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
		Robot.detent.FireDetent();
		
		SmartDashboard.putNumber("Left Encoder", Robot.driveTrain.readLeftEncoder() * .00460153);
		SmartDashboard.putNumber("Right Encoder", Robot.driveTrain.readRightEncoder() * .00460153);
		SmartDashboard.putNumber("Pidgey Angle", Robot.rollerClaw.getAngle());
		
		
		this.CompressorHandler();
	}

	@Override
	public void teleopInit() {
		
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		
		Robot.punch.resetPunch();
		Robot.detent.FireDetent();
	}

	
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		Robot.detent.FireDetent();
		
		
		SmartDashboard.putNumber("Arm Encoder", Robot.Arm.readEncoder());
		SmartDashboard.putNumber("Left Voltage", Robot.driveTrain.leftgetVolt());
		SmartDashboard.putNumber("Right Voltage", Robot.driveTrain.rightGetVolt());
		SmartDashboard.putNumber("Left Encoder", Robot.driveTrain.readLeftEncoder());
		SmartDashboard.putNumber("Right Encoder", Robot.driveTrain.readRightEncoder());
		SmartDashboard.putNumber("Gyro Angle", Robot.rollerClaw.getAngle());
		SmartDashboard.putBoolean("Cube Sensor", Robot.cubeDetector.readCubeSensor());
		SmartDashboard.putBoolean("Line Detector 1", Robot.lineSensor.readLineSensor1());
		SmartDashboard.putBoolean("Line Detector 2", Robot.lineSensor.readLineSensor2());
		
		
		this.CompressorHandler();
		
	}
	
	
	public void CompressorHandler(){
		if (!pcm.getPressureSwitchValue()){
			compressor.set(Value.kForward);
		}
		else {
			compressor.set(Value.kOff);
		}
		
		
	
}

	
	@Override
	public void testPeriodic() {
	}
}
