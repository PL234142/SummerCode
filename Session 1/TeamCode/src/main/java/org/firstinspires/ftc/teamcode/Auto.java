

package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Autonomous", group="Autonomous")
//@Disabled
public class Auto extends LinearOpMode {
    /* Declare OpMode members. */
    static Hardware robot = new Hardware();
    static ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        telemetry.setAutoClear(false);
        telemetry.addLine("Status: Booting");
        telemetry.update();

        robot.init(hardwareMap);
        telemetry.addData("Robot initialized: ", true);
        telemetry.update();

        robot.rightFront.setPower(0);
        robot.leftFront .setPower(0);
        robot.rightRear .setPower(0);
        robot.leftRear  .setPower(0);
        robot.rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftFront .setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightRear .setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftRear  .setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.leftFront .setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.rightRear .setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.leftRear  .setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Send telemetry message to signify robot waiting;
        telemetry.addLine("Waiting for start");
        telemetry.update();
        telemetry.setAutoClear(true);


        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        editHere();
    }


    public void editHere() {
        drive(1000,     1000,   1000, 1000, 0.2, 10000);
        sleep(2000);
        drive(-1000,    1000,   1000, -1000, 0.2,10000);
        sleep(2000);
        drive(-1000,    -1000, -1000, -1000, 0.2, 10000);
        sleep(2000);
        drive(1000,     -1000, -1000, 1000, 0.2, 10000);
    }

    public void drive (int rightFront, int leftFront, int rightRear, int leftRear, double power, int timeOut) {
        robot.rightFront.setPower(0);
        robot.leftFront .setPower(0);
        robot.rightRear .setPower(0);
        robot.leftRear  .setPower(0);

        robot.rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftFront .setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightRear .setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftRear  .setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.rightFront.setTargetPosition(rightFront);
        robot.leftFront .setTargetPosition(leftFront);
        robot.rightRear .setTargetPosition(rightRear);
        robot.leftRear  .setTargetPosition(leftRear);

        robot.rightFront.setPower(power);
        robot.leftFront .setPower(power);
        robot.rightRear .setPower(power);
        robot.leftRear  .setPower(power);

        robot.rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftFront .setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightRear .setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftRear  .setMode(DcMotor.RunMode.RUN_TO_POSITION);

        runtime.reset();
        while(timeOut > runtime.milliseconds()
                && robot.rightFront.isBusy()
                && robot.leftFront.isBusy()
                && robot.rightRear.isBusy()
                && robot.leftRear.isBusy()) {
            displayTelemetry();
            sleep(25);
        }
        robot.rightFront.setPower(0);
        robot.rightRear.setPower(0);
        robot.leftFront.setPower(0);
        robot.leftRear.setPower(0);
    }

    public void displayTelemetry() {
        telemetry.addLine("Drive Encoder ticks")
                .addData("Front Left", robot.leftFront.getCurrentPosition())
                .addData("Front Right", robot.rightFront.getCurrentPosition())
                .addData("Back Left", robot.leftRear.getCurrentPosition())
                .addData("Back Right", robot.rightRear.getCurrentPosition());
        telemetry.update();
    }
}
