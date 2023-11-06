package com.example;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class App 
{
    public static void main( String[] args )
    {
        try {
            Socket s = new Socket("localhost", 6790);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            BufferedReader inServ = new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println(inServ.readLine());
            String st="";
            String nota="";
            int a=0;
            do {
                System.out.println(inServ.readLine());
                st = in.readLine();
                out.writeBytes(st + '\n');
                if(st.equals("AGGIUNGI"))
                {
                    System.out.println("Inserisci nota:");
                    nota = in.readLine();
                    out.writeBytes(nota + '\n');
                    System.out.println(inServ.readLine());
                }
                else if(st.equals("ESCI"))
                {
                    a=1;
                }
                else{
                    System.out.println(inServ.readLine());
                }
            } while (a == 0);
            s.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore durante la comunicazione!");
            System.exit(1);
        }
    }
}