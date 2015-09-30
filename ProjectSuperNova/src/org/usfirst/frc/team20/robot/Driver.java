package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Driver {

	Joystick driverJoy = new Joystick(0);
	Drivetrain dtrain = new Drivetrain();
	Pneumatics pneu = new Pneumatics();

	public void driverControls() {
		double rTurn = driverJoy.getRawAxis(3);
		double lTurn = driverJoy.getRawAxis(2);
		double speed = -driverJoy.getRawAxis(1);

		if (driverJoy.getPOV() == 90 && driverJoy.getRawButton(3)) {
		}
		if (driverJoy.getPOV() == 90 && driverJoy.getRawButton(4)) {
		}
		if (driverJoy.getPOV() == 90 && driverJoy.getRawButton(2)) {
		}
		if (driverJoy.getPOV() == 90 && driverJoy.getRawButton(1)) {
		}

		dtrain.arcadeDrive(speed, rTurn, lTurn);
	}

}
