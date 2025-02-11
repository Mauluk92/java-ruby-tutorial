package it.mauluk92.ruby.testutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class RubyFacade {

    private final static Logger logger = Logger.getLogger(RubyFacade.class.getName());


    public static int interpret(String sourcePath, String file) {
        try {
            ProcessBuilder compileBuilder = new ProcessBuilder();
            compileBuilder.directory(new File(sourcePath));
            List<String> commands = new ArrayList<>();
            commands.add("ruby");
            commands.add(file);
            compileBuilder.command(commands);
            Process interpretProcess = compileBuilder.start();
            BufferedReader compileErrorReader = new BufferedReader(new InputStreamReader(interpretProcess.getErrorStream()));
            StringBuilder compileErrors = new StringBuilder();
            String line;
            BufferedReader runOutputReader = new BufferedReader(new InputStreamReader(interpretProcess.getInputStream()));
            StringBuilder runOutput = new StringBuilder();
            String lineOut;
            while ((lineOut = runOutputReader.readLine()) != null) {
                runOutput.append(lineOut).append("\n");
            }

            while ((line = compileErrorReader.readLine()) != null) {
                compileErrors.append(line).append("\n");
            }
            int executionExitCode = interpretProcess.waitFor();
            if (executionExitCode != 0) {
                System.out.println("Error during execution (exit code " + executionExitCode + "):" + "file: " + file);
                System.out.println(compileErrors);
            } else {
               System.out.println("Executed successfully file: " + file);
               System.out.println(runOutput);
            }
            return executionExitCode;
        } catch (IOException | InterruptedException e) {
            logger.severe(e.getMessage());
            return -1;
        }
    }
}
