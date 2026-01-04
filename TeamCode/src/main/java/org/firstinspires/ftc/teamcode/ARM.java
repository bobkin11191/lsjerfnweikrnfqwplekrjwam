package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
@TeleOp
public class ARM extends OpMode{

    private DcMotor arm;
    @Override
    public void init() {
       arm = hardwareMap.get(DcMotor.class, "312");
       arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setTargetPosition(0);//265
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setPower(.3);

    }

    @Override
    public void loop() {
        int MIN_POS = 0;
        int MAX_POS = 170;

        double trigger = gamepad1.right_trigger;
        int targetPos = (int)(MIN_POS + trigger * (MAX_POS - MIN_POS));
        arm.setTargetPosition(targetPos);
        arm.setPower(0.4);
        if(gamepad1.a) {
        arm.setTargetPosition(133);
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            arm.setPower(.3);
        }
        if(gamepad1.b) {
            arm.setTargetPosition(0);
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            arm.setPower(.3);}


        telemetry.addData("Trigger", trigger);
        telemetry.addData("Target", targetPos);
        telemetry.addData("Current", arm.getCurrentPosition());
        telemetry.update();
    }
}
