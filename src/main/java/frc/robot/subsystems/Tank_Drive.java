/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;

public class Tank_Drive extends SubsystemBase {
  public Tank_Drive() {

  }

  /**
   * Creates a new Tank_Drive.
   */
  private final CANSparkMax flDrive = new CANSparkMax(DriveConstants.flDrive, MotorType.kBrushless);
  private final CANSparkMax frDrive = new CANSparkMax(DriveConstants.frDrive, MotorType.kBrushless);
  private final CANSparkMax blDrive = new CANSparkMax(DriveConstants.blDrive, MotorType.kBrushless);
  private final CANSparkMax brDrive = new CANSparkMax(DriveConstants.brDrive, MotorType.kBrushless);

  private final DifferentialDrive _drive = new DifferentialDrive(flDrive, frDrive);

  private CANEncoder _encoderLeft = flDrive.getEncoder();
  private CANEncoder _encoderRight = frDrive.getEncoder();

  public void configDrive() {
    blDrive.follow(flDrive);
    brDrive.follow(frDrive);

    flDrive.setInverted(false);
    frDrive.setInverted(false);
    blDrive.setInverted(false);
    brDrive.setInverted(false);

    flDrive.setOpenLoopRampRate(0.5);
    frDrive.setOpenLoopRampRate(0.5);
    blDrive.setOpenLoopRampRate(0.5);
    brDrive.setOpenLoopRampRate(0.5);
    // _encoderLeft.setPositionConversionFactor(25);
    _encoderLeft.setPosition(0);

    // _encoderRight.setPositionConversionFactor(25);
    _encoderRight.setPosition(0);
  }

  public void teleopDrive(final Joystick driveControl) {
    final double forward = driveControl.getRawAxis(JoystickConstants.LEFT_STICK_Y);
    final double turn = driveControl.getRawAxis(JoystickConstants.RIGHT_STICK_X);

    // _drive.arcadeDrive(forward, turn);
    _drive.curvatureDrive(forward, turn, Math.abs(forward)<= .02); //reccomended instead of arcade drive to make turns wider
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("position L", _encoderLeft.getPosition());
    SmartDashboard.putNumber("position R", _encoderRight.getPosition());
  }

  public void limelightDrive(final Joystick driver, final double output) {
    final double forward = driver.getRawAxis(1);
    _drive.arcadeDrive(-forward, output);
  }

  public double getLeftEncoderPosition() {
    return _encoderLeft.getPosition();
  }

  public double getRightEncoderPosition() {
    return _encoderRight.getPosition();
  }

  public void autoMoveForward() {
    _drive.arcadeDrive(-0.25, 0);
  }
}
