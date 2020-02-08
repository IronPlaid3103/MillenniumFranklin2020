/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hopper extends SubsystemBase {
  /**
   * Creates a new Hopper.
   */
  private final WPI_TalonSRX Hopper = new WPI_TalonSRX(7); // 7 is port number
  DigitalInput lineBreak = new DigitalInput(Constants.HopperConstants.lineBreak);
  int counter = 0;
  boolean lastState = false;

  public Hopper() {
    
  }


  public void countBalls(){
    boolean sensorState = lineBreak.get();
    if (!sensorState && lastState) {
      counter ++;
    }
    SmartDashboard.putNumber("Amount of Balls", counter);
    lastState = sensorState;
  }

  public void HopperUp() {
    Hopper.set(ControlMode.PercentOutput, 0.5);
  }

  public void HopperDown(){
    Hopper.set(ControlMode.PercentOutput, -0.5);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
