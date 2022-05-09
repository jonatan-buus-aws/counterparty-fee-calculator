package dk.jonatanbuus.counterparty_fee_calculator.controller;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import org.springframework.http.server.reactive.ServerHttpRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * Abstract controller for common methods used by several API controllers.
 */
@Slf4j
public abstract class AbstractController {
    /**
     * Extracts the source IP and port from the current HTTP request taking the x-forwarded-for and x-forwarded-port HTTP headers into account.
     * 
     * @param request   The current HTTP request
     * @return          The extracted source IP and port
     */
    protected InetSocketAddress getSourceAddress(ServerHttpRequest request) {
        InetSocketAddress ip = request.getRemoteAddress();
        String str = request.getHeaders().getFirst("x-forwarded-for");
        if (str != null) {
            int pos = str.lastIndexOf(",") + 1;
            try {
                ip = new InetSocketAddress(InetAddress.getByName(str.substring(pos).trim() ), ip.getPort() );
            }
            catch (UnknownHostException e) {
                log.warn(String.format("Unable to construct IP from \"x-forwarded-for\" header: %s", str) );
            }
        }
        str = request.getHeaders().getFirst("x-forwarded-port");
        if (str != null) {
            int pos = str.lastIndexOf(",") + 1;
            ip = new InetSocketAddress(ip.getAddress(), Integer.parseInt(str.substring(pos).trim() ) );
        }
        return ip;
    }
}