package org.example.oop;

import java.util.Scanner;

public class PolymorphismMain {

    public static void main(String[] args) {
        Movie theMovie = new Movie("Star Wars");
        theMovie.watchMovie();

        Movie theAdventure = new Adventure("Nosferatu");
        theAdventure.watchMovie();

        Movie newMovie = Movie.getMovie("SciFi", "Star Wars");
        newMovie.watchMovie();

        Scanner s = new Scanner(System.in);

        while(true) {
            System.out.println("A - Adventure, C - Comedy, S - SciFi, Q - Quit");
            String type = s.nextLine();

            if ("Qq".contains(type)) {
                break;
            }else{
                System.out.println("Enter a movie title: ");
                String title = s.nextLine();
                Movie userMovie = Movie.getMovie(type, title);
                userMovie.watchMovie();
            }
        }

//        Adventure jaws = Movie.getMovie("A", "Jaws"); // gives an error since compiler interprets movie class will return a movie, without running the code
        Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws"); // type casting
        jaws.watchMovie();

        Object comedy = Movie.getMovie("C", "Golmaal");
//        comedy.watchComedy(); //returns error
        Movie comedyMovie = (Comedy) comedy;
//        comedyMovie.watchComedy(); // returns error since watchComedy emthod is present in Comedy class
        var com_mov = Movie.getMovie("C", "Golmaal");
        com_mov.watchMovie();

        var plane = new Comedy("Airplanes");
        plane.watchComedy();


        // var is a special contextual keyword in java that lets our code take advantage of Local Variable Type Inference
        // var can only be used for local variables
        // cant be used as return type or in method signature

        // instanceOf operator lets you test the type of an object or instance

        Object unknownObject = Movie.getMovie("C", "Airplane");
        if (unknownObject.getClass().getSimpleName() == "Comedy" ) {
            Comedy c =  (Comedy) unknownObject;
            c.watchComedy();
        }else if (unknownObject instanceof Adventure) {
            ((Adventure) unknownObject).watchAdventure();
        }else if (unknownObject instanceof SciFi syfy) {
            // if the jvm can identify that an object matches the type, it can extract data from the object without casting
            // for this the object can be assigned to a variable - syfy in this case
            syfy.watchSciFi();
        }

    }

}
