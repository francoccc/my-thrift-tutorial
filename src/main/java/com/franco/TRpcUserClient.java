package com.franco;

import com.thrift.user.service.RpcUserService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Thrift Rpc Connector Client
 *
 * @author chenxy
 */
public class TRpcUserClient {

    private RpcUserService.Client client;
    private TSocket transport;
    private String host;;
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void init() {
        this.transport = new TSocket(host, port);
        TBinaryProtocol protocol = new TBinaryProtocol(transport);
        this.client = new RpcUserService.Client(protocol);
    }

    public RpcUserService.Client getRpcThriftService() {
        return client;
    }

    public void open() throws TTransportException {
        this.transport.open();
    }

    public void close() {
        this.transport.close();
    }
}
