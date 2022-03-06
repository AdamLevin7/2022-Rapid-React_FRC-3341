// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Climber;

public class PIDRotate extends CommandBase {
  /** Creates a new PIDRotate. */
  PIDController pid = new PIDController(Constants.pidConsts.pidP, Constants.pidConsts.pidI, Constants.pidConsts.pidD);
  private Climber climber;
  private int armNum;
  private double angle;
  
  public PIDRotate(Climber climber, int armNum, double angle) {
    this.climber = climber;
    this.armNum = armNum;
    this.angle = angle;
    addRequirements(climber);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pid.setSetpoint(angle);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double climberAngle = 0;
    if(armNum == 1) climberAngle = climber.getAngleFrontLeft();
    /*else if (armNum == 2) climberAngle = climber.getAngleFrontRight();
    else if (armNum == 3) climberAngle = climber.getAngleRearLeft();
    else if (armNum == 4) climberAngle = climber.getAngleRearRight();*/
    double direction = 0;
    if(angle > climberAngle) direction = 1;
    else direction = -1;
    climber.rotate(armNum, direction * 0.1);
    //climber.rotate(armNum, pid.calculate(climberAngle));
    SmartDashboard.putNumber("error", Math.abs(climberAngle - angle));
    SmartDashboard.putNumber("power", pid.calculate(climberAngle));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climber.rotate(armNum, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double climberAngle = 0;
    if(armNum == 1) climberAngle = climber.getAngleFrontLeft();
    /*else if (armNum == 2) climberAngle = climber.getAngleFrontRight();
    else if (armNum == 3) climberAngle = climber.getAngleRearLeft();
    else if (armNum == 4) climberAngle = climber.getAngleRearRight();*/
    return Math.abs(climberAngle - angle) <= 2;
  }
}
