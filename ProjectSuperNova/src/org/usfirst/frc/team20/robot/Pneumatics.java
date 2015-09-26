package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.Relay;

public class Pneumatics {
	//TODO Update Relay Port Values!
	Relay relayOne = new Relay(0);
	Relay relayTwo = new Relay(0);

	public void launcherOne() {
	}

	public void launcherTwo() {
	}

	public void launcherThree() {
	}

	public void launchAll() {
		launcherOne();
		launcherTwo();
		launcherThree();
	}
}