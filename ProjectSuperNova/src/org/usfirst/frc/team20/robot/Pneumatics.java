package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;

public class Pneumatics {

	Driver driver = new Driver();

	// TODO Update Relay Port Values!
	Relay relayOne = new Relay(0);
	Relay relayTwo = new Relay(0);

	Timer fireTime = new Timer();

	// TODO Update Double Solenoid Port Values!
	DoubleSolenoid solOne = new DoubleSolenoid(0, 0);
	DoubleSolenoid solTwo = new DoubleSolenoid(0, 0);

	public boolean barrelOne, barrelTwo, barrelThree = false;

	// Launcher Controls - Uses Spike Relays TODO Figure Out How To Cut Time
	public void fireLauncherOne() {
		fireTime.start();
		relayOne.set(Relay.Value.kForward);
		if (fireTime.hasPeriodPassed(.0005)) {
			relayOne.set(Relay.Value.kOff);
		}
		barrelOne = true;

	}

	public void fireLauncherTwo() {
		fireTime.start();
		relayOne.set(Relay.Value.kReverse);
		if (fireTime.get()>.0005) {
			relayOne.set(Relay.Value.kOff);
		}
		barrelTwo = true;
	}

	public void fireLauncherThree() {
		fireTime.start();
		relayTwo.set(Relay.Value.kForward);
		if (fireTime.hasPeriodPassed(.5)) {
			relayTwo.set(Relay.Value.kOff);
		}
		barrelThree = true;
	}

	public void burstAll() {
		fireTime.start();
		relayOne.set(Relay.Value.kOn);
		relayTwo.set(Relay.Value.kForward);
		if (fireTime.hasPeriodPassed(.0005)) {
			relayOne.set(Relay.Value.kOff);
			relayTwo.set(Relay.Value.kOff);
		}
		barrelOne = true;
		barrelTwo = true;
		barrelThree = true;
	}

	public void arcAll() {
		fireTime.start();
		relayOne.set(Relay.Value.kOn);
		if (fireTime.hasPeriodPassed(.0005)) {
			relayOne.set(Relay.Value.kReverse);
		}
		if (fireTime.hasPeriodPassed(.0005)) {
			relayTwo.set(Relay.Value.kForward);
			relayOne.set(Relay.Value.kOff);
		}
		if (fireTime.hasPeriodPassed(.0005)) {
			relayOne.set(Relay.Value.kOff);
			relayTwo.set(Relay.Value.kOff);
		}
		barrelOne = true;
		barrelTwo = true;
		barrelThree = true;
	}

	public void closeAll() {
		relayOne.set(Relay.Value.kOff);
		relayTwo.set(Relay.Value.kOff);
	}

	// Refill Control - Uses Double Solenoids
	public void refillTanks() {
		relayOne.set(Relay.Value.kOff);
		relayTwo.set(Relay.Value.kOff);

		// TODO Update The Times
		if (Robot.refillTime.get() <= 2) {
			if (barrelOne) {
				solOne.set(DoubleSolenoid.Value.kForward);
				if (barrelTwo && !barrelOne) {
					solOne.set(DoubleSolenoid.Value.kReverse);
				}
				if (barrelThree) {
					solTwo.set(DoubleSolenoid.Value.kForward);
				}
			}
			if (Robot.refillTime.get() <= 4) {
				if (barrelTwo && barrelOne) {
					solOne.set(DoubleSolenoid.Value.kReverse);
				} else {
					solOne.set(DoubleSolenoid.Value.kOff);
					solTwo.set(DoubleSolenoid.Value.kOff);
					barrelOne = false;
					barrelTwo = false;
					barrelThree = false;
					Robot.refillTime.stop();
				}

				solTwo.set(DoubleSolenoid.Value.kOff);
			}
			if (Robot.refillTime.get() > 4) {
				solOne.set(DoubleSolenoid.Value.kOff);
				solTwo.set(DoubleSolenoid.Value.kOff);
				barrelOne = false;
				barrelTwo = false;
				barrelThree = false;
				Robot.refillTime.stop();
			}

		}
	}
}