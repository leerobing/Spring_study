package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class LogDemoService {

    private final ObjectProvider<MyLogger> provider;


    public void logic(String id) {
        MyLogger myLogger = provider.getObject();
        myLogger.log("service id = "+id);
    }
}
