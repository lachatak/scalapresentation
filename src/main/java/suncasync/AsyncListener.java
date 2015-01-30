package suncasync;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * Created by mate.magyari on 29/01/2015.
 */
public class AsyncListener {

    private final Map<Long, ResponseListener> listenersByCorrelationId = Maps.newHashMap();

    public void waitForResponse(long correlationId, ResponseListener responseListener) {
        listenersByCorrelationId.put(correlationId,responseListener);
    }

    //called when the response arrives
    void responseArrived(AsyncResponse asyncResponse) {
        listenersByCorrelationId.get(asyncResponse.correlationId).process(asyncResponse);
    }
}
