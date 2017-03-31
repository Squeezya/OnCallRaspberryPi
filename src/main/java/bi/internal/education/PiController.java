package bi.internal.education;

import bi.internal.education.models.OnCallResponse;
import com.pi4j.io.gpio.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by squeezya on 14/02/2017.
 */
@Component
public class PiController {
    private static final Logger log = LoggerFactory.getLogger(PiController.class);

    private final GpioController gpio = GpioFactory.getInstance();
    private final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);

    private RestTemplate restTemplate;

    public PiController() {
        this.restTemplate = new RestTemplate();
    }

    @Scheduled(fixedRate = 5000)
    public void loop() {
        OnCallResponse response = this.restTemplate.getForObject("http://192.168.2.20/script/RestOnCallService", OnCallResponse.class);
        log.info(response.toString());
        if (response.getIsAnyUserOnCall() != 0) {
            this.pin.high();
        } else {
            this.pin.low();
        }
        log.info("The state is now {}", pin.getState());
    }
}
