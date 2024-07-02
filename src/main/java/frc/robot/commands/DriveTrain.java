package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.Joystick;

public class DriveTrain extends Command{
    private Drive m_drive;
    private Joystick m_drive_Joystick;
    private double HorizontalAxis = 0;
    private double VerticalAxis = 0;

    private boolean isFinished;

    public DriveTrain(Drive Drive, Joystick m_drive_Joystick){
        m_drive = Drive;
        this.m_drive_Joystick = m_drive_Joystick;

        addRequirements(Drive);
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
        HorizontalAxis = m_drive_Joystick.getRawAxis(4);
        VerticalAxis = m_drive_Joystick.getRawAxis(5);

        if(Math.abs(HorizontalAxis)>0.1 || Math.abs(VerticalAxis)>0.1){
            m_drive.setDrivePower(VerticalAxis*0.3, VerticalAxis*0.3, HorizontalAxis*0.3, HorizontalAxis*0.3);
        }
        else if(m_drive_Joystick.getRawButton(2)){
            m_drive.setDrivePower(0.2, -0.2, 0, 0);
        }
        else if(m_drive_Joystick.getRawButton(3)){
             m_drive.setDrivePower(-0.2, 0.2, 0, 0);          
        }
        else{
            m_drive.stopDriveMotors();
        }
    }

    public boolean isFinished(){
        return isFinished;
    }
    
}