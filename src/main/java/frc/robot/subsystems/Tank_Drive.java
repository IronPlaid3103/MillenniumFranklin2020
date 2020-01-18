/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.*;
import frc.robot.Constants;

public class Tank_Drive extends SubsystemBase {
  public Tank_Drive(){
  
  }
  /**
   * Creates a new Tank_Drive.
   */
    final WPI_TalonSRX flDrive = new WPI_TalonSRX(Constants.flDrive);
    final WPI_TalonSRX frDrive = new WPI_TalonSRX(Constants.frDrive);
    final WPI_TalonSRX blDrive = new WPI_TalonSRX(Constants.blDrive);
    final WPI_TalonSRX brDrive = new WPI_TalonSRX(Constants.brDrive);

    final DifferentialDrive _drive = new DifferentialDrive(flDrive, frDrive);

    public void configDrive(){

      blDrive.follow(flDrive);
      brDrive.follow(frDrive);

      flDrive.setInverted(false);
      frDrive.setInverted(false);
      blDrive.setInverted(false);
      brDrive.setInverted(false);

    }

    public void teleopDrive(Joystick driveControl) {
      double forward = driveControl.getRawAxis(1);
      double turn = driveControl.getRawAxis(4);

      _drive.arcadeDrive(forward, turn);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
 
  }
}
