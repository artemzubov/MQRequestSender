package com.trgr.dockets.RequestSender.util;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Value;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServerHelper {

    @Value("${server.host}")
    private String host;

    @Value("${server.user}")
    private String user;

    @Value("${server.password}")
    private String password;

    private List<String> executeCommandOnServerAndGetListOfResponseLines(String command) {
        StringBuilder collector = new StringBuilder();
        try {
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();

            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);

            InputStream in = channel.getInputStream();
            channel.connect();
            byte[] tmp = new byte[1024];
            while (!channel.isClosed()) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    collector.append(new String(tmp, 0, i));
                }
            }
            channel.disconnect();
            session.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> serverResponse = new ArrayList<>();
        Collections.addAll(serverResponse, collector.toString().split("\\n"));
        return serverResponse;
    }

    public String getServerDateLinuxFormatted() {
        return executeCommandOnServerAndGetListOfResponseLines("date").get(0);
    }

    public List<String> getListOfFilesInFolder(String path) {
        return executeCommandOnServerAndGetListOfResponseLines("cd " + path + " && ls");
    }
}
