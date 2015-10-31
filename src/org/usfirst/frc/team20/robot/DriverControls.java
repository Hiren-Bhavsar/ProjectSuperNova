package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;

public class DriverControls {
	private CANTalon frontLeft = new CANTalon(2);
	private CANTalon frontRight = new CANTalon(5);
	private CANTalon backLeft = new CANTalon(3);
	private CANTalon backRight = new CANTalon(11);
	private Joystick joy = new Joystick(0);
	private PneumaticControl pneu = new PneumaticControl();
	private Timer time = new Timer();

	public void controlLaunchers() {
		controlDriveTrain();

		if (joy.getPOV() == 90 && joy.getRawButton(3)) {
			pneu.fireLauncherOne();
		} else if (joy.getPOV() == 90 && joy.getRawButton(4)) {
			pneu.fireLauncherTwo();
		} else if (joy.getPOV() == 90 && joy.getRawButton(2)) {
			pneu.fireLauncherThree();
		} else if (joy.getPOV() == 90 && joy.getRawButton(1)) {
			pneu.fireAll();
		} else {
			pneu.closeRelays();
		}

		if (joy.getRawButton(7) && joy.getRawButton(8)) {
			time.reset();
			time.start();
			while (time.get() < 5) {
				pneu.fillTanks();
				controlDriveTrain();
			}
			time.stop();
		}
	}

	public void controlDriveTrain() {
		double rTurn = joy.getRawAxis(3);
		double lTurn = joy.getRawAxis(2);
		double speed = -joy.getRawAxis(1);

		frontLeft.set(-((speed - rTurn + lTurn)));
		backLeft.set(-((speed - rTurn + lTurn)));

		frontRight.set((speed - lTurn + rTurn));
		backRight.set((speed - lTurn + rTurn));
	}
}
