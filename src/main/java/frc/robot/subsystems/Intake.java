package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class Intake extends SubsystemBase {

    private VictorSP RightIntake;
    private VictorSP LeftIntake;

    public Intake(){
        RightIntake = new VictorSP(IntakeConstants.RightIntakePort);
        LeftIntake = new VictorSP(IntakeConstants.LeftIntakePort);
    }

    public void setIntakePower(double power){
        RightIntake.set(power);
        LeftIntake.set(power);
    }

    public void stopAllIntakeMotors(){
        RightIntake.set(0);
        LeftIntake.set(0);
    }


    @Override
    public void periodic(){
    }

}
