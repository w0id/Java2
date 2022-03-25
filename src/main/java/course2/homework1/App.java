package course2.homework1;

public class App {
    public static void main(String[] args) {
        Participants[] participants = {
            new Robot(49,100),
            new Human(60,140),
            new Cat(150, 300)
        };

        Obtacles[] obtacles = {
                new Track(100),
                new Wall(50),
                new Track(50),
                new Track(70),
                new Wall(120),
                new Track(90)
        };

        for (Obtacles obtacle : obtacles) {
            for (Participants participant : participants) {
                obtacle.overcome(participant);
            }

        }
    }
}

