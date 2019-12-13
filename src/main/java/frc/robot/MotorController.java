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
    private static final double maxDriveSpeed = 0.5d;
    private static final double minDriveSpeed = 0.2d;

    // MotorController Instance Variables //
    public int delayTimer = 1;

    //                 -                  //
	private WPI_TalonSRX driveM1 = new WPI_TalonSRX(RobotMap.MOTOR_LEFT_1_ID);
    private WPI_TalonSRX driveM2 = new WPI_TalonSRX(RobotMap.MOTOR_LEFT_2_ID);
	private WPI_TalonSRX driveM3 = new WPI_TalonSRX(RobotMap.MOTOR_RIGHT_1_ID);
    private WPI_TalonSRX driveM4 = new WPI_TalonSRX(RobotMap.MOTOR_RIGHT_2_ID);
    private VictorSPX flywheel = new VictorSPX(RobotMap.MOTOR_FLYWHEEL_ID);
    private Servo servoMotor = new Servo(RobotMap.SERVO_MOTOR);
 //   public void defaultVar(){ // Default speed for motor. Hopefully this will start the bot off with a default speed of (0.1)
  //      flywheel.set(ControlMode.PercentOutput, 0.1);
  //  }
    
	public void drive(double [] val, boolean slow) {
        if(!slow){
            driveM1.set(val[0] * maxDriveSpeed); // Left L
	    	driveM2.set(val[0] * maxDriveSpeed); // Left R
	    	driveM3.set(-val[1] * maxDriveSpeed); // Right L Values are set to negative since motors are inverted
		    driveM4.set(-val[1] * maxDriveSpeed); // Right R Values are set to negative since motors are inverted
        } else if(slow){
            driveM1.set(val[0] * minDriveSpeed); // Left L
	    	driveM2.set(val[0] * minDriveSpeed); // Left R
	    	driveM3.set(-val[1] * minDriveSpeed); // Right L Values are set to negative since motors are inverted
		    driveM4.set(-val[1] * minDriveSpeed); // Right R Values are set to negative since motors are inverted
        }
    }
    
    public void flywheelMotor(boolean [] flyCondition){ // Boolean method for CIM motor on flywheel mech
        System.out.println(flyCondition);
        if(flyCondition[0]){
            flywheel.set(ControlMode.PercentOutput, -0.95); 
        }else if (flyCondition[1]){
            flywheel.set(ControlMode.PercentOutput, -0.5);
        } else {
            flywheel.set(ControlMode.PercentOutput, 0.0);
        }
    }
    /*
    public void flywheelMotorMed(boolean flywheelMed){
        if(flywheelMed){
            flywheel.set(ControlMode.PercentOutput, -0.5);
        } else {
            flywheel.set(ControlMode.PercentOutput, 0.0);
        }
    }
    */
    private final double loAngle = 220;
    public void servoControl(boolean angle) {

        if(angle){ // If the trigger on the joystick is pressed (7), then 'angle' will be true, resulting in the new angle being set to 45 degrees
            servoMotor.setAngle(170); // I am uncertain whether that's the correct angle for the spheres to deploy
            try{
            for(int i = 0; i < delayTimer; i++){
                Thread.sleep(750);  //milliseconds
            }
            servoMotor.setAngle(loAngle);
        } catch (InterruptedException ie){
            Thread.currentThread().interrupt();
        }
    }
        else{
            servoMotor.setAngle(107); // Default angle of servo is set to 0. 
        }
    }

    /** Called once each autonomousPeriodic or teleopPeriodic step */
    public void enabledPeriodic()
    {
        // TODO: this can be used for continuous servo management
        // See also: 
    }
}