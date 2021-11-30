// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically it contains the code
 * necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  //private Joystick m_leftStick;
  //private Joystick m_rightStick;
  private XboxController xbox0;
  private CANSparkMax m_frontLeft;
  private CANSparkMax m_frontRight;
  private CANSparkMax m_rearLeft;
  private CANSparkMax m_rearRight;

  private SpeedControllerGroup m_right;
  private SpeedControllerGroup m_left;

  @Override
  public void robotInit() {
    
    m_rearLeft = new CANSparkMax(15, MotorType.kBrushless); 
    m_frontLeft = new CANSparkMax(13, MotorType.kBrushless);
    m_rearRight = new CANSparkMax(14, MotorType.kBrushless);
    m_frontRight = new CANSparkMax(16, MotorType.kBrushless);

    m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
    m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);

    m_myRobot = new DifferentialDrive(m_left, m_right);

    // m_leftStick = new Joystick(0);
    // m_rightStick = new Joystick(1);
    xbox0 = new XboxController(0);
    
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.arcadeDrive(
      xbox0.getY(GenericHID.Hand.kRight),
      xbox0.getX(GenericHID.Hand.kRight)
    );
  }
}
