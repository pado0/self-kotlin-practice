package inflearn.ch13;

public class JavaHouse {

    private String address;
    private LivingRoom livingRoom;

    public JavaHouse(String address) {
        this.address = address;
        this.livingRoom = new LivingRoom(100);
    }

    public LivingRoom getLivingRoom() {
        return livingRoom;
    }

    public class LivingRoom{
        private double area;

        public LivingRoom(double area) {
            this.area = area;
        }

        public String getAddress(){
            return JavaHouse.this.address; // 바깥 클래스인 JavaHouse를 직접 참조 가능
        }
    }

    public static class LivingRoomWithStatic{
        private double area;

        public LivingRoomWithStatic(double area) {
            this.area = area;
        }

        /* public String getAddress(){
            return JavaHouse.this.address; // 바깥 클래스를 참조할 수 없음
        }*/
    }
}
