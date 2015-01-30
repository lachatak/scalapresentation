package suncasync;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import com.google.common.collect.Lists;

/**
 * Created by mate.magyari on 29/01/2015.
 */
public class RestProxyImpl implements RestProxy {

    private static final int TIMEOUT = 500;
    private final AtomicLong corrIdGenerator = new AtomicLong();
    private final AsyncSender asyncSender;
    private final AsyncListener asyncListener;

    public RestProxyImpl(AsyncSender asyncSender, AsyncListener asyncListener) {
        this.asyncSender = asyncSender;
        this.asyncListener = asyncListener;
    }

    @Override
    public int syncRequest(int input) {

        long correlationId = corrIdGenerator.incrementAndGet();
        final Semaphore semaphore = new Semaphore(0);

        //it's only list because I needed a holder with a final reference
        final List<AsyncResponse> asyncResponseHolder = Lists.newArrayList();

        ResponseListener responseListener = new ResponseListener() {

            @Override
            public void process(AsyncResponse asyncResponse) {
                asyncResponseHolder.add(asyncResponse);
                semaphore.release();
                System.out.println("Semaphore released!");
            }
        };

        asyncListener.waitForResponse(correlationId, responseListener);
        asyncSender.sendRequest(new AsyncRequest(correlationId,input));

        try {
            boolean success = semaphore.tryAcquire(TIMEOUT, TimeUnit.MILLISECONDS);
            if (!success) {
                System.err.println("Timeout!");
                return -1;
            }
            System.out.println("Semaphore acquired!");
        } catch (InterruptedException ex) {
            System.err.println("Timeout!");
            return -1;
        }

        return asyncResponseHolder.get(0).content;
    }

    @Override
    public Long getLatestCorrelationId() {
        return corrIdGenerator.get();
    }
}
