// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
package frc.robot;
 
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
   public final class Ports{
       public static final int frontLeftRotPort = 4;
       public static final int frontRightRotPort = 0;
       public static final int rearLeftRotPort = 0;
       public static final int rearRightRotPort = 0;
       public static final int frontLeftExPort = 1;
       public static final int frontRightExPort = 0;
       public static final int rearLeftExPort = 0;
       public static final int rearRightExPort = 0;
   }

   public final class DIOPorts{
       public static final int frontLeftRefSensor = 0;
       public static final int frontRightRefSensor = 0;
       public static final int rearLeftRefSensor = 0;
       public static final int rearRightRefSensor = 0;
   }

   public final class DriveTrainPorts{
       public static final int LeftDriveTalonPort = 1;
       public static final int RightDriveTalonPort = 2;
   }

   public final class armAngles{
       public static final double up = 30;
       public static final double down = -30;
       public static final double zero = 0;
   }

   public final class MotorNums{
       public static final int frontLeftRot = 1;
       public static final int frontRightRot = 2;
       public static final int rearLeftRot = 3;
       public static final int rearRightRot = 4;
       public static final int frontLeftEx = 5;
       public static final int frontRightEx = 6;
       public static final int rearLeftEx = 7;
       public static final int rearRightEx = 8;
   }

   public static final class pidConsts{
       public static final double pidP = .8;
       public static final double pidI = 0;
       public static final double pidD = 0;
 }

 public static final class charConsts{
       public static final double ks = 0;
       public static final double kcos = 0;
       public static final double kv = 0;
       public static final double ka = 0;
 }

 public static class ExtendConsts{
     public static int frontLeftCurrPos = 0;
     public static int frontRightCurrPos = 0;
     public static int rearLeftCurrPos = 0;
     public static int rearRightCurrPos = 0;
 }

 public static final double threshold = 0;
}
