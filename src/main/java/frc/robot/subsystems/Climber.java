/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  /**
   * Creates a new Climber.
   */
  private CANSparkMax winchLeft = new CANSparkMax(Constants.ClimberConstants.winchLeft, MotorType.kBrushless);
  private CANSparkMax winchRight = new CANSparkMax(Constants.ClimberConstants.winchRight, MotorType.kBrushless);

  public Climber() {

  }

  public void follow() {
    // if want to follow put in here
  }

  public void climberDown() {
    winchLeft.set(Constants.ClimberConstants.winchPower);
    winchRight.set(Constants.ClimberConstants.winchPower);
  }

  public void climberUp() {
    winchLeft.set(Constants.ClimberConstants.winchPower);
    winchRight.set(Constants.ClimberConstants.winchPower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
