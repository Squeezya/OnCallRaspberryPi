package bi.internal.education;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertController {

    private static final Logger log = LoggerFactory.getLogger(OnCallController.class);

    @Autowired
    private IPiController piController;

    private static final int TOGGLES = 10;
    private static final int INTERVAL_MS = 200;
    private boolean isOnAlert;

    @Async
    @RequestMapping("/alert")
    public void alert() {
        log.info("ALERT! call");

        if(!isOnAlert){
            isOnAlert = true;
            try {
                for (int i = 1; i <= TOGGLES; i++){
                    piController.getPin1().toggle();
                    Thread.sleep(INTERVAL_MS);
                }

            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
            isOnAlert = false;
        }
    }
}
