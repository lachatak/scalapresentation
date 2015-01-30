package suncasync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mate.magyari on 29/01/2015.
 */
public class Main {

    public static void main(String... args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        AsyncSender asyncSender = new AsyncSender();
        AsyncListener asyncListener = new AsyncListener();
        final RestProxy restProxy = new RestProxyImpl(asyncSender, asyncListener);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                int response = restProxy.syncRequest(12);
                System.out.println("Response: " + response);
            }
        });

        Thread.sleep(100);


        //asyncListener.responseArrived(new AsyncResponse(restProxy.getLatestCorrelationId(),45));

        executorService.shutdown();
    }
}
