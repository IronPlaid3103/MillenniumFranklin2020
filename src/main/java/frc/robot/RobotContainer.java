/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  
  private final Tank_Drive m_Tank_Drive = new Tank_Drive();
  private final Joystick m_Joystick = new Joystick(0);
  private final Hopper m_Hopper = new Hopper();
  private final Intake m_Intake = new Intake();
  private final Shooter m_Shooter = new Shooter();

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    
    m_Tank_Drive.setDefaultCommand(new ArcadeDrive(m_Tank_Drive, m_Joystick));
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton HopperUp = new JoystickButton(m_Joystick, 1);
    HopperUp.whenPressed(new HopperUp(m_Hopper));

    JoystickButton HopperDown = new JoystickButton(m_Joystick, 2);
    HopperUp.whenPressed(new HopperDown(m_Hopper));
    
    JoystickButton IntakeIn = new JoystickButton(m_Joystick, 3);
    HopperUp.whenPressed(new IntakeIn(m_Intake));

    JoystickButton IntakeOut = new JoystickButton(m_Joystick, 4);
    HopperUp.whenPressed(new IntakeOut(m_Intake));

    JoystickButton ShooterShoot = new JoystickButton(m_Joystick, 5);
    ShooterShoot.whenPressed(new ShooterShoot(m_Shooter));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
