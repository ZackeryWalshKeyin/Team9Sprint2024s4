import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClientTest {
    private Client client;
    private HttpURLConnection mockConnection;

    @BeforeEach
    public void setUp() throws Exception {
        client = new Client();

        // Mocking URL and HttpURLConnection
        URL mockUrl = mock(URL.class);
        mockConnection = mock(HttpURLConnection.class);

        // Mock URL.openConnection() to return our mock HttpURLConnection
        when(mockUrl.openConnection()).thenReturn(mockConnection);
    }

    @Test
    public void testCreateAirport() throws Exception {
        // Mock the response code and input stream
        when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_CREATED);
        InputStream mockInputStream = new ByteArrayInputStream("{\"id\":1,\"name\":\"Test Airport\",\"code\":\"TST\",\"city\":{\"id\":1}}".getBytes());
        when(mockConnection.getInputStream()).thenReturn(mockInputStream);

        // Invoke the method
        client.createAirport("Test Airport", "TST", 1);

        // Verify the connection and response handling
        verify(mockConnection, times(1)).setRequestMethod("POST");
        verify(mockConnection, times(1)).setRequestProperty("Content-Type", "application/json; utf-8");
        verify(mockConnection, times(1)).setDoOutput(true);
        assertNotNull(mockConnection.getInputStream());
    }

    @Test
    public void testUpdateAirport() throws Exception {
        // Mock the response code and input stream
        when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
        InputStream mockInputStream = new ByteArrayInputStream("{\"id\":1,\"name\":\"Updated Airport\",\"code\":\"UPD\",\"city\":{\"id\":1}}".getBytes());
        when(mockConnection.getInputStream()).thenReturn(mockInputStream);

        // Invoke the method
        client.updateAirport(1, "Updated Airport", "UPD", 1);

        // Verify the connection and response handling
        verify(mockConnection, times(1)).setRequestMethod("PUT");
        verify(mockConnection, times(1)).setRequestProperty("Content-Type", "application/json; utf-8");
        verify(mockConnection, times(1)).setDoOutput(true);
        assertNotNull(mockConnection.getInputStream());
    }

    @Test
    public void testDeleteAirport() throws Exception {
        // Mock the response code and input stream
        when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
        InputStream mockInputStream = new ByteArrayInputStream("".getBytes());
        when(mockConnection.getInputStream()).thenReturn(mockInputStream);

        // Invoke the method
        client.deleteAirport(1);

        // Verify the connection and response handling
        verify(mockConnection, times(1)).setRequestMethod("DELETE");
        verify(mockConnection, times(1)).setRequestProperty("Content-Type", "application/json; utf-8");
        verify(mockConnection, times(1)).setDoOutput(true);
        assertNotNull(mockConnection.getInputStream());
    }

    @Test
    public void testListAirports() throws Exception {
        // Mock the response code and input stream
        when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
        InputStream mockInputStream = new ByteArrayInputStream("[{\"id\":1,\"name\":\"Airport 1\",\"code\":\"A1\",\"city\":{\"id\":1}}]".getBytes());
        when(mockConnection.getInputStream()).thenReturn(mockInputStream);

        // Invoke the method
        client.listEntities("/airports");

        // Verify the connection and response handling
        verify(mockConnection, times(1)).setRequestMethod("GET");
        verify(mockConnection, times(1)).setRequestProperty("Content-Type", "application/json; utf-8");
        verify(mockConnection, times(1)).setDoOutput(true);
        assertNotNull(mockConnection.getInputStream());
    }
}