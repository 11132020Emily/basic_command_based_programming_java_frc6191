
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.PortConstants;

import frc.robot.commands.DriveTrain;
import frc.robot.commands.Scoring;
import frc.robot.commands.Intaking;

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Drive;

/*
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  private final Intake m_Intake = new Intake();
  private final Shooter m_Shooter = new Shooter();
  private final Drive m_Drive = new Drive();

  // The driver's controller
  Joystick m_Joystick = new Joystick(PortConstants.ControllerPort);

  private final JoystickButton ScoringButton = new JoystickButton(m_Joystick, 1);
 
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure Default Commands
    m_Drive.setDefaultCommand(new DriveTrain(m_Drive, m_Joystick));

    // Configure the button bindings
    configureButtonBindings();
    DriverStation.silenceJoystickConnectionWarning(true);

  }

  /*
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its
   * subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then calling
   * passing it to a
   * {@link JoystickButton}.
   */
  private void configureButtonBindings() {
    //Operator Intake
    ScoringButton.onTrue(new Scoring(m_Intake, 0.3, m_Shooter, 0.3));
    ScoringButton.onFalse(new Intaking(m_Intake, m_Shooter, m_Joystick));
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}