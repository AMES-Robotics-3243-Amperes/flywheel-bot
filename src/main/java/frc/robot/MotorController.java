/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
// MotorController will be used for operating the flywheel CIM and servo
package frc.robot;

/// BEGIN LIBRARIES ///
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.can.VictorSPX; // Victor motorcont libraries
import edu.wpi.first.wpilibj.Joystick; // Wpilibj generic joystick library
import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX; // Talon motorcont libraries
import edu.wpi.first.wpilibj.Servo; // Generic servo library
import java.util.ArrayList; // Should we use an arraylist? Would it make life easier?

public class MotorController 
{
	private WPI_TalonSRX driveM1 = new WPI_TalonSRX(RobotMap.MOTOR_LEFT_1_ID);
    private WPI_TalonSRX driveM2 = new WPI_TalonSRX(RobotMap.MOTOR_LEFT_2_ID);
	private WPI_TalonSRX driveM3 = new WPI_TalonSRX(RobotMap.MOTOR_RIGHT_1_ID);
    private WPI_TalonSRX driveM4 = new WPI_TalonSRX(RobotMap.MOTOR_RIGHT_2_ID);
    private VictorSPX flywheel = new VictorSPX(RobotMap.MOTOR_FLYWHEEL_ID);

	
	public void drive(double [] val) {
		driveM1.set(val[0]); // Left L
		driveM2.set(val[0]); // Left R
		driveM3.set(-val[1]); // Right L
		driveM4.set(-val[1]); // Right R
    }
    
    public void flywheelMotor(boolean flyCondition){ // Boolean method for CIM motor on flywheel mech
        if(flyCondition){
            flywheel.set(ControlMode.PercentOutput, -1.0); 
        }else{
            flywheel.set(ControlMode.PercentOutput, 0.0);
        }
    }
    public void servoControl(int [] val){
        
    }
}