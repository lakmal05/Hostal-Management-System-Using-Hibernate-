package lk.ijse.hostel_Management.bo.custom.impl;

import lk.ijse.hostel_Management.bo.custom.RoomsBO;

import java.util.ArrayList;
import java.util.List;

public class RoomsBOImpl implements RoomsBO {

    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public List<RoomDTO> getAllRooms() throws Exception {
        List<Room> all = roomDAO.getAll();
        List<RoomDTO> allRooms=new ArrayList<>();
        for (Room room : all) {
            allRooms.add(new RoomDTO(room.getRoomId(),room.getType(),room.getKeyMoney(),room.getQty()));
        }
        return allRooms;
    }

    @Override
    public boolean updateQty(String roomTypeID, int qty) {
        return roomDAO.updateQty(roomTypeID,qty);
    }

    @Override
    public boolean saveRoom(RoomDTO roomDTO) throws Exception {
        return roomDAO.save(new Room(roomDTO.getRoomId(),roomDTO.getType(),roomDTO.getKeyMoney(),roomDTO.getQty()));
    }

    @Override
    public boolean updateRoom(RoomDTO roomDTO) throws Exception {
        return roomDAO.update(new Room(roomDTO.getRoomId(),roomDTO.getType(),roomDTO.getKeyMoney(),roomDTO.getQty()));
    }

    @Override
    public boolean deleteRoom(String id) throws Exception {
        return roomDAO.delete(id);
    }

}
