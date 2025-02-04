package frc.robot.commands;
 
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
 
public class ArcadeDrive extends CommandBase {
 
  private final DriveTrain _driveTrain;
  private final Joystick _joystick;
   
  /** Creates a new TankDrive. */
  public ArcadeDrive(DriveTrain dt, Joystick j) {
    // Use addRequirements() here to declare subsystem dependencies.
    _driveTrain = dt;
    _joystick = j;
 
    addRequirements(_driveTrain); 
  }
 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
 
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    _driveTrain.arcadeDrive(-0.5 * _joystick.getRawAxis(1),
                             0.5*_joystick.getRawAxis(0));
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