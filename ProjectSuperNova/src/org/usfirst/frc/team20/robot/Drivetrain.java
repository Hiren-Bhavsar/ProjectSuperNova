package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.CANTalon;

public class Drivetrain {

	CANTalon frontLeft = new CANTalon(2);
	CANTalon frontRight = new CANTalon(5);
	CANTalon backLeft = new CANTalon(3);
	CANTalon backRight = new CANTalon(11);

	public void arcadeDrive(double speed, double rTurn, double lTurn) {

		speed /= 2;
		rTurn /= 2;
		lTurn /= 2;

		frontLeft.set(((speed - rTurn + lTurn)));
		backLeft.set(((speed - rTurn + lTurn)));

		frontRight.set(-(speed - lTurn + rTurn));
		backRight.set(-(speed - lTurn + rTurn));
	}

}
