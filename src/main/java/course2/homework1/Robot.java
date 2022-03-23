package course2.homework1;

public class Robot implements Participants {

    private boolean isContinue = true;
    private Integer maxHeight;
    private Integer maxDistance;

    public Robot(Integer maxHeight, Integer maxDistance) {
        this.maxHeight = maxHeight;
        this.maxDistance = maxDistance;
    }

    @Override
    public void jump(Wall wall) {
        if (isContinue) {
            if (maxHeight < wall.getHeight()) {
                System.out.println(this.getClass().getSimpleName() + " Сошел с дистанции");
                isContinue = false;
            } else {
                System.out.println(this.getClass().getSimpleName() + " Успешно перепрыгнул " + wall.getHeight() + " сантиметров");
                isContinue = true;
            }
        }
    }

    @Override
    public void run(Track track) {
        if (isContinue) {
            if (maxDistance < track.getDistance()) {
                System.out.println(this.getClass().getSimpleName() + " Сошел с дистанции");
                isContinue = false;
            } else {
                System.out.println(this.getClass().getSimpleName() + " Успешно пробежал " + track.getDistance() + " метров");
                isContinue = true;
            }
        }
    }
}
