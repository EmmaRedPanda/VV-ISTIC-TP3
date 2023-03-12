package fr.istic.vv;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

// /!\/!\/!\/!\/!\/!\
// NO MORE
// /!\/!\/!\/!\/!\/!\
public class TLSSocketFactoryTestMocksV2 {

    @Test
    public void preparedSocket_NullProtocols() {
        // Create a mock SSLSocket with null supported and enabled protocols
        SSLSocket socket = mock(SSLSocket.class);
        Mockito.when(socket.getSupportedProtocols()).thenReturn(null);
        Mockito.when(socket.getEnabledProtocols()).thenReturn(null);

        // Create a TLSSocketFactory instance and call prepareSocket with the mock socket
        TLSSocketFactory factory = new TLSSocketFactory();
        factory.prepareSocket(socket);

        // Verify that setEnabledProtocols was not called on the mock socket
        verify(socket, Mockito.times(0)).setEnabledProtocols(Mockito.any(String[].class));
    }

    @Test
    public void typical() {
        // Create a mock SSLSocket with supported and enabled protocols
        SSLSocket socket = mock(SSLSocket.class);
        Mockito.when(socket.getSupportedProtocols()).thenReturn(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"});
        Mockito.when(socket.getEnabledProtocols()).thenReturn(new String[]{"SSLv3", "TLSv1"});
        doNothing().when(socket).setEnabledProtocols(Mockito.any(String[].class));

        // Create a TLSSocketFactory instance and call prepareSocket with the mock socket
        TLSSocketFactory factory = new TLSSocketFactory();
        factory.prepareSocket(socket);

        // Verify that setEnabledProtocols was called on the mock socket with the expected protocols
        verify(socket).setEnabledProtocols(new String[]{"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3"});
    }


}