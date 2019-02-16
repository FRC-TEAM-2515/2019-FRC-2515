// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2515.ENIGMA.subsystems;


import org.usfirst.frc2515.ENIGMA.Robot;
import org.usfirst.frc2515.ENIGMA.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
    private Solenoid panelSolenoid;
    private Solenoid elevateSolenoidFront;
    private Solenoid elevateSolenoidRear;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public pnuematics() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        compressor1 = new Compressor(10);
        addChild("compressor1",compressor1);
        
        
        armSolenoid = new Solenoid(10, 3);
        addChild("armSolenoid",armSolenoid);
        
        
        panelSolenoid = new Solenoid(10, 7);
        addChild("panelSolenoid",panelSolenoid);
        
        
        elevateSolenoidFront = new Solenoid(10, 2);
        addChild("elevateSolenoidFront",elevateSolenoidFront);
        
        
        elevateSolenoidRear = new Solenoid(10, 1);
        addChild("elevateSolenoidRear",elevateSolenoidRear);
        
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        elevateSolenoidRear.set(false);
        elevateSolenoidFront.set(false);
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
        SmartDashboard.putBoolean("Pressure Switch", compressor1.getPressureSwitchValue());
        SmartDashboard.putNumber("Compressor Current", compressor1.getCompressorCurrent());

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
    public void elevateChassis(){
        // extend both elevator cylinders
        elevateSolenoidRear.set(true);
        elevateSolenoidFront.set(true);
    }
    public void dropChassis(){
        elevateSolenoidRear.set(false);
        elevateSolenoidFront.set(false);
    }
    public void retractFrontElevator(){
        elevateSolenoidFront.set(false);
    }
    public void retractRearElevator(){
        if(!elevateSolenoidFront.get()){
            elevateSolenoidRear.set(false);
        }
    }
    public void extendArm(){
        armSolenoid.set(true);
    }
    
    public void retractArm() {
        if(!Robot.sensors.isCargoCaptured()){
            armSolenoid.set(false);
        }
    }

    public boolean isArmExtended(){
        if(armSolenoid.get()){
            return true;
        }
        return false;
    }
    public void ejectHatchPanel(){
        panelSolenoid.set(true);
        panelSolenoid.set(false);
    }
}

