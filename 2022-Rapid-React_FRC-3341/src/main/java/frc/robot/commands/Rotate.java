// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
package frc.robot.commands;
 
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Climber;
 
public class Rotate extends CommandBase {
  /** Creates a new Rotate. */
  //ArmFeedforward arm = new ArmFeedforward(Constants.charConsts.ks, Constants.charConsts.kcos, Constants.charConsts.kv);
  private Climber climber;
  private Joystick joy;
  private int armNum;
 
  public Rotate(Climber climber, Joystick joy, int armNum) {
    this.climber = climber;
    this.joy = joy;
    this.armNum = armNum;
    addRequirements(climber);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }
 
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    climber.rotate(armNum, 0.2*joy.getX());
    SmartDashboard.putNumber("Joy X", 0.2*joy.getX());
  }
 
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}
 
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
 
