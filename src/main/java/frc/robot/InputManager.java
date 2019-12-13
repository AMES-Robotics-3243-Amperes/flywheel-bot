/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
import edu.wpi.first.wpilibj.Joystick;

/**
 * Add your docs here.
 */
public class InputManager {
    
    Joystick inputOne = new Joystick(RobotMap.DRIVER_CONTROLLER);
    private static final double JOY_CURVE_EXP = 3;
    private static final double JOY_DEAD_THRESHOLD = 0.1d;

    /**
     * Curves and deadzones a joystick axis value
     * @param rawValue
     * @return
     */
    private double processJoyst(double rawValue)
    {
        if(Math.abs(rawValue) < JOY_DEAD_THRESHOLD)  //Deadzone of the joystick so if we slightly move it, it won't move the motors
            return 0.0;
        return Math.pow((rawValue-JOY_DEAD_THRESHOLD) / (1-JOY_DEAD_THRESHOLD), JOY_CURVE_EXP);   //Got rid, because Tanh curve has an asymptote at 1 or 100% speed
        //return Math.tanh(rawValue);    //Testing tanh curve
        //return rawValue;
    }

    public double[] throttles(){
        return new double[] {
            - processJoyst(inputOne.getRawAxis(1)), //double[0]
            - processJoyst(inputOne.getRawAxis(3)) //double[2]
         //   - processJoyst(inputOne.getRawAxis(2))  //double[3]
            //double[0] = ySpeed double[1] = xSpeed double[2] = zRotation *for Mecanum Wheels*
        };
    }

    public boolean dampenDrive(){
        return inputOne.getRawButton(5);
    }

    public boolean[] flyWheels(){ // Input method for flywheel motor
        return new boolean[]{
            inputOne.getRawButton(8),
            inputOne.getRawButton(6)
        };
    }
    /*
    public boolean flywheelsMed(){ // Flywheel spins at half speed
        return inputOne.getRawButton(6);
    }
    */
    public boolean servoMotors(){ // Servo input 
        return inputOne.getRawButton(7);    
    }

    public boolean[] encoderMax(){
        return new boolean[]{
            inputOne.getRawButton(1),
            inputOne.getRawButton(2)
        };
    }

    public boolean fireButton() // 12/8/19 - How to bind trigger to servo motor and flywheel CIM
    {
        return inputOne.getRawButton(5)
            || inputOne.getRawButton(6)
            || inputOne.getRawButton(7)
            || inputOne.getRawButton(8);
        // ANY bumper or trigger
    }
}