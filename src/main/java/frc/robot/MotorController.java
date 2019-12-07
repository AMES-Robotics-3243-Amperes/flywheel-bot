/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
// MotorController will be used for operating the flywheel CIM and servo
package frc.robot;

/// BEGIN LIBRARIES ///
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.VictorSP; // Victor motorcont libraries
import edu.wpi.first.wpilibj.Joystick; // Wpilibj generic joystick library
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Talon; // Talon motorcont libraries
import edu.wpi.first.wpilibj.Servo; // Generic servo library
import java.util.ArrayList; // Should we use an arraylist? Would it make life easier?

public class MotorController 
{
	WPI_TalonSRX driveM1 = new WPI_TalonSRX(0);
    WPI_TalonSRX driveM2 = new WPI_TalonSRX(1);
	WPI_TalonSRX driveM3 = new WPI_TalonSRX(2);
    WPI_TalonSRX driveM4 = new WPI_TalonSRX(3);
    VictorSPX flywheel = new VictorSPX(0);

	
	public void drive(Double [] val) {
		driveM1.set(-val[0]); // Inverted motor 1
		driveM2.set(val[1]);
		driveM3.set(-val[0]); // Inverted motor 2
		driveM4.set(val[1]);
    }
    public void flywheelMotor(boolean [] val){ // Boolean method for CIM motor on flywheel mech
        
    }
    public void servoControl(int [] val){

    }
}