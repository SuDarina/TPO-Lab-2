package function;

import system.CollectData;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CollectData cd = new CollectData(0.1, -3.14, 3.14);
        cd.collectData();
    }
}
