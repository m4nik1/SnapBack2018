package com.team319;

import com.team254.lib.trajectory.WaypointSequence.Waypoint;
import com.team319.trajectory.BobPath;
import com.team319.trajectory.BobPathGenerator;
import com.team319.trajectory.SrxTranslatorConfig;

/**
 * Forked from 254's 2014 Trajectory library just a comment to make a change
 * 
 * @author Jared341
 * @author ttremblay
 */
public class Main {

	public static double robotTotalWidthFeet = 28.5 / 12.0;
	public static double robotTotalLengthFeet = 31.5 / 12.0;

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
		powerUpConfig.max_acc = 10.0;
		powerUpConfig.max_jerk = 65.0;
		powerUpConfig.max_vel = 12; // 11.0
		powerUpConfig.wheelbase_width_feet = 39.5/12.0;// 23.5, then 29.5, 35.5
		powerUpConfig.wheel_dia_inches = 6.0;
		powerUpConfig.scale_factor = .9; // 3.08
		powerUpConfig.encoder_ticks_per_rev = 4096;
		powerUpConfig.robotLength = 31.5;
		powerUpConfig.robotWidth = 28.5;
		powerUpConfig.highGear = false;

		
		//doubleCubeAutos(powerUpConfig);
		//switchAutos(powerUpConfig);
		//scaleAutos(powerUpConfig);
		//centerAutos(powerUpConfig);
		miscAutos(powerUpConfig);
		
		
		 //copyArcsToRobotCode();
		//copyPathsToRobotCode();
	}

	private static void doubleCubeAutos(SrxTranslatorConfig config) {
		
		BobPath tripleScale = new BobPath(config, "tripleScale", -1);
		tripleScale.addWaypoint(leftSideStartingWaypoint);
		tripleScale.addWaypointRelative(10.46, 0, 0);
		tripleScale.addWaypointRelative(12.62, -4.02, 0);
		
		BobPath tripleScaleFront = new BobPath(config, "tripleScaleFront", 1);
		tripleScaleFront.addWaypoint(tripleScale.getLastWaypoint());
		tripleScaleFront.addWaypointRelative(-5.7, -0.7, 10);
		
		
		BobPath tripleScaleBack2 = new BobPath(config, "tripleScaleBack2", -1);
		tripleScaleBack2.addWaypoint(tripleScaleFront.getLastWaypoint());
		tripleScaleBack2.addWaypointRelative(5.7, .7, 10);
		
		
		BobPath doubleCubeScaleBack = new BobPath(config, "doubleLeftScaleBack", -1);
		doubleCubeScaleBack.addWaypoint(leftSideStartingWaypoint);
		doubleCubeScaleBack.addWaypointRelative(10.46, 0, 0);
		doubleCubeScaleBack.addWaypointRelative(12.62, -4.02, 0);
		
		BobPath doubleCubeScaleFront = new BobPath(config, "doubleLeftScaleFront", 1);
		doubleCubeScaleFront.addWaypoint(doubleCubeScaleBack.getLastWaypoint());
		doubleCubeScaleFront.addWaypointRelative(-5.7, -0.7, 10); // angle: 30
		
		BobPath doubleCubeScale2 = new BobPath(config, "doubleLeftScaleBack2", -1);
		doubleCubeScale2.addWaypoint(doubleCubeScaleFront.getLastWaypoint());
		doubleCubeScale2.addWaypointRelative(6.7, .5, -20);
		
		BobPath doubleScaleSwitchBack = new BobPath(config, "doubleLeftScaleSwitchBack", -1);
		doubleScaleSwitchBack.addWaypoint(leftSideStartingWaypoint);
		doubleScaleSwitchBack.addWaypointRelative(10.46, 0, 0);
		doubleScaleSwitchBack.addWaypointRelative(12.62, -4.02, 0);
		
		BobPath doubleScaleBack = new BobPath(config, "doubleLeftScaleBack195", -1);
		doubleScaleBack.addWaypoint(doubleCubeScaleBack.getLastWaypoint());//doubleCubeScale2.getLastWaypoint()
		doubleScaleBack.addWaypointRelative(4, 6, 89.99);//4, 6, 89.99
		
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

		
		//BobPathGenerator.exportArcToJavaFile(tripleScaleFront2);
		BobPathGenerator.exportArcToJavaFile(doubleRightScale);
		BobPathGenerator.exportArcToJavaFile(doubleRightScaleFront);
		BobPathGenerator.exportArcToJavaFile(doubleRightScaleBack2);
		//BobPathGenerator.exportArcToJavaFile(doubleRightScaleFront);
		//BobPathGenerator.exportArcToJavaFile(doubleFarScaleBack2);

	
	}
	
	private static void miscAutos(SrxTranslatorConfig config) {
		
		BobPath Exchange = new BobPath(config, "Exchange", -1);
		Exchange.addWaypoint(leftSideStartingWaypoint);
		Exchange.addWaypointRelative(12, 0, 0);
		
		BobPath ExchangeFront = new BobPath(config, "ExchangeFront", 1);
		ExchangeFront.addWaypoint(Exchange.getLastWaypoint());
		ExchangeFront.addWaypointRelative(-11.31, -7.82, 0);
		
		BobPath crossTheLine = new BobPath(config, "CrossTheLine", -1);
		crossTheLine.addWaypoint(centerStartingWaypoint);
		crossTheLine.addWaypointRelative(12, 0, 0);
		
		BobPath ButtShot = new BobPath(config, "ButtShot", -1);
		ButtShot.addWaypoint(leftSideStartingWaypoint);
		ButtShot.addWaypointRelative(23, 0, 0);
		
		BobPath ButtShot2 = new BobPath(config, "ButtShot2", 1);
		ButtShot2.addWaypoint(ButtShot.getLastWaypoint());
		ButtShot2.addWaypointRelative(3, 0, 0);
		
		
		//BobPathGenerator.exportArcToJavaFile(crossTheLine);
		//BobPathGenerator.exportArcToJavaFile(Exchange);
		//BobPathGenerator.exportArcToJavaFile(ExchangeFront);
		BobPathGenerator.exportArcToJavaFile(ButtShot2);
		
	}

	
	
	private static void copyArcsToRobotCode() {
		BobPathGenerator.copyFilesToRelativeDirectory("Arcs", "..\\PracticeBot2018WithArcs\\src\\org\\usfirst\\frc\\team558\\robot\\paths");
		
	}
	
	private static void copyPathsToRobotCode() {
		BobPathGenerator.copyFilesToRelativeDirectory("Paths", "..\\frc319-2018\\src\\org\\usfirst\\frc\\team319\\paths");
	}
	
}
