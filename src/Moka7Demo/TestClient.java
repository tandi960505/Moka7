package Moka7Demo;

import Moka7.S7;
import Moka7.S7Client;

public class TestClient {

    private static final S7Client client = new S7Client();
    private static byte[] buffer = new byte[1024];

    public static void main(String[] args) {

        client.SetConnectionType(S7.OP);
        // 当前机器的ip:192.168.4.120
        client.ConnectTo("192.168.4.120", 0, 2);

        if (client.Connected) {
            // db模块编号，db模块的起始地址，读取数据的大小
            client.ReadArea(S7.S7AreaDB, 1, 2, 2, buffer);
            int readData = S7.GetWordAt(buffer, 0);
            System.out.println("readData = " + readData);

            // 写
            // client.WriteArea(S7.S7AreaDB, 1, 0, 2, buffer);
        } else {
            System.out.println("连接失败");
        }
    }
}
