package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Drive extends SubsystemBase {

    private TalonFX RightDrive;
    private TalonFX LeftDrive;
    private VictorSPX FrontDrive;
    private VictorSPX BackDrive;

    public Drive(){
        RightDrive = new TalonFX(DriveConstants.RightDrive);
        LeftDrive = new TalonFX(DriveConstants.LeftDrive);
        FrontDrive = new VictorSPX(DriveConstants.FrontDrive);
        BackDrive = new VictorSPX(DriveConstants.BackDrive);
    }

    public void setDrivePower(double RightPower, double LeftPower, double FrontPower, double BackPower){
        RightDrive.set(RightPower);
        LeftDrive.set(LeftPower);
        FrontDrive.set(ControlMode.PercentOutput, FrontPower);
        BackDrive.set(ControlMode.PercentOutput, -BackPower);
    }

    public void stopDriveMotors(){
        RightDrive.set(0);
        LeftDrive.set(0);
        FrontDrive.set(ControlMode.PercentOutput, 0);
        BackDrive.set(ControlMode.PercentOutput, 0);
    }

    @Override
    public void periodic(){
    }

}
