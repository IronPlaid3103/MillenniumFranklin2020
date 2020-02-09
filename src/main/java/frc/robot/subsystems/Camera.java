/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.cscore.VideoSink;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Camera extends SubsystemBase {
  /**
   * Creates a new CameraBack.
   */
  UsbCamera backCamera;
  UsbCamera upCamera;
  VideoSink videoSink1;
  VideoSink videoSink2;
  
  public Camera() {
    CameraServer cs = CameraServer.getInstance();

    try{
      backCamera = cs.startAutomaticCapture("backCamera", 0);
      backCamera.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
    } catch (Exception ex){

    }

    try{
      upCamera = cs.startAutomaticCapture("upCamera", 1);
      upCamera.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
    } catch (Exception ex){

    }

    upCamera.setVideoMode(VideoMode.PixelFormat.kMJPEG, 320, 240, 30);
    backCamera.setVideoMode(VideoMode.PixelFormat.kMJPEG, 176, 144, 30);
  }

  public void showCamera(){
    videoSink1.setSource(backCamera);
    SmartDashboard.putString("Camera", "Back");

    videoSink2.setSource(upCamera);
    SmartDashboard.putString("Camera", "Up");
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
