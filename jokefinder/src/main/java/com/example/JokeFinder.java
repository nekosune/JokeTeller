package com.example;

import java.util.Random;

public class JokeFinder {


    public String getJoke() {
        Random rand = new Random();

        switch (rand.nextInt(10)) {
            case 0:
                return "Darren Walsh: I just deleted all the German names off my phone. It's Hans free.";
            case 1:
                return "Stewart Francis: Kim Kardashian is saddled with a huge arse … but enough about Kanye West.";
            case 2:
                return "Adam Hess: Surely every car is a people carrier?";
            case 3:
                return "Masai Graham: What's the difference between a hippo and a Zippo? One is really heavy, the other is a little lighter.";
            case 4:
                return "Dave Green: If I could take just one thing to a desert island, I probably wouldn't go.";
            case 5:
                return "Mark Nelson: Jesus fed 5,000 people with two fishes and a loaf of bread. That's not a miracle. That's tapas.";
            case 6:
                return "Tom Parry: Red sky at night: shepherd's delight. Blue sky at night: day.";
            case 7:
                return "Alun Cochrane: The first time I met my wife, I knew she was a keeper. She was wearing massive gloves.";
            case 8:
                return "Simon Munnery: Clowns divorce: custardy battle.";
            case 9:
                return " Grace the Child: They're always telling me to live my dreams. But I don't want to be naked in an exam I haven't revised for.";
        }
        return "Joke not found, please try again never";
    }
}
