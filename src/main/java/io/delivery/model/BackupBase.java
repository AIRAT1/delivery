package io.delivery.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BackupBase {
    @Autowired
    private Environment environment;

    public String makeBackup() {
        String pgDump = environment.getProperty("postgresql.dumbAppPath");
        String dumpFile = environment.getProperty("postgresql.dumbFolder") + getBackupFileName();
        final List<String> baseCmds = new ArrayList<>();
        //Path to pd_dumb
        baseCmds.add(pgDump);
        baseCmds.add("-h");
        baseCmds.add("localhost");
        //port
        baseCmds.add("-p");
        baseCmds.add("5432");
        //user
        baseCmds.add("-U");
        baseCmds.add(environment.getProperty("jdbc.postgresql.username"));
        //add blob object into dumb file
        baseCmds.add("-b");
        baseCmds.add("-v");
        //path to dumb file
        baseCmds.add("-f");
        baseCmds.add(dumpFile);
        //base name
        baseCmds.add("snet");
        final ProcessBuilder processBuilder = new ProcessBuilder(baseCmds);
        //password for posgresql user
        final Map<String, String> env = processBuilder.environment();
        env.put("PGPASSWORD", environment.getProperty("jdbc.postgresql.password"));
        try {
            final Process process = processBuilder.start();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line = reader.readLine();
            while (line != null) {
                System.err.println(line);
                line = reader.readLine();
            }
            reader.close();

            final int dcertExitCode = process.waitFor();
            if (dcertExitCode == 0) {
                return "backup complete " + dumpFile;
            }else {
                return "backup failed";
            }
        }catch (IOException | InterruptedException e) {
            return e.toString();
        }
    }

    private String getBackupFileName() {
        long currentTime = System.currentTimeMillis();
        String currentStringDate = new SimpleDateFormat("yyyy_MM_dd_HH-mm").format(currentTime);
        return "snet_" + currentStringDate + ".backup";
    }
}
