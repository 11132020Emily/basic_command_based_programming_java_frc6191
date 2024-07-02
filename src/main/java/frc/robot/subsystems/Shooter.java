package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class Shooter extends SubsystemBase {

    private VictorSP RightShooter;
    private VictorSP LeftShooter;

    public Shooter(){
        RightShooter = new VictorSP(ShooterConstants.RightShooterPort);
        LeftShooter = new VictorSP(ShooterConstants.LeftShooterPort);
    }

    public void setShooterPower(double power){
        RightShooter.set(power);
        LeftShooter.set(power);
    }

    public void stopAllShooterMotors(){
        RightShooter.set(0);
        LeftShooter.set(0);
    }


    @Override
    public void periodic(){
    }

}
