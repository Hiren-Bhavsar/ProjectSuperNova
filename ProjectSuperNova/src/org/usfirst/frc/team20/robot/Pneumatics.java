package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;

public class Pneumatics {

	Relay relayOne = new Relay(2);
	Relay relayTwo = new Relay(0);

	DoubleSolenoid solOne = new DoubleSolenoid(0, 1);
	DoubleSolenoid solTwo = new DoubleSolenoid(2, 7);

	Timer fireTime = new Timer();

	public boolean barrelOne, barrelTwo, barrelThree = false;

	public void fireLauncherOne() {
		fireTime.reset();
		fireTime.start();
		if (fireTime.get() < .0005) {
			relayOne.set(Relay.Value.kForward);
		}
		relayOne.set(Relay.Value.kOff);
		fireTime.stop();

		barrelOne = true;
	}

	public void fireLauncherTwo() {
		fireTime.reset();
		fireTime.start();
		if (fireTime.get() < .0005) {
			relayOne.set(Relay.Value.kReverse);
		}
		relayOne.set(Relay.Value.kOff);
		fireTime.stop();

		barrelTwo = true;
	}

	public void fireLauncherThree() {
		fireTime.reset();
		fireTime.start();
		if (fireTime.get() < .0005) {
			relayTwo.set(Relay.Value.kForward);
		}
		relayTwo.set(Relay.Value.kOff);
		fireTime.stop();

		barrelThree = true;
	}

	public void burstAll() {
		fireTime.reset();
		fireTime.start();
		if (fireTime.get() < .0005) {
			relayOne.set(Relay.Value.kOn);
			relayTwo.set(Relay.Value.kOn);
		}
		relayOne.set(Relay.Value.kOff);
		relayTwo.set(Relay.Value.kOff);
		fireTime.stop();

		barrelOne = true;
		barrelTwo = true;
		barrelThree = true;
	}

	public void arcAll() {
		fireTime.reset();
		fireTime.start();
		if (fireTime.get() < .0010) {
			relayOne.set(Relay.Value.kForward);
		}
		if (fireTime.get() > .0010 && fireTime.get() < .0020) {
			relayOne.set(Relay.Value.kReverse);
		}
		if (fireTime.get() > .0020 && fireTime.get() < .0030) {
			relayOne.set(Relay.Value.kOff);
			relayTwo.set(Relay.Value.kForward);
		}
		relayOne.set(Relay.Value.kOff);
		relayTwo.set(Relay.Value.kOff);
		fireTime.stop();

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
		fireTime.reset();
		fireTime.start();
		while (fireTime.get() < 5.1) {
			if (fireTime.get() < 2.5) {
				solOne.set(DoubleSolenoid.Value.kForward);
				solTwo.set(DoubleSolenoid.Value.kForward);
			}
			if (fireTime.get() > 2.5 && fireTime.get() < 5) {
				solOne.set(DoubleSolenoid.Value.kReverse);
				solTwo.set(DoubleSolenoid.Value.kOff);
			}
			if (fireTime.get() > 5) {
				solOne.set(DoubleSolenoid.Value.kOff);
				solTwo.set(DoubleSolenoid.Value.kOff);
			}
		}
		solOne.set(DoubleSolenoid.Value.kOff);
		solTwo.set(DoubleSolenoid.Value.kOff);
		fireTime.stop();
	}
}