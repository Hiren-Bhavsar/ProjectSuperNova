package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;

public class Pneumatics {
	// TODO Update Relay Port Values!
	Relay relayOne = new Relay(0);
	Relay relayTwo = new Relay(0);

	// TODO Update Double Solenoid Port Values!
	DoubleSolenoid solOne = new DoubleSolenoid(0, 0);
	DoubleSolenoid solTwo = new DoubleSolenoid(0, 0);

	boolean barrelOne, barrelTwo, barrelThree = false;
	
	Timer time = new Timer();
	
	// Launcher Controls - Uses Spike Relays
	public void fireLauncherOne() {
		barrelOne = true;
	}

	public void fireLauncherTwo() {
		barrelTwo = true;
	}

	public void fireLauncherThree() {
		barrelThree = true;
	}

	public void launchAll() {
		barrelOne = true;
		barrelTwo = true;
		barrelThree = true;
	}
	
	
	//Refill Control - Uses Double Solenoids
	public void refillTanks(){
		if(barrelOne&&barrelTwo&&barrelThree){
			time.start();
			//TODO Update Refill Time
			
		}
	} 
}