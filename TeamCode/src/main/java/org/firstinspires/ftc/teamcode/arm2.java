package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
@TeleOp
public class arm2 extends OpMode{

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
        int pos = arm.getCurrentPosition();
        int MIN_POS = 0;
        int MAX_POS = 170;


       if(pos > 1){
        arm.setTargetPosition(170);

       }
       if (pos < 169) {
          arm.setTargetPosition(0);

       }



        telemetry.addData("Current", arm.getCurrentPosition());
        telemetry.update();
    }
}
