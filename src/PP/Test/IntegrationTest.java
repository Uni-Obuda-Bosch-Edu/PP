package PP.Test;

import static org.junit.Assert.*;

import PP.Core.VerticalCPS;
import PP.Core.Integration;
import org.junit.Test;
import virtualDataBus.*;

public class IntegrationTest {
    private final int BUS_READ_PERIOD_MS = 1000;

    Container _bus;
    Integration _integration;

    @org.junit.Before
    public void setUp() throws Exception {
        _bus = Container.getInstance();
        _integration = new Integration(_bus, BUS_READ_PERIOD_MS, new VerticalCPS());
    }

    @org.junit.After
    public void setDown() throws Exception {
        _integration.Disconnect();
    }

    @Test
    public void Engine_connected_test() throws InterruptedException {
        //Arrange
        boolean initState = _integration.IsConnected();

        //Act
        _integration.Connect();
        Thread.sleep(_integration.GetBusReadPeriodMs()+100);

        //Assert
        assertTrue(_integration.GetBusReadPeriodMs() == BUS_READ_PERIOD_MS);
        assertFalse(initState);
        assertTrue(_integration.IsConnected());
        //assertTrue(_integration.GetIsSignaled());
    }

    @Test
    public void Engine_connect_disconnect_test() throws InterruptedException {
        //Arrange
        boolean initState = _integration.IsConnected();

        //Act
        _integration.Connect();
        _integration.Disconnect();
        Thread.sleep(_integration.GetBusReadPeriodMs());

        //Assert
        assertTrue(_integration.GetBusReadPeriodMs() == BUS_READ_PERIOD_MS);
        assertFalse(initState);
        assertFalse(_integration.IsConnected());
        //assertFalse(_engEngineSpy.GetIsSignaled());
    }
}