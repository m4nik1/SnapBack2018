package com.team319;

import com.team254.lib.trajectory.WaypointSequence.Waypoint;
import com.team319.trajectory.BobPath;
import com.team319.trajectory.BobPathGenerator;
import com.team319.trajectory.SrxTranslatorConfig;
import com.team319.trajectory.SrxTrajectoryExporter;

/**
 * Forked from 254's 2014 Trajectory library just a comment to make a change
 * 
 * @author Jared341
 * @author ttremblay
 */
public class Main {

	public static double robotTotalWidthFeet = 28.5 / 12.0;
	public static double robotTotalLengthFeet = 31.5 / 12.0;
	
	//public static SrxTrajectoryExporter SrxTrajectoryExporter = new SrxTrajectoryExporter();
	
	public static Waypoint rightSideStartingWaypoint = new Waypoint(robotTotalLengthFeet / 2, 45.5 / 12.0, 0);
	public static Waypoint leftSideStartingWaypoint = new Waypoint(robotTotalLengthFeet / 2, 277.8 / 12.0, 0);
	public static Waypoint centerStartingWaypoint = new Waypoint(robotTotalLengthFeet / 2, 157.0 / 12.0, 0);
	
	public static SrxTranslatorConfig powerUpConfig;
	public static SrxTranslatorConfig switchConfig;
	public static SrxTranslatorConfig longDistanceConfig;

	public static void main(String[] args) {

		powerUpConfig = new SrxTranslatorConfig();
		powerUpConfig.name = "powerUpConfig";
		powerUpConfig.dt = .01;
		powerUpConfig.max_acc = 11.0;
		powerUpConfig.max_jerk = 65.0;
		powerUpConfig.max_vel = 12; // 11.0
		powerUpConfig.wheelbase_width_feet = 39.5/12.0;// 23.5, then 29.5, 35.5
		powerUpConfig.wheel_dia_inches = 6.0;
		powerUpConfig.scale_factor = .9; // 3.08
		powerUpConfig.encoder_ticks_per_rev = 4096;
		powerUpConfig.robotLength = 31.5;
		powerUpConfig.robotWidth = 28.5;
		powerUpConfig.highGear = false;

		
		//tripleCubeAutos(powerUpConfig);
		//doubleCubeAutos(powerUpConfig);
		//switchAutos(powerUpConfig);
		//scaleAutos(powerUpConfig);
		centerAutos(powerUpConfig);
		//miscAutos(powerUpConfig);
	
		
		//spackageStr = 
		
		 //copyArcsToRobotCode();
		//copyPathsToRobotCode();
	}

	
	private static void tripleCubeAutos(SrxTranslatorConfig config) {
		
		BobPath tripleScale = new BobPath(config, "tripleScale", -1);
		tripleScale.addWaypoint(leftSideStartingWaypoint);
		tripleScale.addWaypointRelative(10.46, 0, 0);
		tripleScale.addWaypointRelative(12.62, -4.02, 0);
		
		BobPath tripleScaleFront = new BobPath(config, "tripleScaleFront", 1);
		tripleScaleFront.addWaypoint(tripleScale.getLastWaypoint());
		tripleScaleFront.addWaypointRelative(-5.7, -2.3, 10);
		
		//tripleScaleBack2 is in the new 558Bobtrajectoryfollowing 
		
		BobPath tripleScaleBack2 = new BobPath(config, "tripleScaleBack2", -1);
		tripleScaleBack2.addWaypoint(tripleScaleFront.getLastWaypoint());
		tripleScaleBack2.addWaypointRelative(5.7, .5, -20); 
		
		BobPath tripleScaleFront2 = new BobPath(config, "tripleScaleFront2", 1);
		tripleScaleFront2.addWaypoint(tripleScaleBack2.getLastWaypoint());
		tripleScaleFront2.addWaypointRelative(-5.7, -3.2, 0);
		
		BobPath tripleScaleBack3 = new BobPath(config, "tripleScaleBack3", -1);
		tripleScaleBack3.addWaypoint(tripleScaleFront2.getLastWaypoint());
		tripleScaleBack3.addWaypointRelative(5.7, 2.5, 10);
		
		
		//BobPathGenerator.exportArcToJavaFile(tripleScaleBack3);
		//BobPathGenerator.exportArcToJavaFile(tripleScaleFront2);
		//BobPathGenerator.exportArcToJavaFile(tripleScaleBack2);
		//BobPathGenerator.exportArcToJavaFile(tripleScaleFront);
		//BobPathGenerator.exportArcToJavaFile(tripleScale);
		
	}
	
	private static void doubleCubeAutos(SrxTranslatorConfig config) {
		
		BobPath doubleFarScale = new BobPath(config, "doubleFarScale", -1);
		doubleFarScale.addWaypoint(rightSideStartingWaypoint);
		doubleFarScale.addWaypointRelative(12.5, 0.0, 0.0);
		doubleFarScale.addWaypointRelative(6.5, 5.0, 89.99);
		doubleFarScale.addWaypointRelative(0.0, 8.0, 0.0);
		doubleFarScale.addWaypointRelative(5.0, 4.0, -89.99);
		
		BobPath doubleFarScaleFront = new BobPath(config, "doubleFarScaleFront", 1);
		doubleFarScaleFront.addWaypoint(doubleFarScale.getLastWaypoint());
		doubleFarScaleFront.addWaypointRelative(-6.3, -.5, 20.0);
		
		BobPath doubleFarScaleBack2 = new BobPath(config, "doubleFarScaleBack2", -1);
		doubleFarScaleBack2.addWaypoint(doubleFarScaleFront.getLastWaypoint());
		doubleFarScaleBack2.addWaypointRelative(6.3, .5, -30);
		
		
		BobPath doubleCubeScaleBack = new BobPath(config, "doubleLeftScaleBack", -1);
		doubleCubeScaleBack.addWaypoint(leftSideStartingWaypoint);
		doubleCubeScaleBack.addWaypointRelative(13.46, 0, 0);
		doubleCubeScaleBack.addWaypointRelative(12.32, -4.02, 0);
		
		BobPath doubleCubeScaleFront = new BobPath(config, "doubleLeftScaleFront", 1);
		doubleCubeScaleFront.addWaypoint(doubleCubeScaleBack.getLastWaypoint());
		doubleCubeScaleFront.addWaypointRelative(-6.2, -.8, 8); // angle: 30
		
		BobPath doubleCubeScale2 = new BobPath(config, "doubleLeftScaleBack2", -1);
		doubleCubeScale2.addWaypoint(doubleCubeScaleFront.getLastWaypoint());
		doubleCubeScale2.addWaypointRelative(6.7, .5, -20);
		
		
		BobPath doubleRightScale = new BobPath(config, "doubleRightScaleBack", -1);
		doubleRightScale.addWaypoint(rightSideStartingWaypoint);
		doubleRightScale.addWaypointRelative(12.46, 0, 0);
		doubleRightScale.addWaypointRelative(14.62, 4.02, 0);
		
		BobPath doubleRightScaleFront = new BobPath(config, "doubleRightScaleFront", 1);
		doubleRightScaleFront.addWaypoint(doubleRightScale.getLastWaypoint());
		doubleRightScaleFront.addWaypointRelative(-6.2, -.8, -8);
		
		BobPath doubleRightScaleBack2 = new BobPath(config, "doubleRightScaleBack2", -1);
		doubleRightScaleBack2.addWaypoint(doubleRightScaleFront.getLastWaypoint());
		doubleRightScaleBack2.addWaypointRelative(6.7, -.5, 20);//6.7, -.5, 20
		
		/*BobPath doubleScaleSwitchBack = new BobPath(config, "doubleLeftScaleBack", -1);
		doubleCubeScaleBack.addWaypoint(leftSideStartingWaypoint);
		doubleCubeScaleBack.addWaypointRelative(10.46, 0, 0);
		doubleCubeScaleBack.addWaypointRelative(12.62, -4.02, 0);*/
		
		BobPath doubleScaleBack = new BobPath(config, "doubleLeftScaleBack195", -1);
		doubleScaleBack.addWaypoint(doubleCubeScale2.getLastWaypoint());
		doubleScaleBack.addWaypointRelative(2, 5, 0);
		
		
		BobPath doubleScaleSwitchFront = new BobPath(config, "doubleScaleSwitchFront", 1);
		doubleScaleSwitchFront.addWaypoint(doubleCubeScaleBack.getLastWaypoint());
		doubleScaleSwitchFront.addWaypointRelative(-5.7, -0.7, 10); // angle: 30
		
		BobPath doubleScaleSwitchFront2 = new BobPath(config, "doubleScaleSwitchFront", 1);
		doubleScaleSwitchFront2.addWaypoint(doubleCubeScaleFront.getLastWaypoint());
		doubleScaleSwitchFront2.addWaypointRelative(-3, 0, 0);
		

		
		//BobPathGenerator.exportArcToJavaFile(doubleCubeScaleBack);
		BobPathGenerator.exportArcToJavaFile(doubleRightScale);
		BobPathGenerator.exportArcToJavaFile(doubleRightScaleFront);
		BobPathGenerator.exportArcToJavaFile(doubleRightScaleBack2);
		//BobPathGenerator.exportArcToJavaFile(doubleFarScaleFront);
		//BobPathGenerator.exportArcToJavaFile(doubleFarScaleBack2);
		//BobPathGenerator.exportArcToJavaFile(doubleScaleSwitchFront);
		//BobPathGenerator.exportArcToJavaFile(doubleScaleSwitchFront2);

	
	}
	
	private static void centerAutos(SrxTranslatorConfig config) {
		
		BobPath CenterAutoLeft = new BobPath(powerUpConfig, "CenterLeftAuto", -1);
		CenterAutoLeft.addWaypoint(centerStartingWaypoint);
		CenterAutoLeft.addWaypointRelative(9.77, 4.7, 0);
		
		BobPath CenterAutoRight = new BobPath(powerUpConfig, "CenterAutoRight", -1);
		CenterAutoRight.addWaypoint(centerStartingWaypoint);
		CenterAutoRight.addWaypointRelative(9.77, -4.7, 0);
		
		BobPath doubleCenterLeft = new BobPath(config, "doubleCenterLeft", 1);
		doubleCenterLeft.addWaypoint(centerStartingWaypoint);
		doubleCenterLeft.addWaypointRelative(9.77, 5.3, 0);
		
		BobPath doubleCenterLeftBack = new BobPath(config, "doubleCenterLeftBack", -1);
		doubleCenterLeftBack.addWaypoint(doubleCenterLeft.getLastWaypoint());
		doubleCenterLeftBack.addWaypointRelative(-8.5, -4.2, 0);
		
		BobPath doubleCenterLeftFront = new BobPath(config, "doubleCenterLeftFront", 1);
		doubleCenterLeftFront.addWaypoint(doubleCenterLeftBack.getLastWaypoint());
		doubleCenterLeftFront.addWaypointRelative(5.5, 0, 0);
		
		BobPath doubleCenterLeftBack2 = new BobPath(config, "doubleCenterLeftBack2", -1);
		doubleCenterLeftBack2.addWaypoint(doubleCenterLeftFront.getLastWaypoint());
		doubleCenterLeftBack2.addWaypointRelative(-4.5, 0, 0);
		
		BobPath doubleCenterLeftFront2 = new BobPath(config, "doubleCenterLeftFront2", 1);
		doubleCenterLeftFront2.addWaypoint(doubleCenterLeftBack2.getLastWaypoint());
		doubleCenterLeftFront2.addWaypointRelative(9.5, 4.7, 0);
		
		BobPath doubleCenterRight = new BobPath(config, "doubleCenterRight", 1);
		doubleCenterRight.addWaypoint(centerStartingWaypoint);
		doubleCenterRight.addWaypointRelative(9.77, -4.7, 0);
		
		BobPath doubleCenterRightBack = new BobPath(config, "doubleCenterRightBack", -1);
		doubleCenterRightBack.addWaypoint(doubleCenterRight.getLastWaypoint());
		doubleCenterRightBack.addWaypointRelative(-8.5, 5.5, 0);
		
		BobPath doubleCenterRightFront = new BobPath(config, "doubleCenterRightFront", 1);
		doubleCenterRightFront.addWaypoint(doubleCenterRightBack.getLastWaypoint());
		doubleCenterRightFront.addWaypointRelative(5.7, 0, 0);
		
		BobPath doubleCenterRightBack2 = new BobPath(config, "doubleCenterRightBack2", -1);
		doubleCenterRightBack2.addWaypoint(doubleCenterRightFront.getLastWaypoint());
		doubleCenterRightBack2.addWaypointRelative(-4.5, 0, 0);
		
		
		BobPath doubleCenterRightFront2 = new BobPath(config, "doubleCenterRightFront2", 1);
		doubleCenterRightFront2.addWaypoint(doubleCenterRightBack2.getLastWaypoint());
		doubleCenterRightFront2.addWaypointRelative(9.5, -4.7, 0);
		
		
		
		BobPathGenerator.exportArcToJavaFile(doubleCenterRight);
		BobPathGenerator.exportArcToJavaFile(doubleCenterRightBack);
		BobPathGenerator.exportArcToJavaFile(doubleCenterRightFront);
		BobPathGenerator.exportArcToJavaFile(doubleCenterRightBack2);
		BobPathGenerator.exportArcToJavaFile(doubleCenterRightFront2);
		
		
				
		//BobPathGenerator.exportArcToJavaFile();
		
	}
	
	private static void switchAutos(SrxTranslatorConfig config) {
		
		BobPath switchRight = new BobPath(config, "switchRight", -1);
		switchRight.addWaypoint(rightSideStartingWaypoint);
		switchRight.addWaypointRelative(10, 0, 0);
		switchRight.addWaypointRelative(3.708, 4, -89.99);
		
		BobPath switchLeft = new BobPath(config, "switchLeft", -1);
		switchLeft.addWaypoint(leftSideStartingWaypoint);
		switchLeft.addWaypointRelative(10, 0, 0);
		switchLeft.addWaypointRelative(3.708, -4, 89.99);
		
		BobPath leftFarSwitch = new BobPath(config, "leftFarSwitch", -1);
		leftFarSwitch.addWaypoint(leftSideStartingWaypoint);
		leftFarSwitch.addWaypointRelative(13, 0 , 0);
		leftFarSwitch.addWaypointRelative(5.512, -5.98, -89.99);
		leftFarSwitch.addWaypointRelative(-1.5, -8, -60);
		
		
		
		BobPathGenerator.exportArcToJavaFile(switchRight);
		BobPathGenerator.exportArcToJavaFile(switchLeft);
		//BobPathGenerator.exportArcToJavaFile(leftFarSwitch);
		
		
		
	}
	
	private static void miscAutos(SrxTranslatorConfig config) {
		
		BobPath Exchange = new BobPath(config, "Exchange", -1);
		Exchange.addWaypoint(leftSideStartingWaypoint);
		Exchange.addWaypointRelative(12, 0, 0);
		
		BobPath ExchangeFront = new BobPath(config, "ExchangeFront", 1);
		ExchangeFront.addWaypoint(Exchange.getLastWaypoint());
		ExchangeFront.addWaypointRelative(-10.8, -9.52, 0);
		
		BobPath threeFeet = new BobPath(config, "ThreeFeet", -1);
		threeFeet.addWaypoint(centerStartingWaypoint);
		threeFeet.addWaypointRelative(4, -5, -89.99);
		//threeFeet.addWaypointRelative(2, 0, 0);
		
		
		BobPath CrossTheLine = new BobPath(config, "CrossTheLine", -1);
		CrossTheLine.addWaypoint(centerStartingWaypoint);
		CrossTheLine.addWaypointRelative(10, 0, 0);
		
		BobPath RightExchange = new BobPath(config, "RightExchange", -1);
		RightExchange.addWaypoint(rightSideStartingWaypoint);
		RightExchange.addWaypointRelative(12, 0, 0);
		
		BobPath RightExchangeFront = new BobPath(config, "RightExchangeFront", 1);
		RightExchangeFront.addWaypoint(RightExchange.getLastWaypoint());
		RightExchangeFront.addWaypointRelative(-10.8, 9.84, 0);
		
		
		BobPath ButtShot = new BobPath(config, "ButtShot", -1);
		ButtShot.addWaypoint(leftSideStartingWaypoint);
		ButtShot.addWaypointRelative(27.7, 1.8, 0);
		
		BobPath ButtShotRight = new BobPath(config, "ButtShotRight", -1);
		ButtShotRight.addWaypoint(rightSideStartingWaypoint);
		ButtShotRight.addWaypointRelative(27.7, -1.8, 0);
		
		
		BobPath ButtShot2 = new BobPath(config, "ButtShot2", 1);
		ButtShot2.addWaypoint(ButtShot.getLastWaypoint());
		ButtShot2.addWaypointRelative(6, 0, 0);
		
		//BobPathGenerator.exportArcToJavaFile(threeFeet);
		//BobPathGenerator.exportArcToJavaFile(Exchange);
		BobPathGenerator.exportArcToJavaFile(ButtShotRight);
		BobPathGenerator.exportArcToJavaFile(ButtShot2);
		BobPathGenerator.exportArcToJavaFile(ButtShot);
		
	}

	
	
	private static void copyArcsToRobotCode() {
		BobPathGenerator.copyFilesToRelativeDirectory("Arcs", "..\\SnapBackHartford\\src\\org\\usfirst\\frc\\team558\\robot\\center_paths");
		
	}
	
	private static void copyPathsToRobotCode() {
		BobPathGenerator.copyFilesToRelativeDirectory("Paths", "..\\frc319-2018\\src\\org\\usfirst\\frc\\team319\\paths");
	}
	
}
