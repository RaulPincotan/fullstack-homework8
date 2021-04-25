package ro.fastrackit.fullstackhomework8.repository;

import org.springframework.stereotype.Repository;
import ro.fastrackit.fullstackhomework8.model.RoomFilters;
import ro.fastrackit.fullstackhomework8.model.entity.Room;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RoomDao {
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public RoomDao(EntityManager entityManager) {
        this.entityManager = entityManager;
        criteriaBuilder = this.entityManager.getCriteriaBuilder();
    }

    public List<Room> getAll(RoomFilters filters) {
        CriteriaQuery<Room> criteria = criteriaBuilder.createQuery(Room.class);
        Root<Room> root = criteria.from(Room.class);

        List<Predicate> whereClause = new ArrayList<>();
        Optional.ofNullable(filters.getFloor())
                .ifPresent(floor -> whereClause.add(criteriaBuilder.equal(root.get("floor"), floor)));
        Optional.ofNullable(filters.getFloor())
                .ifPresent(hotelName -> whereClause.add(criteriaBuilder.equal(root.get("hotelName"), hotelName)));

        CriteriaQuery<Room> query = criteria.select(root).where(whereClause.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}
