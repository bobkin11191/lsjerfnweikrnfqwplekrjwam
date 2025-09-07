package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp
public class a extends LinearOpMode {

    // Declare OpMode members for each of the 4 motors.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontLeftDrive = null;
    private DcMotor backLeftDrive = null;
    private DcMotor frontRightDrive = null;
    private DcMotor backRightDrive = null;
    private DcMotor arm = null;
    private Servo handrist = null;
    private Servo hand = null;
private  Servo geaber = null;


  //  DcMotor slide;
    boolean hasmoooved = false;

    @Override
    public void runOpMode() {

        // Initialize the hardware variables. Note that the strings used here must correspond
        // to the names assigned during the robot configuration step on the DS or RC devices.
        frontLeftDrive = hardwareMap.get(DcMotor.class, "Fl");
        backLeftDrive = hardwareMap.get(DcMotor.class, "Bl");
        frontRightDrive = hardwareMap.get(DcMotor.class, "Fr");
        backRightDrive = hardwareMap.get(DcMotor.class, "Br");
        arm = hardwareMap.get(DcMotor.class, "aarm");
        hand = hardwareMap.get(Servo.class, "H");
        handrist = hardwareMap.get(Servo.class, "Hs");
        geaber = hardwareMap.get(Servo.class, "gaber");
        hand.setPosition(0.0); // Range is 0.0 to 1.0
        handrist.setPosition(0.25);
      // slide = hardwareMap.get(DcMotor.class, "S");
        geaber.setPosition(0.0);
        waitForStart();
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        while (opModeIsActive()) {





            frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
            backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
            frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
            backRightDrive.setDirection(DcMotor.Direction.FORWARD);

            // Wait for the game to start (driver presses START)
            telemetry.addData("Status", "Initialized");
            telemetry.update();

            waitForStart();
            runtime.reset();

            // run until the end of the match (driver presses STOP)
            while (opModeIsActive()) {
                double max;
                if (gamepad1.left_bumper) {
                    hand.setPosition(1);
                } else if (gamepad1.right_bumper) {
                    hand.setPosition(0.9);
                }
                if (gamepad1.a) {
                    handrist.setPosition(.25);
                } else if (gamepad1.b) {
                    handrist.setPosition(-0.2);
                }
                if (gamepad1.dpad_up) {
                    geaber.setPosition(1);

                } else if (gamepad1.dpad_down) {
                   geaber.setPosition(-1);

                }
                if (gamepad1.x) {
                    hand.setPosition(.7);

                }
                // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
                double axial = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
                double lateral = gamepad1.left_stick_x;
                double yaw = gamepad1.right_stick_x;
                double mooovArm = gamepad2.left_stick_x;
                //double mooovslide = gamepad2.right_stick_x;

                // Combine the joystick requests for each axis-motion to determine each wheel's power.
                // Set up a variable for each drive wheel to save the power level for telemetry.
                double frontLeftPower = axial + lateral + yaw;
                double frontRightPower = axial - lateral - yaw;
                double backLeftPower = axial - lateral + yaw;
                double backRightPower = axial + lateral - yaw;
                double armp = mooovArm;
                //double slidep = mooovslide;

                // Normalize the values so no wheel power exceeds 100%
                // This ensures that the robot maintains the desired motion.
                max = Math.max(Math.abs(frontLeftPower), Math.abs(frontRightPower));
                max = Math.max(max, Math.abs(backLeftPower));
                max = Math.max(max, Math.abs(backRightPower));
                max = Math.max(max, Math.abs(armp));
               // max = Math.max(max, Math.abs(slidep));
                if (max > 1.0) {
                    frontLeftPower /= max;
                    frontRightPower /= max;
                    backLeftPower /= max;
                    backRightPower /= max;
                    armp /= max;
                  //  slidep /= max;
                }

               

                // Send calculated power to wheels
                frontLeftDrive.setPower(frontLeftPower);
                frontRightDrive.setPower(frontRightPower);
                backLeftDrive.setPower(backLeftPower);
                backRightDrive.setPower(backRightPower);
                arm.setPower(armp);
                slide.setPower(armp);


                // Show the elapsed game time and wheel power.
                telemetry.addData("Status", "Run Time: " + runtime.toString());
                telemetry.addData("Front left/Right", "%4.2f, %4.2f", frontLeftPower, frontRightPower);
                telemetry.addData("Back  left/Right", "%4.2f, %4.2f", backLeftPower, backRightPower);
                telemetry.addData("Servo Position", hand.getPosition());

                telemetry.addData("Gamepad A", gamepad1.a);
                telemetry.addData("Gamepad B", gamepad1.b);

                telemetry.update();


            }
        }


    }



    }

