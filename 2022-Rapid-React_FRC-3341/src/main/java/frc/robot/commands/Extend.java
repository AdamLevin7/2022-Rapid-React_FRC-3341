// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
package frc.robot.commands;
 
import java.lang.invoke.ConstantCallSite;
 
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Climber;
 
 
public class Extend extends CommandBase {
  /** Creates a new Extend. */
  private DigitalInput input;
  private Climber climber;
  private int armNum, steps, direction, currPos;
  private boolean currInput;
 
  public Extend(Climber climber, int armNum, int pos) {
    addRequirements(climber);
    this.climber = climber;
    this.armNum = armNum;
    if(armNum == 1) {
      currPos = Constants.ExtendConsts.frontLeftCurrPos;
      input = climber.getInput();
    }else{
      currPos = 0;
      input = climber.getInput();
    }
    /*else if(armNum == 2) currPos = Constants.ExtendConsts.frontRightCurrPos;
    else if(armNum == 3) currPos = Constants.ExtendConsts.rearLeftCurrPos;
    else if(armNum == 4) currPos = Constants.ExtendConsts.rearRightCurrPos;*/
    steps = pos - currPos;
    if(steps > 0) direction = 1;
    else if(steps < 0) direction = -1;
    else direction = 0;
    currInput = input.get();
    
  }
 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
 
  }
 
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(steps != 0){
      if(input.get() != currInput && !input.get()){
        steps -= direction;
        currPos += direction;
      }
      currInput = input.get();
      climber.extend(armNum, .3 * direction);
    }
  }
 
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climber.extend(armNum, 0);
  }
 
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return steps == 0;
  }
}
