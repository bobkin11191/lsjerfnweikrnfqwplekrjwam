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

        arm.setTargetPosition(500);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setPower(.3);
    }

    @Override
    public void loop() {

    }
}
