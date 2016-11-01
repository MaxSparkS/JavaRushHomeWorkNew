package com.javarush.test.level26.lesson15.big01;

/**
 * Created by m.shkurko on 10/27/2016.
 */
public class testCommand
    {
    public static void main(String[] args) {
        Computer c = new Computer();
        User u = new User(new StartCommand(c), new StopCommand(c), new ResetCommand(c));
        u.StartComputer();

    }


    interface Command
        {
        void execute();
        }

    static class Computer
        {
        void start() {
            System.out.println("Start");
        }

        void stop() {
            System.out.println("Stop");
        }

        void reset() {
            System.out.println("Reset");
        }
        }

    static class StartCommand implements Command
        {
        Computer computer = new Computer();

        public StartCommand(Computer computer) {
            this.computer = computer;
        }

        @Override
        public void execute() {
            computer.start();
        }
        }

    static class StopCommand implements Command
        {

        Computer computer = new Computer();

        public StopCommand(Computer computer) {
            this.computer = computer;
        }

        @Override
        public void execute() {
            computer.stop();
        }
        }

     static class ResetCommand implements Command
        {
        Computer computer = new Computer();

        public ResetCommand(Computer computer) {
            this.computer = computer;
        }

        @Override
        public void execute() {
            computer.reset();
        }
        }
// Invoker class
    public static class User
        {
        Command start;
        Command stop;
        Command reset;

        public User(Command start, Command stop, Command reset) {
            this.start = start;
            this.stop = stop;
            this.reset = reset;
        }

        void StartComputer(){
            start.execute();
        }
        void StopComputer(){
            stop.execute();
        }
        void ResetComputer(){
            reset.execute();
        }
        }


    }
