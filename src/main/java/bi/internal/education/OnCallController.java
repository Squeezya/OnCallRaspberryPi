package bi.internal.education;

import bi.internal.education.models.OnCallResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OnCallController {

    private static final Logger log = LoggerFactory.getLogger(OnCallController.class);

    @Autowired
    private IPiController piController;

    private RestTemplate restTemplate;

    public OnCallController() {
        this.restTemplate = new RestTemplate();
    }

    @Scheduled(fixedRate = 5000)
    public void loop() {
        OnCallResponse response = this.restTemplate.getForObject("http://192.168.2.20/script/RestOnCallService", OnCallResponse.class);
        log.info(response.toString());
        if (response.getIsAnyUserOnCall() != 0) {
            piController.getPin1().high();
        } else {
            piController.getPin1().low();
        }
    }
}
