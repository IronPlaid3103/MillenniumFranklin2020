/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hook extends SubsystemBase {
  /**
   * Creates a new Hook.
   */
  private TalonSRX hookLeft = new TalonSRX(Constants.ClimberConstants.hookLeft);
  private TalonSRX hookRight = new TalonSRX(Constants.ClimberConstants.hookRight);

  public Hook() {

  }

  public void hookUp() {
    hookLeft.set(ControlMode.PercentOutput, 0.5);
    hookRight.set(ControlMode.PercentOutput, 0.5);
  }

  public void hookDown() {
    hookLeft.set(ControlMode.PercentOutput, -0.5);
    hookRight.set(ControlMode.PercentOutput, -0.5);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
