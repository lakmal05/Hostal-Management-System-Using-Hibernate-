package lk.ijse.hibernate.dto;

public class RoomDTO {

    private String roomID;
    private String type;
    private Double keyMoney;
    private  int qty;

    public RoomDTO() {
    }

    public RoomDTO(String roomID, String type, Double keyMoney, int qty) {
        this.roomID = roomID;
        this.type = type;
        this.keyMoney = keyMoney;
        this.qty = qty;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getKeyMoney() {
        return keyMoney;
    }

    public void setKeyMoney(Double keyMoney) {
        this.keyMoney = keyMoney;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "roomID='" + roomID + '\'' +
                ", type='" + type + '\'' +
                ", keyMoney=" + keyMoney +
                ", qty=" + qty +
                '}';
    }
}
