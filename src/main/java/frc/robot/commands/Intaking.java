package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class Intaking extends Command{
    private Intake m_intake;
    private Shooter m_shooter;
    private Joystick m_intake_Joystick;

    private boolean isFinished;

    public Intaking(Intake Intake, Shooter Shooter, Joystick m_intake_Joystick){
        m_intake = Intake;
        m_shooter = Shooter;
        this.m_intake_Joystick = m_intake_Joystick;

        addRequirements(Intake);
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
        if(m_intake_Joystick.getRawButton(4)){
            m_intake.setIntakePower(0.2);
            m_shooter.stopAllShooterMotors();
        }
        else{
            m_intake.stopAllIntakeMotors();
            m_shooter.stopAllShooterMotors();
        }
    }

    public boolean isFinished(){
        return isFinished;
    }
    
}