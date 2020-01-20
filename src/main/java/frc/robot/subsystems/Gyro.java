/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Gyro extends SubsystemBase {
  private myGyro gyro;

  /**
   * Creates a new Gyro.
   */
  public Gyro() {
    gyro = new myGyro(1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
