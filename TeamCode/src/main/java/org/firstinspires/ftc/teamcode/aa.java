package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
public class aa extends OpMode{
    @TeleOp
    public CRServo thing;
    @Override
    public void init() {
        thing = hardwareMap.get(CRServo.class, "thingg");
    }

    @Override
    public void loop() {
if (gamepad1.a) {
    thing.setPower(1);
}
if (gamepad1.b) {
    
    thing.setPower(0);
}
    }
}
