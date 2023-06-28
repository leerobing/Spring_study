package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient{
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 url: "+ url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작 호출
    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("url: "+url+ ", message: "+message);
    }

    //서비스 종료 호출
    public void disconnect() {
        System.out.println("close :" + url);
    }



    @PostConstruct
    public void init() { //의존관계 주입이 끝난 후 실행
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() { //종료시 실행
        disconnect();
    }

}
