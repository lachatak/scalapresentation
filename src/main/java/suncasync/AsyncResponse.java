package suncasync;

/**
 * Created by mate.magyari on 29/01/2015.
 */
public class AsyncResponse {

    public final Long correlationId;
    public final int content;

    public AsyncResponse(Long correlationId, int content) {
        this.correlationId = correlationId;
        this.content = content;
    }
}
