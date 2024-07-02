package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class Scoring extends Command{
    private Intake m_intake;
    private double IntakePower;

    private Shooter m_shooter;
    private double ShooterPower;

    private boolean isFinished;

    private double pretime;
    private double nowtime;

    public Scoring(Intake Intake, double IntakePower, Shooter Shooter, double ShooterPower){
        m_intake = Intake;
        this.IntakePower = IntakePower;

        m_shooter = Shooter;
        this.ShooterPower = ShooterPower;

        addRequirements(Intake);
        addRequirements(Shooter);
    }

    /**
     * Called when the command is initially scheduled.
     * Sets the RPM of the motors if the IntakeShooter is in the correct state.
     */
    @Override
    public void initialize(){

    }

    /**
     * Called every time the scheduler runs while the command is scheduled.
     * Checks if the motors are at their target RPM and either finishes the command or resets the timer.
     */
    @Override
    public void execute(){
        pretime = Timer.getFPGATimestamp();
        nowtime = Timer.getFPGATimestamp();
        while(nowtime - pretime < 1.0){
            m_shooter.setShooterPower(ShooterPower);
            m_intake.stopAllIntakeMotors();
            nowtime = Timer.getFPGATimestamp();
        }
        while (nowtime - pretime > 1.0 && nowtime - pretime < 2.0) {
            m_shooter.setShooterPower(ShooterPower);
            m_intake.setIntakePower(IntakePower);
            nowtime = Timer.getFPGATimestamp();
        }
        while (nowtime - pretime > 2.0) {
            m_shooter.stopAllShooterMotors();
            m_intake.stopAllIntakeMotors();
            nowtime = Timer.getFPGATimestamp();
            break;
        }
    }

    public boolean isFinished(){
        return isFinished;
    }
    
}