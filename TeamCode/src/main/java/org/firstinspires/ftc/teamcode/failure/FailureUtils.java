package org.firstinspires.ftc.teamcode.failure;

import android.annotation.SuppressLint;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.common.PaladinsComponent;
import org.firstinspires.ftc.teamcode.common.PaladinsOpMode;



public class FailureUtils extends PaladinsComponent {
    final private PaladinsOpMode opMode;
    final public DcMotor rightLiftMotor;
    final public DcMotor leftLiftMotor;
    final public DcMotor extensionMotor;
    final public CRServo grabber;
    final public Servo internalGrabber;
    final public Servo internalGrabber2;


    public double liftPower;
    public double extensionPower;
    public double grabberPower;

    public double grabberPos1;
    public double grabberPos2;

    public FailureUtils(PaladinsOpMode opMode, DcMotor rightLiftMotor, DcMotor leftLiftMotor, DcMotor extensionMotor, CRServo grabber, Servo internalGrabber, Servo internalGrabber2) {
        super(opMode);
        this.opMode = opMode;
        this.rightLiftMotor = rightLiftMotor;
        this.leftLiftMotor = leftLiftMotor;

        this.extensionMotor = extensionMotor;
        this.grabber = grabber;
        this.internalGrabber = internalGrabber;
        this.internalGrabber2 = internalGrabber2;

        rightLiftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftLiftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftPower = 0;

        extensionMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        extensionPower = 0;
        grabberPower = 0;

        grabberPos1 = 0;
        grabberPos2 = 0;
    }

    public void setLiftPower(double power) {
        liftPower = power;
    }

    public void setExtensionPower(double power) {
        extensionPower = power;
    }

    public void grab(double power) {
        grabberPower = power;
    }

    public void pelican(double pos1, double pos2) {
        grabberPos1 = pos1;
        grabberPos2 = pos2;
    }

    @SuppressLint("DefaultLocale")
    public void update() {
            rightLiftMotor.setPower(-liftPower);
            leftLiftMotor.setPower(liftPower);
            extensionMotor.setPower(extensionPower);
            grabber.setPower(grabberPower);
            internalGrabber.setPosition(grabberPos1);
            internalGrabber2.setPosition(grabberPos2);
        }

    public boolean isFinished() {
        return !(rightLiftMotor.isBusy());
    }

}
