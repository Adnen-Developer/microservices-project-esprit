package tn.esprit.logger;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SharedLogger {

    @Async
    public void debug(String message) {
        log.debug(formatMessage(message));
    }

    @Async
    public void info(String message) {
        log.info(formatMessage(message));
    }

    @Async
    public void warn(String message) {
        log.warn(formatMessage(message));
    }

    @Async
    public void error(String message) {
        log.error(formatMessage(message));
    }

    private String formatMessage(String message) {
        String traceId = MDC.get("traceId");
        return traceId != null ? "[" + traceId + "] " + message : message;
    }

    public void setContext(String key, String value) {
        MDC.put(key, value);
    }

    public void clearContext() {
        MDC.clear();
    }
}