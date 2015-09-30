
package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Relay;

public class Robot extends IterativeRobot {

	public void robotInit() {
	}

	public void autonomousPeriodic() {

	}

	public void disabledPeridoic() {
		Pneumatics pneu = new Pneumatics();
		pneu.relayOne.set(Relay.Value.kOff);
		pneu.relayTwo.set(Relay.Value.kOff);
		pneu.solOne.set(DoubleSolenoid.Value.kOff);
		pneu.solTwo.set(DoubleSolenoid.Value.kOff);

	}

	public void teleopPeriodic() {
		Driver driver = new Driver();
		driver.driverControls();

	}

	public void testPeriodic() {

	}

}
