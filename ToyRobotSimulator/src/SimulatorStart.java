import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.game.simulation.Robot;

public class SimulatorStart {

	public static void main(final String[] args) {
		if (args.length == 0) {
			System.out.println("Provide the input command file");
			return;
		}
		final String fileName = args[0];

		// read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			final Robot simulator = new Robot();
			stream.forEach(commandInput -> simulator.executeCommand(commandInput));

		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
}
