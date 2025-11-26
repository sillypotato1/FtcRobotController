package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.mechanisms.MecanumDrive;

@TeleOp
public class DroneDrive extends OpMode {
    MecanumDrive robot = new MecanumDrive();

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        double left_y1 = -gamepad1.left_stick_y; //flips value because moving stick up on gamepad is negative and I want the y to be positive when the stick is up
        double left_x1 = gamepad1.left_stick_x;
        double right_x1 = gamepad1.right_stick_x;

        robot.mecanumDrive(left_y1,left_x1,right_x1);
    }
}
