package course2.homework1;

public class Wall implements Obtacles {

    private Integer height;

    public Wall(Integer height) {
        this.height = height;
    }

    public Integer getHeight() {
        return height;
    }

    @Override
    public void overcome(Participants participant) {
        participant.jump(this);
    }
}
