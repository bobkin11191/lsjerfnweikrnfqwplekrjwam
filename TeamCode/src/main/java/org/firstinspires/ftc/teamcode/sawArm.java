package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp
public class sawArm extends OpMode {
public DcMotor A;
    @Override
    public void init() {
        A = hardwareMap.get(DcMotor.class, "a");
    }

    @Override
    public void loop() {
        double max;
 double a1 = gamepad1.left_stick_x;
 double a2 = a1;
        max = Math.max(max = 1, Math.abs(a2));
        if (max > 1) {

          a2 /= max;
        }
        A.setPower(a2);
    }
}
