package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MecanumDrive {
    //DC motors
    private DcMotor front_left_motor, front_right_motor, back_left_motor, back_right_motor;

    public void init(HardwareMap hwMap) {
        //front left motor
        front_left_motor = hwMap.get(DcMotor.class,"front_left_motor");
        front_left_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        front_left_motor.setDirection(DcMotorSimple.Direction.FORWARD);
        //front right motor
        front_right_motor = hwMap.get(DcMotor.class,"front_right_motor");
        front_right_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        front_right_motor.setDirection(DcMotorSimple.Direction.FORWARD);
        //back left motor
        back_left_motor = hwMap.get(DcMotor.class,"back_left_motor");
        back_left_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        back_left_motor.setDirection(DcMotorSimple.Direction.FORWARD);
        //back right motor
        back_right_motor = hwMap.get(DcMotor.class,"back_right_motor");
        back_right_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        back_right_motor.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void mecanumDrive(double forward, double strafe, double rotate) {
        double frontLeftPower = forward + strafe + rotate,
                frontRightPower = forward - strafe - rotate,
                backLeftPower = forward - strafe + rotate,
                backRightPower = forward + strafe - rotate;

        double maxPower = 1.0;
        double maxSpeed = 1.0;

        List<Double> maxPowers = Arrays.asList(
                maxPower,
                Math.abs(frontLeftPower),
                Math.abs(frontRightPower),
                Math.abs(backLeftPower),
                Math.abs(backRightPower)
        );
        maxPower = Collections.max(maxPowers);
        front_left_motor.setPower(maxSpeed * (frontLeftPower / maxPower));
        front_right_motor.setPower(maxSpeed * (frontRightPower / maxPower));
        back_left_motor.setPower(maxSpeed * (backLeftPower / maxPower));
        back_right_motor.setPower(maxSpeed * (backRightPower / maxPower));
    }

}