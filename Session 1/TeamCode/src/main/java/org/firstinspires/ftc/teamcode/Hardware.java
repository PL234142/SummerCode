package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.hardware.bosch.BNO055IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

/**
 * This is NOT an opmode.
 * <p>
 * This class can be used to define all the specific hardware for a single robot.
 */
public class Hardware {
    private final ElapsedTime period = new ElapsedTime();
    /* Public OpMode members. */
    public DcMotor rightFront;
    public DcMotor leftFront;
    public DcMotor rightRear;
    public DcMotor leftRear;
    public DcMotor intake;
    /* local OpMode members. */
    HardwareMap hwMap = null;

    /* Constructor */
    public Hardware() {

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        //driveTrain


        //util motors
        rightFront  = hwMap.get(DcMotor.class, "right front");
        leftFront   = hwMap.get(DcMotor.class, "left front");
        rightRear   = hwMap.get(DcMotor.class, "right rear");
        leftRear    = hwMap.get(DcMotor.class, "left rear");
        intake      = hwMap.get(DcMotor.class, "intake");
        rightFront  .setDirection(DcMotor.Direction.REVERSE); // Set to REVERSE if using AndyMark motors
        leftFront   .setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors
        rightRear   .setDirection(DcMotor.Direction.REVERSE);
        leftRear    .setDirection(DcMotor.Direction.FORWARD);
        intake      .setDirection(DcMotor.Direction.FORWARD);
        rightFront  .setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftFront   .setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightRear   .setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftRear    .setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intake      .setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }
}
