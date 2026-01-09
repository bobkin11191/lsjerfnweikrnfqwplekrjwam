package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
@TeleOp
public class arm3 extends OpMode{

    private DcMotor arm;

    static final int POS_IN = 0;
    static final int POS_OUT = 170;

    int targetPos = POS_IN;
    boolean lastButton = false;
    @Override
    public void init() {
        arm = hardwareMap.get(DcMotor.class, "312");
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setTargetPosition(0);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);



    }

    @Override
    public void loop() {
        boolean button = gamepad1.a; // press A to toggle

        // Detect a NEW press (edge detection)
        if (button && !lastButton) {
            if (targetPos == POS_IN) {
                targetPos = POS_OUT;
            } else {
                targetPos = POS_IN;
            }
        }
        lastButton = button;

        arm.setTargetPosition(targetPos);
        arm.setPower(0.4);

        telemetry.addData("Target", targetPos);
        telemetry.addData("Current", arm.getCurrentPosition());
        telemetry.update();



    }
}
