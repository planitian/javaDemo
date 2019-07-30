package build;

public class WorkBuilder {
    private RoomParmas parmas;

    public WorkBuilder() {
        this.parmas = new RoomParmas();
    }

    public WorkBuilder makeWindow(String window) {
        parmas.window = window;
        return this;
    }

    public WorkBuilder makeFloor(String floorCorlor) {
        parmas.floor = floorCorlor;
        return this;
    }

    public WorkBuilder makeDoor(String door) {
        parmas.door = door;
        return this;
    }

    public WorkBuilder makeChat(String chat) {
        parmas.chat = chat;
        return this;
    }

    public Room build() {
        Room room=new Room();
        room.apply(this.parmas);
         return room;
    }

    class RoomParmas {
        public String window;
        public String floor;
        public String door;
        public String chat;
    }


    /**
     * 房子类
     * 首先要描述下 房子要有些什么
     * 有哪些属性
     *
     * @author tucheng
     */
    public class Room {
        private String window;
        private String floor;
        private String doorl;
        private String chat;

        public void apply(WorkBuilder.RoomParmas parmas) {
            window = parmas.window;
            floor = parmas.floor;
            doorl = parmas.door;
            chat = parmas.chat;
        }

        public void setChat(String chat) {
            this.chat = chat;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "---->floor  " + floor + "   window   " + window;
        }

        public void show() {

        }
    }
}
