// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
package frc.robot;
 
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Rotate;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

 
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private Climber climber;
  private Rotate up;
  private Rotate down;
  private Rotate zero;
  private static Joystick joy;
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
 
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
 
  //private final DriveTrain driveTrain;
 //private final ArcadeDrive arcadeDrive;
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    joy = new Joystick(0);
    climber = new Climber();
    Constants.ExtendConsts.frontLeftCurrPos = 0;
    up = new Rotate(climber, 1, Constants.armAngles.up, joy);
    /*down = new Rotate(climber, 1, Constants.armAngles.down);
    zero = new Rotate(climber, 1, Constants.armAngles.zero);
    climber.setPosition(0);*/
  //  driveTrain = new DriveTrain();
   // arcadeDrive = new ArcadeDrive(driveTrain, joy);
    climber.setDefaultCommand(up);
    //driveTrain.setDefaultCommand(arcadeDrive);
    configureButtonBindings();
  }
 
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    /*JoystickButton zeroButton = new JoystickButton(joy, 3);
    JoystickButton upButton = new JoystickButton(joy, 4);
    JoystickButton downButton = new JoystickButton(joy, 5);
 
    zeroButton.whenPressed(zero);
    upButton.whenPressed(up);
    downButton.whenPressed(down);*/
  }
 public static Joystick returnJoy(){
   return joy;
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
