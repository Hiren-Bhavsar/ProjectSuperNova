package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Driver {

	Joystick driverJoy = new Joystick(0);
	Drivetrain dtrain = new Drivetrain();
	Launchers launch = new Launchers();

	public void driverControls() {
		double rTurn = driverJoy.getRawAxis(3);
		double lTurn = driverJoy.getRawAxis(2);
		double speed = -driverJoy.getRawAxis(1);

		boolean aBut = driverJoy.getRawButton(1);
		boolean yBut = driverJoy.getRawButton(4);
		boolean bBut = driverJoy.getRawButton(2);
		boolean xBut = driverJoy.getRawButton(3);

		int povVal = driverJoy.getPOV();

		if (povVal == 90 && aBut) {
			launch.launchAll();
		}
		if (povVal == 90 && bBut) {
			launch.launcherThree();
		}
		if (povVal == 90 && xBut) {
			launch.launcherOne();
		}
		if (povVal == 90 && yBut) {
			launch.launcherTwo();
		}

		dtrain.arcadeDrive(speed, rTurn, lTurn);
	}

}
