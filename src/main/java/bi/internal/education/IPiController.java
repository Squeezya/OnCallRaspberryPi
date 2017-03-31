package bi.internal.education;

import com.pi4j.io.gpio.GpioPinDigitalOutput;

public interface IPiController {
    GpioPinDigitalOutput getPin1();
}
