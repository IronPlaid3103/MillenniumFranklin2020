/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Tank_Drive;

public class DriveForward extends CommandBase {
  /**
   * Creates a new DriveForward.
   */
  private Tank_Drive _tankDrive;
  public DriveForward(Tank_Drive tankDrive) {
    // Use addRequirements() here to declare subsystem dependencies.
    _tankDrive = tankDrive;
    addRequirements(tankDrive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    _tankDrive.autoMoveForward();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double position = _tankDrive.getRightEncoderPosition();
    return (position >= 500);
  }
}
