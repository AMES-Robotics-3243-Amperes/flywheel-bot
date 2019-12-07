/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
// MotorController will be used for operating the flywheel CIM and servo
package frc.robot;

/// BEGIN LIBRARIES ///
import com.ctre.phoenix.motorcontrol.can.TalonSRX; 


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.Talon;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.VictorSP;

public class MotorController 
{
	WPI_TalonSRX driveM1 = new WPI_TalonSRX(0);
    WPI_TalonSRX driveM2 = new WPI_TalonSRX(1);
	VictorSP driveM3 = new VictorSP(0);
	VictorSP driveM4 = new VictorSP(1);
	
	public void drive(Double [] val) {
		driveM1.set(-val[0]); // Inverted motor 1
		driveM2.set(val[1]);
		driveM3.set(-val[0]); // Inverted motor 2
		driveM4.set(val[1]);
	}
}