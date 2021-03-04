package indirectOut;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class ExIndirectOutTest {
    @Mock
    Greeting greeting;
    @InjectMocks
    ExIndirectOut injectedMock;
    @Test
    public void testHelloOnce() {
        MockitoAnnotations.initMocks(this);
        injectedMock.doIt("Hello");
        verify(greeting,times(1)).say("Hello World!");
    }
    @Test
    public void testHelloThreeTimes() {
        MockitoAnnotations.initMocks(this);
        for(int i=0; i < 3; i++)
            injectedMock.doIt("Hello");
        verify(greeting,times(3)).say("Hello World!");
    }
    @Test
    public void testHiOnce() {
        MockitoAnnotations.initMocks(this);
        injectedMock.doIt("Hi");
        verify(greeting,times(1)).say("Good Bye!");
    }
    @Test
    public void testHiAndHello() {
        MockitoAnnotations.initMocks(this);
        injectedMock.doIt("Hello");
        injectedMock.doIt("Hi");
        verify(greeting,times(1)).say("Hello World!");
        verify(greeting,times(1)).say("Good Bye!");
    }
    @Test
    public void testHiResponsesWithin100ms() {
        MockitoAnnotations.initMocks(this);
        injectedMock.doIt("Hi");
        verify(greeting,timeout(100).atLeast(1)).say("Good Bye!");
    }
}
