// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2515.ENIGMA_V2.subsystems;


import org.usfirst.frc2515.ENIGMA_V2.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class pnuematics extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private Compressor compressor1;
    private Solenoid armSolenoid;
    private Solenoid elevatorRearSolenoid;
    private Solenoid elevatorFrontSolenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public pnuematics() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        compressor1 = new Compressor(10);
        addChild("compressor1",compressor1);
        
        
        armSolenoid = new Solenoid(10, 3);
        addChild("armSolenoid",armSolenoid);
        
        
        elevatorRearSolenoid = new Solenoid(10, 1);
        addChild("elevatorRearSolenoid",elevatorRearSolenoid);
        
        
        elevatorFrontSolenoid = new Solenoid(10, 2);
        addChild("elevatorFrontSolenoid",elevatorFrontSolenoid);
        
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        // startCompressor();
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void startCompressor(){
        compressor1.enabled();
        compressor1.setClosedLoopControl(true);
        compressor1.start();

    }
    public void stopCompressor(){
        compressor1.stop();
    }
    public void extendArm(){
        armSolenoid.set(true);
    }
    public void retractArm(){
        armSolenoid.set(false);
    }
    public boolean getArmPosition(){
        return armSolenoid.get();
    }
    public void liftChassis(){
        elevatorFrontSolenoid.set(true);
        elevatorRearSolenoid.set(true);
    }
    public void raiseFront(){
        elevatorFrontSolenoid.set(false);
    }
    public void raiseBack(){
        if(!elevatorFrontSolenoid.get()){
            elevatorRearSolenoid.set(false);
        }
    }
    public void lowerChassis(){
        elevatorFrontSolenoid.set(false);
        elevatorRearSolenoid.set(false);
    }
    public boolean isChassisElevated(){
        if(elevatorFrontSolenoid.get() && elevatorRearSolenoid.get()){
            return true;
        }
        return false;
    }
}

