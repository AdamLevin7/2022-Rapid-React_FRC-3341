// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
package frc.robot.subsystems;
 
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
 
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
 
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
 
public class Climber extends SubsystemBase {
 
  private final WPI_TalonSRX frontLeftRot;
  private final WPI_TalonSRX frontRightRot;
  private final WPI_TalonSRX rearLeftRot;
  private final WPI_TalonSRX rearRightRot;
  private final WPI_TalonSRX frontLeftEx;
  private final WPI_TalonSRX frontRightEx;
  private final WPI_TalonSRX rearLeftEx;
  private final WPI_TalonSRX rearRightEx;
  private final DigitalInput input;

  private boolean currInput;
 
  public Climber() {
    frontLeftRot = new WPI_TalonSRX(Constants.Ports.frontLeftRotPort);
    frontRightRot = new WPI_TalonSRX(Constants.Ports.frontRightRotPort);
    rearLeftRot = new WPI_TalonSRX(Constants.Ports.rearLeftRotPort);
    rearRightRot = new WPI_TalonSRX(Constants.Ports.rearRightRotPort);
    frontLeftEx = new WPI_TalonSRX(Constants.Ports.frontLeftExPort);
    frontRightEx = new WPI_TalonSRX(Constants.Ports.frontRightExPort);
    rearLeftEx = new WPI_TalonSRX(Constants.Ports.rearLeftExPort);
    rearRightEx = new WPI_TalonSRX(Constants.Ports.rearRightExPort);
    
    frontLeftRot.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed);
    frontLeftRot.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed);
 
    frontLeftRot.configFactoryDefault();
    frontLeftRot.setInverted(false);
    frontLeftRot.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
 
   /* frontRightRot.configFactoryDefault();
    frontRightRot.setInverted(false);
    frontRightRot.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
 
    rearLeftRot.configFactoryDefault();
    rearLeftRot.setInverted(false);
    rearLeftRot.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
 
    rearRightRot.configFactoryDefault();
    rearRightRot.setInverted(false);
    rearRightRot.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
 */
    input = new DigitalInput(Constants.DIOPorts.frontLeftRefSensor);
    currInput = input.get();
  }
  public void setPosition(double position){
    frontLeftRot.setSelectedSensorPosition(position);
  }
  public double getAngleFrontLeft(){
    return toRadians(frontLeftRot.getSelectedSensorPosition());
  }
 
  public double getAngleFrontRight(){
    return toRadians(frontRightRot.getSelectedSensorPosition());
  }
 
  public double getAngleRearLeft(){
    return toRadians(rearLeftRot.getSelectedSensorPosition());
  }
 
  public double getAngleRearRight(){
    return toRadians(rearRightRot.getSelectedSensorPosition());
  }
 
  public double toRadians(double motorPos){
    return motorPos * 2 * Math.PI / 4096.0;
  }
 
  public void rotate(int motorNum, double speed){
    if(motorNum == 1) frontLeftRot.set(ControlMode.PercentOutput, speed);
    else if(motorNum == 2) frontRightRot.set(ControlMode.PercentOutput, speed);
    else if(motorNum == 3) rearLeftRot.set(ControlMode.PercentOutput, speed);
    else if(motorNum == 4) rearRightRot.set(ControlMode.PercentOutput, speed);
  }
 
  public void extend(int motorNum, double speed){
    if(motorNum == 1) frontLeftEx.set(ControlMode.PercentOutput, speed);
    else if(motorNum == 2) frontRightEx.set(ControlMode.PercentOutput, speed);
    else if(motorNum == 3) rearLeftEx.set(ControlMode.PercentOutput, speed);
    else if(motorNum == 4) rearRightEx.set(ControlMode.PercentOutput, speed);
  }
 
  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Input Value", input.get());
    if(input.get() != currInput && !input.get()){
      Constants.ExtendConsts.frontLeftCurrPos += 1;
    }
    currInput = input.get();
    SmartDashboard.putNumber("Front Left Extension", Constants.ExtendConsts.frontLeftCurrPos);
    SmartDashboard.putNumber("Front Left Rotation", getAngleFrontLeft());
    rotate(1, RobotContainer.returnJoy().getY());
    /*SmartDashboard.putNumber("Front Right Extension", Constants.ExtendConsts.frontRightCurrPos);
    SmartDashboard.putNumber("Rear Left Extension", Constants.ExtendConsts.rearLeftCurrPos);
    SmartDashboard.putNumber("Rear Right Extension", Constants.ExtendConsts.rearRightCurrPos);
    SmartDashboard.putNumber("Front Right Rotation", getAngleFrontRight());
    SmartDashboard.putNumber("Rear Left Rotation", getAngleRearLeft());
    SmartDashboard.putNumber("Rear Right Rotation", getAngleRearRight());*/
  }
}
