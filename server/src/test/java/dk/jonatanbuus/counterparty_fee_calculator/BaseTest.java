package dk.jonatanbuus.counterparty_fee_calculator;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.mock.web.server.MockServerWebExchange;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;

import lombok.Getter;

@Getter
public abstract class BaseTest {
    protected InetSocketAddress ip;

    @BeforeEach
    public void setup() throws Exception {
        this.ip = new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 54321);
    }
    @AfterEach
    public void reset() {
    }
    @AfterAll
    public static void teardown() {
    }
    /**
     * Convenience method for creating a mock Server Web Exchange without any http headers
     * using the provided values.
     * This is the same as calling {@link #createExchange(HttpMethod, String, MultiValueMap)} with an empty list of headers.
     * 
     * @see MockServerWebExchange
     * @see MockServerHttpRequest
     * @see #createExchange(HttpMethod, String, MultiValueMap)
     * 
     * @param method    The HTTP method for the mock exchange
     * @param path      The absolute path for the mock exchange
     * @return          The created mock Server Web Exchange
     */
    protected ServerWebExchange createExchange(HttpMethod method, String path) {

		return this.createExchange(method, path, new HttpHeaders() );
	}
    /**
     * Created a mock Server Web Exchange using the provided values.
     * This is the same as calling {@link #createExchange(HttpMethod, String, MultiValueMap)} with an empty list of headers.
     * 
     * @see MockServerWebExchange
     * @see MockServerHttpRequest
     * 
     * @param method    The HTTP method for the mock exchange
     * @param path      The absolute path for the mock exchange
     * @param headers   List of HTTP headers that should be included in the mock exchange
     * @return          The created mock Server Web Exchange
     */
    protected ServerWebExchange createExchange(HttpMethod method, String path, MultiValueMap<String, String> headers) {

		return MockServerWebExchange.from(MockServerHttpRequest
				.method(method, "http://localhost" + path)
                .remoteAddress(this.ip)
                .headers(headers) );
	}
}