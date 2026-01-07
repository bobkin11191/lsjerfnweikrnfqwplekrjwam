package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
@TeleOp
public class cfgcvhj extends OpMode{

    private DcMotor arm;
    @Override
    public void init() {
        arm = hardwareMap.get(DcMotor.class, "312");


    }

    @Override
    public void loop() {
        if(gamepad1.a) {
            arm.setPower(1);

        }
    }
}
