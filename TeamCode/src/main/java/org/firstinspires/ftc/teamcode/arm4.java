package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
@TeleOp
public class arm4 extends OpMode{

    private DcMotor arm;

    static final int POS_IN = 0;
    static final int POS_OUT = 170;

    static final int TRIP = 10;      // how far you must push to switch

    static final double HOLD_POWER = 0.08;  // VERY gentle

    int targetPos = POS_IN;
    @Override
    public void init() {
        arm = hardwareMap.get(DcMotor.class, "312");
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setTargetPosition(0);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setPower(0.12);

    }

    @Override
    public void loop() {

        int current = arm.getCurrentPosition();

        // Detect manual push
        if (targetPos == POS_IN && current > POS_IN + TRIP) {
            targetPos = POS_OUT;
        }
        else if (targetPos == POS_OUT && current < POS_OUT - TRIP) {
            targetPos = POS_IN;
        }

        // Apply constant gentle power toward target
        if (targetPos == POS_OUT) {
            arm.setPower(HOLD_POWER);
        } else {
            arm.setPower(-HOLD_POWER);
        }
        telemetry.addData("Current", arm.getCurrentPosition());
        telemetry.update();



    }
}
