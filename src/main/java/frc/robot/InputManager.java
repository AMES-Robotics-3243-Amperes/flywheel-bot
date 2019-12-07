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

public class InputManager {
	
	Joystick stickInput = new Joystick(0);
	Double[] stickData = new Double[2];
	
	Double[] getMoveInput() {
		
		stickData[0] = stickInput.getRawAxis(1);
		stickData[1] = stickInput.getRawAxis(3);
		
		return stickData;
	}	
}