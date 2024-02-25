package com.splitwise.Splitwise;

import com.splitwise.Splitwise.commands.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {
	@Autowired
	private CommandExecutor commandExecutor;
	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

	public Scanner scanner = new Scanner(System.in);
	@Override
	public void run(String... args) throws Exception {
		while (true){
			String input = scanner.next();
			commandExecutor.execute(input);
		}
	}
}
