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
  
  private final Tank_Drive _tank_Drive = new Tank_Drive();
  private final Joystick _joystick = new Joystick(0);
  private final Hopper _hopper = new Hopper();
  private final Intake _intake = new Intake();
  private final Shooter _shooter = new Shooter();
  private final Climber _climber = new Climber();
  private final Hook _hook = new Hook();
  private final Camera _camera = new Camera();
  private final AutonCommand _autonCommand = new AutonCommand();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    _tank_Drive.configDrive();
    _tank_Drive.setDefaultCommand(new ArcadeDrive(_tank_Drive, _joystick));
  }

  public Tank_Drive getTank_Drive(){
    return _tank_Drive;
  }

/**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    final JoystickButton hopperUp = new JoystickButton(_joystick, Constants.JoystickConstants.A);
    hopperUp.whenPressed(new HopperUp(_hopper));

    final JoystickButton hopperDown = new JoystickButton(_joystick, Constants.JoystickConstants.B);
    hopperDown.whenPressed(new HopperDown(_hopper));

    final JoystickButton intakeIn = new JoystickButton(_joystick, Constants.JoystickConstants.X);
    intakeIn.whenPressed(new IntakeIn(_intake));

    final JoystickButton intakeOut = new JoystickButton(_joystick, Constants.JoystickConstants.Y);
    intakeOut.whenPressed(new IntakeOut(_intake));

    final JoystickButton shooterShoot = new JoystickButton(_joystick, Constants.JoystickConstants.BUMPER_LEFT);
    shooterShoot.whenPressed(new ShooterShoot(_shooter));

    final JoystickButton climberDown = new JoystickButton(_joystick, Constants.JoystickConstants.BUMPER_RIGHT);
    climberDown.whenPressed(new ClimberDown(_climber));

    final JoystickButton climberUp = new JoystickButton(_joystick, Constants.JoystickConstants.LOGO_LEFT);
    climberUp.whenPressed(new ClimberUp(_climber));

    final JoystickButton hookUp = new JoystickButton(_joystick, Constants.JoystickConstants.LEFT_STICK_BUTTON);
    hookUp.whenPressed(new HookUp(_hook));

    final JoystickButton hookDown = new JoystickButton(_joystick, Constants.JoystickConstants.RIGHT_STICK_BUTTON);
    hookDown.whenPressed(new HookDown(_hook));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return _autonCommand;
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
  }
}
