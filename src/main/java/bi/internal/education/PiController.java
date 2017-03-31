package bi.internal.education;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PiController implements IPiController {

    // Get onCallPin from Pi
    private HashMap<Pin, GpioPinDigitalOutput> pinMap = new HashMap<>();

    @Override
    public GpioPinDigitalOutput getPin1(){
        if(!pinMap.containsKey(RaspiPin.GPIO_01)){
            pinMap.put(RaspiPin.GPIO_01, getPin(RaspiPin.GPIO_01));
        }
        return pinMap.get(RaspiPin.GPIO_01);
    }

    private GpioPinDigitalOutput getPin(Pin pin){
        return GpioFactory.getInstance().provisionDigitalOutputPin(pin);
    }
}
