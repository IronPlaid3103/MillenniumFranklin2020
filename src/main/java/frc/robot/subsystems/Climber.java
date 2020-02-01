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

public class Climber extends SubsystemBase {
  /**
   * Creates a new Climber.
   */
  private TalonSRX winchLeft = new TalonSRX(Constants.ClimberConstants.winchLeft);
  private TalonSRX winchRight = new TalonSRX(Constants.ClimberConstants.winchRight);
  public Climber() {

  }

  public void follow(){
    //if want to follow put in here
  }

  public void ClimberDown(){
    winchLeft.set(ControlMode.PercentOutput, -0.5);
    winchRight.set(ControlMode.PercentOutput, -0.5);
  }

  public void ClimberUp(){
    winchLeft.set(ControlMode.PercentOutput, 0.5);
    winchRight.set(ControlMode.PercentOutput, 0.5);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
