package suncasync;

/**
 * Created by mate.magyari on 29/01/2015.
 */
public interface RestProxy {

    int syncRequest(int input) ;

    //just for test
    Long getLatestCorrelationId();
}
