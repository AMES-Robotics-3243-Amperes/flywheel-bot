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
import java.util.concurrent.TimeUnit;

public class MotorController 
{
	private WPI_TalonSRX driveM1 = new WPI_TalonSRX(RobotMap.MOTOR_LEFT_1_ID);
    private WPI_TalonSRX driveM2 = new WPI_TalonSRX(RobotMap.MOTOR_LEFT_2_ID);
	private WPI_TalonSRX driveM3 = new WPI_TalonSRX(RobotMap.MOTOR_RIGHT_1_ID);
    private WPI_TalonSRX driveM4 = new WPI_TalonSRX(RobotMap.MOTOR_RIGHT_2_ID);
    private VictorSPX flywheel = new VictorSPX(RobotMap.MOTOR_FLYWHEEL_ID);
    private Servo servoMotor = new Servo(RobotMap.SERVO_MOTOR);
    public void defaultVar(){ // Default speed for motor. Hopefully this will start the bot off with a default speed of (0.1)
        flywheel.set(ControlMode.PercentOutput, 0.1);
    }
    
	public void drive(double [] val) {
		driveM1.set(val[0]); // Left L
		driveM2.set(val[0]); // Left R
		driveM3.set(-val[1]); // Right L Values are set to negative since motors are inverted
		driveM4.set(-val[1]); // Right R Values are set to negative since motors are inverted
    }
    
    public void flywheelMotorMax(boolean flyCondition){ // Boolean method for CIM motor on flywheel mech
        if(flyCondition){
            flywheel.set(ControlMode.PercentOutput, -1.0); 
        }else{
            flywheel.set(ControlMode.PercentOutput, 0.0);
        }
    }
    public void flywheelMotorMed(boolean medCondition){
        if(medCondition){
            flywheel.set(ControlMode.PercentOutput, -0.5);
        } else {
            flywheel.set(ControlMode.PercentOutput, 0.0);
        }
    }
    public void servoControl(boolean angle) throws InterruptedException{
        if(angle){ // If the trigger on the joystick is pressed (7), then 'angle' will be true, resulting in the new angle being set to 45 degrees
            servoMotor.setAngle(75); // I am uncertain whether that's the correct angle for the spheres to deploy
            Thread.sleep(2500);
            servoMotor.setAngle(0);
        }
        else{
            servoMotor.setAngle(0); // Default angle of servo is set to 0. 
        }
    }
}