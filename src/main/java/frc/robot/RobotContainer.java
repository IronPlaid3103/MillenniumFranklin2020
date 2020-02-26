/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
  private final Joystick _driver = new Joystick(0);
  private final Joystick _operator = new Joystick(1);
  private final Hopper _hopper = new Hopper();
  private final Intake _intake = new Intake();
  private final Shooter _shooter = new Shooter();
  private final Climber _climber = new Climber();
  private final Camera _camera = new Camera();
  private final AutonCommand _autonCommand = new AutonCommand();
  private Preferences _preferences = Preferences.getInstance();
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    _tank_Drive.configDrive();
    _tank_Drive.setDefaultCommand(new ArcadeDrive(_tank_Drive, _driver));
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
    final JoystickButton hopperUp = new JoystickButton(_operator, Constants.JoystickConstants.Y);
    hopperUp.whileHeld(new HopperUp(_hopper));

    final JoystickButton hopperDown = new JoystickButton(_operator, Constants.JoystickConstants.A);
    hopperDown.whileHeld(new HopperDown(_hopper));

    final JoystickButton intakeIn = new JoystickButton(_operator, Constants.JoystickConstants.BUMPER_RIGHT);
    intakeIn.whileHeld(new IntakeIn(_intake));

    final JoystickButton intakeOut = new JoystickButton(_operator, Constants.JoystickConstants.BUMPER_LEFT);
    intakeOut.whileHeld(new IntakeOut(_intake));

    final JoystickButton shooterShoot = new JoystickButton(_driver, Constants.JoystickConstants.BUMPER_RIGHT);
    shooterShoot.whileHeld(new ShooterShoot(_shooter));


    new JoystickButton(_operator, Constants.JoystickConstants.B).whileHeld(() -> _climber.climbFast());
    new JoystickButton(_operator, Constants.JoystickConstants.X).whileHeld(() -> _climber.climbSlow());
    new JoystickButton(_operator, Constants.JoystickConstants.LOGO_LEFT).whileHeld(() -> _climber.motorReset());
    //TODO: convert to in line work
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

  public void loadPreferences() {
    double climberPowerFast = _preferences.getDouble("Climber.Power.Fast", Constants.ClimberConstants.defaultPowerFast);
    SmartDashboard.putNumber("Climber Fast", climberPowerFast);
    _climber.setFastPower(climberPowerFast);

    double climberPowerSlow = _preferences.getDouble("Climber.Power.Slow", Constants.ClimberConstants.defaultPowerSlow);
    SmartDashboard.putNumber("Climber Slow", climberPowerSlow);
    _climber.setSlowPower(climberPowerSlow);

    //TODO: Hopper - power
    //TODO: Intake - power
    //TODO: Shooter - RPM
    //TODO: Shooter - kF
    //TODO: Shooter - kP
  }

  public void savePreferences() {
    _preferences.putDouble("Climber.Power.Fast", _climber.getFastPower());
    _preferences.putDouble("Climber.Power.Slow", _climber.getSlowPower());
  }
}
