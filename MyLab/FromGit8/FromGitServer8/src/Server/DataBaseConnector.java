package Server;

import java.sql.*;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.util.Properties;


public class DataBaseConnector {

    private String strSshUser = "suck my dick";
    private String strSshPassword = "suck my dick";
    private String strSshHost = "suck my dick";
    private int nSshPort = 2222;
    private String strRemoteHost = "pg";
    private int nLocalPort = 3749;
    private int nRemotePort = 5432;
    private String strDbUser = "suck my dick";
    private String strDbPassword = "suck my dick";
    private static Connection con;

    public void connect() {
        this.doSshTunnel(strSshUser, strSshPassword, strSshHost, nSshPort, strRemoteHost, nLocalPort, nRemotePort);
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.con = DriverManager.getConnection("jdbc:postgresql://localhost:"+nLocalPort+"/studs", strDbUser, strDbPassword);


        } catch (SQLException throwables) {
            System.out.println("Error in SSH tunnel)");
            throwables.printStackTrace();
        }
    }


    private void doSshTunnel( String strSshUser, String strSshPassword, String strSshHost, int nSshPort, String strRemoteHost, int nLocalPort, int nRemotePort )
    {
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(strSshUser, strSshHost, nSshPort);
            session.setPassword(strSshPassword);

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            session.connect();
            session.setPortForwardingL(nLocalPort, strRemoteHost, nRemotePort);
        }catch (JSchException e){System.out.println("AAAAAAAA");}
    }

    public  Connection getCon(){
        return this.con;
    }

}
