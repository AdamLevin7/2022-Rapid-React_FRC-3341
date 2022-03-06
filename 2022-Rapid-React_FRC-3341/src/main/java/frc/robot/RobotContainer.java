// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
package frc.robot;
 
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Extend;
import frc.robot.commands.PIDRotate;
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
  //private Climber climber;
  private Rotate teleOpFrontLeft;
  private Rotate teleOpFrontRight;
  private Rotate teleOpRearLeft;
  private Rotate teleOpRearRight;

  /*private PIDRotate up; 
  private PIDRotate down;
  private PIDRotate zero;
  private Extend Ex0; 
  private Extend Ex1;
  private Extend Ex2;
  private Extend Ex3;
  private Extend Ex4;*/
  private static Joystick joy;
  private static int armNum;
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
 
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final Climber climber = new Climber();
 
  //private final DriveTrain driveTrain;
 //private final ArcadeDrive arcadeDrive;
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    joy = new Joystick(0);
    //climber = new Climber();
    Constants.ExtendConsts.frontLeftCurrPos = 0;
    teleOpFrontLeft = new Rotate(climber, joy, 1);
    teleOpFrontRight = new Rotate(climber, joy, 2);
    teleOpRearLeft = new Rotate(climber, joy, 3);
    teleOpRearRight = new Rotate(climber, joy, 4);
    
    /*up = new PIDRotate(climber, 1, Constants.armAngles.up);
    down = new PIDRotate(climber, 1, Constants.armAngles.down);
    zero = new PIDRotate(climber, 1, Constants.armAngles.zero);
    Ex0 = new Extend(climber, 1, 0);
    Ex1 = new Extend(climber, 1, 1);
    Ex2 = new Extend(climber, 1, 2);
    Ex3 = new Extend(climber, 1, 3);
    Ex4 = new Extend(climber, 1, 4);*/
    climber.setPosition(0);
  //  driveTrain = new DriveTrain();
   // arcadeDrive = new ArcadeDrive(driveTrain, joy);
    climber.setDefaultCommand(teleOpFrontLeft);
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
    JoystickButton frontLeft = new JoystickButton(joy, 5);
    JoystickButton frontRight = new JoystickButton(joy, 6);
    JoystickButton rearLeft = new JoystickButton(joy, 3);
    JoystickButton rearRight = new JoystickButton(joy, 4);

    frontLeft.whenPressed(teleOpFrontLeft);
    frontRight.whenPressed(teleOpFrontRight);
    rearLeft.whenPressed(teleOpRearLeft);
    rearRight.whenPressed(teleOpRearRight);

    if(frontLeft.get()) climber.setArmNum(1);
    else if(frontRight.get()) climber.setArmNum(2);
    else if(rearLeft.get()) climber.setArmNum(3);
    else if(rearRight.get()) climber.setArmNum(4);

    /*JoystickButton zeroButton = new JoystickButton(joy, 3);
    JoystickButton upButton = new JoystickButton(joy, 4);
    JoystickButton downButton = new JoystickButton(joy, 5);

    JoystickButton Ex0Button = new JoystickButton(joy, 7);
    JoystickButton Ex1Button = new JoystickButton(joy, 8);
    JoystickButton Ex2Button = new JoystickButton(joy, 9);
    JoystickButton Ex3Button = new JoystickButton(joy, 10);
    JoystickButton Ex4Button = new JoystickButton(joy, 11);
 
    zeroButton.whenPressed(zero, false);
    upButton.whenPressed(up, false);
    downButton.whenPressed(down, false);

    Ex0Button.whenPressed(Ex0, false);
    Ex1Button.whenPressed(Ex1, false);
    Ex2Button.whenPressed(Ex2, false);
    Ex3Button.whenPressed(Ex3, false);
    Ex4Button.whenPressed(Ex4, false);

    zeroButton.whenReleased(teleOp);
    upButton.whenReleased(teleOp);
    downButton.whenReleased(teleOp);

    Ex0Button.whenReleased(teleOp);
    Ex1Button.whenReleased(teleOp);
    Ex2Button.whenReleased(teleOp);
    Ex3Button.whenReleased(teleOp);
    Ex4Button.whenReleased(teleOp);*/
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
