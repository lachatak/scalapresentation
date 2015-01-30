package suncasync;

/**
 * Created by mate.magyari on 29/01/2015.
 */
public class AsyncRequest {

    public final Long correlationId;
    public final int content;

    public AsyncRequest(Long correlationId, int content) {
        this.correlationId = correlationId;
        this.content = content;
    }
}
