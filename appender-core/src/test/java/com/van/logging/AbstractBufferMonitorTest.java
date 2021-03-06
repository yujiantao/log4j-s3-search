package com.van.logging;

import org.junit.Before;
import java.util.concurrent.Future;

/**
 * Abstract base class for monitor tests. Shared facilities for testing
 * different implementations of BufferMonitors.
 */
public abstract class AbstractBufferMonitorTest {
    protected int publishCount = 0;

    protected IFlushAndPublish publisher = new IFlushAndPublish() {
        @Override
        public Future<Boolean> flushAndPublish() {
            System.out.println("flushAndPublish() called.");
            publishCount++;
            return null;
        }

        @Override
        public Boolean syncFlushAndPublish() {
            System.out.println("syncFlushAndPublish() called.");
            publishCount++;
            return true;
        }
    };

    @Before
    public void setUp() {
        System.out.println("resetting publishCount");
        publishCount = 0;
    }


}
