package edu.sjsu.assasins.hotelbooking.hotelrooms;

import edu.sjsu.assasins.hotelbooking.models.HotelRoom;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

public abstract class HotelRoomRepositoryCustomImpl implements HotelRoomRepositoryCustom{
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<HotelRoom> findAllRoomByHotelid(int hid) {
        System.out.println(hid);
//       String sql="select id,hotelid,roomid,typeofroom,numberofrooms,availability from HotelRoom where hotelid=:hid";
        String sql="select e from HotelRoom e where e.hotelid=:hid";
        final TypedQuery<HotelRoom> query= entityManager.createQuery(sql, HotelRoom.class);
       query.setParameter("hid",hid);
        System.out.println("test");
       return query.getResultList();
    }
}
