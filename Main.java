package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

public class Main {
    static FlowNetwork flowNetwork;
    public static void main(String[] args) throws Exception {
	// write your code here
        String fileName = "g.txt";
        URL path = Main.class.getResource(fileName);

        if (path == null) {
            throw new Exception("file name not accepted");
        }

        BufferedReader reader;


        try {
            File f = new File(path.toURI());
            reader = new BufferedReader(new FileReader(f));
            int V = Integer.parseInt(reader.readLine());
            flowNetwork = new FlowNetwork(V);

            for (int i = 0; i < V; i++) {                          //create lists for each city
                String name = reader.readLine();
                flowNetwork.setCityNames(i, name);
            }

        }
        catch
    }
}
