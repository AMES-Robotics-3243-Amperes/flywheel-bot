/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class InputManager {
    Joystick inputOne = new Joystick(0);
    
    double[] var = new double[2];
    boolean getButton =  false;


    public double[] driver(){
        
        var[0] = inputOne.getRawAxis(1);
        var[1] = inputOne.getRawAxis(2);
        return var;
    }
    public boolean pressButton(){
        getButton = inputOne.getRawButton(1);
        return getButton;
    }
}