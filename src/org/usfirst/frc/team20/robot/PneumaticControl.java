package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;

public class PneumaticControl {
	private DoubleSolenoid oneDS = new DoubleSolenoid(0, 1);
	private DoubleSolenoid twoDS = new DoubleSolenoid(2, 7);
	private DoubleSolenoid threeDS = new DoubleSolenoid(4, 5);
	private Relay oneR = new Relay(2);
	private Relay twoR = new Relay(0);
	private Timer fireTime = new Timer();

	public void fireLauncherOne() {
		oneR.set(Relay.Value.kForward);
	}

	public void fireLauncherTwo() {
		oneR.set(Relay.Value.kReverse);
	}

	public void fireLauncherThree() {
		twoR.set(Relay.Value.kOn);
	}

	public void fireAll() {
		oneR.set(Relay.Value.kOn);
		fireLauncherThree();
	}

	public void closeRelays() {
		oneR.set(Relay.Value.kOff);
		twoR.set(Relay.Value.kOff);
	}

	public void fillTanks() {
		oneDS.set(DoubleSolenoid.Value.kForward);
		twoDS.set(DoubleSolenoid.Value.kForward);
		threeDS.set(DoubleSolenoid.Value.kForward);
	}

	public void closeDS() {
		oneDS.set(DoubleSolenoid.Value.kReverse);
		twoDS.set(DoubleSolenoid.Value.kReverse);
		threeDS.set(DoubleSolenoid.Value.kReverse);
	}
}
